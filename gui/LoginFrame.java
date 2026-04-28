package gui;

import javax.swing.*;
import model.UserDatabase;

public class LoginFrame extends JFrame {

    JTextField usernameField = new JTextField(15);
    JPasswordField passwordField = new JPasswordField(15);

    JButton loginBtn = new JButton("Login");
    JButton registerBtn = new JButton("Register");

    public LoginFrame() {

        setTitle("Login");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(new JLabel("Username"));
        add(usernameField);
        add(new JLabel("Password"));
        add(passwordField);
        add(loginBtn);
        add(registerBtn);

        loginBtn.addActionListener(e -> login());
        registerBtn.addActionListener(e -> {
            new RegisterFrame();
            dispose();
        });

        setVisible(true);
    }

    void login() {

        String user = usernameField.getText();
        String pass = new String(passwordField.getPassword());

        if(UserDatabase.login(user, pass)) {
            new GameFrame();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Login");
        }
    }
}