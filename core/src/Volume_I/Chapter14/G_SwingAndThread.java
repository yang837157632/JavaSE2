package Volume_I.Chapter14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by Star Yang on 2017/3/24.
 */
public class G_SwingAndThread {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new SwingThreadFrame();
                frame.setTitle("SwingThreadTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class SwingThreadFrame extends JFrame {
    public SwingThreadFrame(){
        final JComboBox<Integer> combo = new JComboBox<Integer>();
        combo.insertItemAt(Integer.MAX_VALUE , 0);
        combo.setPrototypeDisplayValue(combo.getItemAt(0));
        combo.setSelectedIndex(0);

        JPanel panel = new JPanel();
        JButton goodButton = new JButton("Good");
        goodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(new GoodRunnable(combo)).start();
            }
        });
        panel.add(goodButton);

        JButton badButton = new JButton("Bad");
        badButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(new BadRunnable(combo)).start();
            }
        });
        panel.add(badButton);

        panel.add(combo);
        add(panel);
        pack();
    }
}

class BadRunnable implements Runnable {
    private JComboBox<Integer> combo;
    private Random generator;

    public BadRunnable(JComboBox<Integer> combo) {
        this.combo = combo;
        generator = new Random();
    }

    @Override
    public void run() {
        try {
            while (true) {
                int i = Math.abs(generator.nextInt());
                if (i % 2 == 0) {
                    combo.insertItemAt(i, 0);
//                    System.out.println("Bad Add");
                }
                else if (combo.getItemCount() > 0) {
                    combo.removeItemAt(i % combo.getItemCount());
//                    System.out.println("Bad Remove");
                }
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class GoodRunnable implements Runnable {
    private JComboBox<Integer> combo;
    private Random generator;

    public GoodRunnable(JComboBox<Integer> combo) {
        this.combo = combo;
        generator = new Random();
    }

    @Override
    public void run() {
        try {
            while (true) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        int i = Math.abs(generator.nextInt());
                        if (i % 2 == 0){
                            combo.insertItemAt(i, 0);
//                            System.out.println("Good Add");
                        }
                        else if (combo.getItemCount() > 0) {
                            combo.removeItemAt(i % combo.getItemCount());
//                            System.out.println("Good Remove");
                        }
                    }
                });
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
