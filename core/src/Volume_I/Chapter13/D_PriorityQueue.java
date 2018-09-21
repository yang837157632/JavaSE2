package Volume_I.Chapter13;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.PriorityQueue;

/**
 * Created by Star Yang on 2017/3/11.
 */
public class D_PriorityQueue {
    public static void main(String[] args){
        PriorityQueue<GregorianCalendar> pq = new PriorityQueue<GregorianCalendar>();
        pq.add(new GregorianCalendar(1906 , Calendar.DECEMBER , 9));
        pq.add(new GregorianCalendar(1815 , Calendar.DECEMBER , 10));
        pq.add(new GregorianCalendar(1803 , Calendar.DECEMBER , 3));
        pq.add(new GregorianCalendar(1910 , Calendar.JUNE , 22));

        System.out.println("Iterating over elements ...");
        for (GregorianCalendar data : pq){
            System.out.println(data.get(Calendar.YEAR));
        }
        System.out.println("Removing elements ...");
        while(!pq.isEmpty()){
            System.out.println(pq.remove().get(Calendar.YEAR));
        }
    }
}
