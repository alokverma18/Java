package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MaxLenPairChain {
    public static void main(String[] args) {
        int[][] pairs = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};

        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));

        int count = 1;
        int last = pairs[0][1];
        System.out.println(pairs[0][0] + " " + pairs[0][1]);

        for (int i = 0; i < pairs.length; i++) {
            if(pairs[i][0]>last){
                System.out.println(pairs[i][0] + " " + pairs[i][1]);
                count++;
                last = pairs[i][1];
            }
        }
        System.out.println("Max Length of Chain : " + count);
    }
}
