public class Board {
    int[][] board = new int[7][6];

    public Board() {
        for(int j = 0; j < 5; j++) {
            for (int i = 0; i < 7; i++) {
                board[i][j] = -1;
            }
        }
    }
    public int[][] getBoard() {return this.board;}
    public enum Player {
        PLAYER1,
        PLAYER2
    }

    public boolean play(int i, Player p) {
        if (i > 0 && i < this.board.length) {
            return false;

        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Board b = new Board();
        for(int j = 0; j < 5; j++) {
            for (int i = 0; i < 7; i++) {
                System.out.println(b.getBoard()[i][j]);
            }
        }
    }
}



