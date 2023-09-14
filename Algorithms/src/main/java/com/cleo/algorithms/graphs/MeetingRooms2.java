package com.cleo.algorithms.graphs;

import java.util.*;
import java.util.stream.IntStream;

public class MeetingRooms2 {
    static class UnionFind{

        private final int[] root;
        private final int[] rank;

        public UnionFind(int size) {
            root = IntStream.range(0,size).toArray();
            rank=new int[size];
            Arrays.fill(rank,1);

        }

        public int find(int x){
            if(root[x]==x)
                return x;
            else return root[x]=find(root[x]);

        }
        public void union(int node1, int node2){
            int rootNode1=find(node1);
            int rootNode2=find(node2);
            if(rootNode1!=rootNode2){
                if(rank[rootNode1]<rank[rootNode2])
                    root[rootNode1]=rootNode2;
                else if(rank[rootNode1]>rank[rootNode2])
                    root[rootNode2]=rootNode1;
                else{
                    root[rootNode2]=rootNode1;
                    rank[rootNode1]+=1;
                }
            }
        }
        public boolean connected(int x, int y){
            return find(x)==find(y);
        }
    }
    static class Activity{
        int start;
        int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public Activity() {
        }
    }
    public int minMeetingRoomsV2(int[][] intervals) {
        Queue<Activity> activitySet = new PriorityQueue<>((a, b)->a.start-b.start);
        for(int[] interval:intervals){
            activitySet.add(new Activity(interval[0],interval[1]));
        }
        int rooms = 1;
        if(intervals.length==1)
            return 1;
        Activity first=activitySet.poll();
        int start=first.start;
        int end = first.end;
        List<Activity> answer = new LinkedList<>();
        while(!activitySet.isEmpty()){
            Activity current = activitySet.poll();
            if(current.start<=end) {
                end=Math.max(end,current.end);
            }else{
                answer.add(new Activity(start,end));
                start=current.start;
                end=current.end;


            }
        }
        answer.add(new Activity(start,end));

        return answer.size();

    }


    //Given an array of meeting time intervals intervals where intervals[i] = [starti, endi],
    // return the minimum number of conference rooms required.
    //
    //
    //
    //Example 1:
    //
    //Input: intervals = [[0,30],[5,10],[15,20]]
    //Output: 2
    public int minMeetingRooms(int[][] intervals) {
        int answer=0;
        int n = intervals.length;
        if(n<=1)
            return n;
        UnionFind uf = new UnionFind(n);
        int start=intervals[0][0];
        int end=intervals[0][1];
        Arrays.sort(intervals,(i,j)->Integer.compare(i[0],j[0]));

        for (int i = 1; i < n; i++) {

        }
        return 0;
    }

    public static void main(String[] args) {
        //intervals = [[0,30],[5,10],[15,20]]
        //Input: intervals = [[7,10],[2,4]]
        int[][] intervals = {{0,30},{5,10},{15,20}};
        int[][] intervals1 = {{3,5},{5,7}};
        MeetingRooms2 meetingRooms = new MeetingRooms2();
        System.out.println(meetingRooms.minMeetingRoomsV2(intervals));
        System.out.println(meetingRooms.minMeetingRoomsV2(intervals1));
    }
}