package mock;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Objects;

public class ReadingFiles {
    private static final String FILE= Objects.requireNonNull(ReadingFiles.class.getResource("./rural.txt")).getFile();

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(FILE));
        System.out.println(reader.readLine());
    }
}
