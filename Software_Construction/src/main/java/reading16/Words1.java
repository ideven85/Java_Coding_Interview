package reading16;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Words1 {
    private static int count;
    /**
     * Find all files in the folder at this parent folder
     * Store them in an arraylist
     */
    public static List<File> allFilesInFolderV1(File folder) {
        List<File> files = new ArrayList<>();

//            return files;

        for (File f : Objects.requireNonNull(folder.listFiles())) {
            if (f.isFile())
                files.add(f.getAbsoluteFile());
            else if (f.isDirectory()) {
                files.addAll(allFilesInFolderV1(f));
            }
            count++;
         /* return  switch(f){
              case File x:x.isFile() > files.add(x);
                case (f.isDirectory())->files.addAll(listFilesInFolder(f));
                default -> System.out.println(f);
*/


        }
        return files;

    }

    /**
     *
     * @param folder  files return by above method
     * @param suffix filtering the ones matching the given suffix
     * @return Returning the result
     */
    public static List<File> listFilesWithGivenSuffix(File folder,String suffix){
        List<File> f = allFilesInFolderV1(folder),result = new ArrayList<>();
        for(File file:f)
            if(file.getName().endsWith(suffix))
                result.add(file);

        return result;
    }

    public static void main(String[] args) {
       // System.out.println(listFilesInFolderV1(new File(System.getProperty("user.dir"))));
        //System.out.println(listFilesInFolderV1(new File(".")));
        System.out.println(Paths.get(new File(".").getAbsoluteFile().toString()));
        System.out.println(listFilesWithGivenSuffix(new File("."),"java"));
        System.out.println(Objects.requireNonNull(Words1.class.getResource("./1.txt")).getFile());
        System.out.println(count);

    }

}
