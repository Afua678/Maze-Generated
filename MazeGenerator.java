import java.util.Scanner;

public class MazeGenerator {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter an integer for the number of rows and columns in the maze:");
        int n = in.nextInt();
        System.out.println();

        // Three necessary data structures: vertices in the MST, edges in the MST, vertices outside the MST
        // PriorityQueue with updating values, each node holds a vertice and its cheapest edge
        // Pop off the cheapest vertex and add it to list of vertexes we do have
        // Update all the values of the edges that we bow have access too in the PriorityQueue


        in.close();
    }

    

}