import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FileManager {
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
            BufferedReader read = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file), App.textFrame.charCode));
            App.textFrame.textArea.setText(null);
            while ((line = read.readLine()) != null) {
                App.textFrame.textArea.append(line + "\n");
            }
            read.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    // テキストファイル保存メソッド
    public void saveFile() {
        JFileChooser fileChooser = new JFileChooser();
        var response = fileChooser.showSaveDialog(App.textFrame);
        var selectedFile = fileChooser.getSelectedFile();

        try {
            if (response == JFileChooser.APPROVE_OPTION && isTextFile(selectedFile)) {
                BufferedWriter write = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream(selectedFile), App.textFrame.charCode));
                write.write(App.textFrame.textArea.getText());
                write.close();
            } else if (!isTextFile(selectedFile)) {
                JOptionPane.showMessageDialog(null, "拡張子\".txt\"を指定してください。");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
