package com.cleo.revision.old.java_coding_problems.item1;

import java.util.stream.Stream;

@FunctionalInterface
public interface RecursiveCall<T> {

    RecursiveCall<T> apply();

    default boolean isComplete(){
        return false;
    }

    default T result(){
        throw new Error("Not Implemented");
    }

    default T run(){
        return Stream.iterate(this,RecursiveCall::apply)
                .filter(RecursiveCall::isComplete)
                .findFirst()
                .orElseThrow()
                .result();


    }
    static<T> RecursiveCall<T> done(T value){
        return new RecursiveCall<T>() {
            @Override
            public RecursiveCall<T> apply() {
                throw new UnsupportedOperationException();
            }
            @Override
            public boolean isComplete(){
                return true;
            }

            @Override
            public T result() {
                return value;
            }
        };
    }


}
