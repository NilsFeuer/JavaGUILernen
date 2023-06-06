package mainPackage;

import guiPackage.MainFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setTitle("Main-Frame");
        mainFrame.setVisible(true);
        mainFrame.setSize(450, 400);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
    }
}
