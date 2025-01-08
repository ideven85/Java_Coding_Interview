package mit.reading3;

public class Gcd {
    public static int gcd(int a, int b) {
        if (a > b) {
            return gcd(a-b, b);
        } else if (b > a) {
            return gcd(a, b-a);
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(gcd(-1,-1));
    }
}
