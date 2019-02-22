public class Board {
    private String player1;
    private String player2;

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

    public boolean playerWon(int i, int p) {
        return false;
    }





    @Override
    public String toString() {
        String outString = "";
        for(int j = 0; j < 6; j++) {
            for(int i = 0; i < 7; i++) {
                outString += board[i][j];
            }
            outString+="\n";
        }
        return outString;
    }

    public static void main(String[] args) {
        Board b = new Board();
        System.out.println(b);

    }
}



