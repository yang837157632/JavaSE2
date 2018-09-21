package Volume_I.Chapter9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Star Yang on 2017/1/29.
 */
public class D_JRadioButton {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyFrame4 frame = new MyFrame4();
                frame.setTitle("RadioButton");
                frame.setSize(800,200);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class MyFrame4 extends JFrame{
    private JPanel buttonPanel;
    private ButtonGroup buttonGroup;
    private JLabel label;
    private static final int DEFAULT_SIZE = 36;

    public MyFrame4(){
        label = new JLabel("The quick brown fox jumps over the lazy dog.",JLabel.CENTER);
        label.setFont(new Font("Serif",Font.PLAIN,DEFAULT_SIZE));
        add(label);

        buttonPanel = new JPanel();
        buttonGroup = new ButtonGroup();
        addRadioButton("Small",8);
        addRadioButton("Medium",12);
        addRadioButton("Large",18);
        addRadioButton("Extra large",36);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void addRadioButton(String name,final int size){
        boolean selected = size == DEFAULT_SIZE;
        JRadioButton button = new JRadioButton(name,selected);
        buttonGroup.add(button);
        buttonPanel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setFont(new Font("Serif",Font.PLAIN,size));
            }
        });
    }
}
