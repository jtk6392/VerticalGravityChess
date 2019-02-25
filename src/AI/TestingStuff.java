package AI;

import Game.Board;

import java.util.ArrayList;
import java.util.Random;

public class TestingStuff {

    public static void main(String[] args) {
        Random rnd = new Random();

        Board b1 = new Board();


        ArrayList<Node> outputs = new ArrayList<>();
        ArrayList<Edge> toOutputs = new ArrayList<>();

        ArrayList<Node> inputs = new ArrayList<>();
        ArrayList<Edge> toInputs = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            outputs.add(new EndNode(null));
        }

        for (int[] yArray : b1.getBoard()) {
            for (int val : yArray) {
                inputs.add(new FrontNode((double) val));
            }
        }

        for (Node node : inputs) {
            for (Node next : outputs){
                node.addOutput(new Edge(rnd.nextDouble(), next));
            }
        }

        for (Node node : outputs) {
            for (Node next : inputs){
                node.addOutput(new Edge(rnd.nextDouble(), next));
            }
        }

        ArrayList<Node> finished = new ArrayList<>();
        finished.addAll(inputs);
        finished.addAll(outputs);
        Network network = new Network(finished);

        System.out.println(network);
    }
}
