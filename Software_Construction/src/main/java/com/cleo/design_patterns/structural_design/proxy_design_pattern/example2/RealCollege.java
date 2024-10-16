package com.cleo.design_patterns.structural_design.proxy_design_pattern.example2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RealCollege {

    private  Map<String,Integer> db;
    private List<String> output;

    public RealCollege() {
        this.db = new HashMap<>();
        this.db=database();


        load_from_database();
    }

    /**
     *
     * @return Assuming dummy database...Fetching from database all students
     */
    private Map<String,Integer> database(){

        db.put("Deven",500);
        db.put("Anchit",1000);
        db.put("John",200);
        return db;
    }

    public void load_from_database(){
        output = new ArrayList<>();
        System.out.println("Loading from Database... Expensive Action");

        for(Map.Entry<String,Integer> student:db.entrySet()){
            if(student.getValue()>=500)
                output.add(student.getKey());
        }
        System.out.println("Number of students: " + output.size());
    }
    public void display(){
        System.out.println("Displaying Results: " + output);
    }
}
