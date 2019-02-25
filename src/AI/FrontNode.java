package AI;

import java.util.ArrayList;

public class FrontNode extends Node {

    public FrontNode(Double value, ArrayList<Edge> outputs) {
        super(value, null, outputs);
    }

    public FrontNode(Double value) {
        super(value);
    }
}
