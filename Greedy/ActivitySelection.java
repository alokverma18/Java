package Greedy;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {

    public static int maxActivities(int[] start, int[] end){

        //sorting
        int[][] activities = new int[start.length][3];
        for (int i = 0; i < activities.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        //sorting on the basis of 2nd column i.e end
        Arrays.sort(activities, Comparator.comparingInt(o -> o[2]));

        int count = 1;
        int lastFinish = activities[0][2];
        System.out.println("Activity : " + activities[0][0]);

        for(int i=1; i<end.length; i++){
            if(activities[i][1]>lastFinish){
                count++;
                lastFinish = activities[i][2];
                System.out.println("Activity : " + activities[i][0]);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] start = {8, 0, 3, 5, 1, 5};
        int[] end =   {9, 6, 4, 7, 2, 9};

        System.out.println("Max : " + maxActivities(start, end));
    }
}
