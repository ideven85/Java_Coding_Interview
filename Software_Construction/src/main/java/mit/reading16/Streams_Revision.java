package mit.reading16;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streams_Revision {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1","2","3");
        String[] strings = {"1","2","3"};
        var stream = Stream.of(list);
        var stringStream = Stream.concat(stream, Arrays.stream(strings).toList().stream());
        System.out.println(Arrays.toString(stringStream.toArray()));
        double a=7,b=0;
        int x=7;
        int b1;
        double f=212.0;
        double c=(f-32)*5/9;
        System.out.println(c);
        String s="a";StringBuilder tb = new StringBuilder(s);
        f(s,tb);

        System.out.println(tb);
    }
   static void f(String s, StringBuilder sb){
        s.concat("b");
        s+="c";
        sb.append("d");
    }
}
