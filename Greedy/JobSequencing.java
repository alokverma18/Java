package Greedy;

import java.util.ArrayList;
import java.util.Collections;

public class JobSequencing {

    public static class Job{
        char id;
        int profit;
        int deadline;

        Job(char id, int profit, int deadline){
            this.id = id;
            this.profit = profit;
            this.deadline = deadline;
        }
    }

    public static void main(String[] args) {
        int[][] jobsInfo = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};

        ArrayList<Job> jobs = new ArrayList<>(); 

        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job((char)('A'+ i), jobsInfo[i][1], jobsInfo[i][0])); 
        }

        Collections.sort(jobs, (a, b) -> b.profit-a.profit);    //descending

        int time = 0;
        int profit = 0;

        for (int i = 0; i < jobs.size(); i++) {
            if(time<jobs.get(i).deadline){
                profit+=jobs.get(i).profit;
                System.out.println(jobs.get(i).id);
                time++;
            }
        }
        System.out.println("Profit : " + profit);

        
    }
}

// doesn't work, consider jobsInfo = {{5, 200}, {3, 180}, {3, 190}, {2, 300}, {4, 120}, {2, 100}}, ans is 2, 4, 3, 5, 1 profit=990