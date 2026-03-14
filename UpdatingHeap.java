import java.util.ArrayList;

public class UpdatingHeap {
    // We need to keep track of every vertex's index, so that we can access/update them in constant time
    int[][] indices;
    boolean[][] inHeap;
    int nodesInHeap;

    // we need a constructor to create the object in maze generator
    public UpdatingHeap(int length) {
         inHeap = new boolean[length][length];
         nodesInHeap = 0;
    }
    
    //check and update the neighbors then return the smallest neighbor
    public Node addNode(Node n, Node[][] tree){
        Node x = null;
        if(n.x+ 1 < indices.length){
            Edge z = new Edge(n, tree[n.x + 1][n.y]);
            
            x = tree[n.x + 1][n.y];
        }
        // from here on udpate x if the cost of that node is less
        //also edge z updates the cost of the node when we look at it in the edge class
        // so no need to update the cost
        return x;
    }

    public boolean isNodeinHeap(Node n){
        return inHeap[n.x][n.y];
    }
}

