package mit.reading14;

public class Subsequences {

    private static String subsequence="";
    private static int count;
    public static String generateSubsequence(String word){
        if(word.isEmpty())
            return subsequence;
        else{
            String withoutFirstLetter = generateSubsequence(word.substring(1));
            subsequence+=word.charAt(0);
            String withFirstLetter = generateSubsequence(word.substring(1));
            return withoutFirstLetter + ","+withFirstLetter;
        }
    }

    private static String subsequences(String word){
        partialSubsequence="";
        return subsequencesLouis("xy");
    }
    private static String partialSubsequence = "";
    public static String subsequencesLouis(String word) {
        System.out.println(partialSubsequence + " " + word);;
        if (word.isEmpty()) {
            // base case
            return partialSubsequence;
        } else {
            // recursive step

            String withoutFirstLetter = subsequencesLouis(word.substring(1));
            partialSubsequence += word.charAt(0);
            String withFirstLetter = subsequencesLouis(word.substring(1));
            return withoutFirstLetter + "," + withFirstLetter;
        }
    }
    public static String subsequencesV2(String word) {
        count++;
        if(word.isEmpty())
            return "";
        else {
            var first = word.charAt(0);
            var restSequences = word.substring(1);
            String subsequencesOfRest = subsequencesV2(restSequences);
            StringBuilder result = new StringBuilder();
            for (var subsequence : subsequencesOfRest.split(",", -1)) {
                result.append(",").append(subsequence);
                result.append(",").append(first).append(subsequence);
            }
            // System.out.println(result);
            return result.substring(1);
        }

    }

    public static void main(String[] args) {
//        System.out.println(subsequencesLouis("c"));
//        System.out.println(partialSubsequence);
//        System.out.println(subsequencesLouis("a"));
        //System.out.println(subsequences(""));
        System.out.println(subsequencesV2("abcdef"));
        System.out.println(count);
       // System.out.println(partialSubsequence);
    }
}
