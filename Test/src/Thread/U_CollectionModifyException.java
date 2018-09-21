package Thread;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Star Yang on 2016/11/25.
 */
public class U_CollectionModifyException {

    public static void main(String[] args){
        Collection users = new CopyOnWriteArrayList();
//        Collection users = new ArrayList();

        users.add(new User("Ace",28));
        users.add(new User("Bob",32));
        users.add(new User("Candy",36));
        users.add(new User("Dave",40));

        Iterator iterator = users.iterator();
        while (iterator.hasNext()){
            System.out.print("Hello......");
            User user = (User)iterator.next();
            if("Ace".equals(user.getName())){
                System.out.println();
                users.remove(user);
            }else{
                System.out.println(user);
            }
        }
    }
}
