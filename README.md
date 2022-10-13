# graph-colouring-group4_2022
graph-colouring-group4_2022 created by GitHub Classroom

Our code project contains the following files:

- Algorithms:
  -Backtrack (a back track algorithm for graph coloring problem).
  -Greedy (a greedy algorithm for graph coloring problem).
  -TabuCol (Tabu Coloring algorithm, is a heuristic algorithm based on Tabu local seach. Needs more testing and improvement, currently was tested on a set
            of DIMACS benchmark graps and does NOT return the solution, runs out of iterations. Still works for smaller/simpler inputs).
  
- BIG_TEST:
  -Main_test (a class for testing lower/upper-bound approximation and running greedy algorithm on given graphs).
  
- Graph_Implementation:
  -GraphList (Adjacency list representation of a graph).
  -GraphMatrix (Adjacency matrix representation of a graph).
  -TestGraph (a class for testing/boulding graps).
  
- Lower_Upper_bound_approx:
  -Lower_bound (class containing our lower-bound approximation algorithms).
  -Upper_bound (class containing our upper-bound approximation algorithms).
  
- txtReader_DIMACS:
  -list of some DIMACS graphs 
  -txtReader_DIMACS (a class containing a method that reads a txt in DIMACS format and returns a graph).
  
- txtReader_ForGivvenGraphs
  -list of given given graphs 
  -txtReader (a class containing a method that reads a txt of given format and returns a graph).
  
  In order to check the performance of greedy and lower/upper-bound approximation, user needs to open Main_test class and run the section of choosen graph. 
  In order if user wants to run back-track/tabuCol, he/she is supposed to open Backtrack/TabuCol class and change the path variable in main method to the actual 
  path of the txt containing the graph. 
