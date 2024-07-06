package HashMaps;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Maps {
    
    public static void main(String[] args) {

        // HashMap - Unordered - O(1)
        
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("Swayam", 22);
        hm.put("Raghav", 15);
        hm.put("Vikas", 11);
        hm.put("Balram", 18);

        System.out.println(hm);

        System.out.println(hm.get("Vikas"));

        hm.remove("Swayam");
        System.out.println(hm);

        System.out.println(hm.keySet());
        System.out.println(hm.entrySet());


        System.out.println();

        //LinkedHashMap - Ordered - O(1)

        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("Swayam", 22);
        lhm.put("Raghav", 15);
        lhm.put("Vikas", 11);
        lhm.put("Balram", 18);
        System.out.println(lhm);

        System.out.println();

        //TreeMap - Sorted -  O(log N)

        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("Swayam", 22);
        tm.put("Raghav", 15);
        tm.put("Vikas", 11);
        tm.put("Balram", 18);
        System.out.println(tm);


    }
}
