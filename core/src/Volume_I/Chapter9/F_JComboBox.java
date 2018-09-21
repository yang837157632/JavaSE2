package Volume_I.Chapter9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Star Yang on 2017/1/29.
 */
public class F_JComboBox {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyFrame6 frame = new MyFrame6();
                frame.setTitle("ComboBox");
                frame.setSize(800, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class MyFrame6 extends JFrame {
    private String[] fontNames;
    private JComboBox<String> faceCombo;
    private JLabel label;
    private JPanel panel;
    private static final int DEFAULT_SIZE = 24;

    public MyFrame6() {
        fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        label = new JLabel("The quick brown fox jumps over the lazy dog",JLabel.CENTER);
        label.setFont(new Font("Serif",Font.PLAIN,DEFAULT_SIZE));
        add(label);

        faceCombo = new JComboBox<String>();
        for(String face : fontNames){
            faceCombo.addItem(face);
        }
        faceCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setFont(new Font(faceCombo.getItemAt(faceCombo.getSelectedIndex()),Font.PLAIN,DEFAULT_SIZE));
            }
        });

        panel = new JPanel();
        panel.add(faceCombo);
        add(panel,BorderLayout.SOUTH);
    }
}
