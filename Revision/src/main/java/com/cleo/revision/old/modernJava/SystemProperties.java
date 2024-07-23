package com.cleo.revision.old.modernJava;

public class SystemProperties {
    public static void main(String[] args) {
        var properties = System.getProperties();
        for(var property:properties.entrySet()){
            System.out.println(property.getKey()+":"+property.getValue());
        }
    }
}
