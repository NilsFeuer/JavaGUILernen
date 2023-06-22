package guiPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    Container c;
    JButton loginButton, registrationButton;
    private static MainFrame mainFrame = new MainFrame();

    private MainFrame() {
        c = getContentPane();
        c.setLayout(new FlowLayout());
        loginButton = new JButton("Einloggen");
        LoginButtonListener loginButtonListener = new LoginButtonListener();
        loginButton.addActionListener(loginButtonListener);

        registrationButton = new JButton("Registrieren");
        RegistrationButtonListener registrationButtonListener = new RegistrationButtonListener();
        registrationButton.addActionListener(registrationButtonListener);

        c.add(registrationButton);
        c.add(loginButton);
    }

    public static MainFrame getMainFrame() {
        return mainFrame;
    }

    public class LoginButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
            loginFrame.setTitle("Login-Page");
            loginFrame.setSize(350, 200);
            loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            loginFrame.setLocationRelativeTo(null);
        }
    }

    public class RegistrationButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            RegistrationFrame registrationFrame = new RegistrationFrame();
            registrationFrame.setVisible(true);
            registrationFrame.setTitle("Registration-Page");
            registrationFrame.setSize(350, 200);
            registrationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            registrationFrame.setLocationRelativeTo(null);
        }
    }
}
