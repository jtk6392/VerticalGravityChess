package AI;
import Game.Board;
import java.util.ArrayList;

public class Network {

    private final ArrayList<Node> network;

    private boolean win;

    public Network(ArrayList<Node> network){
        this.network = network;
    }

    public ArrayList<Node> getNetwork() {
        return network;
    }

    public void playMove(Board currBoard){

    }

    public void updateNetwork(){

    }

    public boolean getWin(){
        return this.win;
    }
}
