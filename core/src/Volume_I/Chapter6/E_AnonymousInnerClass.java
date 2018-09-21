package Volume_I.Chapter6;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by Star Yang on 2017/1/17.
 */
public class E_AnonymousInnerClass {
    public static void main(String[] args){
        AlarmClock clock = new AlarmClock();
        clock.start(1000, true);

        JOptionPane.showMessageDialog(null , "Quit Program ?");
        System.exit(0);
    }
}

class AlarmClock{
    public void start(int interval , final boolean beep){
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(beep){
                    Date date = new Date();
                    System.out.println("At this moment , the time is "+ date);
                }
            }
        };
        Timer timer = new Timer(interval , listener);
        timer.start();
    }
}
