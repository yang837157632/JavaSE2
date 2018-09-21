package Volume_I.Chapter9;

import Volume_I.Chapter9.Info.PasswordChooser;
import Volume_I.Chapter9.Info.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Star Yang on 2017/1/31.
 */
public class M_DataExchange {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyFrame13 frame = new MyFrame13();
                frame.setLocationByPlatform(true);
                frame.setTitle("Data Exchange");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class MyFrame13 extends JFrame{
    private static final int TEXT_ROWS = 20;
    private static final int TEXT_COLUMNS = 40;
    private PasswordChooser dialog = null;
    private JTextArea textArea;

    public MyFrame13(){
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem connectItem = new JMenuItem("Connect");
        connectItem.addActionListener(new connectAction());
        fileMenu.add(connectItem);

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(exitItem);

        textArea = new JTextArea(TEXT_ROWS , TEXT_COLUMNS);
        add(new JScrollPane(textArea),BorderLayout.CENTER);
        pack();
    }

    private class connectAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(dialog==null) dialog = new PasswordChooser();
            dialog.setUser(new User("yourname" , null));

            if(dialog.showDialog(MyFrame13.this,"Connect")){
                User user = dialog.getUser();
                textArea.append("Username: "+user.getUsername()+"\nPassword: "+new String(user.getPassword())+"\n");
            }
        }
    }
}
