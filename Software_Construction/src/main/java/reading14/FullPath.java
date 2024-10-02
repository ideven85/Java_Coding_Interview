package reading14;

import java.io.File;

public class FullPath {

    public static String getFullPath(File file){
        if(file.getParentFile()==null)
            return file.getName();
        else
            return getFullPath(file.getParentFile())+"/"+file.getName();
    }
}
