import java.awt.Color;
import java.awt.event.*;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

public class TextArea extends JTextArea implements KeyListener {

    public String[] colorList = new String[] { "黒", "シアン", "緑", "マゼンタ", "オレンジ", "ピンク", "白", "黄" };

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
            App.textFrame.fileManager.openFile();
        } else if ((e.getKeyCode() == KeyEvent.VK_S) && ((e.getModifiersEx() &
                KeyEvent.CTRL_DOWN_MASK) != 0)) {
            App.textFrame.fileManager.saveFile();
        } else if ((e.getKeyCode() == KeyEvent.VK_J) && ((e.getModifiersEx() &
                KeyEvent.CTRL_DOWN_MASK) != 0)) {
            changeCharColor();
        } else if ((e.getKeyCode() == KeyEvent.VK_B) && ((e.getModifiersEx() &
                KeyEvent.CTRL_DOWN_MASK) != 0)) {
            changeBackgroundColor();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    // 文字の色を変更するメソッド
    public void changeCharColor() {
        int index = showDialogForColor("文字の色を選択して下さい。", "文字色を変更する");
        Color color = getColor(index);
        this.setForeground(color);
    }

    // 背景の色を変更するメソッド
    public void changeBackgroundColor() {
        int index = showDialogForColor("背景の色を選択して下さい。", "背景色を変更する");
        Color color = getColor(index);
        this.setBackground(color);
    }

    // 設定できる色をダイアログで表示するメソッド
    public int showDialogForColor(String message, String title) {
        int value = JOptionPane.showOptionDialog(App.textFrame,
                message,
                title,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                colorList,
                colorList[0]);
        return value;
    }

    // インデックスからColorを返すメソッド
    public Color getColor(int index) {
        String colorString = colorList[index];
        if (colorString == "黒")
            return Color.black;
        else if (colorString == "シアン")
            return Color.cyan;
        else if (colorString == "緑")
            return Color.green;
        else if (colorString == "マゼンタ")
            return Color.magenta;
        else if (colorString == "オレンジ")
            return Color.orange;
        else if (colorString == "ピンク")
            return Color.pink;
        else if (colorString == "白")
            return Color.white;
        else if (colorString == "黄")
            return Color.yellow;
        else
            return Color.BLACK;
    }
}
