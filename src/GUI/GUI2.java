package GUI;

import Graph_Implementation.GraphMatrix;
import Graph_Implementation.Vertex;
import Lower_Upper_bound_approx.Upper_bound;
import Phase_2.RandomGraph;
import txtReader_ForGivenGraphs.*;
import  Algorithms.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.jar.JarEntry;
import java.util.random.*;

import Phase_2.RandomGraph;
import static Phase_2.RandomOrder.RandomVertexSequence;
import static GUI.colorVertexGui.colorVertexGUI;
import static Phase_2.RandomGraph.randomGraph_GUI;


public class GUI2{

    // booleans for each game mode
    static boolean bestUpper = false;
    static boolean bitterEnd = false;
    static boolean randOrder = false;
    GraphMatrix graphGUI;
    List<Vertex> vertecesGUI;

    List<Vertex> sequence;
    int sequenceIndex = 0;

    int upperBound;
    String upperBoundString;
    String hint1;

    int backTrackResult = 0;
    
    String[] bitterEndHints = {"","Try coloring the vertices with the highest degree first","Utilize any symmetry in the graph if possible"};
    String[] bestUpperHints = {"","You get 3 seconds per vertex in the game, use the time wisely","Try coloring everything as fast as possible, and then change colors to make the coloring correct."};
    String[] randOrderHints = {"","Dont't color two adjacent vertices the same color, or you can't win","Try thinking in advance which vertex you are going to give what color"};

    boolean hintDisplay = false;
    boolean txtinput = false;

    int indexBitterEndHints = 0;
    int indexBestUpperHints = 0;
    int indexrandOrderHints = 0;

    boolean[] colorsUsed = new boolean[20];

    JButton exitButton;
    JButton playButton;
    JButton menuButton;
    JButton randomButton;
    JButton customButton;
    JButton upVertex;
    JButton downVertex;
    JButton upEdge;
    JButton downEdge;
    JLabel vertexAmount;
    JLabel edgeAmount;
    JLabel selectMode;
    int vertexCount = 1;
    int edgeCount = 0;
    int xPosition = 0;
    int yPosition = 0;
    int xPosRand = 0;
    int yPosRand = 0;
    int time = 0;
    int colorSelected = 1;
    int[][] vertexLocations;
    Timer gametimer;
    JFrame frame;
    JPanel selectionPanel;
    JPanel startPanel;
    JPanel playPanel;
    JTextField graphRead;
    boolean randomCustom = true; 
    JButton bitterEndMode;
    JButton bestUpperBoundMode;
    JButton randomOrderMode;
    JButton startButton;
    JButton backMenuButton;
    JLabel buttonBounds;
    JButton[] vertexButtons;
    JButton randomizeVertices;
    JButton hintButton;
    JButton checkGameButton;
    JLabel hintLabel;
    JLabel timer;
    JButton color1;
    JButton color2;
    JButton color3;
    JButton color4;
    JButton color5;
    JButton color6;
    JButton color7;
    JButton color8;
    JButton color9;
    JButton color10;
    JButton color11;
    JButton color12;
    JButton color13;
    JButton color14;
    JButton color15;
    JButton color16;
    JButton color17;
    JButton color18;
    JButton color19;
    JButton color20;
    
    public void paint(Graphics g){
        Graphics2D edges = (Graphics2D) g;
        edges.setStroke(new BasicStroke(5));
        edges.drawLine(100,100,300,300);
    }
    public GUI2() {
        Border border = BorderFactory.createLineBorder(Color.blue,5);
        Border buttonBorder = BorderFactory.createLineBorder(new Color(0, 102, 255),3);
        Border selectedColor = BorderFactory.createLineBorder(new Color(255, 255, 255),3);
        Border colorBorder = BorderFactory.createLineBorder(new Color(0,0,0),1);

        color1 = new JButton(new AbstractAction("") {   //20 hard coded color buttons in the actual game, I set an int to corresponding color so that that number can be used later.
            @Override
            public void actionPerformed(ActionEvent e) {
                colorSelected = 1;
                color1.setBorder(selectedColor);
                color2.setBorder(colorBorder);
                color3.setBorder(colorBorder);
                color4.setBorder(colorBorder);
                color5.setBorder(colorBorder);
                color6.setBorder(colorBorder);
                color7.setBorder(colorBorder);
                color8.setBorder(colorBorder);
                color9.setBorder(colorBorder);
                color10.setBorder(colorBorder);
                color11.setBorder(colorBorder);
                color12.setBorder(colorBorder);
                color13.setBorder(colorBorder);
                color14.setBorder(colorBorder);
                color15.setBorder(colorBorder);
                color16.setBorder(colorBorder);
                color17.setBorder(colorBorder);
                color18.setBorder(colorBorder);
                color19.setBorder(colorBorder);
                color20.setBorder(colorBorder); 
             }
        });
        color1.setBounds(1236,200,75,75);
        color1.setFocusable(false);
        color1.setBackground(new Color(0,0,153));
        color1.setBorder(selectedColor);

        color2 = new JButton(new AbstractAction("") {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorSelected = 2;
                color1.setBorder(colorBorder);
                color2.setBorder(selectedColor);
                color3.setBorder(colorBorder);
                color4.setBorder(colorBorder);
                color5.setBorder(colorBorder);
                color6.setBorder(colorBorder);
                color7.setBorder(colorBorder);
                color8.setBorder(colorBorder);
                color9.setBorder(colorBorder);
                color10.setBorder(colorBorder);
                color11.setBorder(colorBorder);
                color12.setBorder(colorBorder);
                color13.setBorder(colorBorder);
                color14.setBorder(colorBorder);
                color15.setBorder(colorBorder);
                color16.setBorder(colorBorder);
                color17.setBorder(colorBorder);
                color18.setBorder(colorBorder);
                color19.setBorder(colorBorder);
                color20.setBorder(colorBorder); 
             }
        });
        color2.setBounds(1311,200,75,75);
        color2.setFocusable(false);
        color2.setBackground(new Color(0,0,255));
        color2.setBorder(colorBorder);
        
        color3 = new JButton(new AbstractAction("") {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorSelected = 3;
                color1.setBorder(colorBorder);
                color2.setBorder(colorBorder);
                color3.setBorder(selectedColor);
                color4.setBorder(colorBorder);
                color5.setBorder(colorBorder);
                color6.setBorder(colorBorder);
                color7.setBorder(colorBorder);
                color8.setBorder(colorBorder);
                color9.setBorder(colorBorder);
                color10.setBorder(colorBorder);
                color11.setBorder(colorBorder);
                color12.setBorder(colorBorder);
                color13.setBorder(colorBorder);
                color14.setBorder(colorBorder);
                color15.setBorder(colorBorder);
                color16.setBorder(colorBorder);
                color17.setBorder(colorBorder);
                color18.setBorder(colorBorder);
                color19.setBorder(colorBorder);
                color20.setBorder(colorBorder); 
             }
        });
        color3.setBounds(1386,200,75,75);
        color3.setFocusable(false);
        color3.setBackground(new Color(128,128,255));
        color3.setBorder(colorBorder);
        
        color4 = new JButton(new AbstractAction("") {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorSelected = 4;
                color1.setBorder(colorBorder);
                color2.setBorder(colorBorder);
                color3.setBorder(colorBorder);
                color4.setBorder(selectedColor);
                color5.setBorder(colorBorder);
                color6.setBorder(colorBorder);
                color7.setBorder(colorBorder);
                color8.setBorder(colorBorder);
                color9.setBorder(colorBorder);
                color10.setBorder(colorBorder);
                color11.setBorder(colorBorder);
                color12.setBorder(colorBorder);
                color13.setBorder(colorBorder);
                color14.setBorder(colorBorder);
                color15.setBorder(colorBorder);
                color16.setBorder(colorBorder);
                color17.setBorder(colorBorder);
                color18.setBorder(colorBorder);
                color19.setBorder(colorBorder);
                color20.setBorder(colorBorder); 
             }
        });
        color4.setBounds(1461,200,75,75);
        color4.setFocusable(false);
        color4.setBackground(new Color(204,204,255));
        color4.setBorder(colorBorder);

        color5 = new JButton(new AbstractAction("") {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorSelected = 5;
                color1.setBorder(colorBorder);
                color2.setBorder(colorBorder);
                color3.setBorder(colorBorder);
                color4.setBorder(colorBorder);
                color5.setBorder(selectedColor);
                color6.setBorder(colorBorder);
                color7.setBorder(colorBorder);
                color8.setBorder(colorBorder);
                color9.setBorder(colorBorder);
                color10.setBorder(colorBorder);
                color11.setBorder(colorBorder);
                color12.setBorder(colorBorder);
                color13.setBorder(colorBorder);
                color14.setBorder(colorBorder);
                color15.setBorder(colorBorder);
                color16.setBorder(colorBorder);
                color17.setBorder(colorBorder);
                color18.setBorder(colorBorder);
                color19.setBorder(colorBorder);
                color20.setBorder(colorBorder); 
             }
        });
        color5.setBounds(1236,275,75,75);
        color5.setFocusable(false);
        color5.setBackground(new Color(153,0,153));
        color5.setBorder(colorBorder);

        color6 = new JButton(new AbstractAction("") {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorSelected = 6;
                color1.setBorder(colorBorder);
                color2.setBorder(colorBorder);
                color3.setBorder(colorBorder);
                color4.setBorder(colorBorder);
                color5.setBorder(colorBorder);
                color6.setBorder(selectedColor);
                color7.setBorder(colorBorder);
                color8.setBorder(colorBorder);
                color9.setBorder(colorBorder);
                color10.setBorder(colorBorder);
                color11.setBorder(colorBorder);
                color12.setBorder(colorBorder);
                color13.setBorder(colorBorder);
                color14.setBorder(colorBorder);
                color15.setBorder(colorBorder);
                color16.setBorder(colorBorder);
                color17.setBorder(colorBorder);
                color18.setBorder(colorBorder);
                color19.setBorder(colorBorder);
                color20.setBorder(colorBorder); 
             }
        });
        color6.setBounds(1311,275,75,75);
        color6.setFocusable(false);
        color6.setBackground(new Color(255,0,255));
        color6.setBorder(colorBorder);
        
        color7 = new JButton(new AbstractAction("") {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorSelected = 7;
                color1.setBorder(colorBorder);
                color2.setBorder(colorBorder);
                color3.setBorder(colorBorder);
                color4.setBorder(colorBorder);
                color5.setBorder(colorBorder);
                color6.setBorder(colorBorder);
                color7.setBorder(selectedColor);
                color8.setBorder(colorBorder);
                color9.setBorder(colorBorder);
                color10.setBorder(colorBorder);
                color11.setBorder(colorBorder);
                color12.setBorder(colorBorder);
                color13.setBorder(colorBorder);
                color14.setBorder(colorBorder);
                color15.setBorder(colorBorder);
                color16.setBorder(colorBorder);
                color17.setBorder(colorBorder);
                color18.setBorder(colorBorder);
                color19.setBorder(colorBorder);
                color20.setBorder(colorBorder); 
             }
        });
        color7.setBounds(1386,275,75,75);
        color7.setFocusable(false);
        color7.setBackground(new Color(255,128,255));
        color7.setBorder(colorBorder);
        
        color8 = new JButton(new AbstractAction("") {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorSelected = 8;
                color1.setBorder(colorBorder);
                color2.setBorder(colorBorder);
                color3.setBorder(colorBorder);
                color4.setBorder(colorBorder);
                color5.setBorder(colorBorder);
                color6.setBorder(colorBorder);
                color7.setBorder(colorBorder);
                color8.setBorder(selectedColor);
                color9.setBorder(colorBorder);
                color10.setBorder(colorBorder);
                color11.setBorder(colorBorder);
                color12.setBorder(colorBorder);
                color13.setBorder(colorBorder);
                color14.setBorder(colorBorder);
                color15.setBorder(colorBorder);
                color16.setBorder(colorBorder);
                color17.setBorder(colorBorder);
                color18.setBorder(colorBorder);
                color19.setBorder(colorBorder);
                color20.setBorder(colorBorder); 
             }
        });
        color8.setBounds(1461,275,75,75);
        color8.setFocusable(false);
        color8.setBackground(new Color(255,204,255));
        color8.setBorder(colorBorder);

        color9 = new JButton(new AbstractAction("") {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorSelected = 9;
                color1.setBorder(colorBorder);
                color2.setBorder(colorBorder);
                color3.setBorder(colorBorder);
                color4.setBorder(colorBorder);
                color5.setBorder(colorBorder);
                color6.setBorder(colorBorder);
                color7.setBorder(colorBorder);
                color8.setBorder(colorBorder);
                color9.setBorder(selectedColor);
                color10.setBorder(colorBorder);
                color11.setBorder(colorBorder);
                color12.setBorder(colorBorder);
                color13.setBorder(colorBorder);
                color14.setBorder(colorBorder);
                color15.setBorder(colorBorder);
                color16.setBorder(colorBorder);
                color17.setBorder(colorBorder);
                color18.setBorder(colorBorder);
                color19.setBorder(colorBorder);
                color20.setBorder(colorBorder); 
             }
        });
        color9.setBounds(1236,350,75,75);
        color9.setFocusable(false);
        color9.setBackground(new Color(153,0,0));
        color9.setBorder(colorBorder);

        color10 = new JButton(new AbstractAction("") {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorSelected = 10;
                color1.setBorder(colorBorder);
                color2.setBorder(colorBorder);
                color3.setBorder(colorBorder);
                color4.setBorder(colorBorder);
                color5.setBorder(colorBorder);
                color6.setBorder(colorBorder);
                color7.setBorder(colorBorder);
                color8.setBorder(colorBorder);
                color9.setBorder(colorBorder);
                color10.setBorder(selectedColor);
                color11.setBorder(colorBorder);
                color12.setBorder(colorBorder);
                color13.setBorder(colorBorder);
                color14.setBorder(colorBorder);
                color15.setBorder(colorBorder);
                color16.setBorder(colorBorder);
                color17.setBorder(colorBorder);
                color18.setBorder(colorBorder);
                color19.setBorder(colorBorder);
                color20.setBorder(colorBorder); 
             }
        });
        color10.setBounds(1311,350,75,75);
        color10.setFocusable(false);
        color10.setBackground(new Color(255,0,0));
        color10.setBorder(colorBorder);
        
        color11 = new JButton(new AbstractAction("") {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorSelected = 11;
                color1.setBorder(colorBorder);
                color2.setBorder(colorBorder);
                color3.setBorder(colorBorder);
                color4.setBorder(colorBorder);
                color5.setBorder(colorBorder);
                color6.setBorder(colorBorder);
                color7.setBorder(colorBorder);
                color8.setBorder(colorBorder);
                color9.setBorder(colorBorder);
                color10.setBorder(colorBorder);
                color11.setBorder(selectedColor);
                color12.setBorder(colorBorder);
                color13.setBorder(colorBorder);
                color14.setBorder(colorBorder);
                color15.setBorder(colorBorder);
                color16.setBorder(colorBorder);
                color17.setBorder(colorBorder);
                color18.setBorder(colorBorder);
                color19.setBorder(colorBorder);
                color20.setBorder(colorBorder); 
             }
        });
        color11.setBounds(1386,350,75,75);
        color11.setFocusable(false);
        color11.setBackground(new Color(255,128,128));
        color11.setBorder(colorBorder);
        
        color12 = new JButton(new AbstractAction("") {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorSelected = 12;
                color1.setBorder(colorBorder);
                color2.setBorder(colorBorder);
                color3.setBorder(colorBorder);
                color4.setBorder(colorBorder);
                color5.setBorder(colorBorder);
                color6.setBorder(colorBorder);
                color7.setBorder(colorBorder);
                color8.setBorder(colorBorder);
                color9.setBorder(colorBorder);
                color10.setBorder(colorBorder);
                color11.setBorder(colorBorder);
                color12.setBorder(selectedColor);
                color13.setBorder(colorBorder);
                color14.setBorder(colorBorder);
                color15.setBorder(colorBorder);
                color16.setBorder(colorBorder);
                color17.setBorder(colorBorder);
                color18.setBorder(colorBorder);
                color19.setBorder(colorBorder);
                color20.setBorder(colorBorder); 
             }
        });
        color12.setBounds(1461,350,75,75);
        color12.setFocusable(false);
        color12.setBackground(new Color(255,204,204));
        color12.setBorder(colorBorder);

        color13 = new JButton(new AbstractAction("") {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorSelected = 13;
                color1.setBorder(colorBorder);
                color2.setBorder(colorBorder);
                color3.setBorder(colorBorder);
                color4.setBorder(colorBorder);
                color5.setBorder(colorBorder);
                color6.setBorder(colorBorder);
                color7.setBorder(colorBorder);
                color8.setBorder(colorBorder);
                color9.setBorder(colorBorder);
                color10.setBorder(colorBorder);
                color11.setBorder(colorBorder);
                color12.setBorder(colorBorder);
                color13.setBorder(selectedColor);
                color14.setBorder(colorBorder);
                color15.setBorder(colorBorder);
                color16.setBorder(colorBorder);
                color17.setBorder(colorBorder);
                color18.setBorder(colorBorder);
                color19.setBorder(colorBorder);
                color20.setBorder(colorBorder); 
             }
        });
        color13.setBounds(1236,425,75,75);
        color13.setFocusable(false);
        color13.setBackground(new Color(153,153,0));
        color13.setBorder(colorBorder);

        color14 = new JButton(new AbstractAction("") {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorSelected = 14;
                color1.setBorder(colorBorder);
                color2.setBorder(colorBorder);
                color3.setBorder(colorBorder);
                color4.setBorder(colorBorder);
                color5.setBorder(colorBorder);
                color6.setBorder(colorBorder);
                color7.setBorder(colorBorder);
                color8.setBorder(colorBorder);
                color9.setBorder(colorBorder);
                color10.setBorder(colorBorder);
                color11.setBorder(colorBorder);
                color12.setBorder(colorBorder);
                color13.setBorder(colorBorder);
                color14.setBorder(selectedColor);
                color15.setBorder(colorBorder);
                color16.setBorder(colorBorder);
                color17.setBorder(colorBorder);
                color18.setBorder(colorBorder);
                color19.setBorder(colorBorder);
                color20.setBorder(colorBorder); 
             }
        });
        color14.setBounds(1311,425,75,75);
        color14.setFocusable(false);
        color14.setBackground(new Color(255,255,0));
        color14.setBorder(colorBorder);
        
        color15 = new JButton(new AbstractAction("") {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorSelected = 15;
                color1.setBorder(colorBorder);
                color2.setBorder(colorBorder);
                color3.setBorder(colorBorder);
                color4.setBorder(colorBorder);
                color5.setBorder(colorBorder);
                color6.setBorder(colorBorder);
                color7.setBorder(colorBorder);
                color8.setBorder(colorBorder);
                color9.setBorder(colorBorder);
                color10.setBorder(colorBorder);
                color11.setBorder(colorBorder);
                color12.setBorder(colorBorder);
                color13.setBorder(colorBorder);
                color14.setBorder(colorBorder);
                color15.setBorder(selectedColor);
                color16.setBorder(colorBorder);
                color17.setBorder(colorBorder);
                color18.setBorder(colorBorder);
                color19.setBorder(colorBorder);
                color20.setBorder(colorBorder); 
             }
        });
        color15.setBounds(1386,425,75,75);
        color15.setFocusable(false);
        color15.setBackground(new Color(255,255,128));
        color15.setBorder(colorBorder);
        
        color16 = new JButton(new AbstractAction("") {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorSelected = 16;
                color1.setBorder(colorBorder);
                color2.setBorder(colorBorder);
                color3.setBorder(colorBorder);
                color4.setBorder(colorBorder);
                color5.setBorder(colorBorder);
                color6.setBorder(colorBorder);
                color7.setBorder(colorBorder);
                color8.setBorder(colorBorder);
                color9.setBorder(colorBorder);
                color10.setBorder(colorBorder);
                color11.setBorder(colorBorder);
                color12.setBorder(colorBorder);
                color13.setBorder(colorBorder);
                color14.setBorder(colorBorder);
                color15.setBorder(colorBorder);
                color16.setBorder(selectedColor);
                color17.setBorder(colorBorder);
                color18.setBorder(colorBorder);
                color19.setBorder(colorBorder);
                color20.setBorder(colorBorder); 
             }
        });
        color16.setBounds(1461,425,75,75);
        color16.setFocusable(false);
        color16.setBackground(new Color(255,255,204));
        color16.setBorder(colorBorder);

        color17 = new JButton(new AbstractAction("") {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorSelected = 17;
                color1.setBorder(colorBorder);
                color2.setBorder(colorBorder);
                color3.setBorder(colorBorder);
                color4.setBorder(colorBorder);
                color5.setBorder(colorBorder);
                color6.setBorder(colorBorder);
                color7.setBorder(colorBorder);
                color8.setBorder(colorBorder);
                color9.setBorder(colorBorder);
                color10.setBorder(colorBorder);
                color11.setBorder(colorBorder);
                color12.setBorder(colorBorder);
                color13.setBorder(colorBorder);
                color14.setBorder(colorBorder);
                color15.setBorder(colorBorder);
                color16.setBorder(colorBorder);
                color17.setBorder(selectedColor);
                color18.setBorder(colorBorder);
                color19.setBorder(colorBorder);
                color20.setBorder(colorBorder); 
             }
        });
        color17.setBounds(1236,500,75,75);
        color17.setFocusable(false);
        color17.setBackground(new Color(0,153,0));
        color17.setBorder(colorBorder);

        color18 = new JButton(new AbstractAction("") {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorSelected = 18;
                color1.setBorder(colorBorder);
                color2.setBorder(colorBorder);
                color3.setBorder(colorBorder);
                color4.setBorder(colorBorder);
                color5.setBorder(colorBorder);
                color6.setBorder(colorBorder);
                color7.setBorder(colorBorder);
                color8.setBorder(colorBorder);
                color9.setBorder(colorBorder);
                color10.setBorder(colorBorder);
                color11.setBorder(colorBorder);
                color12.setBorder(colorBorder);
                color13.setBorder(colorBorder);
                color14.setBorder(colorBorder);
                color15.setBorder(colorBorder);
                color16.setBorder(colorBorder);
                color17.setBorder(colorBorder);
                color18.setBorder(selectedColor);
                color19.setBorder(colorBorder);
                color20.setBorder(colorBorder); 
             }
        });
        color18.setBounds(1311,500,75,75);
        color18.setFocusable(false);
        color18.setBackground(new Color(0,255,0));
        color18.setBorder(colorBorder);
        
        color19 = new JButton(new AbstractAction("") {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorSelected = 19;
                color1.setBorder(colorBorder);
                color2.setBorder(colorBorder);
                color3.setBorder(colorBorder);
                color4.setBorder(colorBorder);
                color5.setBorder(colorBorder);
                color6.setBorder(colorBorder);
                color7.setBorder(colorBorder);
                color8.setBorder(colorBorder);
                color9.setBorder(colorBorder);
                color10.setBorder(colorBorder);
                color11.setBorder(colorBorder);
                color12.setBorder(colorBorder);
                color13.setBorder(colorBorder);
                color14.setBorder(colorBorder);
                color15.setBorder(colorBorder);
                color16.setBorder(colorBorder);
                color17.setBorder(colorBorder);
                color18.setBorder(colorBorder);
                color19.setBorder(selectedColor);
                color20.setBorder(colorBorder); 
             }
        });
        color19.setBounds(1386,500,75,75);
        color19.setFocusable(false);
        color19.setBackground(new Color(128,255,128));
        color19.setBorder(colorBorder);
        
        color20 = new JButton(new AbstractAction("") {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorSelected = 20;
                color1.setBorder(colorBorder);
                color2.setBorder(colorBorder);
                color3.setBorder(colorBorder);
                color4.setBorder(colorBorder);
                color5.setBorder(colorBorder);
                color6.setBorder(colorBorder);
                color7.setBorder(colorBorder);
                color8.setBorder(colorBorder);
                color9.setBorder(colorBorder);
                color10.setBorder(colorBorder);
                color11.setBorder(colorBorder);
                color12.setBorder(colorBorder);
                color13.setBorder(colorBorder);
                color14.setBorder(colorBorder);
                color15.setBorder(colorBorder);
                color16.setBorder(colorBorder);
                color17.setBorder(colorBorder);
                color18.setBorder(colorBorder);
                color19.setBorder(colorBorder);
                color20.setBorder(selectedColor); 
             }
        });
        color20.setBounds(1461,500,75,75);
        color20.setFocusable(false);
        color20.setBackground(new Color(204,255,204));
        color20.setBorder(colorBorder);

        graphRead = new JTextField("File Path... (file with max 20 vertices)");     //text field to read in the graph (doesnt work yet)
        graphRead.setBounds(250,500, 1000,50);
        graphRead.setFont(new Font("Baskerville Old Face",Font.ITALIC,20));
        graphRead.setVisible(false);
        graphRead.setBorder(buttonBorder);

        checkGameButton = new JButton(new AbstractAction("Finish") {    //button on play panel to validate if the user has completed the game.
            @Override
            public void actionPerformed(ActionEvent e) {
                if(bitterEnd || bestUpper){
                    for (int i = 0; i < vertecesGUI.size(); i++) {
                        int vertexColor = vertecesGUI.get(i).getColour();
                        colorsUsed[vertexColor] = true;
                    }
                    for (int i = 0; i < vertecesGUI.size(); i++) {

                        int vertex_id = vertecesGUI.get(i).getVertexNum();
                        List<Integer> neigh = graphGUI.neighbours(vertex_id);
                        int vertex_color = vertecesGUI.get(i).getColour();

                        for (int j = 0; j < neigh.size(); j++) {
                            int neighbor = neigh.get(i);
                            if(vertex_color == vertecesGUI.get(neighbor).getColour()){
                                hintLabel.setText("Adjecent vertices have the same color, try again");
                            }
                            else{
                                hintLabel.setText("Congratulations");
                            }
                        }
                    }
                    
                    int colorsTotal = 0;
                    for (int i = 0; i < colorsUsed.length; i++) {
                        if(colorsUsed[i]){
                            colorsTotal++;
                        }
                    }

                    if(colorsTotal == backTrackResult){
                        hintLabel.setText("Congratulations");
                    }
                    else{
                        hintLabel.setText("You didn't get it right, try again");
                    }

                }else if(randOrder){

                    for (int i = 0; i < vertecesGUI.size(); i++) {

                        int vertex_id = vertecesGUI.get(i).getVertexNum();
                        List<Integer> neigh = graphGUI.neighbours(vertex_id);
                        int vertex_color = vertecesGUI.get(i).getColour();

                        for (int j = 0; j < neigh.size(); j++) {
                            int neighbor = neigh.get(i);
                            if(vertex_color == vertecesGUI.get(neighbor).getColour()){
                                hintLabel.setText("Adjecent vertices have the same color, try again");
                            }
                            else{
                                hintLabel.setText("Congratulations");
                            }
                        }

                    }
                }
             }
        });
        checkGameButton.setBounds(1236,691,300,50);
        checkGameButton.setFocusable(false);
        checkGameButton.setFont(new Font("Baskerville Old Face",Font.PLAIN,20));
        checkGameButton.setBackground(new Color(173,216,255)); 
        checkGameButton.setBorder(buttonBorder);
        checkGameButton.setVisible(true);

        timer = new JLabel("0");
        timer.setForeground(Color.blue);
        timer.setFont(new Font("Baskerville Old Face",Font.PLAIN,20));
        timer.setBorder(buttonBorder);
        timer.setVerticalAlignment(JLabel.CENTER);
        timer.setHorizontalAlignment(JLabel.CENTER);
        timer.setBounds(1236,0,300,50);

        gametimer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(bestUpper){
                    time--;
                    if(time<=0){
                        hintLabel.setText("You ran out of time");
                        gametimer.stop();
                    }
                    timer.setText(""+ time);
                }else{
                    time++;
                    timer.setText(""+ time);
                }
            }
          });

        buttonBounds = new JLabel();
        buttonBounds.setForeground(Color.blue);
        buttonBounds.setFont(new Font("Baskerville Old Face",Font.PLAIN,50));
        buttonBounds.setBorder(border);
        buttonBounds.setVerticalAlignment(JLabel.CENTER);
        buttonBounds.setHorizontalAlignment(JLabel.CENTER);
        buttonBounds.setBounds(0,0,1236,841);

        randomizeVertices = new JButton(new AbstractAction("Relocate Vertices") {   //reloctes the vertex buttons and saves coordinates in 2d array named vertexLocations
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < vertexCount; i++) {
                    Random xRandomize = new Random();
                    Random yRandomize = new Random();
                    xPosRand = xRandomize.nextInt(1181);
                    yPosRand = yRandomize.nextInt(794);
                    vertexButtons[i].setLocation(xPosRand, yPosRand);

                    vertexLocations[i][0] = (xPosRand+25);
                    vertexLocations[i][1] = (yPosRand+25);
                   
                    
                }
             }
        });
        randomizeVertices.setBounds(1236,741,300,50);
        randomizeVertices.setFocusable(false);
        randomizeVertices.setFont(new Font("Baskerville Old Face",Font.PLAIN,20));
        randomizeVertices.setBackground(new Color(173,216,255));
        randomizeVertices.setBorder(buttonBorder);
        randomizeVertices.setVisible(true);

        backMenuButton = new JButton(new AbstractAction("Title Screen") { //button on play screen that that returns user to title screen
            @Override
            public void actionPerformed(ActionEvent e) {
                gametimer.stop();
                time = 0;
                timer.setText("0");
                hintLabel.setText("");
                startPanel.setVisible(true);
                playPanel.setVisible(false);
                vertexCount = 1;
                vertexAmount.setText("Vertices: " + vertexCount);
                edgeCount = 0;
                edgeAmount.setText("Edges: " + edgeCount);
                downVertex.setVisible(false);
                downEdge.setVisible(false);
                playPanel.removeAll();
                playPanel.setLayout(null);
                playPanel.setBounds(0,0,1920,1080);
                playPanel.setBackground(new Color(130,197,223));
                playPanel.setVisible(false);
                playPanel.add(backMenuButton);
                playPanel.add(buttonBounds);
                playPanel.add(randomizeVertices);
                playPanel.add(hintButton);
                playPanel.add(hintLabel);
                playPanel.add(timer);
                playPanel.add(checkGameButton);
                playPanel.add(color1);
                playPanel.add(color2);
                playPanel.add(color3);
                playPanel.add(color4);
                playPanel.add(color5);
                playPanel.add(color6);
                playPanel.add(color7);
                playPanel.add(color8);
                playPanel.add(color9);
                playPanel.add(color10);
                playPanel.add(color11);
                playPanel.add(color12);
                playPanel.add(color13);
                playPanel.add(color14);
                playPanel.add(color15);
                playPanel.add(color16);
                playPanel.add(color17);
                playPanel.add(color18);
                playPanel.add(color19);
                playPanel.add(color20);
                indexBestUpperHints = 0;
                indexBitterEndHints = 0;
                indexrandOrderHints = 0;

             }
        });
        backMenuButton.setBounds(1236,791,300,50);
        backMenuButton.setFocusable(false);
        backMenuButton.setFont(new Font("Baskerville Old Face",Font.PLAIN,20));
        backMenuButton.setBackground(new Color(173,216,255));
        backMenuButton.setBorder(buttonBorder);

        startButton = new JButton(new AbstractAction("Play With Selected Options") {    //sends user from selection screen to play screen with selected options.
            @Override
            public void actionPerformed(ActionEvent e) {

                if(txtinput){
                    
                    try {
                        GraphMatrix graph =  txtReader.createGraphFromTxt_Matrix(graphRead.getText());
                        graphGUI = graph;
                        vertexCount = graphGUI.getNumVert();
                        upperBound = Upper_bound.upperBound_maxDegree(graph);
                        graph.createVertexGraph();
                        List<Vertex> vertices = graph.getVertexGraph();
                        backTrackResult = Backtrack.backTrack(graph);
                        vertecesGUI = vertices;
                        
                    } catch (FileNotFoundException e1) {

                        e1.printStackTrace();
                    }
                }else{
                    GraphMatrix graph = randomGraph_GUI(vertexCount,edgeCount);
                    upperBound = Upper_bound.upperBound_maxDegree(graph);
                    graph.createVertexGraph();
                    List<Vertex> vertices = graph.getVertexGraph();
                    graphGUI = graph;
                    backTrackResult = Backtrack.backTrack(graph);
                    vertecesGUI = vertices;
                }
                    
                if(bitterEnd || randOrder || bestUpper){
                selectionPanel.setVisible(false);
                playPanel.setVisible(true);
                vertexButtons = new JButton[vertexCount];
                vertexLocations = new int[vertexCount][2];

                if(bitterEnd){
                    gametimer.start();
                }else if (randOrder){
                    gametimer.start();
                }else if (bestUpper){
                    time = vertexCount*3;
                    timer.setText(""+ time);
                    gametimer.start();
                }
                //greate a adj matrix graph from given params
                upperBoundString = Integer.toString(upperBound);
                hint1 = "Amount of colors used should be less or equal to " + upperBoundString + " colors";
                bitterEndHints[0] = hint1;
                bestUpperHints[0] = hint1;
                randOrderHints[0] = hint1;
                //System.out.println(" agjaskldfjlaksjdflkasf" +upperBound);
                sequence = RandomVertexSequence((ArrayList<Vertex>)vertecesGUI);
                //print the sequence
                // for (int i = 0; i < graph.getNumVert(); i++) {
                //     System.out.println("rand sequence " + (sequence.get(i).getVertexNum() + 1));
                // }
                for(int i=0; i<vertexCount; i++){           //creates vertices with selected amount and in 2d array named vertexLocations
                    vertexButtons[i] = new JButton(new AbstractAction(""+ (i+1)) {
                        @Override
                        
                        public void actionPerformed(ActionEvent e) {    //the vertex button, now changes color corresponding to selected color. Here, a method which checks if the user can color the vertex a certain color should go.
                            String buttonNr = ((JButton) e.getSource()).getText();
                            Vertex pickedVertex = vertecesGUI.get(Integer.parseInt(buttonNr)-1);
                            System.out.println("sequence ID " + (sequence.get(sequenceIndex).getVertexNum() + 1));
                            System.out.println("picked vertex id " + (pickedVertex.getVertexNum()+1));
                            if((randOrder && pickedVertex.getColour() != -1 )|| (randOrder && (pickedVertex.getVertexNum()+1) != (sequence.get(sequenceIndex).getVertexNum()+1))){}
                            else{
                                if(randOrder){
                                    try{
                                    vertexButtons[(sequence.get(sequenceIndex+1).getVertexNum())].setBackground(new Color(220,220,220)); 
                                    }catch(Exception exception){}
                                }
                            switch(colorSelected){
                                case 1: vertexButtons[Integer.parseInt(buttonNr)-1].setBackground(new Color(0,0,153));
                                break;
                                case 2: vertexButtons[Integer.parseInt(buttonNr)-1].setBackground(new Color(0,0,255));
                                break;
                                case 3: vertexButtons[Integer.parseInt(buttonNr)-1].setBackground(new Color(128,128,255));
                                break;
                                case 4: vertexButtons[Integer.parseInt(buttonNr)-1].setBackground(new Color(204,204,255));
                                break;
                                case 5: vertexButtons[Integer.parseInt(buttonNr)-1].setBackground(new Color(153,0,153));
                                break;
                                case 6: vertexButtons[Integer.parseInt(buttonNr)-1].setBackground(new Color(255,0,255));
                                break;
                                case 7: vertexButtons[Integer.parseInt(buttonNr)-1].setBackground(new Color(255,128,255));
                                break;
                                case 8: vertexButtons[Integer.parseInt(buttonNr)-1].setBackground(new Color(255,204,255));
                                break;
                                case 9: vertexButtons[Integer.parseInt(buttonNr)-1].setBackground(new Color(153,0,0));
                                break;
                                case 10: vertexButtons[Integer.parseInt(buttonNr)-1].setBackground(new Color(255,0,0));
                                break;
                                case 11: vertexButtons[Integer.parseInt(buttonNr)-1].setBackground(new Color(255,128,128));
                                break;
                                case 12: vertexButtons[Integer.parseInt(buttonNr)-1].setBackground(new Color(255,204,204));
                                break;
                                case 13: vertexButtons[Integer.parseInt(buttonNr)-1].setBackground(new Color(153,153,0));
                                break;
                                case 14: vertexButtons[Integer.parseInt(buttonNr)-1].setBackground(new Color(255,255,0));
                                break;
                                case 15: vertexButtons[Integer.parseInt(buttonNr)-1].setBackground(new Color(255,255,128));
                                break;
                                case 16: vertexButtons[Integer.parseInt(buttonNr)-1].setBackground(new Color(255,255,204));
                                break;
                                case 17: vertexButtons[Integer.parseInt(buttonNr)-1].setBackground(new Color(0,153,0));
                                break;
                                case 18: vertexButtons[Integer.parseInt(buttonNr)-1].setBackground(new Color(0,255,0));
                                break;
                                case 19: vertexButtons[Integer.parseInt(buttonNr)-1].setBackground(new Color(128,255,128));
                                break;
                                case 20: vertexButtons[Integer.parseInt(buttonNr)-1].setBackground(new Color(204,255,204));
                                break;
                                
                            }
                        }
                            colorVertexGUI(pickedVertex, colorSelected, randOrder);

                            if(randOrder){
                                sequenceIndex++;
                            }
                            System.out.println("ID:" + pickedVertex.getVertexNum());
                            System.out.println("Color :" + pickedVertex.getColour());
                        }
                    });
                    vertexButtons[i].setFont(new Font("Baskerville Old Face",Font.PLAIN,15));
                    vertexButtons[i].setBackground(Color.WHITE);
                    vertexButtons[i].setSize(50,50);
                    vertexButtons[i].setFocusable(false);
                    Random xRand = new Random();
                    Random yRand = new Random();
                    xPosition = xRand.nextInt(1181);
                    yPosition = yRand.nextInt(794);
                    vertexButtons[i].setLocation(xPosition, yPosition);
                    playPanel.add(vertexButtons[i]);
                    
                    vertexLocations[i][0] = (xPosition+25);     
                    vertexLocations[i][1] = (yPosition+25);         //sets location of vertex buttons
                    
                } 
                }
                if(randOrder){
                    vertexButtons[(sequence.get(0).getVertexNum())].setBackground(new Color(220,220,220));
                }
        }
        });
        startButton.setBounds(250,625,1000,50);
        startButton.setFont(new Font("Baskerville Old Face",Font.PLAIN,20));
        startButton.setFocusable(false);
        startButton.setBackground(new Color(173,216,255));
        startButton.setBorder(buttonBorder); 

        hintLabel = new JLabel("");
        hintLabel.setForeground(Color.blue);
        hintLabel.setFont(new Font("Baskerville Old Face",Font.PLAIN,20));
        hintLabel.setVerticalAlignment(JLabel.CENTER);
        hintLabel.setHorizontalAlignment(JLabel.CENTER);
        hintLabel.setBounds(0,10,1236,50);
        
        hintButton = new JButton(new AbstractAction("Hint") {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(hintDisplay == true){
                    hintLabel.setText("");
                    hintDisplay = false;
                    
                }else if(bitterEnd && hintDisplay==false){
                    hintLabel.setText(bitterEndHints[indexBitterEndHints]);
                    hintDisplay = true;
                    indexBitterEndHints++;
                    if(indexBitterEndHints >=3){
                        indexBitterEndHints = 0;
                    }
                }else if(randOrder && hintDisplay==false){
                    hintLabel.setText(randOrderHints[indexrandOrderHints]);
                    hintDisplay = true;
                    indexrandOrderHints++;
                    if(indexrandOrderHints >=3){
                        indexrandOrderHints = 0;
                    }
                }else if(bestUpper && hintDisplay==false){
                    hintLabel.setText(bestUpperHints[indexBestUpperHints]);
                    hintDisplay = true;
                    indexBestUpperHints++;
                    if(indexBestUpperHints >=3){
                        indexBestUpperHints = 0;
                    }
                }
             }
        });
        hintButton.setBounds(1236,50,300,50);
        hintButton.setFocusable(false);
        hintButton.setFont(new Font("Baskerville Old Face",Font.PLAIN,20));
        hintButton.setBackground(new Color(173,216,255)); 
        hintButton.setBorder(buttonBorder);
        hintButton.setVisible(true);


        selectMode = new JLabel("Select Game Mode");
        selectMode.setForeground(Color.blue);
        selectMode.setFont(new Font("Baskerville Old Face",Font.PLAIN,30));
        selectMode.setBorder(border);
        selectMode.setVerticalAlignment(JLabel.CENTER);
        selectMode.setHorizontalAlignment(JLabel.CENTER);
        selectMode.setBounds(250,75,1000,50);

        bitterEndMode = new JButton(new AbstractAction("To The Bitter End") {       //button to select bitter end gamemode, (doesnt work yet, probably set int to certain value and then check that int when starting the game to see what gamemode the user has selected)
            @Override
            public void actionPerformed(ActionEvent e) {
                bitterEndMode.setBackground(new Color(77, 148, 255));
                bestUpperBoundMode.setBackground(new Color(173,216,255));
                randomOrderMode.setBackground(new Color(173,216,255));
                bitterEnd = true;
                randOrder = false;
                bestUpper = false;
            }
        });
        bitterEndMode.setBounds(250,150,300,50);
        bitterEndMode.setFocusable(false);        
        bitterEndMode.setFont(new Font("Baskerville Old Face",Font.PLAIN,20));
        bitterEndMode.setBackground(new Color(173,216,255));
        bitterEndMode.setBorder(buttonBorder);

        bestUpperBoundMode = new JButton(new AbstractAction("Best Upper Bound") { //button to select best upper bound mode (doesnt work yet, probably set int to certain value and then check that int when starting the game to see what gamemode the user has selected)
            @Override
            public void actionPerformed(ActionEvent e) {
                bitterEndMode.setBackground(new Color(173,216,255));
                bestUpperBoundMode.setBackground(new Color(77, 148, 255));
                randomOrderMode.setBackground(new Color(173,216,255));
                bitterEnd = false;
                randOrder = false;
                bestUpper = true;
                
            }
        });
        bestUpperBoundMode.setBounds(600,150,300,50);
        bestUpperBoundMode.setFocusable(false);        
        bestUpperBoundMode.setFont(new Font("Baskerville Old Face",Font.PLAIN,20));
        bestUpperBoundMode.setBackground(new Color(173,216,255));
        bestUpperBoundMode.setBorder(buttonBorder);

        randomOrderMode = new JButton(new AbstractAction("Random Order") { //button to select random order mode (doesnt work yet, probably set int to certain value and then check that int when starting the game to see what gamemode the user has selected)
            @Override
            public void actionPerformed(ActionEvent e) {
                bitterEndMode.setBackground(new Color(173,216,255));
                bestUpperBoundMode.setBackground(new Color(173,216,255));
                randomOrderMode.setBackground(new Color(77, 148, 255));
                bitterEnd = false;
                randOrder = true;
                bestUpper = false;
                
            }
        });
        randomOrderMode.setBounds(950,150,300,50);
        randomOrderMode.setFocusable(false);        
        randomOrderMode.setFont(new Font("Baskerville Old Face",Font.PLAIN,20));
        randomOrderMode.setBackground(new Color(173,216,255));
        randomOrderMode.setBorder(buttonBorder);

        vertexAmount = new JLabel("Vertices: 1");
        vertexAmount.setForeground(Color.blue);
        vertexAmount.setFont(new Font("Baskerville Old Face",Font.PLAIN,30));
        vertexAmount.setBorder(border);
        vertexAmount.setVerticalAlignment(JLabel.CENTER);
        vertexAmount.setHorizontalAlignment(JLabel.CENTER);
        vertexAmount.setBounds(250,500, 475,50);

        edgeAmount = new JLabel("Edges: 0");
        edgeAmount.setForeground(Color.blue);
        edgeAmount.setFont(new Font("Baskerville Old Face",Font.PLAIN,30));
        edgeAmount.setBorder(border);
        edgeAmount.setVerticalAlignment(JLabel.CENTER);
        edgeAmount.setHorizontalAlignment(JLabel.CENTER);
        edgeAmount.setBounds(775,500, 475,50);

        upEdge = new JButton(new AbstractAction("+") {      //increases amount of edges in selection screen
            @Override
            public void actionPerformed(ActionEvent e) {
                edgeCount++;
                edgeAmount.setText("Edges: " + edgeCount);
                if(edgeCount>0){
                    downEdge.setVisible(true);
                }
                if(edgeCount >= ((vertexCount*(vertexCount-1))/2)){
                    upEdge.setVisible(false);
                }
            }
        });
        upEdge.setBounds(775,465, 475,25);
        upEdge.setFocusable(false);
        upEdge.setFont(new Font("Baskerville Old Face",Font.PLAIN,20));
        upEdge.setBackground(new Color(173,216,255));
        upEdge.setBorder(buttonBorder);

        downEdge = new JButton(new AbstractAction("-") { //decreases amount of edges in selection screen
            @Override
            public void actionPerformed(ActionEvent e) {
                edgeCount--;
                edgeAmount.setText("Edges: "+ edgeCount);
                if(edgeCount<((vertexCount*(vertexCount-1))/2)){
                    upEdge.setVisible(true);
                }
                if(edgeCount <=0){
                    downEdge.setVisible(false);
                }
            }
        });
        downEdge.setBounds(775,560, 475,25);
        downEdge.setFocusable(false);
        downEdge.setFont(new Font("Baskerville Old Face",Font.PLAIN,20));
        downEdge.setVisible(false);
        downEdge.setBackground(new Color(173,216,255));
        downEdge.setBorder(buttonBorder);

        upVertex = new JButton(new AbstractAction("+") {//increases amount of vertices in selection screen
            @Override
            public void actionPerformed(ActionEvent e) {
                vertexCount++;
                vertexAmount.setText("Vertices: "+ vertexCount);
                if(vertexCount>1){
                    downVertex.setVisible(true);
                }
                if(vertexCount >=20){
                    upVertex.setVisible(false);
                }
                if(edgeCount <= 0){
                    downEdge.setVisible(false);   
                }                   
                if(edgeCount <= ((vertexCount*(vertexCount-1))/2)){
                    upEdge.setVisible(true); 
                }    
            }
        });
        upVertex.setBounds(250,465, 475,25);
        upVertex.setFocusable(false);
        upVertex.setFont(new Font("Baskerville Old Face",Font.PLAIN,20));
        upVertex.setBackground(new Color(173,216,255));
        upVertex.setBorder(buttonBorder);

        downVertex = new JButton(new AbstractAction("-") { //decreases amount of vertices in selection screen
            @Override
            public void actionPerformed(ActionEvent e) {
                vertexCount--;
                vertexAmount.setText("Vertices: "+ vertexCount);
                if(vertexCount<20){
                    upVertex.setVisible(true);
                }
                if(vertexCount <=1){
                    downVertex.setVisible(false);
                }
                if(edgeCount > ((vertexCount*(vertexCount-1))/2)){
                    edgeCount = ((vertexCount*(vertexCount-1))/2);
                    edgeAmount.setText("Edges: " + edgeCount);
                    upEdge.setVisible(false);
                    if(edgeCount<=0){
                        downEdge.setVisible(false);
                    }
                }
                if(edgeCount > 0){
                    downEdge.setVisible(true);
                }
                if(edgeCount >= ((vertexCount*(vertexCount-1))/2)){
                    upEdge.setVisible(false); 
                }
            }
        });
        downVertex.setBounds(250,560, 475,25);
        downVertex.setFocusable(false);
        downVertex.setFont(new Font("Baskerville Old Face",Font.PLAIN,20));
        downVertex.setVisible(false);
        downVertex.setBackground(new Color(173,216,255));
        downVertex.setBorder(buttonBorder);

        exitButton = new JButton(new AbstractAction("Exit") { //gives a pop up screen asking if the user wants to quit the game
            @Override
            public void actionPerformed(ActionEvent e) {
                new exitGUI();
            }
        });
        exitButton.setBounds(520,500, 500,50);
        exitButton.setFocusable(false);
        exitButton.setFont(new Font("Baskerville Old Face",Font.PLAIN,20));
        exitButton.setBackground(new Color(93,197,223));
        exitButton.setBorder(buttonBorder);

        playButton = new JButton(new AbstractAction("Play") {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectionPanel.setVisible(true);
                startPanel.setVisible(false);
                upVertex.setVisible(true);
                upEdge.setVisible(true);
            }
        });
        playButton.setBounds(520,425, 500,50);
        playButton.setFocusable(false);
        playButton.setFont(new Font("Baskerville Old Face",Font.PLAIN,20));
        playButton.setBackground(new Color(93,197,223));
        playButton.setBorder(buttonBorder);

        menuButton = new JButton(new AbstractAction("Back") { //sends the user from selection screen to title screen
            @Override
            public void actionPerformed(ActionEvent e) {
                selectionPanel.setVisible(false);
                startPanel.setVisible(true);
                vertexCount = 1;
                vertexAmount.setText("Vertices: " + vertexCount);
                edgeCount = 10;
                edgeAmount.setText("Edges: " + edgeCount);
                downVertex.setVisible(false);
                downEdge.setVisible(false);
            }
        });
        menuButton.setBounds(600,800,300,50);
        menuButton.setFocusable(false);
        menuButton.setFont(new Font("Baskerville Old Face",Font.PLAIN,20));
        menuButton.setBackground(new Color(173,216,255));
        menuButton.setBorder(buttonBorder);

        randomButton = new JButton(new AbstractAction("Random") { //lets user set vertices to random, if pressed multiple times, the amount of vertices and edges get randomized
            @Override
            public void actionPerformed(ActionEvent e) {
                randomButton.setBackground(new Color(77, 148, 255));
                customButton.setBackground(new Color(173,216,255));
                txtinput = false;
                     try{
                    Random randVertex = new Random();
                    Random randEdge = new Random();
                    vertexCount = randVertex.nextInt(2,19);
                    edgeCount = randEdge.nextInt(0,(((vertexCount*(vertexCount-1))/2))-1);
                    vertexAmount.setText("Vertices: " + vertexCount);
                    edgeAmount.setText("Edges: " + edgeCount);
                }catch(Exception exception){
                    edgeCount = vertexCount;
                }
                graphRead.setVisible(false);
                randomCustom = true;
                if(vertexCount<20){
                    upVertex.setVisible(true);
                }
                if(vertexCount>1){
                    downVertex.setVisible(true);
                }
                if(edgeCount < ((vertexCount*(vertexCount-1))/2)){
                    upEdge.setVisible(true);
                }
                if(edgeCount>0){
                    downEdge.setVisible(true);
                }
            }
        });
        randomButton.setBounds(250,325, 475,50);
        randomButton.setFocusable(false);        
        randomButton.setFont(new Font("Baskerville Old Face",Font.PLAIN,20));
        randomButton.setBackground(new Color(77, 148, 255));
        randomButton.setBorder(buttonBorder);
        
        customButton = new JButton(new AbstractAction("Custom") {   //lets the user input a graph file
            @Override
            public void actionPerformed(ActionEvent e) {
                randomButton.setBackground(new Color(173,216,255));
                customButton.setBackground(new Color(77, 148, 255));
                graphRead.setVisible(true);
                randomCustom = false;
                upVertex.setVisible(false);
                upEdge.setVisible(false);
                downVertex.setVisible(false);
                downEdge.setVisible(false);
                txtinput = true;
            }
        });
        customButton.setBounds(775,325, 475,50);
        customButton.setFocusable(false);        
        customButton.setFont(new Font("Baskerville Old Face",Font.PLAIN,20));
        customButton.setBackground(new Color(173,216,255));
        customButton.setBorder(buttonBorder);

        JLabel title = new JLabel("Graph Coloring Game");
        title.setForeground(Color.blue);
        title.setFont(new Font("Baskerville Old Face",Font.PLAIN,50));
        title.setBorder(border);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(520,150,500,100);

        JLabel filePath = new JLabel("File Path:");
        filePath.setForeground(Color.blue);
        filePath.setFont(new Font("Baskerville Old Face",Font.PLAIN,20));
        
        playPanel =  new javax.swing.JPanel() { //play screen with actual game
            @Override
            protected void paintComponent(Graphics g) { //here we get the locations of the vertices which should be connected, and draw a line in between
                
                super.paintComponent(g);
                Graphics2D edges = (Graphics2D) g;
                edges.setStroke(new BasicStroke(4));

                //graphGUI.printGraph();
                for (int i = 0; i < graphGUI.getNumVert(); i++){
                    for (int j = i + 1; j < graphGUI.getNumVert(); j++) {
                        if (graphGUI.hasEdge(i,j)){
                            edges.drawLine(vertexLocations[i][0],vertexLocations[i][1],vertexLocations[j][0],vertexLocations[j][1]);
                        }
                    }
                }
            }
        };
        playPanel.setLayout(null);
        playPanel.setBounds(0,0,1920,1080);
        playPanel.setBackground(new Color(130,197,223));
        playPanel.setVisible(false);
        playPanel.add(backMenuButton);
        playPanel.add(buttonBounds);
        playPanel.add(randomizeVertices);
        playPanel.add(hintButton);
        playPanel.add(hintLabel);
        playPanel.add(checkGameButton);
        playPanel.add(timer);
        playPanel.add(color1);
        playPanel.add(color2);
        playPanel.add(color3);
        playPanel.add(color4);
        playPanel.add(color5);
        playPanel.add(color6);
        playPanel.add(color7);
        playPanel.add(color8);
        playPanel.add(color9);
        playPanel.add(color10);
        playPanel.add(color11);
        playPanel.add(color12);
        playPanel.add(color13);
        playPanel.add(color14);
        playPanel.add(color15);
        playPanel.add(color16);
        playPanel.add(color17);
        playPanel.add(color18);
        playPanel.add(color19);
        playPanel.add(color20);

        startPanel =  new javax.swing.JPanel() {    //title screen
            @Override
        protected void paintComponent(Graphics grphcs) {    //ignore these graphics, they are to give background gradient
            Color background = new Color(137,207,240);
            Color background2 = new Color(50,50,255);

            super.paintComponent(grphcs);
            Graphics2D g2d = (Graphics2D) grphcs;
            g2d.setColor(Color.RED);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            GradientPaint gp = new GradientPaint(0, 0,
                    background, 0, getHeight(),
                    background2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, getWidth(), getHeight()); 

        }
    };
        startPanel.setLayout(null);
        startPanel.setBackground(new Color(173,216,255));
        startPanel.setBounds(0,0,1920,1080);
        startPanel.add(exitButton);
        startPanel.add(playButton);
        startPanel.add(title);

        selectionPanel =  new javax.swing.JPanel() { //selection screen
            @Override
        protected void paintComponent(Graphics grphcs) { //ignore these graphics, they are to give background gradient
            Color background = new Color(137,207,240);
            Color background2 = new Color(50,50,255);
            super.paintComponent(grphcs);
            Graphics2D g2d = (Graphics2D) grphcs;
            g2d.setColor(Color.RED);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            GradientPaint gp = new GradientPaint(0, 0,
                    background, 0, getHeight(),
                    background2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, getWidth(), getHeight()); 

        }
    };
        selectionPanel.setLayout(null);
        selectionPanel.setBackground(new Color(93,197,223));
        selectionPanel.setBounds(0,0,1920,1080);
        selectionPanel.setVisible(false);
        selectionPanel.add(menuButton);
        selectionPanel.add(randomButton);
        selectionPanel.add(customButton);
        selectionPanel.add(graphRead);
        selectionPanel.add(upVertex);
        selectionPanel.add(downVertex);
        selectionPanel.add(vertexAmount);
        selectionPanel.add(edgeAmount);
        selectionPanel.add(upEdge);
        selectionPanel.add(downEdge);
        selectionPanel.add(bitterEndMode);
        selectionPanel.add(bestUpperBoundMode);
        selectionPanel.add(randomOrderMode);
        selectionPanel.add(selectMode);
        selectionPanel.add(startButton);
        
        frame = new JFrame ();  //actual frame where everything is displayed on
        frame.setTitle("Graph Coloring");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(173,216,230));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        frame.add(startPanel);
        frame.add(selectionPanel);
        frame.add(playPanel);
    }

    public static void main(String[] args) {
        new GUI2();
    }
}
