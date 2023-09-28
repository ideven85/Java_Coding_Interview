package modernjavainaction.chap07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Spliterator;
import java.util.StringTokenizer;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class WordCount {

  public static final String SENTENCE =
      " Nel   mezzo del cammin  di nostra  vita "
      + "mi  ritrovai in una  selva oscura"
      + " che la  dritta via era   smarrita ";

  private static String FILE=WordCount.class.getResource("./rural.txt").getFile();
  public static void main(String[] args) {

    System.out.println("Found " + countWordsIteratively(SENTENCE) + " words");
    System.out.println("Found " + countWords(SENTENCE) + " words");
  }

  public static int countWordsIteratively(String s) {
    int counter = 0;
    boolean lastSpace = true;
    for (char c : s.toCharArray()) {
      if (Character.isWhitespace(c)) {
        lastSpace = true;
      }
      else {
        if (lastSpace) {
          counter++;
        }
        lastSpace = Character.isWhitespace(c);
      }
    }
    return counter;
  }

  public static int countWords(String s) {
    //Stream<Character> stream = IntStream.range(0, s.length())
    //    .mapToObj(SENTENCE::charAt).parallel();
    Spliterator<Character> spliterator = new WordCounterSpliterator(s);
    Stream<Character> stream = StreamSupport.stream(spliterator, true);

    return countWords(stream);
  }

  private static int countWords(Stream<Character> stream) {
    WordCounter wordCounter = stream.reduce(new WordCounter(0, true),
            WordCounter::accumulate, WordCounter::combine);
    return wordCounter.getCounter();
  }

  private static class WordCounter {

    private final int counter;
    private final boolean lastSpace;

    public WordCounter(int counter, boolean lastSpace) {
      this.counter = counter;
      this.lastSpace = lastSpace;
    }

    public WordCounter accumulate(Character c) {
      if (Character.isWhitespace(c)) {
        return lastSpace ? this : new WordCounter(counter, true);
      }
      else {
        return lastSpace ? new WordCounter(counter + 1, false) : this;
      }
    }

    public WordCounter combine(WordCounter wordCounter) {
      return new WordCounter(counter + wordCounter.counter, wordCounter.lastSpace);
    }

    public int getCounter() {
      return counter;
    }

  }

  private static class WordCounterSpliterator implements Spliterator<Character> {

    private final String string;
    private int currentChar = 0;

    private WordCounterSpliterator(String string) {
      this.string = string;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
      action.accept(string.charAt(currentChar++));
      return currentChar < string.length();
    }

    @Override
    public Spliterator<Character> trySplit() {
      int currentSize = string.length() - currentChar;
      if (currentSize < 10) {
        return null;
      }
      for (int splitPos = currentSize / 2 + currentChar; splitPos < string.length(); splitPos++) {
        if (Character.isWhitespace(string.charAt(splitPos))) {
          Spliterator<Character> spliterator = new WordCounterSpliterator(string.substring(currentChar, splitPos));
          currentChar = splitPos;
          return spliterator;
        }
      }
      return null;
    }

    @Override
    public long estimateSize() {
      return string.length() - currentChar;
    }

    @Override
    public int characteristics() {
      return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
    }

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
}
