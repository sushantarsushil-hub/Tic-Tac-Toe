package logic;

public class GameLogic {
     public static String checkWinner(String[][] board) {

        for (int i = 0; i < 3; i++) {
            if (!board[i][0].equals("") &&
                board[i][0].equals(board[i][1]) &&
                board[i][1].equals(board[i][2]))
                return board[i][0];

            if (!board[0][i].equals("") &&
                board[0][i].equals(board[1][i]) &&
                board[1][i].equals(board[2][i]))
                return board[0][i];
        }

        if (!board[0][0].equals("") &&
            board[0][0].equals(board[1][1]) &&
            board[1][1].equals(board[2][2]))
            return board[0][0];

        if (!board[0][2].equals("") &&
            board[0][2].equals(board[1][1]) &&
            board[1][1].equals(board[2][0]))
            return board[0][2];

        return "";
    }

    public static boolean isDraw(String[][] board) {
        for (int i=0;i<3;i++)
            for (int j=0;j<3;j++)
                if (board[i][j].equals(""))
                    return false;

        return checkWinner(board).equals("");
    }
}
