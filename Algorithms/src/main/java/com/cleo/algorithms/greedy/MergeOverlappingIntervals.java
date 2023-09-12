package com.cleo.algorithms.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingIntervals {
    static class Activity{
        int start_time;
        int finish_time;

        public Activity(int start_time, int finish_time) {
            this.start_time = start_time;
            this.finish_time = finish_time;
        }

        @Override
        public String toString() {
            return this.start_time+" "+this.finish_time;
        }
    }
    static class ActivityComparator implements Comparator<Activity>{
        @Override
        public int compare(Activity o1, Activity o2) {
            return o1.finish_time-o2.start_time;
        }
    }
    public static int[][] merge(int[][] intervals) {
        List<Activity> activities = new ArrayList<>();
        for(int[] interval:intervals){
            int startTime=interval[0];
            int finishTime=interval[1];
            activities.add(new Activity(startTime,finishTime));
        }
        activities.sort(new ActivityComparator());
        System.out.println(activities);
        int[][] answer = new int[activities.size()][];
        //int current=0;
        int prev=0;
        for (int i = 0; i < activities.size(); i++) {


            Activity current=activities.get(i);
            Activity previous = activities.get(prev);
            if(current.finish_time>=previous.start_time) {
                answer[prev] = new int[]{previous.start_time, current.finish_time};
                prev=i;
            }

        }
        return answer;




    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        intervals=merge(intervals);
        for(var interval:intervals)
            System.out.println(Arrays.toString(interval));
    }
}
