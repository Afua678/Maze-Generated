public class Edge {
    Node node1, node2; 
    int cost;

    public Edge(Node node1, Node node2) {
        this.node1 = node1;
        this.node2 = node2;
        cost = (int)((Math.random()* 10)+ 1);
        
        //updates the node we are considering
        node2.cost = cost;
    }

}
