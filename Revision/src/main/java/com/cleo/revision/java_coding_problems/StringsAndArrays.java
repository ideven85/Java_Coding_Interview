package com.cleo.revision.java_coding_problems;


import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.util.Map.Entry.comparingByValue;

public class StringsAndArrays {

    public long factorial(int n){
        return n<2?1:n*factorial(n-1);
    }

    public long factorialV2(int n){
        return LongStream.rangeClosed(1,n).reduce(1,(a,b)->a*b);
    }
    public boolean isUnique(String str){
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(char c: str.toCharArray()){
            if(c==' ' || map.get(c)==null)
                map.put(c,1);
            else{
                return false;
            }
        }

        return true;
    }

    public char[] firstNonRepeatedCharacter(String str){
     /*   char min = 'Z';boolean flag = false;
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(char c: str.toCharArray()){
            if(map.get(c)==null&&c!=' '){
                if(!flag) {
                    min = c;
                    flag=true;
                }
                map.put(c,1);
            }else{
                if(min==c)
                    flag=false;
                map.put(c,map.get(c)+1);
            }
        }
        return min;

*/        return Character.toChars(str.codePoints()
                .boxed()
                .collect(
                        Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()))
                .entrySet()
                .stream()
                .filter(c->c.getValue()==1L)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse((int) Character.MIN_VALUE)
        );



    }


    public String reverseWords(String str){
        var strings = str.split(" ");
        StringBuilder sb = new StringBuilder();
        if(strings.length==1){
            return sb.append(str).reverse().toString();
        }
        /**
         * Version 1 Basic
         */
        for (int i = 0; i < strings.length; i++) {
            sb = new StringBuilder(strings[i]);
            strings[i]=sb.reverse().toString();
        }
        for (int i = 0; i < strings.length/2; i++) {
            String temp = strings[i];
            strings[i]=strings[ strings.length-i-1];
            strings[strings.length-1]=temp;
        }
      //  System.out.println(Arrays.toString(strings));
        /*Arrays.stream(strings)
                .forEach(c->sb.append(c).reverse());
        System.out.println(Arrays.toString(strings));

         */
        /**
         * Java 8 functional style
         */
        final Pattern PATTERN = Pattern.compile(" +");

        String s = PATTERN.splitAsStream(str)
                .map(w->new StringBuilder(w).reverse()+ " ")
                .collect(Collectors.joining());
        System.out.println(s);

        String s2 = new StringBuilder(str).reverse().toString();
        System.out.println(s2);


        return Arrays.toString(strings);

    }

    public boolean containsOnlyCharacters(String str){
        return str.chars()
                .noneMatch(Character::isDigit);
    }

    public static int[] vowelsAndConsonants(String str){
        str = str.toLowerCase();
       //V1
        Set<Character> vowels = new HashSet<>(List.of('a','e','i','o','u'));
        int[] answer = new int[2];
        for(char c:str.toCharArray()){
            if(vowels.contains(c))
                answer[0]++;
            else if(c>'a'&&c<='z')
                answer[1]++;
        }
        //Functional Style

        long v = str.chars()
                .filter(c->vowels.contains((char)c))
                .count();
        long consonants = str.chars()
                .filter(c->!vowels.contains((char)c))
                .filter(c->c>'a'&&c<='z')
                .count();
        System.out.println(v+ " " + consonants);

        //Shortest way

        return answer;
    }

    public static boolean isPalindrome(String str){
        return
                IntStream.range(0,str.length()/2)
                        .noneMatch(i -> str.charAt(i)!=str.charAt(str.length()-i-1));
    }

    public static String uniqueCharacters(String str){

        return Arrays.stream(str.split("")).distinct()
                .collect(Collectors.joining())
                ;
    }

    public static String removeCharacter(String str, char ch){
        String s = str.replace(String.valueOf(ch),"");
        System.out.println("After removing character: "+s);
        return str.chars()
                .filter(c->c!=ch)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }

    public static  char characterWithMostAppearances(String str){
        //Normal way
        Map<Character,Integer> map = new HashMap<>();
        int count = 0;char max='a';
        for(char c: str.toCharArray()){
                if(map.get(c)==null){
                    map.put(c,1);
                    if(count<=1)
                        count=1;
                }else{
                    int value = map.get(c);
                    map.put(c,++value);
                    if(count<value) {
                        count = value;
                        max=c;
                    }
                }
        }


        //V2
      return  str.chars()
                .filter(c-> !Character.isWhitespace(c))
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(c->c,Collectors.counting()))
                .entrySet()
                .stream()
                .max(comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(Character.MIN_VALUE);


      //  return max;
    }

    public static void allPermutations(String str){
        int n = str.length();

        generatePermutations("", str);
    }
    public static void generatePermutations(String prefix, String str){
        int n = str.length();
        if(n==0)
            System.out.print(prefix+"\t");


        for (int i = 0; i < n; i++) {
            generatePermutations(prefix+str.charAt(i),str.substring(i+1,n)+str.substring(0,i));
        }

    }

    public static String removeDuplicates(String str){
        StringBuilder sb = new StringBuilder();
        for(char c: str.toCharArray()){
            if(sb.indexOf(String.valueOf(c))==-1)
                sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "Deven Kalra";
        StringsAndArrays stringsAndArrays = new StringsAndArrays();
        System.out.println(stringsAndArrays.isUnique("Deven Kalra"));
        System.out.println(stringsAndArrays.firstNonRepeatedCharacter("DevenD Kalra"));
        System.out.println(stringsAndArrays.reverseWords("Deven Kalra"));
        System.out.println(stringsAndArrays.containsOnlyCharacters("Deven1"));
        Function<String,String> hello = name -> "Hello " + name;
        System.out.println(hello.apply("Deven"));
        System.out.println(Arrays.toString(vowelsAndConsonants(str)));
        System.out.println(uniqueCharacters(str));
        System.out.println(removeCharacter(str,'e'));
        System.out.println(characterWithMostAppearances(str));
        allPermutations("abc");
        System.out.println();
        System.out.println(removeDuplicates(str));
        //System.out.println(System.currentTimeMillis()+ " " + System.nanoTime());
        var a= System.nanoTime();
        stringsAndArrays.factorial(10);
        var b= System.nanoTime();
        stringsAndArrays.factorialV2(10);
        var c = System.nanoTime();
        System.out.println((b-a) + " " + (c-b));

    }

}
