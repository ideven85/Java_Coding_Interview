package com.cleo.revision.old.modernJava;

public class SystemProperties {
    public static void main(String[] args) {
        var properties = System.getProperties();
        var env = System.getenv();
        for(var m:env.entrySet()){
            System.out.println(m.getKey()+" ");
        }
     //   System.out.print(System.getenv().entrySet().contains("user.dir"));
        System.out.print(System.getProperties().get("user.dir")+" ");

    }
}
