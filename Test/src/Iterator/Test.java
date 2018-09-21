package Iterator;

/**
 * Created by Star Yang on 2016/11/29.
 */
public class Test {

    public static void main(String[] args){
//        CollectionX collectionX = new ArrayListX();
        CollectionX collectionX = new LinkedListX();

        for(int i=0;i<15;i++){
            collectionX.add(i);
        }

        System.out.println(collectionX.size());

        IteratorX iteratorX = collectionX.iterator();
        while (iteratorX.hasNext()){
            System.out.println(iteratorX.next());
        }

    }
}
