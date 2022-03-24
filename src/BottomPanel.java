import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BottomPanel extends JPanel {

    public JLabel charCodeLabel;

    public BottomPanel() {
        setBackground(Color.LIGHT_GRAY);
        setLayout(new BorderLayout());

        charCodeLabel = new JLabel(AvailableCharCodeSet.defaultCharCode);
        charCodeLabel.setFont(new Font("Arial", Font.ROMAN_BASELINE, 14));
        add(charCodeLabel, BorderLayout.WEST);
    }

    public static void test() {

    }
}
