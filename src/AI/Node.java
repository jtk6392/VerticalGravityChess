package AI;

import java.util.ArrayList;

public class Node {

    private Double value;

    private ArrayList<Edge> inputs;

    private ArrayList<Edge> outputs;

    public Node(Double value, ArrayList<Edge> inputs, ArrayList<Edge> outputs) {
        this.value = value;
        this.inputs = inputs;
        this.outputs = outputs;
    }

    public Node(Double value) {
        this.value = value;
        this.inputs = new ArrayList<>();
        this.outputs = new ArrayList<>();
    }

    public Double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public ArrayList<Edge> getInputs() {
        return inputs;
    }

    public void setInputs(ArrayList<Edge> inputs) {
        this.inputs = inputs;
    }

    public void addInput(Edge edge){
        inputs.add(edge);
    }

    public ArrayList<Edge> getOutputs() {
        return outputs;
    }

    public void setOutputs(ArrayList<Edge> outputs) {
        this.outputs = outputs;
    }

    public void addOutput(Edge edge){
        outputs.add(edge);
    }

    @Override
    public String toString(){
        return "{value=" + this.getValue() + ", inputs=" + this.getInputs() +
                ", outputs=" + this.getOutputs() + "}";
    }
}
