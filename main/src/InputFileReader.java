import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class InputFileReader {
    public static List<String> getTextStreamFromFile(String filename) {
        try {
            List<String> streamFromBufferedReader = createStreamFromBufferedReader(new BufferedReader(new FileReader(filename)));
            return removeCapitalizationAndPunctuation(streamFromBufferedReader);
        } catch (Exception e) {
            System.out.println("Could not read stream from file");
        }
        return null;
    }

    private static List<String> removeCapitalizationAndPunctuation(List<String> streamFromBufferedReader) {
        return streamFromBufferedReader
                .stream()
                .map(word -> word
                        .toLowerCase()
                        .replaceAll("[^a-z]", ""))
                .collect(Collectors.toList());
    }

    private static List<String> createStreamFromBufferedReader(BufferedReader bufferedReader) throws IOException {
        return bufferedReader
                .lines()
                .map(line -> Arrays.asList(line.split(" ")))
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());
    }
}
