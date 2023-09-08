package com.cleo.algorithms.graphs;

import java.util.*;

// TODO: 29/08/23 "Incorrect Algorithm" 
public class MinConnectionsToConnectAllAirPorts {

    private final Map<String, List<String>> visitedMap = new LinkedHashMap<>();
    static List<String> result = null;

    public  int airportConnections(
            List<String> airports, List<List<String>> routes, String startingAirport) {
        // Write your code here.
        int V = airports.size();
        for(var route: routes){
            String origin = route.get(0);
            String destination = route.get(1);
            List<String> destinationList;
            if(visitedMap.containsKey(origin)){
                destinationList = visitedMap.get(origin);
                destinationList.add(destination);
            }else{
                destinationList = new LinkedList<>();
                destinationList.add(destination);
                visitedMap.put(origin,destinationList);
            }





        }
        visitedMap.forEach((key, value) -> value.stream().count());
        for(Map.Entry<String,List<String>> map:visitedMap.entrySet()){
            System.out.println(map.getKey()+":"+map.getValue());
        }
        result= new ArrayList<>();

        dfs(startingAirport);
        System.out.println(result);
        return result.size();
    }
    protected  void dfs(String origin) {
        // Visit all the outgoing edges first.
        if (visitedMap.containsKey(origin)) {
            List<String> destList = visitedMap.get(origin);
            for (int i = 0; i < destList.size(); i++) {
                String destination = destList.remove(i);
                dfs(destination);
            }
        }
        // add the airport to the head of the itinerary
        result.add(origin);
    }
        public static void main(String[] args){
            List<String> airports = Arrays.asList("BGI", "CDG", "DEL", "DOH", "DSM", "EWR", "EYW", "HND", "ICN", "JFK", "LGA", "LHR", "ORD", "SAN", "SFO", "SIN", "TLV", "BUD");
            List<List<String>> routes = List.of(
                    List.of("DSM", "ORD"),
                    List.of("ORD", "BGI"),
                    List.of("BGI", "LGA"),
                    List.of("SIN", "CDG"),
                    List.of("CDG", "SIN"),
                    List.of("CDG", "BUD"),
                    List.of("DEL", "DOH"),
                    List.of("DEL", "CDG"),
                    List.of("TLV", "DEL"),
                    List.of("EWR", "HND"),
                    List.of("HND", "ICN"),
                    List.of("HND", "JFK"),
                    List.of("ICN", "JFK"),
                    List.of("JFK", "LGA"),
                    List.of("EYW", "LHR"),
                    List.of("LHR", "SFO"),
                    List.of("SFO", "SAN"),
                    List.of("SFO", "DSM"),
                    List.of("SAN", "EYW")
            );
            MinConnectionsToConnectAllAirPorts allAirPorts = new MinConnectionsToConnectAllAirPorts();
            System.out.println(allAirPorts.airportConnections(airports,routes,"LGA"));
        }
    }


