import java.io.BufferedReader;
import java.io.FileNotFoundException;

public final class FileReader {
    public static BufferedReader getBufferedReaderFromFile(String filename) {
        try {
            return new BufferedReader(new java.io.FileReader(filename));
        } catch (FileNotFoundException e) {
            System.out.println("Could not read file");
            e.printStackTrace();
        }
        return null;
    }


}
