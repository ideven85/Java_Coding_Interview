package com.cleo.dataStructures;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Activity{
    int start;
    int finish;

    public Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

class ActivityComparator implements Comparator<Activity>{
    @Override
    public int compare(Activity first, Activity second) {
        return first.finish - second.start;
    }
}


class ActivitySelectionProblem{


    /**
     *
     * 2 pointer approach to solve the activity selection problem
     *
     */
    static int maximumActivities(Activity[] activities, int n){

        Arrays.sort(activities, new ActivityComparator());
        int res=1;
        int prev=0;
        int start=activities[0].start;
        int finish=activities[0].finish;
        //System.out.println(n);
        List<Activity> result = new LinkedList<>();
        for(Activity activity:activities){
            if(activity.start<=finish)
                finish=Math.max(finish, activity.finish);
            else{
               result.add(new Activity(start,finish));
                start=activity.start;
                finish=activity.finish;
                res++;
            }
        }
        result.add(new Activity(start,finish));
        return result.size();
    }
    public static int activitySelection(int start[], int end[], int n)
    {
      //  System.out.println(n);
        // add your code here
        Activity[] activities = new Activity[n];
        for (int i = 0; i < n; i++) {
            activities[i]=new Activity(start[i],end[i]);
        }
        return maximumActivities(activities,n);
    }

    public static void main(String[] args) {
//intervals = [[0,30],[5,10],[15,20]]
        int[] start={5,3};
        int[] end={7,5};

       Activity[] activities = {new Activity(0,30),new Activity(5,10),new Activity(15,20)};
       Activity[] meetingRoooms ={new Activity(7,10),new Activity(2,4)};
        System.out.println((maximumActivities(activities,activities.length)));
        System.out.println(activitySelection(start,end,2));
        System.out.println(maximumActivities(meetingRoooms, meetingRoooms.length));
    }
}


/**
 * Fractional Knapsack, we can take values wholely or partially
 * We need to find the maximum value we can take with a given maximum weight
 */
class FractionalKnapSackProblem{

    private static class Item {
        int weight;int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }


    }

    private static class ItemComparator implements Comparator<Item>{
        @Override
        public int compare(Item o, Item o2) {
            return o2.weight/(o2.value)-(o.weight)/(o.value);
        }
    }

    public static double maximumValue(Item Items[], int W) {
        Arrays.sort(Items, new ItemComparator());
        int weights = 0, max_value = 0;
        int prev = 0;
        double max=0.0;

        for (int i = 0; i < Items.length; i++) {

            if(Items[i].weight<=W){
                max=max+Items[i].value;
                W-=Items[i].weight;
               // System.out.println(max);
            }else{
                max = max + (double)(Items[i].weight)*(double) W/(double) Items[i].value;
                break;
            }

        }
        return max;
    }


    public static void main(String[] args) {
        int[] values = {60,100,20};
        int[] weights = {10,20,30};
        Item[] Items = {new Item(10,60),new Item(20,100),new Item(30,20)};
        //Arrays.stream(Items).forEach(n->System.out.print(n.weight + " " ));
        System.out.println(maximumValue(Items,50));
    }
}

public class GreedyAlgorithms {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }

}
