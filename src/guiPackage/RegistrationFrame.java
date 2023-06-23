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

    public void checkRegistration() {
        if (equalPasswords() && checkEmptyFields()) {
            PasswortManager.getPasswortManager().setMap(usernameText.getText(), getPassword());
            JOptionPane.showMessageDialog(c, "Erfolgreich registriert");
            usernameText.setText("");
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(c, "Passwörter stimmen nicht überein");
        }
        passwordField.setText("");
        repeatPasswordField.setText("");
    }

    private String getPassword() {
        return new String(passwordField.getPassword());
    }

    private String getRePassword() {
        return new String(repeatPasswordField.getPassword());
    }

    private Boolean equalPasswords() {
        return getPassword().equals(getRePassword());
    }

    private Boolean checkEmptyFields() {
        return !getPassword().equals("") && !usernameText.getText().equals("");
    }

    public class RegistrationButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            checkRegistration();
        }
    }
}
