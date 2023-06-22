package mainPackage;

import guiPackage.MainFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        MainFrame.getMainFrame().setTitle("Main-Frame");
        MainFrame.getMainFrame().setVisible(true);
        MainFrame.getMainFrame().setSize(450, 400);
        MainFrame.getMainFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.getMainFrame().setLocationRelativeTo(null);
    }
}
