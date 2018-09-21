package Volume_I.Chapter9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Star Yang on 2017/1/29.
 */
public class B_Text {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyFrame2 frame = new MyFrame2();
                frame.setTitle("Text");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class MyFrame2 extends JFrame{
    public static final int TEXTAREA_ROWS = 8;
    public static final int TEXTAREA_COLUMNS = 20;

    public MyFrame2(){
        final JTextField textField = new JTextField();
        final JPasswordField passwordField = new JPasswordField();

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2,2));
        northPanel.add(new JLabel("Username",SwingConstants.RIGHT));
        northPanel.add(textField);
        northPanel.add(new JLabel("Password",SwingConstants.RIGHT));
        northPanel.add(passwordField);
        add(northPanel,BorderLayout.NORTH);

        final JTextArea textArea = new JTextArea(TEXTAREA_ROWS,TEXTAREA_COLUMNS);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane,BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        JButton insertButton = new JButton("Insert");
        southPanel.add(insertButton);
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("Username: "+textField.getText()+"\n" +
                        "Password: "+new String(passwordField.getPassword())+"\n");
            }
        });
        add(southPanel,BorderLayout.SOUTH);
        pack();
    }
}
