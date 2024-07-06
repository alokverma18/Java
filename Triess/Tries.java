package Triess;

public class Tries {

    public static class Node {
        Node children[] = new Node[26];
        boolean eow;

        Node(){
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
            eow = false;
        }
    }

    public static void insert(String s){
        Node curr = root;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static boolean search(String s){
        Node curr = root;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i)-'a';
            if(curr.children[idx]==null)
                return false;
            curr = curr.children[idx];
        }
        return curr.eow;
    }

    public static boolean wordBreak(String s){
        if(s.length()==0){
            return true;
        }

        for (int i = 1; i <= s.length(); i++) {
            if(search(s.substring(0, i)) && wordBreak(s.substring(i))){
                return true;
            }
        }
        return false;
    }

    public static Node root = new Node();
    
    public static void main(String[] args) {
        // String[] words = {"the", "a", "their", "any", "thee"};

        // for(String s : words){
        //     insert(s);
        // }

        //System.out.println(search("anya"));

        String[] arr = {"i", "like", "a", "cricket", "tea", "music"};
        for(String s : arr){
            insert(s);
        }

        System.out.println(wordBreak("likeatea"));
    }
}
