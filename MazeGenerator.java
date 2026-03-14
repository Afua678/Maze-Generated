import java.util.Scanner;

public class MazeGenerator {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter an integer for the number of rows and columns in the maze:");
        int n = in.nextInt();
        System.out.println();
        

        Node[][] tree = new Node[n][n];
        
        // instantiating each node
        for (int i = 0; i < tree.length; i++) {
            for (int j = 0; j < tree.length; j++) {
                tree[i][j] = new Node(i, j);
            }
        }

        // 2D array for keeping track of added vertices, starts at 0
        int[][] vertexArray = new int[n][n];


                
        
        in.close();
    }

    

}