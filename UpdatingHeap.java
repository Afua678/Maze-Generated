import java.util.ArrayList;

public class UpdatingHeap {
    // keeps track of the order in which nodes are popped
    int[][] indices;
    boolean[][] inTree;
    ArrayList<Node> heap;

    public UpdatingHeap(int length, Node[][] tree, boolean[][] inTree) {
        indices = new int[length][length];
        this.inTree = inTree;
        heap = createHeap(tree);
    }

    // All nodes are added upon instantiation, the only time there will be adding
    // Since they all have the same cost (max), there is no bubbling
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

    //removes min node and adjusts rest of tree
    public Node pop() {
        if (heap.size() == 0) {
            throw new IndexOutOfBoundsException();
        } else if (heap.size() == 1) {
            Node min = heap.remove(0);
            inTree[min.x][min.y] = true;
            return min;
        }else{Node min = heap.get(0);
        inTree[min.x][min.y] = true;
        Node lastItem = heap.remove(heap.size() - 1);
        heap.set(0, lastItem);
        indices[lastItem.x][lastItem.y] = 0;
        bubbleDown(0);
        

        return min;
        }
    }

    public void updateNode(Node n, int newCost) {
        int index = indices[n.x][n.y];
        heap.get(index).updateCost(newCost);
        bubbleUp(index);
    }

    private void bubbleDown(int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < heap.size() && heap.get(left).isLessThan(heap.get(smallest))) {
            smallest = left;
        }
        if (right < heap.size() && heap.get(right).isLessThan(heap.get(smallest))) {
            smallest = right;
        }

        if (smallest != i) {
            swap(i, smallest);
            bubbleDown(smallest);
        }
    }


    private void bubbleUp(int i) {
        while (i > 0) {
            int parent = parent(i);

            if (!heap.get(i).isLessThan(heap.get(parent))) {
                break;
            }

            swap(i, parent);
            i = parent;
        }
    }

    private int parent(int i) {
        if (i % 2 == 1) {
            return i / 2;
        }
        return (i - 1) / 2;
    }

    private void swap(int i, int j) {
        Node a = heap.get(i);
        Node b = heap.get(j);

        heap.set(i, b);
        heap.set(j, a);

        indices[a.x][a.y] = j;
        indices[b.x][b.y] = i;
    }

}

