package test2;
import test1.Foo;
public class Bar {
    public static void main(String[] args) {
        Foo foo = new Foo();

        System.out.println(foo.count);
        foo = new Foo();
        System.out.println(foo.count);
        foo = null;
       // System.out.println(foo.count);

        foo = new Foo();
        System.out.println(foo.count);

    }
}
