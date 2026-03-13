public class Edge {
    Vertex vertex1, vertex2; 
    int cost;

    public Edge(Vertex vertex1, Vertex vertex2) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        cost = (int)(Math.random()* 10);
    }

}
