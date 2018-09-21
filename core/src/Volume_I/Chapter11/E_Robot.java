package Volume_I.Chapter11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 * Created by Star Yang on 2017/2/15.
 */
public class E_Robot {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ButtonFrame frame = new ButtonFrame();
                frame.setTitle("ButtonTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });

        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice screen = environment.getDefaultScreenDevice();

        try {
            final Robot robot = new Robot(screen);
            robot.waitForIdle();
            new Thread() {
                public void run() {
                    runTest(robot);
                }
            }.start();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void runTest(Robot robot) {
        robot.delay(1000);
        robot.keyPress(' ');
        robot.keyRelease(' ');

        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(' ');
        robot.keyRelease(' ');

        robot.delay(1000);
        robot.mouseMove(220, 40);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);

        robot.delay(1000);
        BufferedImage image = robot.createScreenCapture(new Rectangle(0, 0, 400, 300));

        ImageFrame frame = new ImageFrame(image);
        frame.setVisible(true);
    }
}

class ImageFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 450;
    private static final int DEFAULT_HEIGHT = 350;

    public ImageFrame(Image image) {
        setTitle("Capture");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocation(500, 200);
        JLabel label = new JLabel(new ImageIcon(image));
        add(label);
    }
}

class ButtonFrame extends JFrame {
    private JPanel panel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public ButtonFrame() {
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        panel = new JPanel();
        add(panel);

        JButton yellowButton = new JButton("YELLOW");
        JButton redButton = new JButton("RED");
        JButton greenButton = new JButton("GREEN");

        ColorAction yellowListener = new ColorAction(Color.YELLOW);
        ColorAction redListener = new ColorAction(Color.RED);
        ColorAction greenListener = new ColorAction(Color.GREEN);

        yellowButton.addActionListener(yellowListener);
        redButton.addActionListener(redListener);
        greenButton.addActionListener(greenListener);

        panel.add(yellowButton);
        panel.add(redButton);
        panel.add(greenButton);
    }

    private class ColorAction implements ActionListener {
        private Color bgcolor;

        public ColorAction(Color color) {
            bgcolor = color;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            panel.setBackground(bgcolor);
        }
    }
}