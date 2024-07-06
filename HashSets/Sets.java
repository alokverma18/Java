package HashSets;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Sets {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("Raghav");
        set.add("Balram");
        set.add("Vikas");
        set.add("Swayam");
        set.add("Balram");

        System.out.println(set);

        set.remove("Swayam");
        System.out.println(set);

        System.out.println(set.contains("Swayam"));


        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Raghav");
        lhs.add("Balram");
        lhs.add("Vikas");
        lhs.add("Raghav");

        System.out.println(lhs);


        TreeSet<String> ts = new TreeSet<>();
        ts.add("Raghav");
        ts.add("Balram");
        ts.add("Vikas");
        ts.add("Vikas");

        System.out.println(ts);

    }
}
