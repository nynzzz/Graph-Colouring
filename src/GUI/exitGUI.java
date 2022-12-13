package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class exitGUI{

    JButton exitbutton2; 
    JButton cancelbutton;
    JFrame exitFrame;

    public exitGUI() {  //this gui is only asking the user if they want to quit
        
        Border buttonBorder = BorderFactory.createLineBorder(new Color(0, 102, 255),3);

        JLabel label = new JLabel("Are you sure?");
        label.setBounds(18,7, 150,30);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Baskerville Old Face",Font.PLAIN,20));
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);

        cancelbutton = new JButton(new AbstractAction("Cancel") {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                exitFrame.dispatchEvent(new WindowEvent(exitFrame, WindowEvent.WINDOW_CLOSING));
            }
        });
        cancelbutton.setFocusable(false);
        cancelbutton.setBounds(18,50, 150,30);
        cancelbutton.setFont(new Font("Baskerville Old Face",Font.PLAIN,20));
        cancelbutton.setBackground(new Color(173,216,255));
        cancelbutton.setBorder(buttonBorder);

        exitbutton2 = new JButton(new AbstractAction("Exit") {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                exitFrame.dispatchEvent(new WindowEvent(exitFrame, WindowEvent.WINDOW_CLOSING));
            }
        });
        exitbutton2.setFocusable(false);
        exitbutton2.setBounds(18,100, 150,30);
        exitbutton2.setFont(new Font("Baskerville Old Face",Font.PLAIN,20));
        exitbutton2.setBackground(new Color(173,216,255));
        exitbutton2.setBorder(buttonBorder);

        exitFrame = new JFrame("Exit?");
        exitFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        exitFrame.setResizable(false);
        exitFrame.setVisible(true);
        exitFrame.getContentPane().setBackground(new Color(93,197,223));
        exitFrame.setSize(200, 200);
        exitFrame.setLocationRelativeTo(null);
        exitFrame.setLayout(null);
        exitFrame.add(cancelbutton);
        exitFrame.add(exitbutton2);
        exitFrame.add(label);
        

    }

}
