package Volume_I.Chapter6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by Star Yang on 2017/1/17.
 */
public class C_Timer {
    public static void main(String[] args){
        ActionListener listener = new TimeListener();
        Timer timer = new Timer(1000, listener);
        timer.start();

        JOptionPane.showMessageDialog(null,"Quit Program ?");
        timer.stop();
//        System.exit(0);
    }
}

class TimeListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        Date now = new Date();
        System.out.println("At this moment, the time is " + now );
        Toolkit.getDefaultToolkit().beep();
    }
}
