package com.cleo.design_patterns.structural_design.proxy_design_pattern;

public class ProxyImage implements Image{
    private RealImage realImage;
    private final String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(realImage==null)
            realImage = new RealImage(fileName);
        realImage.display();
    }
}
