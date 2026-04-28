package logic;

import java.util.Random;

public class AIPlayer {

    static Random random = new Random();

    public static int[] easyMove(String[][] board) {
        return randomMove(board);
    }

    public static int[] mediumMove(String[][] board) {

        
        if(random.nextBoolean())
            return hardMove(board);
        else
            return randomMove(board);
    }

    public static int[] hardMove(String[][] board) {

        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j].equals("")){
                    board[i][j] = "O";
                    if(GameLogic.checkWinner(board).equals("O")){
                        board[i][j] = "";
                        return new int[]{i,j};
                    }
                    board[i][j] = "";
                }
            }
        }

        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j].equals("")){
                    board[i][j] = "X";
                    if(GameLogic.checkWinner(board).equals("X")){
                        board[i][j] = "";
                        return new int[]{i,j};
                    }
                    board[i][j] = "";
                }
            }
        }

        return randomMove(board);
    }

    private static int[] randomMove(String[][] board) {
        while(true){
            int r = random.nextInt(3);
            int c = random.nextInt(3);
            if(board[r][c].equals(""))
                return new int[]{r,c};
        }
    }
}