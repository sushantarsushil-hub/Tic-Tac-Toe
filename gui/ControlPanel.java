package gui;
import javax.swing.*;
public class ControlPanel extends JPanel{
  
     public JButton restartBtn = new JButton("Restart");
    public JComboBox<String> modeBox =
            new JComboBox<>(new String[]{"Two Player","AI Player"});

    public JComboBox<String> levelBox =
            new JComboBox<>(new String[]{"Easy","Medium","Hard"});

    public JLabel scoreLabel = new JLabel("X:0   O:0");

    public ControlPanel() {
        add(modeBox);
        add(levelBox);
        add(restartBtn);
        add(scoreLabel);
    }
    
}
