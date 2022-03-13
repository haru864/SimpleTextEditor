import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import java.awt.Dimension;
import java.awt.event.*;

public class TextFrame extends JFrame implements ActionListener {
    public TextFrame() {
        this.setTitle("Simple Text Editor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setSize(600, 700);
        this.getContentPane().setPreferredSize(new Dimension(650, 700));

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu settingMenu = new JMenu("Setting");
        JMenu helpMenu = new JMenu("Help");

        menuBar.add(fileMenu);
        menuBar.add(settingMenu);
        menuBar.add(helpMenu);

        this.setJMenuBar(menuBar);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}
