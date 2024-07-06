package ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class PairSumInRotatedSorted {

    public static int findPivot(ArrayList<Integer> list){
        for (int i = 0; i < list.size()-1; i++) {
            if(list.get(i)>list.get(i+1)){
                return i+1;
            }
        }
        return 0;
    }

    public static void pairSum(ArrayList<Integer> list, int target){
        int l = findPivot(list);
        int r = l-1;
        
        while(l!=r){
            if(list.get(l)+list.get(r)==target){
                System.out.println(list.get(l) + " " + list.get(r));
                return;
            } else if(list.get(l)+list.get(r)<target){
                l = (l+1)%list.size();
            } else {
                r = (list.size()+r-1)%list.size();
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
