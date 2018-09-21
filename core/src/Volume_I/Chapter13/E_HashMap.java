package Volume_I.Chapter13;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Star Yang on 2017/3/12.
 */
public class E_HashMap {
    public static void main(String[] args) {
        Map<String, Item> map = new HashMap<String, Item>();
        map.put("5464", new Item("Amy Lee", 5464));
        map.put("2546", new Item("Harry Hacker", 2546));
        map.put("7935", new Item("Gary Cooper", 7935));
        map.put("5527", new Item("Francesca Cruz", 5527));
        System.out.println(map);

        map.remove("2546");
        map.put("5527", new Item("Francesca Miller", 5527));
        System.out.println(map.get("7935"));

        for (Map.Entry<String, Item> entry : map.entrySet()) {
            String key = entry.getKey();
            Item value = entry.getValue();
            System.out.println("key = " + key + " , value = " + value);
        }
    }
}
