package mit.reading14;

import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
//Must See
//todo
public class FilesWithImmutabiity {
    /**
     * The implementations of both functions accumulate their results by mutating a mutable Set whose scope is limited to that function alone. This requires a mutable resultSet in (A). Both Collections.unmodifiableSet and Set.of would return immutable sets.
     *
     * In (B), the recursive call has just returned a set of results, and we add all of those results to our current result set.
     *
     * And in (C), we have the opportunity to defend against mutability bugs by wrapping resultSet in an immutable wrapper. Once the function returns, that wrapper will have the only reference to the original mutable resultSet, preventing any future mutation. When we write the specs for visitNode/visitChildren, we can choose whether to guarantee immutability of the returned sets as part of the specs.
     *
     */
    public static Set<File> visitNode(File file, String pattern) {
        Set<File> resultSet =new HashSet<>(); //A
        if (file.getName().startsWith(pattern)) { resultSet.add(file); }
        if (file.isDirectory()) {
            resultSet.addAll(visitChildren(Objects.requireNonNull(file.listFiles()), pattern));//B
        }
        return Collections.unmodifiableSet(resultSet);//C
    }

    public static Set<File> visitChildren(File[] files, String pattern) {
        Set<File> resultSet = new HashSet<>();
        for (File file : files) {
            resultSet.addAll(visitNode(file,pattern));
        }
        return Collections.unmodifiableSet(resultSet);
    }

    public static void main(String[] args) {
        System.out.println(visitNode(new File("."),"A"));
    }

}
