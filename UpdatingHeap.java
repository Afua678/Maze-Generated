import java.util.ArrayList;

public class UpdatingHeap {
    // We need to keep track of every vertex's index, so that we can access/update them in constant time
    boolean[][] indices;
    int nodesInHeap;

    //I'm considering deleting this because not sure we need it
    public UpdatingHeap(int length) {
        indices = new boolean[length][length];
        nodesInHeap = 0;
    }
    
    public boolean isNodeinHeap(Node n){
        if(indices[n.x][n.y] ==true){
            return true;
        }
        return false;
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

    //method to return nodes in heap so we can check if we are done

}

