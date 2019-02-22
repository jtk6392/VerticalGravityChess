import java.lang.Character;
import java.util.Scanner;
public class Game {

    public static char menu() {
        return 'X';
    }

    public static void playGame() {
        boolean done = false;
        Board b = new Board();
        Scanner sc = new Scanner(System.in);
        Board.Player player = Board.Player.PLAYER1;
        int p = 1;
        int play;
        while (!done) {
            System.out.println(b);
            System.out.print("Enter your play: ");
            play = sc.nextInt();
            if (b.play(play, player)) {
                System.out.println(b);
                done = b.playerWon(play, p);
                if (done) {
                    System.out.println("Player " + p + " Wins!");
                } else {
                    if (p == 1) {
                        p = 2;
                        player = Board.Player.PLAYER2;
                    } else {
                        p = 1;
                        player = Board.Player.PLAYER1;
                    }
                }
            } else {
                System.out.println("Invalid play");
            }

        }
    }

    public static void main(String[] args) {
        char choice = 'X';

        /*
        while(choice != 'Q'){
            choice = menu();
            switch(choice) {
                case 'P':playGame();
                case 'Q':
            }
        }
    */
        playGame();
    }
}
