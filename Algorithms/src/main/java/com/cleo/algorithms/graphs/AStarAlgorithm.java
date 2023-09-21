package com.cleo.algorithms.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// TODO: 21/09/23  
public class AStarAlgorithm {


    /**
     * Shortest Path finder we can traverse up down right or left
     * @param startRow 0
     * @param startCol 1
     * @param endRow 4
     * @param endCol 3
     * @param graph [
     *   [0, 0, 0, 0, 0],
     *   [0, 1, 1, 1, 0],
     *   [0, 0, 0, 0, 0], if first column was an obstacle, our answer would be different
     *   [1, 0, 1, 1, 1],
     *   [0, 0, 0, 0, 0]
     * ] nodes containing 1 represent an obstacle
     * @return nodes with shortest length if possible else an empty array. Idea
     * is to make an educated guess to what our next node should be to come up with the shortest path
     */
    public int[][] aStarAlgorithm(int startRow, int startCol, int endRow, int endCol, int[][] graph) {
        // Write your code here.
        int rows = graph.length,columns = graph[0].length;
        List<List<Node>> nodes=new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            nodes.add(new ArrayList<>());
            for (int j = 0; j < columns; j++) {
                nodes.get(i).add(new Node(i,j,graph[i][j]));
            }
        }
        Node startNode = nodes.get(startRow).get(startCol);
        Node endNode = nodes.get(endRow).get(endCol);

        startNode.distanceFromStart=0;
        startNode.estimatedDistanceToEnd=calculateManHattanDistance(startNode,endNode);

        Queue<Node> nodesToVisit = new PriorityQueue<>();
        nodesToVisit.add(startNode);
        while(!nodesToVisit.isEmpty()){
            Node current = nodesToVisit.remove();
            if(current==endNode)
                break;
            List<Node> adjacentNodes = getAdjacentNodes(current,nodes);
            for(Node node:adjacentNodes){
                if(nodesToVisit.contains(node))
                    nodesToVisit.offer(node);
                if(node.value==1)
                    continue;
                int tentativeDistance = current.distanceFromStart+1;
                if(tentativeDistance>=node.distanceFromStart)
                    continue;
                node.nodeWhereWeCameFrom=current;
                node.distanceFromStart=tentativeDistance;
                node.estimatedDistanceToEnd=tentativeDistance+calculateManHattanDistance(node,endNode);

                if(!nodesToVisit.contains(node))
                    nodesToVisit.add(node);
                else{
                    nodesToVisit.add(node);

                }

            }
        }

        return new int[][] {};
    }

    public List<Node> getAdjacentNodes(Node currentNode,List<List<Node>> graph){
        int row = currentNode.row;
        int column = currentNode.column;
        int rows = graph.size();
        int columns = graph.size();
        List<Node> adjacent = new ArrayList<>();
        if(row<rows-1)
            adjacent.add(graph.get(row+1).get(column));
        if(row>0)
            adjacent.add(graph.get(row-1).get(column));
        if(column<columns-1)
            adjacent.add(graph.get(row).get(column+1));
        if(column>0)
            adjacent.add(graph.get(row).get(column-1));
        return adjacent;
    }

    public int calculateManHattanDistance(Node start,Node end){
        int startRow = start.row,startCol=start.column,endRow=end.row,endCol=end.column;

        return Math.abs(endRow-startRow)+Math.abs(endCol-startCol);


    }
    static class Node{
        int row,column,value;

        int distanceFromStart;
        int estimatedDistanceToEnd;
        Node nodeWhereWeCameFrom;

        // F = G + H

        public Node(int row, int column,int value) {
            this.row = row;
            this.column = column;
            this.value=value;
            distanceFromStart = Integer.MAX_VALUE;
            estimatedDistanceToEnd = Integer.MAX_VALUE;
            nodeWhereWeCameFrom=null;

        }
    }

}
