package guiPackage;

import authentifizierungPackage.AuthentifizierungKlasse;
import authentifizierungPackage.PasswortManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
        LoginButtonKeyListener loginButtonKeyListener = new LoginButtonKeyListener();
        loginButton.addKeyListener(loginButtonKeyListener);

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
            LoggedInFrame eingeloggt = new LoggedInFrame();
            eingeloggt.setVisible(true);
            eingeloggt.setSize(300, 200);
            eingeloggt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(false);
            MainFrame mainFrame = MainFrame.getMainFrame();
            mainFrame.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(c, "Falsches Passwort/Username");
        }
    }

    public String getUserText() {
        return userText.getText();
    }

    public String getPasswordField() {
        return new String(passwordField.getPassword());
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

    public class LoginButtonKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                checkLogin();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

}
