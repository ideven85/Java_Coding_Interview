package mit.reading3;

public class ReverseString {
    /**
     * Reverses the end of a string.
     * <p>
     * 012345                     012345
     * For example: reverseEnd("Hello, world", 5) returns "Hellodlrow ,"
     * <----->                    <----->
     * <p>
     * With start == 0, reverses the entire text.
     * With start == text.length(), reverses nothing.
     *
     * @param text  string that will have its end reversed
     * @param start the index at which the remainder of the input is reversed,
     *              requires 0 <= start <= text.length()
     * @return input text with the substring from start to the end of the string reversed
     */
    public static String reverseEnd(String text, int start){
        if(text.isEmpty())
            return text;
        int n = text.length();
        int to_reverse=n-start-1;
        StringBuilder sb = new StringBuilder(text.substring(start));
        sb=sb.reverse();
//        System.out.println(sb);
//        System.out.println(text.substring(0,start));

       // System.out.println(text.substring(to_reverse));
        return text.substring(0,start)+sb;


    }

    public static void main(String[] args) {
        System.out.println(reverseEnd("Hello, world", 6));
    }
}
