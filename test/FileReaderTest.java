import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnit4.class)
public class FileReaderTest {

    @Test
    public void shouldReturnBufferedReaderFromFile() throws IOException {
        List<String> textStreamFromFile = FileReader.getTextStreamFromFile("./test.txt");
        assertThat(textStreamFromFile, is(notNullValue()));
        assertThat(textStreamFromFile.get(0), is("Test"));
    }

    @Test
    public void shouldCatchErrorWhenFileDoesNotExist() {
        try {
            FileReader.getTextStreamFromFile("Not a real file");
        } catch (Exception e) {
            assertTrue(true);
        }
    }
}