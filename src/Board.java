public class Board {
    private String player1;
    private String player2;

    /**
     * 2D array to represent the 7x6 board.
     */
    int[][] board = new int[7][6];

    /**
     * Constructor for board. initializes the board to be -1 except for the bottom row.
     */
    public Board() {
        for(int j = 5; j > 0; j--) {
            for (int i = 0; i < 7; i++) {
                board[i][j] = -1;
            }
        }
    }

    /**
     * Returns the current board.
     * @return The current board.
     */
    public int[][] getBoard() {return this.board;}

    /**
     * Enum to represent a player.
     */
    public enum Player {
        PLAYER1,
        PLAYER2
    }

    /**
     * Makes a play on the board.
     * @param i the x value of the play.
     * @param p the player making the play.
     * @return true if the play was made successfully, otherwise false.
     */
    public boolean play(int i, Player p) {
        if (i >= 0 && i < this.board.length) {
            for(int j = 5; j >=0; j--) {
                if(board[i][j] == 0) {
                    if(p == Player.PLAYER1) {
                        board[i][j] = 1;
                    } else {
                        board[i][j] = 2;
                    }
                    if(j+1 < 6){
                        board[i][j+1] = 0;
                    }
                    return true;
                }
            }

        } else {
            return false;
        }
        return false;
    }

    /**
     * Helper method for playerWon, determines the length of a vertical line of plays.
     * @param i the x index of the play
     * @param j the y index of the play
     * @param p the player that made the most recent play.
     * @return the number of consecutive plays vertically.
     */
    private int verticalConsecutives(int i, int j, int p) {
        int consecutives = 0;

        while(j >= 0 && board[i][j] == p) { // Check a vertical column from the play.
            j--;
            consecutives++;
        }
        return consecutives;
    }

    /**
     * Helper method for playerWon, determines the length of a horizontal line of plays.
     * @param i the x index of the play
     * @param j the y index of the play
     * @param p the player that made the most recent play.
     * @return the number of consecutive plays horizontally.
     */
    private int horizontalConsecutives(int i, int j, int p) {
        int consecutives = 0;
        int temp = i;
        while(temp >= 0 && board[temp][j] == p) { // Check left of play
                temp--;
                consecutives++;
            }
        temp = i+1;
        while(temp < 7 && board[temp][j] == p) { // Check right of play.
            temp++;
            consecutives++;
        }

        return consecutives;
    }

    /**
     * Helper method for playerWon, determines the length of a diagonal line of plays(lower left to upper right).
     * @param i the x index of the play
     * @param j the y index of the play
     * @param p the player that made the most recent play.
     * @return the number of consecutive plays diagonally(lower left to upper right).
     */
    private int rightDiagonalConsecutives(int i, int j, int p) {
        int consecutives = 0;
        int tempx = i;
        int tempy = j;

        while(tempx < 7 && tempy < 6 && board[tempx][tempy] == p) { // Check up and to the right.
            consecutives++;
            tempx++;
            tempy++;
        }
        tempx = i - 1;
        tempy = j - 1;
        while(tempx >= 0 && tempy >= 0 && board[tempx][tempy] == p) { // Check down and to the left.
            consecutives++;
            tempx--;
            tempy--;
        }
        return consecutives;
    }

    /**
     * Helper method for playerWon, determines the length of a diagonal line of plays(upper left to lower right).
     * @param i the x index of the play
     * @param j the y index of the play
     * @param p the player that made the most recent play.
     * @return the number of consecutive plays diagonally(lower upper left to lower right).
     */
    private int leftDiagonalConsecutives(int i, int j, int p) {
        int consecutives = 0;
        int tempx = i;
        int tempy = j;

        while(tempx >= 0 && tempy < 6 && board[tempx][tempy] == p) { // Check up and to the left.
            consecutives++;
            tempx--;
            tempy++;
        }
        tempx = i + 1;
        tempy = j - 1;
        while(tempx < 7 && tempy >= 0 && board[tempx][tempy] == p) { // Check down and to the right.
            consecutives++;
            tempx++;
            tempy--;
        }
        return consecutives;
    }

    /**
     * Determines if a play connects four.
     * @param i The x index of the play.
     * @param p The player that made the play.
     * @return If the play caused a four-play connection, true. otherwise false.
     */
    public boolean playerWon(int i, int p) {
        int j = 5;
        int consecutives = 0;
        int temp;
        while(board[i][j]==-1){ // Finds the y-index of the play.
            j--;
        }
        j--;

        consecutives = verticalConsecutives(i, j, p);
        if(consecutives==4) {
            return true;
        }
        consecutives = rightDiagonalConsecutives(i,j,p);
        if(consecutives==4) {
            return true;
        }
        consecutives = leftDiagonalConsecutives(i, j, p);
        if(consecutives==4) {
            return true;
        }
        consecutives = horizontalConsecutives(i, j, p);
        if(consecutives==4) {
            return true;
        }

        return false;
    }

    /**
     * Returns a string representation of the board.
     * @return
     */
    @Override
    public String toString() {
        String outString = "";
        for(int j = 5; j >= 0; j--) {
            for(int i = 0; i < 7; i++) {
                if(board[i][j] == -1) {
                    outString += 'X';
                } else if(board[i][j] == 0) {
                    outString += 'O';
                } else if(board[i][j] == 1) {
                    outString += 'R';
                } else {
                    outString += 'B';
                }
            }
            outString+="\n";
        }
        return outString;
    }

    /**
     * Test function for Board.
     * @param args unused.
     */
    public static void main(String[] args) {
        Board b = new Board();
        System.out.println(b);

        // ~~~~~~~~~~~~Tests verticalConsecutives()
        b.play(0,Player.PLAYER1);
        b.play(1,Player.PLAYER2);
        b.play(0,Player.PLAYER1);
        b.play(0,Player.PLAYER1);
        b.play(0,Player.PLAYER1);
        System.out.println(b);
        if(b.playerWon(0, 1)) {
            System.out.println("Player 1 won!\n");
        }

        Board b2 = new Board();
        System.out.println(b2);

        // ~~~~~~~~Tests rightDiagonalConsecutives()
        b2.play(0,Player.PLAYER1);
        b2.play(1,Player.PLAYER1);
        b2.play(1,Player.PLAYER1);
        b2.play(2,Player.PLAYER1);
        b2.play(2,Player.PLAYER1);
        b2.play(2,Player.PLAYER1);
        b2.play(3,Player.PLAYER2);
        b2.play(3,Player.PLAYER1);
        b2.play(3,Player.PLAYER1);
        b2.play(3,Player.PLAYER1);

        System.out.println(b2);
        if(b2.playerWon(3,1)) {
            System.out.println("Player 1 won!\n");
        }

        b = new Board();
        b.play(0,Player.PLAYER1);
        b.play(1,Player.PLAYER1);
        b.play(2,Player.PLAYER1);
        b.play(3,Player.PLAYER1);
        System.out.println(b);
        if(b.playerWon(3,1)){
            System.out.println("Player 1 won!");
        }
    }
}



