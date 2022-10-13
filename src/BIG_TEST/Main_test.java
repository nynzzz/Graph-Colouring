package BIG_TEST;

import Algorithms.Backtrack;
import Algorithms.Greedy;
import Algorithms.TabuCol;
import Graph_Implementation.GraphList;
import Graph_Implementation.GraphMatrix;
import Lower_Upper_bound_approx.Lower_bound;
import Lower_Upper_bound_approx.Upper_bound;
import txtReader_ForGivenGraphs.txtReader;

import java.io.FileNotFoundException;

public class Main_test {

public static void main(String[] args) throws FileNotFoundException {

//    Backtrack backtrack = new Backtrack();
//    Greedy greedy = new Greedy();
//    TabuCol tabuCol = new TabuCol();
//    Lower_bound lower_bound = new Lower_bound();
//    Upper_bound upper_bound = new Upper_bound();
//    txtReader txtReader = new txtReader();

//    //graph 01
//    String path = "/Users/mymac/Desktop/Graph_Coloring_1.1/Graph_Coloring_1.1/src/txtReader_ForGivenGraphs/graph01_2022.txt";
//    GraphMatrix graph_matrix1 = txtReader.createGraphFromTxt_Matrix(path);
//    GraphList graph_list1 = txtReader.createGraphFromTxt_List(path);
//
//    System.out.println("lower bound approximation 01: " + Lower_bound.lowerBound_cycle(graph_matrix1));
//    System.out.println("upper bound approximation (max degree vertex)f 01: " + Upper_bound.upperBound_maxDegree(graph_matrix1));
//    System.out.println("upper bound approximation (vertex cover) 01: " + Upper_bound.upperBound_vertCov(graph_matrix1));
//    System.out.println("greedy 01: " + Greedy.greedy(graph_list1));

//    //graph 02
//    String path = "/Users/mymac/Desktop/Graph_Coloring_1.1/Graph_Coloring_1.1/src/txtReader_ForGivenGraphs/graph02_2022.txt";
//    GraphMatrix graph_matrix2 = txtReader.createGraphFromTxt_Matrix(path);
//    GraphList graph_list2 = txtReader.createGraphFromTxt_List(path);
//
//    System.out.println("lower bound approximation 02: " + Lower_bound.lowerBound_cycle(graph_matrix2));
//    System.out.println("upper bound approximation (max degree vertex) 02: " + Upper_bound.upperBound_maxDegree(graph_matrix2));
//    System.out.println("upper bound approximation (vertex cover) 02: " + Upper_bound.upperBound_vertCov(graph_matrix2));
////    System.out.println("back-track 02: " + Backtrack.backTrack(graph_matrix2));
//    System.out.println("greedy 02: " + Greedy.greedy(graph_list2));
////    System.out.println("tabuCol 02: " + TabuCol.tabuCol(graph_matrix2, 0));

    //graph 03
//    String path = "/Users/mymac/Desktop/Graph_Coloring_1.1/Graph_Coloring_1.1/src/txtReader_ForGivenGraphs/graph03_2022.txt";
//    GraphMatrix graph_matrix3 = txtReader.createGraphFromTxt_Matrix(path);
//    GraphList graph_list3 = txtReader.createGraphFromTxt_List(path);
//
//    System.out.println("lower bound approximation 03: " + Lower_bound.lowerBound_cycle(graph_matrix3));
//    System.out.println("upper bound approximation (max degree vertex) 03: " + Upper_bound.upperBound_maxDegree(graph_matrix3));
//    System.out.println("upper bound approximation (vertex cover) 03: " + Upper_bound.upperBound_vertCov(graph_matrix3));
////    System.out.println("back-track 03: " + Backtrack.backTrack(graph_matrix3));
//    System.out.println("greedy 03: " + Greedy.greedy(graph_list3));
////    System.out.println("tabuCol 03: " + TabuCol.tabuCol(graph_matrix3, 0));

//    //graph 04
//    String path = "/Users/mymac/Desktop/Graph_Coloring_1.1/Graph_Coloring_1.1/src/txtReader_ForGivenGraphs/graph04_2022.txt";
//    GraphMatrix graph_matrix4 = txtReader.createGraphFromTxt_Matrix(path);
//    GraphList graph_list4 = txtReader.createGraphFromTxt_List(path);
//
//    System.out.println("lower bound approximation 04: " + Lower_bound.lowerBound_cycle(graph_matrix4));
//    System.out.println("upper bound approximation (max degree vertex) 04: " + Upper_bound.upperBound_maxDegree(graph_matrix4));
//    System.out.println("upper bound approximation (vertex cover) 04: " + Upper_bound.upperBound_vertCov(graph_matrix4));
////    System.out.println("back-track 04: " + Backtrack.backTrack(graph_matrix4));
//    System.out.println("greedy 04: " + Greedy.greedy(graph_list4));
////    System.out.println("tabuCol 04: " + TabuCol.tabuCol(graph_matrix4, 0));

//    //graph 05
//    String path = "/Users/mymac/Desktop/Graph_Coloring_1.1/Graph_Coloring_1.1/src/txtReader_ForGivenGraphs/graph05_2022.txt";
//    GraphMatrix graph_matrix5 = txtReader.createGraphFromTxt_Matrix(path);
//    GraphList graph_list5 = txtReader.createGraphFromTxt_List(path);
//
//    System.out.println("lower bound approximation 05: " + Lower_bound.lowerBound_cycle(graph_matrix5));
//    System.out.println("upper bound approximation (max degree vertex) 05: " + Upper_bound.upperBound_maxDegree(graph_matrix5));
//    System.out.println("upper bound approximation (vertex cover) 05: " + Upper_bound.upperBound_vertCov(graph_matrix5));
////    System.out.println("back-track 05: " + Backtrack.backTrack(graph_matrix5));
//    System.out.println("greedy 05: " + Greedy.greedy(graph_list5));
////    System.out.println("tabuCol 05: " + TabuCol.tabuCol(graph_matrix5, 0));

//    //graph 06
//    String path = "/Users/mymac/Desktop/Graph_Coloring_1.1/Graph_Coloring_1.1/src/txtReader_ForGivenGraphs/graph06_2022.txt";
//    GraphMatrix graph_matrix6 = txtReader.createGraphFromTxt_Matrix(path);
//    GraphList graph_list6 = txtReader.createGraphFromTxt_List(path);
//
//    System.out.println("lower bound approximation 06: " + Lower_bound.lowerBound_cycle(graph_matrix6));
//    System.out.println("upper bound approximation (max degree vertex) 06: " + Upper_bound.upperBound_maxDegree(graph_matrix6));
//    System.out.println("upper bound approximation (vertex cover) 06: " + Upper_bound.upperBound_vertCov(graph_matrix6));
////    System.out.println("back-track 06: " + Backtrack.backTrack(graph_matrix6));
//    System.out.println("greedy 06: " + Greedy.greedy(graph_list6));
////    System.out.println("tabuCol 06: " + TabuCol.tabuCol(graph_matrix6, 0));

//    //graph 07
//    String path = "/Users/mymac/Desktop/Graph_Coloring_1.1/Graph_Coloring_1.1/src/txtReader_ForGivenGraphs/graph07_2022.txt";
//    GraphMatrix graph_matrix7 = txtReader.createGraphFromTxt_Matrix(path);
//    GraphList graph_list7 = txtReader.createGraphFromTxt_List(path);
//
//    System.out.println("lower bound approximation 07: " + Lower_bound.lowerBound_cycle(graph_matrix7));
//    System.out.println("upper bound approximation (max degree vertex) 07: " + Upper_bound.upperBound_maxDegree(graph_matrix7));
//    System.out.println("upper bound approximation (vertex cover) 07: " + Upper_bound.upperBound_vertCov(graph_matrix7));
////    System.out.println("back-track 07: " + Backtrack.backTrack(graph_matrix7));
//    System.out.println("greedy 07: " + Greedy.greedy(graph_list7));
////    System.out.println("tabuCol 07: " + TabuCol.tabuCol(graph_matrix7, 0));

//    //graph 08
//    String path = "/Users/mymac/Desktop/Graph_Coloring_1.1/Graph_Coloring_1.1/src/txtReader_ForGivenGraphs/graph08_2022.txt";
//    GraphMatrix graph_matrix8 = txtReader.createGraphFromTxt_Matrix(path);
//    GraphList graph_list8 = txtReader.createGraphFromTxt_List(path);
//
//    System.out.println("lower bound approximation 08: " + Lower_bound.lowerBound_cycle(graph_matrix8));
//    System.out.println("upper bound approximation (max degree vertex) 08: " + Upper_bound.upperBound_maxDegree(graph_matrix8));
//    System.out.println("upper bound approximation (vertex cover) 08: " + Upper_bound.upperBound_vertCov(graph_matrix8));
////    System.out.println("back-track 08: " + Backtrack.backTrack(graph_matrix8));
//    System.out.println("greedy 08: " + Greedy.greedy(graph_list8));
////    System.out.println("tabuCol 08: " + TabuCol.tabuCol(graph_matrix8, 0));


//    //graph 09
//    String path = "/Users/mymac/Desktop/Graph_Coloring_1.1/Graph_Coloring_1.1/src/txtReader_ForGivenGraphs/graph09_2022.txt";
//    GraphMatrix graph_matrix9 = txtReader.createGraphFromTxt_Matrix(path);
//    GraphList graph_list9 = txtReader.createGraphFromTxt_List(path);
//
//    System.out.println("lower bound approximation 09: " + Lower_bound.lowerBound_cycle(graph_matrix9));
//    System.out.println("upper bound approximation (max degree vertex) 09: " + Upper_bound.upperBound_maxDegree(graph_matrix9));
//    System.out.println("upper bound approximation (vertex cover) 09: " + Upper_bound.upperBound_vertCov(graph_matrix9));
////    System.out.println("back-track 09: " + Backtrack.backTrack(graph_matrix9));
//    System.out.println("greedy 09: " + Greedy.greedy(graph_list9));
////    System.out.println("tabuCol 09: " + TabuCol.tabuCol(graph_matrix9, 0));

//    //graph 10
//    String path = "/Users/mymac/Desktop/Graph_Coloring_1.1/Graph_Coloring_1.1/src/txtReader_ForGivenGraphs/graph10_2022.txt";
//    GraphMatrix graph_matrix10 = txtReader.createGraphFromTxt_Matrix(path);
//    GraphList graph_list10 = txtReader.createGraphFromTxt_List(path);
//
//    System.out.println("lower bound approximation 10: " + Lower_bound.lowerBound_cycle(graph_matrix10));
//    System.out.println("upper bound approximation (max degree vertex) 10: " + Upper_bound.upperBound_maxDegree(graph_matrix10));
//    System.out.println("upper bound approximation (vertex cover) 10: " + Upper_bound.upperBound_vertCov(graph_matrix10));
////    System.out.println("back-track 10: " + Backtrack.backTrack(graph_matrix10));
//    System.out.println("greedy 10: " + Greedy.greedy(graph_list10));
////    System.out.println("tabuCol 10: " + TabuCol.tabuCol(graph_matrix10, 0));

//    //graph 11
//    String path = "/Users/mymac/Desktop/Graph_Coloring_1.1/Graph_Coloring_1.1/src/txtReader_ForGivenGraphs/graph11_2022.txt";
//    GraphMatrix graph_matrix11 = txtReader.createGraphFromTxt_Matrix(path);
//    GraphList graph_list11 = txtReader.createGraphFromTxt_List(path);
//
//    System.out.println("lower bound approximation 11: " + Lower_bound.lowerBound_cycle(graph_matrix11));
//    System.out.println("upper bound approximation (max degree vertex) 11: " + Upper_bound.upperBound_maxDegree(graph_matrix11));
//    System.out.println("upper bound approximation (vertex cover) 11: " + Upper_bound.upperBound_vertCov(graph_matrix11));
////    System.out.println("back-track 11: " + Backtrack.backTrack(graph_matrix11));
//    System.out.println("greedy 11: " + Greedy.greedy(graph_list11));
////    System.out.println("tabuCol 11: " + TabuCol.tabuCol(graph_matrix11, 0));

//    //graph 12
//    String path = "/Users/mymac/Desktop/Graph_Coloring_1.1/Graph_Coloring_1.1/src/txtReader_ForGivenGraphs/graph12_2022.txt";
//    GraphMatrix graph_matrix12 = txtReader.createGraphFromTxt_Matrix(path);
//    GraphList graph_list12 = txtReader.createGraphFromTxt_List(path);
//
//    System.out.println("lower bound approximation 12: " + Lower_bound.lowerBound_cycle(graph_matrix12));
//    System.out.println("upper bound approximation (max degree vertex) 12: " + Upper_bound.upperBound_maxDegree(graph_matrix12));
//    System.out.println("upper bound approximation (vertex cover) 12: " + Upper_bound.upperBound_vertCov(graph_matrix12));
////    System.out.println("back-track 12: " + Backtrack.backTrack(graph_matrix12));
//    System.out.println("greedy 12: " + Greedy.greedy(graph_list12));
////    System.out.println("tabuCol 12: " + TabuCol.tabuCol(graph_matrix12, 1));

//    //graph 13
//    String path = "/Users/mymac/Desktop/Graph_Coloring_1.1/Graph_Coloring_1.1/src/txtReader_ForGivenGraphs/graph13_2022.txt";
//    GraphMatrix graph_matrix13 = txtReader.createGraphFromTxt_Matrix(path);
//    GraphList graph_list13 = txtReader.createGraphFromTxt_List(path);
//
//    System.out.println("lower bound approximation 13: " + Lower_bound.lowerBound_cycle(graph_matrix13));
//    System.out.println("upper bound approximation (max degree vertex) 13: " + Upper_bound.upperBound_maxDegree(graph_matrix13));
//    System.out.println("upper bound approximation (vertex cover) 13: " + Upper_bound.upperBound_vertCov(graph_matrix13));
////    System.out.println("back-track 13: " + Backtrack.backTrack(graph_matrix13));
//    System.out.println("greedy 13: " + Greedy.greedy(graph_list13));
////    System.out.println("tabuCol 13: " + TabuCol.tabuCol(graph_matrix13, 1));

//    //graph 14
//    String path = "/Users/mymac/Desktop/Graph_Coloring_1.1/Graph_Coloring_1.1/src/txtReader_ForGivenGraphs/graph14_2022.txt";
//    GraphMatrix graph_matrix14 = txtReader.createGraphFromTxt_Matrix(path);
//    GraphList graph_list14 = txtReader.createGraphFromTxt_List(path);
//
//    System.out.println("lower bound approximation 14: " + Lower_bound.lowerBound_cycle(graph_matrix14));
//    System.out.println("upper bound approximation (max degree vertex) 14: " + Upper_bound.upperBound_maxDegree(graph_matrix14));
//    System.out.println("upper bound approximation (vertex cover) 14: " + Upper_bound.upperBound_vertCov(graph_matrix14));
////    System.out.println("back-track 14: " + Backtrack.backTrack(graph_matrix14));
//    System.out.println("greedy 14: " + Greedy.greedy(graph_list14));
////    System.out.println("tabuCol 14: " + TabuCol.tabuCol(graph_matrix14, 1));

//    //graph 15
//    String path = "/Users/mymac/Desktop/Graph_Coloring_1.1/Graph_Coloring_1.1/src/txtReader_ForGivenGraphs/graph15_2022.txt";
//    GraphMatrix graph_matrix15 = txtReader.createGraphFromTxt_Matrix(path);
//    GraphList graph_list15 = txtReader.createGraphFromTxt_List(path);
//
//    System.out.println("lower bound approximation 15: " + Lower_bound.lowerBound_cycle(graph_matrix15));
//    System.out.println("upper bound approximation (max degree vertex) 15: " + Upper_bound.upperBound_maxDegree(graph_matrix15));
//    System.out.println("upper bound approximation (vertex cover) 15: " + Upper_bound.upperBound_vertCov(graph_matrix15));
////    System.out.println("back-track 15: " + Backtrack.backTrack(graph_matrix15));
//    System.out.println("greedy 15: " + Greedy.greedy(graph_list15));
////    System.out.println("tabuCol 15: " + TabuCol.tabuCol(graph_matrix15, 1));

//    //graph 16
//    String path = "/Users/mymac/Desktop/Graph_Coloring_1.1/Graph_Coloring_1.1/src/txtReader_ForGivenGraphs/graph16_2022.txt";
//    GraphMatrix graph_matrix16 = txtReader.createGraphFromTxt_Matrix(path);
//    GraphList graph_list16 = txtReader.createGraphFromTxt_List(path);
//
//    System.out.println("lower bound approximation 16: " + Lower_bound.lowerBound_cycle(graph_matrix16));
//    System.out.println("upper bound approximation (max degree vertex) 16: " + Upper_bound.upperBound_maxDegree(graph_matrix16));
//    System.out.println("upper bound approximation (vertex cover) 16: " + Upper_bound.upperBound_vertCov(graph_matrix16));
////    System.out.println("back-track 16: " + Backtrack.backTrack(graph_matrix16));
//    System.out.println("greedy 16: " + Greedy.greedy(graph_list16));
////    System.out.println("tabuCol 16: " + TabuCol.tabuCol(graph_matrix16, 1));

//    //graph 17
//    String path = "/Users/mymac/Desktop/Graph_Coloring_1.1/Graph_Coloring_1.1/src/txtReader_ForGivenGraphs/graph17_2022.txt";
//    GraphMatrix graph_matrix17 = txtReader.createGraphFromTxt_Matrix(path);
//    GraphList graph_list17 = txtReader.createGraphFromTxt_List(path);
//
//    System.out.println("lower bound approximation 17: " + Lower_bound.lowerBound_cycle(graph_matrix17));
//    System.out.println("upper bound approximation (max degree vertex) 17: " + Upper_bound.upperBound_maxDegree(graph_matrix17));
//    System.out.println("upper bound approximation (vertex cover) 17: " + Upper_bound.upperBound_vertCov(graph_matrix17));
////    System.out.println("back-track 17: " + Backtrack.backTrack(graph_matrix17));
//    System.out.println("greedy 17: " + Greedy.greedy(graph_list17));
////    System.out.println("tabuCol 17: " + TabuCol.tabuCol(graph_matrix17, 1));

//    //graph 18
//    String path = "/Users/mymac/Desktop/Graph_Coloring_1.1/Graph_Coloring_1.1/src/txtReader_ForGivenGraphs/graph18_2022.txt";
//    GraphMatrix graph_matrix18 = txtReader.createGraphFromTxt_Matrix(path);
//    GraphList graph_list18 = txtReader.createGraphFromTxt_List(path);
//
//    System.out.println("lower bound approximation 18: " + Lower_bound.lowerBound_cycle(graph_matrix18));
//    System.out.println("upper bound approximation (max degree vertex) 18: " + Upper_bound.upperBound_maxDegree(graph_matrix18));
//    System.out.println("upper bound approximation (vertex cover) 18: " + Upper_bound.upperBound_vertCov(graph_matrix18));
////    System.out.println("back-track 18: " + Backtrack.backTrack(graph_matrix18));
//    System.out.println("greedy 18: " + Greedy.greedy(graph_list18));
////    System.out.println("tabuCol 18: " + TabuCol.tabuCol(graph_matrix18, 1));

//    //graph 19
//    String path = "/Users/mymac/Desktop/Graph_Coloring_1.1/Graph_Coloring_1.1/src/txtReader_ForGivenGraphs/graph19_2022.txt";
//    GraphMatrix graph_matrix19 = txtReader.createGraphFromTxt_Matrix(path);
//    GraphList graph_list19 = txtReader.createGraphFromTxt_List(path);
//
//    System.out.println("lower bound approximation 19: " + Lower_bound.lowerBound_cycle(graph_matrix19));
//    System.out.println("upper bound approximation (max degree vertex) 19: " + Upper_bound.upperBound_maxDegree(graph_matrix19));
//    System.out.println("upper bound approximation (vertex cover) 19: " + Upper_bound.upperBound_vertCov(graph_matrix19));
////    System.out.println("back-track 19: " + Backtrack.backTrack(graph_matrix19));
//    System.out.println("greedy 19: " + Greedy.greedy(graph_list19));
////    System.out.println("tabuCol 19: " + TabuCol.tabuCol(graph_matrix19, 1));

    //graph 20
    String path = "/Users/mymac/Desktop/Graph_Coloring_1.1/Graph_Coloring_1.1/src/txtReader_ForGivenGraphs/graph20_2022.txt";
    GraphMatrix graph_matrix20 = txtReader.createGraphFromTxt_Matrix(path);
    GraphList graph_list20 = txtReader.createGraphFromTxt_List(path);

    System.out.println("lower bound approximation 20: " + Lower_bound.lowerBound_cycle(graph_matrix20));
    System.out.println("upper bound approximation (max degree vertex) 20: " + Upper_bound.upperBound_maxDegree(graph_matrix20));
    System.out.println("upper bound approximation (vertex cover) 20: " + Upper_bound.upperBound_vertCov(graph_matrix20));
//    System.out.println("back-track 20: " + Backtrack.backTrack(graph_matrix20));
    System.out.println("greedy 20: " + Greedy.greedy(graph_list20));
//    System.out.println("tabuCol 20: " + TabuCol.tabuCol(graph_matrix20, 1));

}
}
