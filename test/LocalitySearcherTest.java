import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class LocalitySearcherTest {


    int PROXIMITY_NUMBER = 3;

    @Test
    public void shouldFailWhenNeitherWordIsInStream() {
        List<String> words = Arrays.asList("no", "no", "no");
        LocalitySearcher searcher = new LocalitySearcher();
        Boolean wordInStream = searcher.findWordsInStream(words, "yes", "yeah");
        assertThat(wordInStream, is(false));
    }

    @Test
    public void shouldSucceedWhenFirstWordIsDirectlyBeforeSecondWord() {
        List<String> words = Arrays.asList("yes", "yeah", "no");
        LocalitySearcher searcher = new LocalitySearcher();
        Boolean wordInStream = searcher.findWordsInStream(words, "yes", "yeah");
        assertThat(wordInStream, is(true));
    }

    @Test
    public void shouldSucceedWhenSecondWordIsDirectlyBeforeFirstWord() {
        List<String> words = Arrays.asList("yeah", "yes", "no");
        LocalitySearcher searcher = new LocalitySearcher();
        Boolean wordInStream = searcher.findWordsInStream(words, "yes", "yeah");
        assertThat(wordInStream, is(true));
    }

    @Test
    public void shouldFailWhenFirstWordIsNotDirectlyBeforeSecondWord() {
        List<String> words = Arrays.asList("yes", "no", "yeah" );
        LocalitySearcher searcher = new LocalitySearcher();
        Boolean wordInStream = searcher.findWordsInStream(words, "yes", "yeah");
        assertThat(wordInStream, is(false));
    }

    @Test
    public void shouldFailWhenSecondWordIsNotDirectlyBeforeFirstWord() {
        List<String> words = Arrays.asList("yeah", "no", "yes" );
        LocalitySearcher searcher = new LocalitySearcher();
        Boolean wordInStream = searcher.findWordsInStream(words, "yes", "yeah");
        assertThat(wordInStream, is(false));
    }
}