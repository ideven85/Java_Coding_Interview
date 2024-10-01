package com.cleo.revision.innerClasses;

public class Parcel {
    record Contents(int i){ }

    record Destination(String destination){

        public String readDestination(){
            return   destination;
        }

       public Destination {
        }
    }
    public Contents contents = new Contents(0);
    public Destination to = new Destination("Tasmania");
    public void ship(String destination){
        Contents c =  contents;
        String  d = to.readDestination();
        System.out.println("Shipping from:" + d);
        Destination dest = new Destination(destination);
        System.out.println("Going to: "+dest.readDestination());

    }

    public static void main(String[] args) {
        Parcel p = new Parcel();
        p.ship("Tasmania");
    }
}
