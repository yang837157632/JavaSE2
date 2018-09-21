package Volume_I.Chapter12.Info;

/**
 * Created by Star Yang on 2017/2/16.
 */
public class Pair<T> {
    private T first;
    private T last;

    public Pair() {
        first = null;
        last = null;
    }

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getLast() {
        return last;
    }

    public void setLast(T last) {
        this.last = last;
    }
}
