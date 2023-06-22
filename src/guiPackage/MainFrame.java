package guiPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    Container c;
    JButton loginButton;
    private static MainFrame mainFrame = new MainFrame();

    private MainFrame() {
        c = getContentPane();
        loginButton = new JButton("Einloggen");
        LoginButtonListener loginButtonListener = new LoginButtonListener();
        loginButton.addActionListener(loginButtonListener);


        c.add(loginButton, BorderLayout.NORTH);
    }
    public static MainFrame getMainFrame(){
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
}
