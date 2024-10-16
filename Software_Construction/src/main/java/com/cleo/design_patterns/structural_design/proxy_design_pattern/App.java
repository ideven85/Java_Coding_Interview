package com.cleo.design_patterns.structural_design.proxy_design_pattern;

public class App {

    public static void main(String[] args) {
        Image image = new ProxyImage("example.jpg");

        image.display();//Once the image has been called... we will not create another object of RealImage...It's cached

        image.display();//Same Image is loaded

    }
}
