package com.cleo.design_patterns.structural_design.proxy_design_pattern.example2;

import java.util.List;

public class ProxyObject {
    private RealCollege realCollege;

    public void  display(){
        if(realCollege==null){
            realCollege = new RealCollege();

        }
        realCollege.display();
    }
}
