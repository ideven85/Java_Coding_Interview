package com.cleo.LowLevelDesign.DesignPatterns.AdapterDesignPattern.Client;

import com.cleo.LowLevelDesign.DesignPatterns.AdapterDesignPattern.Adaptee.WeightMachineForBabies;
import com.cleo.LowLevelDesign.DesignPatterns.AdapterDesignPattern.Adapter.WeightMachineAdapter;
import com.cleo.LowLevelDesign.DesignPatterns.AdapterDesignPattern.Adapter.WeightMachineAdapterImpl;

public class Main {

    public static void main(String args[]){

        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
        System.out.println(weightMachineAdapter.getWeightInKg());
    }
}
