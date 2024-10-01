package com.cleo.revision.records_new;

import java.util.Optional;
import static java.util.Optional.empty;
import static java.util.Optional.of;


public record OperationsWithOptional(Optional<Integer> val1, Optional<Integer> val2) {

  public static void main(String... args) {
    Optional<Integer> first = Optional.of(1);
    Optional<Integer> second = Optional.of(2);
    OperationsWithOptional op = new OperationsWithOptional(first, second);
    System.out.println(max(op.val1(),op.val2())+" ");
    System.out.println(max(of(3), of(5)));
    System.out.println(max(empty(), of(5)));

    Optional<Integer> opt1 = of(5);
    Optional<Integer> opt2 = opt1.or(() -> of(4));
    System.out.println(max(opt1,opt2).orElse(-1)+" ");
    System.out.println(
            of(5).or(() -> of(4))
    );
  }

  public static final Optional<Integer> max(final Optional<Integer> i, final Optional<Integer> j) {
    return i.flatMap(a -> j.map(b -> Math.max(a, b)));
  }
}
