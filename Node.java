public class Node implements Comparable<Node>{
    int cost;
    int vertex;

    public Node(int w, int v) {
        // cost = int.max;
        vertex = v;   
    }
// edges are created as we "unlock them" and they are assigned random weights
// edges themselves don't have weight, the node gets the weight.
//two d (nxn) array of 1 andf 0, keeping track of which vertexes we have
// possible we have x, and y coordinates to keep track of where we are
    public int compareTo(Node e) {
        return this.cost - e.cost;
    }
}
