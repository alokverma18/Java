package Heaps;

import java.util.ArrayList;

public class Heap {
    ArrayList<Integer> h = new ArrayList<>();

    public void add(int n){
        h.add(n);
        int c = h.size()-1;
        int p = (c-1)/2;
        while(h.get(p)>h.get(c)){
            int t = h.get(p);
            h.set(p, h.get(c));
            h.set(c, t);

            c=p;
            p=(c-1)/2;
        }
    }

    public int peek(){
        return h.get(0);
    }

    private void heapify(int idx){
        int l = 2*idx+1;
        int r = 2*idx+2;
        int m = idx;

        if(l<h.size() && h.get(l)<h.get(idx)){
            m = l;
        }
        if(r<h.size() && h.get(r)<h.get(idx)){
            m = r;
        }
        if(idx!=m){
            int t = h.get(idx);
            h.set(idx, h.get(m));
            h.set(m, t);
            heapify(m);
        }
    }
    public int remove(){
        int t = h.get(0);
        h.set(0, h.get(h.size()-1));
        h.set(h.size()-1, t);

        h.removeLast();

        heapify(0);

        return t;
    }

    public boolean isEmpty(){
        return h.size()==0;
    }

    public void show(){
        System.out.println(h);
    }
    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        h.show();

        while(!h.isEmpty()){
            System.out.println(h.remove());
        }
        
    }
}
