package Iterator;

/**
 * Created by Star Yang on 2016/11/29.
 */
public class LinkedListX implements CollectionX {

    private int index = 0;
    private Node first = null;
    private Node last = null;

    @Override
    public void add(Object o) {
        Node node = new Node(o,null);
        if(first==null){
            first = node;
        }else{
            last.setNext(node);
        }
        last = node;
        index++;
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public IteratorX iterator() {
        return new MyIterator();
    }

    private class MyIterator  implements IteratorX{

        private int i =0;
        private Node node = first;

        @Override
        public boolean hasNext() {
            if(i>=index){
                return false;
            }
            return true;
        }

        @Override
        public Object next() {
            if(i==0){
                node = first;
            }else{
                node = node.getNext();
            }
            i++;
            return node;
        }
    }
}
