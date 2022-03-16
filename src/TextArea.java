import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Scrollable;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.text.DefaultCaret;

public class TextArea extends JTextArea implements KeyListener {

    public TextArea() {
        super("Hello world!");
        this.setForeground(Color.white);
        this.setBackground(Color.black);
        // this.setPreferredSize(new Dimension(App.WIDTH, App.HEIGHT));
        this.setLineWrap(true);
        DefaultCaret caret = (DefaultCaret) this.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if ((e.getKeyCode() == KeyEvent.VK_O) && ((e.getModifiersEx() &
                KeyEvent.CTRL_DOWN_MASK) != 0)) {
            System.out.println("Ctrl + o");
        } else if ((e.getKeyCode() == KeyEvent.VK_S) && ((e.getModifiersEx() &
                KeyEvent.CTRL_DOWN_MASK) != 0)) {
            System.out.println("Ctrl + s");
        } else if ((e.getKeyCode() == KeyEvent.VK_C) && ((e.getModifiersEx() &
                KeyEvent.CTRL_DOWN_MASK) != 0)) {
            System.out.println("Ctrl + c");
        } else if ((e.getKeyCode() == KeyEvent.VK_B) && ((e.getModifiersEx() &
                KeyEvent.CTRL_DOWN_MASK) != 0)) {
            System.out.println("Ctrl + b");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
