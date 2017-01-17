import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnit4.class)
public class InputFileReaderTest {

    @Test
    public void shouldReturnBufferedReaderFromFile() throws IOException {
        List<String> textStreamFromFile = InputFileReader.getTextStreamFromFile("./resources/test.txt");
        assertThat(textStreamFromFile, is(notNullValue()));
        assertThat(textStreamFromFile.get(0), is("derp"));
    }

    @Test
    public void shouldCatchErrorWhenFileDoesNotExist() {
        try {
            InputFileReader.getTextStreamFromFile("Not a real file");
        } catch (Exception e) {
            TestCase.assertTrue(true);
        }
    }
}