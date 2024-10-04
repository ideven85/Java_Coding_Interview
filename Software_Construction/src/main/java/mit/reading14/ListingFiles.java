package mit.reading14;

import java.io.File;
import java.util.*;

public class ListingFiles {
    private static int count;
    /**
     * Finds files or folders whose names start with pattern,
     * searching recursively from a root file or folder.
     * @param file a file in the filesystem
     * @param pattern pattern to look for
     * @param resultSet all matching files found are added to this set
     */
    public static Set<File> visitNode(File file, String pattern,Set<File> resultSet ) {

        if(!file.exists())
            return resultSet;

        if(file.getName().startsWith(pattern)) {
            resultSet.add(file);
            count++;
        }
         if (file.isDirectory()) {

            visitChildren(Objects.requireNonNull(file.listFiles()),pattern,resultSet);
        }
         return resultSet;
    }

    /**
     * Finds files or folders whose names start with pattern,
     * searching recursively from a list of root files or folders.
     * @param files a list of files
     * @param pattern pattern to look for
     * @param resultSet all matching files found are added to this set
     */
    public static void visitChildren(File[] files,String pattern,Set<File> resultSet) {
        for (File file : files) {


            visitNode(file,pattern,resultSet);
        }
    }


    public static void main(String[] args) {

        System.out.println(visitNode(new File("."),"F",new HashSet<>()));
        System.out.println(count);
    }
}
