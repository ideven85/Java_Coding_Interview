package com.cleo.design_patterns.structural_design.proxy_design_pattern;


//Real Object.. Proxy  will protect this resource
public class RealImage implements Image{

    private final String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadImageFromDisk();
    }
    private void loadImageFromDisk(){
        System.out.println("Loading Image: " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying Image: " + fileName);
    }
}
