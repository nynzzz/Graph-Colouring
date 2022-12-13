# graph-colouring-group4_2022

## Exact Algorithm and Lower/Upper bound approximation on chromatic number
#### Algorithms:
  - `Backtrack` (a back track algorithm for approximating chromatic number in a graph coloring problem).
  - `Greedy` (a greedy algorithm for approximating chromatic number in a graph coloring problem).
  - `BruteForce` (an exact algorithm to find chromatic number of a graph)
#### BIG_TEST:
  - `Main_test` (a class for testing lower/upper-bound approximation and running greedy algorithm on given graphs).
#### Graph_Implementation:
  - `GraphList` (Adjacency list representation of a graph).
  - `GraphMatrix` (Adjacency matrix representation of a graph).
  - `TestGraph` (a class for testing graphs utilities).
#### Lower_Upper_bound_approx:
  - `Lower_bound` (class containing our lower-bound approximation algorithms).
  - `Upper_bound` (class containing our upper-bound approximation algorithms).
#### txtReader_DIMACS:
  - list of some DIMACS graphs 
  - `txtReader_DIMACS` (a class containing a method that reads a txt in DIMACS format and returns a graph).
#### txtReader_ForGivvenGraphs:
  - list of given graphs 
  - `txtReader` (a class containing a method that reads a txt of given format and returns a graph).
#### Remarks:
  In order to check the performance of greedy and lower/upper-bound approximation, user needs to open Main_test class and run the section of choosen graph. 
  In order if user wants to run back-track/tabuCol, he/she is supposed to open Backtrack/TabuCol class and change the path variable in main method to the actual 
  path of the txt containing the graph. 

## Game
#### Vertex class
A class to represent a vertex as an object with following attributes:
- `vertexNum` (id of a vertex)
- `color` (vertex color)
- `graph` (a graph to which the vertex belongs)
- `colorFixed` (boolean to show if the color is fixed, used in "Random Order" game mode)
#### Phase_2
A package that contains game logic classes and methods. Also contains `RandomGraph` method which generates random graphs.
#### GUI
A package containing GUI implementation of the game. The user interface was implemented using `java.swing` library.
To run the GUI a user has to run the main method in `GUI2` class.
#### How to play the game?
After a user runs the game as described above, he/she can see the starting menu where he/she can choose 
weather start or exit the game. If start option was chosen, the "Choose Game Mode" screen appears where user can choose the game mode he/she wants to play,
also a user can choose between starting the game with a random graph with a given parameters (number of vertices and number of edges). After everything is chosen
the game can start by pressing "start game" button. Enjoy:)