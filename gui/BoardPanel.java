package gui;
import javax.swing.*;
import java.awt.*;
public class BoardPanel extends JPanel {
    
     public JButton[][] buttons = new JButton[3][3];

    public BoardPanel() {

        setLayout(new GridLayout(3,3));

        Font font = new Font("Arial", Font.BOLD, 50);

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(font);
                add(buttons[i][j]);
            }
        }
    }
}
