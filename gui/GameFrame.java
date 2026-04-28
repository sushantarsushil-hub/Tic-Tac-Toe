package gui;

import javax.swing.*;


import model.ScoreBoard;
import logic.GameLogic;
import logic.AIPlayer;

public class GameFrame extends JFrame {
    
  BoardPanel boardPanel = new BoardPanel();
    ControlPanel controlPanel = new ControlPanel();

    ScoreBoard score = new ScoreBoard();

    String[][] board = new String[3][3];
    String currentPlayer = "X";
    boolean gameOver = false;

    public GameFrame() {

        setTitle("Tic Tac Toe");
        setSize(500,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(boardPanel);
        add(controlPanel);

        initBoard();
        addEvents();

        setVisible(true);
    }

    void initBoard() {
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                board[i][j] = "";
    }

    void addEvents() {

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){

                int r=i,c=j;

                boardPanel.buttons[i][j].addActionListener(e -> playMove(r,c));
            }
        }

        controlPanel.restartBtn.addActionListener(e -> resetGame());
    }

    void playMove(int r,int c) {

        if(gameOver || !board[r][c].equals("")) return;

        board[r][c] = currentPlayer;
        boardPanel.buttons[r][c].setText(currentPlayer);

        checkGame();

        if(gameOver) return;

        currentPlayer = currentPlayer.equals("X") ? "O" : "X";

        if(controlPanel.modeBox.getSelectedItem().equals("AI Player")
                && currentPlayer.equals("O")) {

            aiTurn();
        }
    }

    void aiTurn() {

        int[] move;

    String level = controlPanel.levelBox.getSelectedItem().toString();

    switch(level) {
        case "Easy":
            move = AIPlayer.easyMove(board);
            break;
        case "Medium":
            move = AIPlayer.mediumMove(board);
            break;
        default:
            move = AIPlayer.hardMove(board);
    }

    playMove(move[0], move[1]);
    }

    void checkGame() {

        String winner = GameLogic.checkWinner(board);

        if(!winner.equals("")) {

            gameOver = true;

            if(winner.equals("X")) score.xScore++;
            else score.oScore++;

            updateScore();

            JOptionPane.showMessageDialog(this,
                    winner + " Wins!");

        } else if(GameLogic.isDraw(board)) {

            gameOver = true;

            JOptionPane.showMessageDialog(this,
                    "Draw Match!");
        }
    }

    void updateScore() {
        controlPanel.scoreLabel.setText(
                "X:" + score.xScore + "   O:" + score.oScore);
    }

    void resetGame() {

        gameOver = false;
        currentPlayer = "X";

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j] = "";
                boardPanel.buttons[i][j].setText("");
            }
        }
    }

}
