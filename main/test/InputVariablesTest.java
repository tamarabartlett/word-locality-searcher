import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class InputVariablesTest {


    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private String genericArgumentWarning = "Please provide four args: file.txt, first-search-word, second-search-word, number of words between search words\n";

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldSysOutInputWarningWhenGivenTooManyFields(){
        String[] args = {"filename", "word1", "word2", "3", "extraField"};
        new InputVariables(args);
        assertEquals("Too many args. " + genericArgumentWarning, outContent.toString());
    }

    @Test
    public void shouldSysOutInputWarningWhenGivenNotEnoughFields(){
        String[] args = {"filename", "word1", "word2"};
        new InputVariables(args);
        assertEquals("Too few args. " +  genericArgumentWarning, outContent.toString());
    }

    @Test
    public void shouldSysOutInputWarningWhenGivenANonNumericProximityNumber(){
        String[] args = {"filename", "word1", "word2", "notANumber"};
        new InputVariables(args);
        assertEquals("ProximityNumber must be a number. " +  genericArgumentWarning, outContent.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}