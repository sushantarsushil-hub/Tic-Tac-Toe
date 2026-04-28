package gui;

import javax.swing.*;
import model.UserDatabase;

public class RegisterFrame extends JFrame {

    JTextField usernameField = new JTextField(15);
    JPasswordField passwordField = new JPasswordField(15);

    JButton registerBtn = new JButton("Register");
    JButton backBtn = new JButton("Back");

    public RegisterFrame() {

        setTitle("Register");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(new JLabel("Username"));
        add(usernameField);
        add(new JLabel("Password"));
        add(passwordField);
        add(registerBtn);
        add(backBtn);

        registerBtn.addActionListener(e -> register());
        backBtn.addActionListener(e -> {
            new LoginFrame();
            dispose();
        });

        setVisible(true);
    }

    void register() {

        String user = usernameField.getText();
        String pass = new String(passwordField.getPassword());

        if(UserDatabase.register(user, pass)) {
            JOptionPane.showMessageDialog(this, "Registration Success");
            new LoginFrame();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Username already exists");
        }
    }
}