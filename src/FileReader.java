import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class FileReader {
    public static List<String> getTextStreamFromFile(String filename) {
        try {
            return createStreamFromBufferedReader(new BufferedReader(new java.io.FileReader(filename)));
        } catch (Exception e) {
            System.out.println("Could not read stream from file");
        }
        return null;
    }


    private static List<String> createStreamFromBufferedReader(BufferedReader bufferedReader) throws IOException {
        List<String> wordStream = new ArrayList<>();
        String line = bufferedReader.readLine();
        while (line != null) {
            List<String> words = Arrays.asList(line.split(" "));
            wordStream.addAll(words);
            line = bufferedReader.readLine();
        }
        return wordStream;
    }

}
