import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;

public class MazeGenerator {

    //creates a spanning tree that will return the LinkedList of the Nodes
    // or alternatively  we could return an array with each spot pointing to it the next
    // so it is easier to make the graph later (we can change this if needed)
    public static LinkedList<Node> spanningTree(Node n, int len, Node[][] tree){
        //keeps track of the number of nodes we have
        //starting with 1 (because one node n as the source)
        
        int nodes = 1;
        Node node = n;
        UpdatingHeap heap = new UpdatingHeap(len, tree);
        LinkedList<Node> allNodes = new LinkedList<Node>();
        
        allNodes.add(n);
        
        // MOVED THIS FROM UPDATING HEAP
        // if(n.x+ 1 < indices.length){
        //     Edge z = new Edge(n, tree[n.x + 1][n.y]);
            
        //     x = tree[n.x + 1][n.y];
        // }

        return allNodes;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter an integer for the number of rows and columns in the maze:");
        int n = in.nextInt();
        System.out.println();
        
        // 2D array for keeping track of added vertices (nodes), starts at 0
        Node[][] tree = new Node[n][n];
        
        // instantiating each node
        for (int i = 0; i < tree.length; i++) {
            for (int j = 0; j < tree.length; j++) {
                tree[i][j] = new Node(i, j);
            }
        }

        // need to start at first node and add nodes into heap was we traverse
        spanningTree(tree[0][0], n, tree);

        in.close();
    }

    

}