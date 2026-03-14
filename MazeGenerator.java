import java.util.Scanner;

public class MazeGenerator {

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
        


                
        
        in.close();
    }

    

}