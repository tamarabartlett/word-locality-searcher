import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class RunnerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void mainTestShouldSucceedWhenFirstSearchTermIsFirstInFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("data/longer_text.txt").getFile());
        String absolutePathOfFile = file.getAbsolutePath();

        String[] args = {absolutePathOfFile, "Armadillos", "Dogs", "4"};
        Runner runner = new Runner();
        runner.main(args);
        assertEquals("Both words were found proximal to one another\n", outContent.toString());
    }

    @Test
    public void mainTestShouldSucceedWhenSecondSearchTermIsFirstInFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("data/longer_text.txt").getFile());
        String absolutePathOfFile = file.getAbsolutePath();

        String[] args = {absolutePathOfFile, "Dogs", "Armadillos", "1"};
        Runner runner = new Runner();
        runner.main(args);
        assertEquals("The words were not found proximal to one another\n", outContent.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}