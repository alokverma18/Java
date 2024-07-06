package HashMaps;

import java.util.HashMap;

public class ValidAnagram {

    public static boolean anagram(String a, String s){
        if(s.length()!=a.length()){
            return false;
        }
        HashMap<Character, Integer> h1 = new HashMap<>();
        HashMap<Character, Integer> h2 = new HashMap<>();

        for(int i=0; i<a.length(); i++){
            char c = a.charAt(i);
            if(h1.containsKey(c)){
                h1.put(c, h1.get(c)+1);
            } else {
                h1.put(c, 1);
            }
        }

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            h2.put(c, h2.getOrDefault(c, 0)+1);
        }

        return h1.equals(h2);
    }
    public static void main(String[] args) {
        String a = "race";
        String s = "care";

        System.out.println(anagram(a, s));
    }
}
