package telusko.util;

import telusko.util.internal.AddHelper;

public class Calculator {

    AddHelper helper = new AddHelper();

    public int add(int i, int j){
        return helper.add(i,j);
    }
    public int add(double i, double j){
        return helper.add((int)i, (int)j);
    }
}
