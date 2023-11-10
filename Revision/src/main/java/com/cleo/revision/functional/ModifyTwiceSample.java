package com.cleo.revision.functional;

@FunctionalInterface
public interface ModifyTwiceSample {
    int modify(int x);
    default int modifyTwice(int x){
        return modify(modify(x));
    }
}
