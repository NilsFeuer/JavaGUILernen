package guiPackage;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    Container c;
    JButton loginButton, resetButton;
    JTextField userText;
    JPasswordField passwordField;
    JLabel user, passwort;

    public LoginFrame() {
        c = getContentPane();

        loginButton = new JButton("Einloggen");
        resetButton = new JButton("Zurücksetzen");

        userText = new JTextField();

        passwordField = new JPasswordField();

        user = new JLabel("Benutzername");
        passwort = new JLabel("Passwort");

        c.setLayout(new GridLayout(3, 2, 5, 10));
        c.add(user);
        c.add(userText);
        c.add(passwort);
        c.add(passwordField);
        c.add(loginButton);
        c.add(resetButton);
    }
}
