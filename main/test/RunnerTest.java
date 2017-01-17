import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class RunnerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    String goodProximityNumber = "4";
    String badProximityNumber = "1";


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void mainTestShouldSucceedWhenFirstSearchTermIsFirstInFile() {
        String[] args = {testTextFile(), "Armadillos", "Dogs", goodProximityNumber};
        Runner runner = new Runner();
        runner.main(args);
        assertEquals("Both words were found proximal to one another\n", outContent.toString());
    }

    @Test
    public void mainTestShouldSucceedWhenSecondSearchTermIsFirstInFile() {
        String[] args = {testTextFile(), "Dogs", "Armadillos", goodProximityNumber};
        Runner runner = new Runner();
        runner.main(args);
        assertEquals("Both words were found proximal to one another\n", outContent.toString());
    }

    @Test
    public void mainTestShouldFailWhenWordsNotInProximity() {
        String[] args = {testTextFile(), "Dogs", "Armadillos", badProximityNumber};
        Runner runner = new Runner();
        runner.main(args);
        assertEquals("The words were not found proximal to one another\n", outContent.toString());
    }

    private String testTextFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("./resources/longer_text.txt").getFile());
        return file.getAbsolutePath();
    }


    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}