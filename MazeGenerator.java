import java.util.Scanner;

public class MazeGenerator {

    //creates a spanning tree
    public static void spanningTree(int len, Node[][] tree){
        boolean[][] inTree = new boolean[len][len];

        // Starting point is upper left corner
        tree[0][0].cost = 0;
        UpdatingHeap heap = new UpdatingHeap(len, tree, inTree);

        //keep popping nodes from the heap until heap is empty
        while (heap.heap.size() > 0) {
            Node node = heap.pop();
            newEdges(node, heap, len, inTree, tree);
        }

    }

    // Creates newEdges as the algorith goes and also updates UpdatingHeap
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

        
        // 2D array for keeping track of added vertices (nodes), starts at 0
        Node[][] tree = new Node[n][n];
        
        // instantiating each node
        for (int i = 0; i < tree.length; i++) {
            for (int j = 0; j < tree[i].length; j++) {
                tree[i][j] = new Node(i, j);
            }
        }

        // need to start at first node and add nodes into heap was we traverse
        spanningTree(n, tree);

        for (int i = 0; i < tree.length; i++) {
            System.out.print(" _");
        }
        System.out.println();
        for (int i = 0; i < tree.length; i++) {
            boolean underscore = false;
                 if(i==n-1){
                    underscore = true;
                 }
                 System.out.print("|");
                 if(((i<n-1 && tree[i][0].equals(tree[i+1][0].parent)) && !underscore )|| ((i<n-1 && tree[i+1][0].equals(tree[i][0].parent)) && !underscore)){
                    System.out.print(" ");
                 }else{
                    System.out.print("_");
                 }

            for (int j = 1; j < tree.length; j++) {
                if(i<n-1 && (tree[i][j].parent.equals(tree[i+1][j]) || tree[i+1][j].parent.equals(tree[i][j]))){
                        underscore = false;
                }else{
                    underscore = true;
                }
                 if ((tree[i][j].parent != null && tree[i][j].parent.equals(tree[i][j-1])) || (tree[i][j-1].parent != null && tree[i][j-1].parent.equals(tree[i][j])) ){
                    if(underscore){
                        System.out.print( " _");
                    }else{
                        System.out.print("  ");
                    }
                 }else{
                    if(underscore){
                        System.out.print("|_");
                    }else{
                    System.out.print( "| ");
                    }
                 }
            }
            System.out.print("| \n");
        }


        in.close();
    }

    

}