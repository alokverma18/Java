package HashSets;

import java.util.HashMap;

public class TicketItinerary {
    public static void main(String[] args) {
        HashMap<String, String> hm = new HashMap<>();
        hm.put("Chennai", "Bengaluru");
        hm.put("Mumbai", "Delhi");
        hm.put("Goa", "Chennai");
        hm.put("Delhi", "Goa");

        HashMap<String, String> hm2 = new HashMap<>();

        for(String s : hm.keySet()){
            hm2.put(hm.get(s), s);
        }

        String start = "";
        for(String s : hm.keySet()){
            if(!hm2.containsKey(s)){
                start = s;
            }
        }


        System.out.print(start);
        while(hm.containsKey(start)){
            System.out.print(" -> " + hm.get(start));
            start = hm.get(start);
        }

    }
}
