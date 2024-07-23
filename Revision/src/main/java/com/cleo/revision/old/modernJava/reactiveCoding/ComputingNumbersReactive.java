package com.cleo.revision.old.modernJava.reactiveCoding;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class ComputingNumbersReactive {

    public static List<Integer> computeCubes(){
        List<Integer> cubes = new ArrayList<>();
        Flowable.range(1,650)
                .observeOn(Schedulers.computation())
                .map(v->v*v*v)
                .blockingSubscribe(cubes::add);
        return cubes;
    }

    public static List<Integer> computeParallelCubes() {
        List<Integer> cubes = new ArrayList<>();
        Flowable.range(1,650)
                .observeOn(Schedulers.computation())
                .flatMap(v->Flowable.just(v)
                .subscribeOn(Schedulers.computation())
                .map(w->w*w*w)
                ).doOnError(Throwable::printStackTrace)
                .doOnComplete(()-> System.out.println("Completed"))
                .blockingSubscribe(cubes::add);
        return cubes;

    }



    public static void main(String[] args) {
        var a1 = System.nanoTime();
        System.out.println(System.nanoTime());
        System.out.println(System.currentTimeMillis());
        System.out.println(computeCubes());
        var a2 = System.nanoTime();
        var a4 = a2-a1;
        System.out.println(a4);
        var a3 = System.nanoTime();
        System.out.println(computeParallelCubes());
        var a5 = System.nanoTime();
        var a6 = a5-a3;
        System.out.println("Factorial:");
        System.out.println(a6);

        System.out.println(a4-a6);
    }
}
