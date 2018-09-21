package Volume_I.Chapter6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by Star Yang on 2017/1/17.
 */
public class D_InnerClass {
    public static void main(String[] args){
        TimeClock clock = new TimeClock(1000 ,true);
        clock.start();

        JOptionPane.showMessageDialog(null, "Quit Program ?");
        System.exit(0);
    }
}

class TimeClock{
    private int interval;
    private boolean beep;

    public TimeClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start(){
        ActionListener listener = new TimeListener();
        Timer timer = new Timer(interval, listener);
        timer.start();
    }

    public class TimeListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(beep){
                Date date = new Date();
                System.out.println("At this moment , the time is " + date);
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}
