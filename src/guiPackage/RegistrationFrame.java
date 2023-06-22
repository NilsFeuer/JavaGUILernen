package guiPackage;

import authentifizierungPackage.PasswortManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationFrame extends JFrame {
    Container c;
    JLabel username, passwort, repeatPasswort;
    JTextField usernameText;
    JPasswordField passwordField, repeatPasswordField;
    JButton registrationButton, resetButton;

    public RegistrationFrame() {
        c = getContentPane();
        c.setLayout(new GridLayout(4, 2, 10, 5));

        username = new JLabel("Username");
        passwort = new JLabel("Passwort");
        repeatPasswort = new JLabel("Passwort wiederholen");

        usernameText = new JTextField("Username eingeben");

        passwordField = new JPasswordField();
        repeatPasswordField = new JPasswordField();

        registrationButton = new JButton("Registrieren");
        RegistrationButtonListener regButtonListener = new RegistrationButtonListener();
        registrationButton.addActionListener(regButtonListener);
        resetButton = new JButton("Zurücksetzen");

        c.add(username);
        c.add(usernameText);
        c.add(passwort);
        c.add(passwordField);
        c.add(repeatPasswort);
        c.add(repeatPasswordField);
        c.add(registrationButton);
        c.add(resetButton);
    }

    public class RegistrationButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (passwordField.getText().equals(repeatPasswordField.getText())) {
                PasswortManager.getPasswortManager().setMap(usernameText.getText(), passwordField.getText());
                System.out.println(PasswortManager.getPasswortManager().getMap());
            } else {
                JOptionPane.showMessageDialog(c, "Passwörter stimmen nicht überein");
                passwordField.setText("");
                repeatPasswordField.setText("");
            }
        }
    }
}