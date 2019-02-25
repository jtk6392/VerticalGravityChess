package AI;

import java.util.ArrayList;

public class EndNode extends Node {

    public EndNode(Double value, ArrayList<Edge> inputs) {
        super(value, inputs, null);
    }

    public EndNode(Double value) {
        super(value);
    }
}
