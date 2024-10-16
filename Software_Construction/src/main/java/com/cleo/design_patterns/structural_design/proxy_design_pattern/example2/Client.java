package com.cleo.design_patterns.structural_design.proxy_design_pattern.example2;

public class Client {

    public static void main(String[] args) {
        ProxyObject college = new ProxyObject();
        college.display();//First

        college.display();//Second
    }
}
