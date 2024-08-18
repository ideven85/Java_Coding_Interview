
import javax.annotation.Resources;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;


public class InputFile {

    public static String firstLineOfFile(InputStream path) throws IOException{
        if(path==null){
            System.out.print("Nothing Found ");
            return path.toString();
        }
        InputReader reader = new InputReader(new BufferedInputStream(path));
        return reader.next();
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
    public static String getDataFromFileC()  {
        try (var in = InputFile.class.getResourceAsStream("/resources/hi.js")) {
            System.out.print("Hi ");
            return firstLineOfFile(in);
        }catch (IOException ie){
            ie.printStackTrace();
        }finally {
            return "Hi Sexy";
        }
    }
    public static void main(String[] args) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream in = new BufferedInputStream(classloader.getResourceAsStream("resources/hi.js"));
        System.out.print(in.readAllBytes()+" ");

        System.out.print(getDataFromFileC()+" ");;

    }


}
