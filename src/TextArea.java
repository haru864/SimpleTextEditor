import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Scrollable;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.text.DefaultCaret;

public class TextArea extends JTextArea implements KeyListener {

    public Color charColor;
    public Color backgroundColor;

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
        } else if ((e.getKeyCode() == KeyEvent.VK_J) && ((e.getModifiersEx() &
                KeyEvent.CTRL_DOWN_MASK) != 0)) {
            showDialogForCharColor();
        } else if ((e.getKeyCode() == KeyEvent.VK_B) && ((e.getModifiersEx() &
                KeyEvent.CTRL_DOWN_MASK) != 0)) {
            System.out.println("Ctrl + b");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    // 設定できる文字の色をダイアログで表示するメソッド
    public static void showDialogForCharColor() {
        String userDir = System.getProperty("user.dir");
        System.out.println(userDir);
        String[] colorList = new String[] { "黒", "シアン", "緑", "マゼンタ", "オレンジ", "ピンク", "白", "黄" };
        // ImageIcon charColorIcon = new ImageIcon("");

        int value = JOptionPane.showOptionDialog(App.textFrame,
                "どの色にしますか？",
                "文字色を変更する",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                colorList,
                colorList[0]);
    }

    // 文字の色をセットするメソッド
    public void setCharColor() {
    }
}
