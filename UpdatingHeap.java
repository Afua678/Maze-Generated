import java.util.ArrayList;

public class UpdatingHeap {
    boolean[][] inHeap;
    int[][] indices;
    ArrayList<Node> heap;

    public UpdatingHeap(int length, Node[][] tree) {
        inHeap = new boolean[length][length];
        indices = new int[length][length];
        heap = createHeap(tree);
    }

    // This is the only time that we will be adding nodes to the heap
    private ArrayList<Node> createHeap(Node[][] tree) {
        ArrayList<Node> nodes = new ArrayList<>();
        int index = 0; 
        for (int i = 0; i < tree.length; i++) {
            for (int j = 0; j < tree.length; j++) {
                nodes.add(tree[i][j]);
                indices[i][j] = index++;
            }
        }
        return nodes;
    }


    // private void swap(Node i, Node parent) {
    //     Node temp = nodes.get(parent);
    //     nodes.set(parent, nodes.get(i));
    //     nodes.set(i, temp);  
    // }

    // private void minHeapify(int i) {
    //     int left = left(i);
    //     int right = right(i);
    //     int smallest = -1;

    //     // find the smallest key between current node and its children.
    //     if (left <= nodes.size() - 1 && nodes.get(left) < nodes.get(i)) {
    //         smallest = left;
    //     } else {
    //         smallest = i;
    //     }

    //     if (right <= list.size() - 1 && list.get(right) < list.get(smallest)) {
    //         smallest = right;
    //     }

    //     // if the smallest key is not the current key then bubble-down it.
    //     if (smallest != i) {

    //         swap(i, smallest);
    //         minHeapify(smallest);
    //     }
    // }
    
    public boolean isNodeinHeap(Node n){
        return inHeap[n.x][n.y];
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int parent(int i) {
        if (i % 2 == 1) {
            return i / 2;
        }
        return (i - 1) / 2;
    }

    //check and update the neighbors then return the smallest neighbor
    public Node updateNode(Node n, Node[][] tree ){
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

}

