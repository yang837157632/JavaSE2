package Volume_I.Chapter9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Star Yang on 2017/1/29.
 */
public class C_JCheckBox {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyFrame3 frame = new MyFrame3();
                frame.setSize(400,300);
                frame.setTitle("CheckBox");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class MyFrame3 extends JFrame{
    private JPanel buttonPanel;
    private JLabel label;
    private JCheckBox bold;
    private JCheckBox italic;
    private static final int FONTSIZE = 20;

    public MyFrame3(){
        label = new JLabel("The quick brown fox jumps over the lazy dog");
        add(label,BorderLayout.CENTER);

        buttonPanel = new JPanel();
        bold = new JCheckBox("Bold");
        italic = new JCheckBox("Italic");
        buttonPanel.add(bold);
        buttonPanel.add(italic);
        add(buttonPanel,BorderLayout.SOUTH);

        ActionListener listener = new CheckBoxListener();
        bold.addActionListener(listener);
        italic.addActionListener(listener);
    }

    class CheckBoxListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int mode =0;
            if(bold.isSelected()) mode += Font.BOLD;
            if(italic.isSelected()) mode += Font.ITALIC;
            label.setFont(new Font("Serif",mode,FONTSIZE));
        }
    }
}
