package guiPackage;

import authentifizierungPackage.AuthentifizierungKlasse;
import authentifizierungPackage.PasswortManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class LoginFrame extends JFrame {
    Container c;
    JButton loginButton, resetButton;
    JTextField userText;
    JPasswordField passwordField;
    JLabel user, passwort;

    public LoginFrame() {
        c = getContentPane();

        loginButton = new JButton("Einloggen");
        LoginButtonListener loginButtonListener = new LoginButtonListener();
        loginButton.addActionListener(loginButtonListener);
        resetButton = new JButton("Zurücksetzen");
        ResetButtonListener resetButtonListener = new ResetButtonListener();
        resetButton.addActionListener(resetButtonListener);

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

    public void checkLogin() {
        Map<String, String> databaseClone = PasswortManager.getPasswortManager().getMap();
        AuthentifizierungKlasse authentifizierungKlasse = new AuthentifizierungKlasse();
        if (authentifizierungKlasse.checkLogin(databaseClone, this)) {
            JOptionPane.showMessageDialog(c, "Eingeloggt");
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(c, "Falsches Passwort/Username");
        }
    }

    public String getUserText() {
        return userText.getText();
    }

    public String getPasswordField() {
        String password = new String(passwordField.getPassword());
        return password;
    }

    public class LoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            checkLogin();
        }
    }

    public class ResetButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            userText.setText("");
            passwordField.setText("");
        }
    }
}
