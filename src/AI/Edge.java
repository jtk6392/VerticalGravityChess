package AI;

public class Edge{

    private double weight;

    private final Node next;

    public Edge(double weight, Node next){
        this.weight = weight;
        this.next = next;
    }

    public Edge(Node next){
        this.next = next;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Node getNext() {
        return next;
    }
}
