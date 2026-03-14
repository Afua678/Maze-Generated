public class Node implements Comparable<Node>{
    int cost, x, y;

    public Node(int x, int y) {
        cost = Integer.MAX_VALUE;
        this.x = x;
        this.y = y;   
    }

    public boolean randomEdge(int c){
        // I don't think we need this if statement anymore because we dont need to compare to previous 
        // cost since the previous cost could be lower if we look at it from another node, but that node is
        // already in set
        // if(c<cost){
            int cost = c;
            return true;
        // }
            // return false;
    }

// edges are created as we "unlock them" and they are assigned random weights
// edges themselves don't have weight, the node gets the weight.
//two d (nxn) array of 1 andf 0, keeping track of which vertexes we have (btw I put this in UpdatingHeap)
// possible we have x, and y coordinates to keep track of where we are

    public int compareTo(Node e) {
        return this.cost - e.cost;
    }
    
}
