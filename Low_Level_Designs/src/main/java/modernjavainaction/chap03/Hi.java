package modernjavainaction.chap03;

import cleo.WordCount;

import java.util.Arrays;
import java.util.Objects;

public class Hi {
    private static final String FILE= Objects.requireNonNull(Hi.class.getResource("./1.txt")).getFile();

    public static void main(String[] args) {
        System.out.println(FILE);
        Arrays.stream(FILE.split(" "))
                .forEach(s -> System.out.print(s + " "));


        var sexy = Arrays.stream(FILE.split("")).filter(x->x.equalsIgnoreCase("if")).count();
        System.out.println(sexy);
    }
}
