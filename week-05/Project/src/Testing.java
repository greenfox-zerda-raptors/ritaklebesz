import com.greenfox.ritaklebesz.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Rita on 2016-11-17.
 */
public class Testing {
    public static void main(String[] args) {
        Item item1 = new Item(1, true, "item1 done");
        Item item2 = new Item(2, false, "item2 to do");
        Item item3 = new Item(3, true, "item3 done");
        ArrayList<Item> list = new ArrayList<>();
        list.add(item1);
        list.add(item2);
        list.add(item3);

        System.out.println(item1.toString());
        System.out.println(item2.toString());
        System.out.println(item3.toString());
        Collections.sort(list, Item.CompareByState);
        System.out.println(list.toString());


    }
}
