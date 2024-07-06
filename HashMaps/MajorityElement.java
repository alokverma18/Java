package HashMaps;

import java.util.HashMap;

public class MajorityElement {
    
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 3, 1, 5, 1, 2};
        int k = arr.length/3;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i: arr){
            if(hm.containsKey(i)){
                hm.put(i, hm.get(i)+1);
            } else {
                hm.put(i, 1);
            }
        }
        System.out.println(hm);

        for(int i: hm.keySet()){
            if(hm.get(i)>k){
                System.out.println(i);
            }
        }


    }
}
