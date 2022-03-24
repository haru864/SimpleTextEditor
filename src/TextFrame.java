import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextFrame extends JFrame implements ActionListener {

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
    public String charCode = AvailableCharCodeSet.defaultCharCode;

    public TextFrame() {
        // ウィンドウサイズ、ファビコン等を定義
        this.setTitle("Simple Text Editor");
        setFabicon();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.getContentPane().setPreferredSize(new Dimension(App.WIDTH, App.HEIGHT));

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
        this.add(scrollPane);

        // コンポーネント等を設定
        this.setFocusable(true);
        this.setSize(new Dimension(App.WIDTH, App.HEIGHT));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loadItem) {
            openFile();
        } else if (e.getSource() == saveItem) {
            saveFile();
        } else if (e.getSource() == setCharColor) {
            textArea.changeCharColor();
        } else if (e.getSource() == setBackgroundColor) {
            textArea.changeBackgroundColor();
        } else if (e.getSource() == setCharCode) {
            this.charCode = AvailableCharCodeSet.showAvailableCharCode();
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

    // テキストファイル判定メソッド
    public boolean isTextFile(File file) {
        var fileName = file.getName();
        var index = fileName.lastIndexOf(".");
        if (index == -1)
            return false;

        var fileExtension = fileName.substring(index);
        if (fileExtension.equals(".txt"))
            return true;
        else
            return false;
    }

    // テキストファイル選択・読み込みメソッド
    public void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        var selectedFile = fileChooser.getSelectedFile();

        if (isTextFile(selectedFile)) {
            loadTextFile(selectedFile);
        } else {
            JOptionPane.showMessageDialog(null, "テキストファイルを選択してください。");
        }
    }

    // テキストファイル読み込みメソッド
    public void loadTextFile(File file) {
        try {
            String line;
            BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(file), charCode));
            textArea.setText(null);
            while ((line = read.readLine()) != null) {
                textArea.append(line + "\n");
            }
            read.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    // テキストファイル保存メソッド
    public void saveFile() {
        JFileChooser fileChooser = new JFileChooser();
        var response = fileChooser.showSaveDialog(this);
        var selectedFile = fileChooser.getSelectedFile();

        try {
            if (response == JFileChooser.APPROVE_OPTION && isTextFile(selectedFile)) {
                BufferedWriter write = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream(selectedFile), charCode));
                write.write(textArea.getText());
                write.close();
            } else if (!isTextFile(selectedFile)) {
                JOptionPane.showMessageDialog(null, "拡張子\".txt\"を指定してください。");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
