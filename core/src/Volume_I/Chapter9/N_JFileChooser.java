package Volume_I.Chapter9;

import Volume_I.Chapter9.Info.FileIconView;
import Volume_I.Chapter9.Info.ImagePreviewer;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Star Yang on 2017/1/31.
 */
public class N_JFileChooser {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyFrame14 frame = new MyFrame14();
                frame.setTitle("JFileChooser");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class MyFrame14 extends JFrame{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;
    private JLabel label;
    private JFileChooser chooser;

    public MyFrame14(){
        setSize(DEFAULT_WIDTH , DEFAULT_HEIGHT);
        label = new JLabel();
        add(label);
        chooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files" ,"jpg" , "jpeg" , "gif");
        chooser.setFileFilter(filter);
        chooser.setAccessory(new ImagePreviewer(chooser));
        chooser.setFileView(new FileIconView(filter , new ImageIcon("out/production/core/img/3.gif")));

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooser.setCurrentDirectory(new File("."));
                int result = chooser.showOpenDialog(MyFrame14.this);
                if(result==JFileChooser.APPROVE_OPTION){
                    String name = chooser.getSelectedFile().getPath();
                    label.setIcon(new ImageIcon(name));
                    pack();
                }
            }
        });

        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
