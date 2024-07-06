package Greedy;

import java.util.ArrayList;
import java.util.Collections;

public class JobSequencing2 {

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
        int[][] jobsInfo = {{5, 200}, {3, 180}, {3, 190}, {2, 300}, {4, 120}, {2, 100}};

        ArrayList<Job> jobs = new ArrayList<>(); 

        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job((char)('A'+ i), jobsInfo[i][1], jobsInfo[i][0])); 
        }

        Collections.sort(jobs, (a, b) -> b.profit-a.profit);    //descending

        char[] sequence = new char[jobsInfo.length];
        for (int i = 0; i < sequence.length; i++) {
            sequence[i]='-';
        }

        int profit = 0;

        for (int i = 0; i < jobs.size(); i++) {
            int j = jobs.get(i).deadline-1;
            while(j>=0){
                if(sequence[j]=='-'){
                    sequence[j] = jobs.get(i).id;
                    profit+=jobs.get(i).profit;
                    break;
                }
                j--;
            }
        }
        for (int i = 0; i < sequence.length; i++) {
            System.out.print(sequence[i] + " ");
        }
        System.out.println("\nProfit : " + profit);

        
    }
}
