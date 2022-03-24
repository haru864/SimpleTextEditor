import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextFrame extends JFrame implements ActionListener {

    JPanel bottomPanel;
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenu settingMenu;
    JMenuItem loadItem;
    JMenuItem saveItem;
    JMenuItem setCharColor;
    JMenuItem setBackgroundColor;
    JMenuItem setCharCode;
    TextArea textArea;
    File currentTextFile;
    FileManager fileManager = new FileManager();
    String charCode = AvailableCharCodeSet.defaultCharCode;

    public TextFrame() {
        // ウィンドウサイズ、ファビコン等を定義
        this.setTitle("Simple Text Editor");
        setLayout(new BorderLayout());
        setFabicon();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // メニューバーとボタンを定義
        menuBar = new JMenuBar();
        fileMenu = new JMenu("ファイル");
        settingMenu = new JMenu("設定");
        loadItem = new JMenuItem("開く(Ctrl + o)");
        saveItem = new JMenuItem("保存(Ctrl + s)");
        setCharColor = new JMenuItem("文字の色を変更(Ctrl + c)");
        setBackgroundColor = new JMenuItem("背景色を変更(Ctrl + b)");
        setCharCode = new JMenuItem("文字コードを変更");

        // メニューバーにボタンを作成
        List<JMenuItem> itemList = new ArrayList<>(Arrays.asList(loadItem, saveItem));
        setMenuToBar(fileMenu, itemList);
        itemList = new ArrayList<>(Arrays.asList(setCharColor, setBackgroundColor, setCharCode));
        setMenuToBar(settingMenu, itemList);
        this.setJMenuBar(menuBar);

        // テキスト入力スペースを作成
        textArea = new TextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(scrollPane, BorderLayout.CENTER);

        // ボトムパネルを作成
        bottomPanel = new BottomPanel();
        this.add(bottomPanel, BorderLayout.SOUTH);

        // コンポーネント等を設定
        this.setFocusable(true);
        this.setSize(new Dimension(App.WIDTH, App.HEIGHT));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loadItem) {
            fileManager.openFile();
        } else if (e.getSource() == saveItem) {
            fileManager.saveFile();
        } else if (e.getSource() == setCharColor) {
            textArea.changeCharColor();
        } else if (e.getSource() == setBackgroundColor) {
            textArea.changeBackgroundColor();
        } else if (e.getSource() == setCharCode) {
            var selectedCharCode = AvailableCharCodeSet.showAvailableCharCode();
            ((BottomPanel) bottomPanel).charCodeLabel.setText(selectedCharCode);
            this.charCode = AvailableCharCodeSet.getCharCode(selectedCharCode);
            // System.out.println(selectedCharCode + ", " + this.charCode);
        }
    }

    // ファビコン作成メソッド
    public void setFabicon() {
        ImageIcon icon = new ImageIcon("./src/pic/pencil.png");
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
