package ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class PairSumInSorted {

    public static void pairSum(ArrayList<Integer> list, int target){
        int l = 0;
        int r = list.size()-1;

        while(l!=r){
            if(list.get(l)+ list.get(r)==target){
                System.out.println(list.get(l) + " " + list.get(r));
                return;
            } else if(list.get(l)+list.get(r)<target){
                l++;
            } else {
                r--;
            }
        }
        System.out.println("No such Pair");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements : ");
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        System.out.print("Enter elements : ");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        System.out.print("Enter target : ");
        int target = sc.nextInt();

        pairSum(list, target);
        sc.close(); 
    }
}
