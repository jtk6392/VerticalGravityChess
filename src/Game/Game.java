package Game;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class Game {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * Main menu.
     * @return The choice for the menu.
     */
    public static char menu() {
        boolean control = true;
        String line;
        char c = 'x';
        System.out.println("MENU");
        System.out.println("Press P to play");
        System.out.println("Press Q to quit");

        //while(control) {
            try{
                System.out.print("Enter your choice: ");
                line = Game.sc.nextLine();
                    if (line.length() == 1) {
                        c = line.charAt(0);
                        control = false;
                    }
            } catch(NoSuchElementException e) {
                System.err.println(e.getMessage());
                c = 'Q';
            }
        return c;
    }

    /**
     * Main game loop.
     */
    public static void playGame() {
        boolean done = false;
        Board b = new Board();
        Board.Player player = Board.Player.PLAYER1;
        int p = 1;
        int play;
        while (!done) {
            System.out.println(b);
            System.out.print("Player " + p + " Enter your play: ");

            play = Game.sc.nextInt();
            Game.sc.nextLine();

            if (b.play(play, player)) {
                System.out.println(b);
                done = b.playerWon(play, p);
                if (done) {
                    System.out.println("Player " + p + " Wins!");
                } else if(b.DetermineTie()) {
                    System.out.println("Tie!");
                    done = true;
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

    /**
     * Entry point to the game currently.
     * @param args
     */
    public static void main(String[] args) {
        char choice = 'X';
        while(choice != 'Q'){
            choice = menu();
            choice = Character.toUpperCase(choice);
            switch(choice) {
                case 'P': playGame();
                    break;
                case 'Q':
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice\n");
                    break;
            }
        }
    }
}
