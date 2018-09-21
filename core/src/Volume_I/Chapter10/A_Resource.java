package Volume_I.Chapter10;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Star Yang on 2017/4/8.
 */
public class A_Resource {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new ResourceFrame();
                frame.setTitle("Resource");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class ResourceFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 300;

    public ResourceFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        URL aboutURL = getClass().getResource("../../img/6.jpg");
        Image image = new ImageIcon(aboutURL).getImage();
        setIconImage(image);

        JTextArea textArea = new JTextArea();
        InputStream inputStream = getClass().getResourceAsStream("../../txt/1.txt");
        Scanner in = new Scanner(inputStream);
        while (in.hasNext()) {
            textArea.append(in.nextLine() + "\n");
        }
        add(textArea);
    }
}