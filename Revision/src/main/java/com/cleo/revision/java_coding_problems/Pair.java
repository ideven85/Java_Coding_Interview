package com.cleo.revision.java_coding_problems;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Pair<T,U> {

    T first;
    U second;
    
    public Pair(T t, U u) {
            this.first =  t;
            this.second = u;
    }

}
