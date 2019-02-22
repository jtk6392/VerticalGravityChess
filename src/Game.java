import java.lang.Character;
public class Game {

    public static char menu() {
        return 'X';
    }

    public static void playGame() {

    }

    public static void main(String[] args) {
        char choice = 'X';

        while(choice != 'Q'){
            choice = menu();
            switch(choice) {
                case 'P':playGame();
                case 'Q':
            }
        }
    }


}
