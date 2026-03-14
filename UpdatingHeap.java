import java.util.ArrayList;

public class UpdatingHeap {
    int[][] indices;
    ArrayList<Node> heap;

    public UpdatingHeap(int length, Node[][] tree) {
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

    public Node pop() {
        if (heap.size() == 0) {
            throw new IndexOutOfBoundsException();
        } else if (heap.size() == 1) {
            Node min = heap.remove(0);
            return min;
        }

        Node min = heap.get(0);
        Node lastItem = heap.remove(heap.size() - 1);
        heap.set(0, lastItem);
        indices[lastItem.x][lastItem.y] = 0;
        bubbleDown(0);

        return min;
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

    private void bubbleDown(int i) {
        Node currNode = heap.get(i);
        Node left = getLeft(i);
        Node right = getRight(i);
        
        // find smallest node between parent and children
        int smallest = i;
        if ((2*i+1) <= heap.size() - 1 && left.isLessThan(currNode)) {
            smallest = 2*i+1;
        }
        if ((2*i+2) <= heap.size() - 1 && right.isLessThan(currNode) && right.isLessThan(left)) {
            smallest = 2*i+2;
        }
        
        // if the smallest key is not the current key then bubble-down it.
        if (smallest != i) {
            swap(i, smallest);
            bubbleDown(smallest);
        }
    }

    private void bubbleUp(int i) {
        Node currNode = heap.get(i);
        Node parentNode = getParent(i);
        int parent = parent(i);

        while (i > 0 && parentNode.isLessThan(currNode)) {
            swap(i, parent);
            i = parent;
            parent = parent(parent);
        }
    }
    
    private Node getRight(int i) {
        return heap.get(2 * i + 2);
    }

    private Node getLeft(int i) {
        return heap.get(2 * i + 1);
    }

    private Node getParent(int i) {
         if (i % 2 == 1) {
             return heap.get(i/2);
         }
         return heap.get((i-1)/2);
    }

    private int parent(int i) {
        if (i % 2 == 1) {
            return i / 2;
        }
        return (i - 1) / 2;
    }

    private void swap(int i, int j) {
        Node temp = heap.get(j);
        heap.set(j, heap.get(i));
        heap.set(i, temp);  

        int tempIndex = indices[heap.get(j).x][heap.get(j).y];
        indices[heap.get(j).x][heap.get(j).y] = indices[heap.get(i).x][heap.get(i).y];
        indices[heap.get(i).x][heap.get(i).y] = tempIndex;
    }

}

