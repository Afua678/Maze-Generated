public class Node {

    int x, y, cost;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;   
        cost = Integer.MAX_VALUE;
    }

    // we use this method in the UpdatingHeap with an if-statement
    public void updateCost(int c){
        cost = c;
    }

// edges are created as we "unlock them" and they are assigned random weights
// edges themselves don't have weight, the node gets the weight.
//two d (nxn) array of 1 andf 0, keeping track of which vertexes we have (btw I put this in UpdatingHeap)
// possible we have x, and y coordinates to keep track of where we are

    public boolean isLessThan(Node e) {
        return this.cost < e.cost;
    }
    
}
