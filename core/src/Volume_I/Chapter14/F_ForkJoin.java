package Volume_I.Chapter14;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Star Yang on 2017/3/22.
 */
public class F_ForkJoin {
    public static void main(String[] args) {
        final int SIZE = 10000000;
        double[] numbers = new double[SIZE];
        for(int i=0;i<SIZE;i++) numbers[i] = Math.random();
        NumberCounter counter = new NumberCounter(numbers, 0, numbers.length, new Filter() {
            @Override
            public boolean accept(double t) {
                return t>0.5;
            }
        });
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(counter);
        System.out.println(counter.join());
    }
}

interface Filter{
    boolean accept(double t);
}

class NumberCounter extends RecursiveTask<Integer> {
    public static final int THRESHOLD = 1000;
    private double[] values;
    private int from;
    private int to;
    private Filter filter;

    public NumberCounter(double[] values, int from, int to, Filter filter) {
        this.values = values;
        this.from = from;
        this.to = to;
        this.filter = filter;
    }

    @Override
    protected Integer compute() {
        if(to-from<THRESHOLD){
            int count = 0;
            for(int i = from;i<to;i++){
                if(filter.accept(values[i])) count++;
            }
            return count;
        }else{
            int mid = (from + to)/2;
            NumberCounter first = new NumberCounter(values , from , mid, filter);
            NumberCounter second = new NumberCounter(values, mid, to ,filter);
            invokeAll(first ,second);
            return first.join() + second.join();
        }
    }
}