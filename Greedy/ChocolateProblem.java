package Greedy;

import java.util.Arrays;
import java.util.Collections;

public class ChocolateProblem {
    public static void main(String[] args) {
        
        Integer[] vertical = {4, 1, 2};
        Integer horizontal[] = {2, 1, 3, 1, 4};

        Arrays.sort(vertical, Collections.reverseOrder());
        Arrays.sort(horizontal, Collections.reverseOrder());

        int i=0, j=0, cost=0;

        while(i<vertical.length && j<horizontal.length){
            if(vertical[i]>=horizontal[j]){
                cost+=vertical[i]*(j+1);
                i++;
            } else {
                cost+=horizontal[j]*(i+1);
                j++;
            }
        }
        while(i<vertical.length){
            cost+=vertical[i]*(j+1);
            i++;
        }
        while(j<horizontal.length){
            cost+=horizontal[j]*(i+1);
            j++;
        }

        System.out.println("Total Cost : " + cost);
    }
}
