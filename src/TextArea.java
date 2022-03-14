import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Scrollable;
import javax.swing.plaf.DimensionUIResource;

public class TextArea extends JTextArea {

    public TextArea() {
        super("Hello world!");
        this.setForeground(Color.white);
        this.setBackground(Color.black);
        this.setPreferredSize(new Dimension(App.WIDTH, App.HEIGHT));
    }
}
