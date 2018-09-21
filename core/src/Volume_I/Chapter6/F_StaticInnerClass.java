package Volume_I.Chapter6;

/**
 * Created by Star Yang on 2017/1/17.
 */
public class F_StaticInnerClass {
    public static void main(String[] args){
        double[] values = new double[20];
        for(int i=0; i<20;i++){
            values[i] = Math.random()*100;
            System.out.println(values[i]);
        }

        ArrayAlg.Pair pair = ArrayAlg.minmax(values);
        System.out.println("The Min Value is "+pair.getFirst());
        System.out.println("The Max Value is "+pair.getSecond());
    }
}

class ArrayAlg{
    public static class Pair{
        private double first;
        private double second;

        public Pair(double first, double second) {
            this.first = first;
            this.second = second;
        }

        public double getFirst() {
            return first;
        }

        public double getSecond() {
            return second;
        }
    }

    public static Pair minmax(double[] values){
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for(double d: values){
            if(min > d) min = d;
            if(max < d) max =d;
        }
        return new Pair(min, max);
    }
}
