package Greedy;

public class ActivitySelectionSorted {

    public static int maxActivities(int[] start, int[] end){
        int count = 1;
        int lastFinish = end[0];
        System.out.println("Activity : " + 0);

        for(int i=1; i<end.length; i++){
            if(start[i]>lastFinish){
                count++;
                lastFinish = end[i];
                System.out.println("Activity : " + i);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};

        System.out.println("Max : " + maxActivities(start, end));
    }
}
