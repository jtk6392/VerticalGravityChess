package AI;
import java.util.Random;
import java.util.ArrayList;

public class NextGen {

    public static ArrayList<Network> fittest(ArrayList<Network> gen1){
        Random rnd = new Random();

        ArrayList<Network> nextGen = new ArrayList<>();
        for (Network network : gen1){
            if (network.getWin()){
                nextGen.add(network);
            }
        }

        for (Network network : nextGen){

        }




        return nextGen;
    }

}
