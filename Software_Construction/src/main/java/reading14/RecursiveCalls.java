package reading14;

import java.io.File;
import java.nio.file.Path;
import java.util.*;

public class RecursiveCalls {
    //subsequences("abc") might return "abc,ab,bc,ac,a,b,c,".
    // Note the trailing comma preceding the empty subsequence, which is also a valid subsequence.
    public static String subsequences(String word) {
        if(word.isEmpty())
            return "";
        else {
            var first = word.charAt(0);
            var restSequences = word.substring(1);
            String subsequencesOfRest = subsequences(restSequences);
            StringBuilder result = new StringBuilder();
            for (var subsequence : subsequencesOfRest.split(",", -1)) {
                result.append(",").append(subsequence);
                result.append(",").append(first).append(subsequence);
            }
           // System.out.println(result);
            return result.substring(1);
        }

    }
    private static Map<Character,String> memo;
    public static String subsequencesAlternative(String word){
        return subsequencesHelper("",word);
    }
    public static String partial;

    private static String subsequencesHelper(String partial,String word){
        if(word.isEmpty()) {
          /*  System.out.println(memo);
          //  memo.put();
            System.out.println(partial);
            Scanner in = new Scanner(System.in);in.next();*/
            return partial;
        }
        /*if(memo.containsKey(partial))
            return ;*/
       // System.out.println(memo);
        memo.put(word.charAt(0),subsequencesHelper(partial , word.substring(1))+","
                +subsequencesHelper(partial + word.charAt(0),word.substring(1)));
       // System.out.println(memo);
//        return (subsequencesHelper(partial,word.substring(1))+","+
//                subsequencesHelper(partial+word.charAt(0),word.substring(1)));//10,284,500
        return memo.get(word.charAt(0));//9,696,833
    }

    /**
     * @param n integer to convert to string
     * @param base base for the representation. Requires 2<=base<=10.
     * @return n represented as a string of digits in the specified base, with
     *           a minus sign if n<0.  No unnecessary leading zeros are included.
     */
    public static String stringValue(int n, int base) {
        if (n < 0) {
            return "-" + stringValue(-n, base);

        } else if (n<base) {
            //return "0123456789".substring(n,n+1);
            return ""+n;

        } else {
            return stringValue(n/base, base) + "0123456789".charAt(n%base);
        }
    }

    public static String getFullPath(File file){
        if(!file.exists())
            return "File Does Not exist";
        else {
            if (file.getParentFile() == null)
                return file.getName();
            else
                return getFullPath(file.getParentFile()) + "/" + file.getName();
        }
    }
    public static int maxList(List<Integer> list){
        int max=maxListHelper(list,0,list.size()-1);
        System.out.println(list);
        return max;
    }
    public static int maxListHelper(List<Integer> list, int start, int end){
        if(start==end)
            return list.get(start);


        else if(list.get(start)==list.get(end))
            return list.get(start);
        else{



                int mid = (start+end)/2;

                return Math.max(maxListHelper(list,start,mid),maxListHelper(list,mid+1,end));
            }


    }

    public static void main(String[] args) {
        memo = new LinkedHashMap<>();
        memo.put(' ',",");
        var s1 = System.nanoTime();
        System.out.println(subsequences("1234"));
        var s2 = System.nanoTime();
       System.out.println(subsequencesAlternative("1234"));
       var s3 = System.nanoTime();
        System.out.println(s2-s1);
        System.out.println(s3-s2);
       System.out.println(memo);
        //System.out.println(memo.get());
       // Scanner in = new Scanner(System.in);
       // in.next();
        System.out.println(stringValue(-829,9));
        System.out.println(getFullPath(new File(System.getProperty("user.home")+"/hello.py")));
        System.out.println(Path.of(System.getProperty("user.dir")));
        System.out.println(System.getProperty("user.dir"));
        List<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(5);
        System.out.println(list.get(0));
       // System.out.println(list.get(1));
       // System.out.println(list.indexOf(0));
              list.add(6);
              list.add(9);
              list.add(-1);

        System.out.println(maxList(list));
    }
}
