package Triess;

public class ShortestUniquePrefix {

    public static class Node {
        Node children[] = new Node[26];
        boolean eow;
        int freq;

        Node(){
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
            eow = false;
            freq = 1;
        }
    }

    public static void insert(String s){
        Node curr = root;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx] = new Node();
            } else{
                curr.children[idx].freq+=1;
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    // public static boolean search(String s){
    //     Node curr = root;
    //     for (int i = 0; i < s.length(); i++) {
    //         int idx = s.charAt(i)-'a';
    //         if(curr.children[idx]==null)
    //             return false;
    //         curr = curr.children[idx];
    //     }
    //     return curr.eow;
    // }

    public static String search(String s){
        Node curr = root;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i)-'a';
            if(curr.children[idx]!=null && curr.children[idx].freq==1){
                return s.substring(0, i+1);
            }
            curr = curr.children[idx];
        }
        return s;
    }

    public static Node root = new Node();
    
    public static void main(String[] args) {

        String[] arr = {"i", "like", "a", "love", "icecream", "ice", "duck", "zebra", "dog", "dove"};

        for(String s : arr){
            insert(s);
        }

        for(String s : arr){
            System.out.println(s + " " + search(s));
        }
        
    }
}

