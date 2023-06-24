package guiPackage;

import javax.swing.*;
import java.awt.*;

public class LoggedInFrame extends JFrame {
    Container c;
    JLabel headline;
    public LoggedInFrame(){
        c = getContentPane();

        headline = new JLabel("Willkommen");

        c.add(headline, BorderLayout.CENTER);
    }
}
