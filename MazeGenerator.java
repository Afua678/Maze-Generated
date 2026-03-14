import java.util.Scanner;
import java.util.LinkedList;

public class MazeGenerator {

    //creates a spanning tree that will return the LinkedList of the Nodes
    // or alternatively  we could return an array with each spot pointing to it the next
    // so it is easier to make the graph later (we can change this if needed)
    public static LinkedList<Node> spanningTree(int len, Node[][] tree){
        boolean[][] inTree = new boolean[len][len];
        LinkedList<Node> addedNodes = new LinkedList<Node>();

        // Starting point is upper left corner
        tree[0][0].cost = 0;
        UpdatingHeap heap = new UpdatingHeap(len, tree, inTree);

        while (heap.heap.size() > 0) {
            Node node = heap.pop();
            addedNodes.add(node);
            newEdges(node, heap, len, inTree, tree);
        }

        return addedNodes;
    }

    // Creates newEdges and also updates UpdatingHeap
    private static void newEdges(Node n, UpdatingHeap heap, int len, boolean[][] inTree, Node[][] tree) {
        if (n.x > 0 && !inTree[n.x - 1][n.y]) {
            Edge up = new Edge(n, tree[n.x-1][n.y]);
            if (up.cost < up.node2.cost) {
                heap.updateNode(up.node2, up.cost);
                up.node2.parent = n;
            }
            
        }
        if (n.x < len - 1 && !inTree[n.x + 1][n.y]) {
            Edge down = new Edge(n, tree[n.x+1][n.y]);
            if (down.cost < down.node2.cost) {
                heap.updateNode(down.node2, down.cost);
                down.node2.parent = n;                
            }

        }
        if (n.y > 0 && !inTree[n.x][n.y - 1]) {
            Edge left = new Edge(n, tree[n.x][n.y-1]);
            if (left.cost < left.node2.cost) {
                heap.updateNode(left.node2, left.cost);
                left.node2.parent = n;            
            }

        }
        if (n.y < len - 1 && !inTree[n.x][n.y + 1]) {
            Edge right = new Edge(n, tree[n.x][n.y + 1]);
            if (right.cost < right.node2.cost) {
                heap.updateNode(right.node2, right.cost);
                right.node2.parent = n;                
            }
        }
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
        spanningTree(n, tree);

        in.close();
    }

    

}