package cleo;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class StreamDemo {

    //Make concise..
    public static int stringComparator(String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1==0&&n2==0)
            return 0;
        if(n1<=0)
            return 1;
        if(n2<=0)
            return -1;
        if(s1.equals(s2))
            return 0;
        int first = s1.charAt(0),second = s2.charAt(0);
        if(first<second)
            return 1;
        else if (first==second) {
            return stringComparator(s1.substring(1),s2.substring(1));
        }else
            return -1;
    }

    public static String terminalStreamOperation(List<List<String>> list){

        //Collect
        var startsWithS = list
                .stream()
                .flatMap(List::parallelStream)
                .filter(x->x.toUpperCase().startsWith("S"))
                .toList();

        //Reduce
        String concatenated = startsWithS
                .stream()
                        .reduce("",(partialString,element)->partialString +" " + element).trim();
        return concatenated;

    }


    public static void main(String[] args) {
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("Reflection", "Collection", "Stream"),
                Arrays.asList("Structure", "State", "Flow"),
                Arrays.asList("Sorting", "Mapping", "Reduction", "Stream")
        );
        // Create a set to hold intermediate results
        Set<String> intermediateResults = new LinkedHashSet<>();
        Set<String> intermediateResults1 = new LinkedHashSet<>();
        System.out.println(listOfLists);
        var time1 = System.nanoTime();

        List<String> list = listOfLists
                .stream()

                .flatMap(List::stream)
               // .parallel()
                .map(String::toUpperCase)
                .distinct()
              //  .parallel()//5,384,875
                //without parallel 2,599,416
                .filter(x->x.toUpperCase().startsWith("S"))
              //  .sorted(StreamDemo::stringComparator)

                .peek(s->intermediateResults.add(s))

                .toList();

        var time2 = System.nanoTime();
        var list2 = listOfLists
                .stream()
                        .flatMap(List::stream)
                .parallel()
               // .distinct()
                .map(String::toUpperCase)
                                .filter(s->s.startsWith("S"))
                                        .peek(s->intermediateResults1.add(s))
                                                .toList();
        var time3 = System.nanoTime();
        System.out.println(intermediateResults);
        System.out.println(intermediateResults1);
        System.out.println(list);
        System.out.println(list2);
        System.out.println(time2-time1);
        System.out.println(time3-time2);

        System.out.println(terminalStreamOperation(listOfLists));

    }
}
