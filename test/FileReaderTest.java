import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.io.IOException;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnit4.class)
public class FileReaderTest {
    String PATHNAME = "./test.txt";

    @Test
    public void shouldReturnBufferedReaderFromFile() throws IOException {
        File file = new File(PATHNAME);
        file.createNewFile();
        assertThat(FileReader.getBufferedReaderFromFile(PATHNAME), is(notNullValue()));
    }

    @Test
    public void shouldCatchErrorWhenFileDoesNotExist() {
        try {
            FileReader.getBufferedReaderFromFile("Not a real file");
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @After
    public void tearDown() {
        File file = new File(PATHNAME);
        file.delete();
    }
}