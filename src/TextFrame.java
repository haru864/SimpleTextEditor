import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextFrame extends JFrame implements ActionListener, KeyListener {
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenu settingMenu;
    JMenuItem loadItem;
    JMenuItem saveItem;
    JMenuItem setCharColor;
    JMenuItem setBackgroundColor;

    public TextFrame() {
        // ウィンドウサイズ、ファビコン等を定義
        this.setTitle("Simple Text Editor");
        setFabicon();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.getContentPane().setPreferredSize(new Dimension(App.WIDTH, App.HEIGHT));

        // メニューバーとボタンを定義
        menuBar = new JMenuBar();
        fileMenu = new JMenu("ファイル");
        settingMenu = new JMenu("編集");
        loadItem = new JMenuItem("開く(Ctrl + o)");
        saveItem = new JMenuItem("保存(Ctrl + s)");
        setCharColor = new JMenuItem("文字の色を変更(Ctrl + c)");
        setBackgroundColor = new JMenuItem("背景色を変更(Ctrl + b)");

        // メニューバーにボタンを作成
        List<JMenuItem> itemList = new ArrayList<>(Arrays.asList(loadItem, saveItem));
        setMenuToBar(fileMenu, itemList);
        itemList = new ArrayList<>(Arrays.asList(setCharColor, setBackgroundColor));
        setMenuToBar(settingMenu, itemList);
        this.setJMenuBar(menuBar);

        // テキスト入力スペースを作成
        TextArea testArea = new TextArea();
        JScrollPane scrollPane = new JScrollPane(testArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(scrollPane);

        // コンポーネント等を設定
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setSize(new Dimension(App.WIDTH, App.HEIGHT));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loadItem) {
            System.out.println("load");
        } else if (e.getSource() == saveItem) {
            System.out.println("save");
        } else if (e.getSource() == setCharColor) {
            System.out.println("setCharColor");
        } else if (e.getSource() == setBackgroundColor) {
            System.out.println("setBackgroundColor");
        }
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

    // ファビコン作成メソッド
    public void setFabicon() {
        ImageIcon icon = new ImageIcon("./src/pencil.png");
        this.setIconImage(icon.getImage());
    }

    // メニューバー作成メソッド
    public void setMenuToBar(JMenu menu, List<JMenuItem> itemArr) {
        for (var currItem : itemArr) {
            System.out.println(currItem.getText());
            currItem.addActionListener(this);
            menu.add(currItem);
        }
        menuBar.add(menu);
    }
}
