import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class LocalitySearcherTest {

    @Test
    public void shouldFailWhenOnlyFirstWordIsInStream(){
        List<String> words = Arrays.asList("yes", "no", "no");
        LocalitySearcher searcher = new LocalitySearcher();
        Boolean wordInStream = searcher.findWordsInStream(words, "yes", "yeah");
        assertThat(wordInStream, is(false));
    }

    @Test
    public void shouldFailWhenOnlySecondWordIsInStream(){
        List<String> words = Arrays.asList("yeah", "no", "no");
        LocalitySearcher searcher = new LocalitySearcher();
        Boolean wordInStream = searcher.findWordsInStream(words, "yes", "yeah");
        assertThat(wordInStream, is(false));
    }

    @Test
    public void shouldFailWhenNeitherWordIsInStream(){
        List<String> words = Arrays.asList("no", "no", "no");
        LocalitySearcher searcher = new LocalitySearcher();
        Boolean wordInStream = searcher.findWordsInStream(words, "yes", "yeah");
        assertThat(wordInStream, is(false));
    }

    @Test
    public void shouldSucceedWhenBothWordsAreInStream(){
        List<String> words = Arrays.asList("yeah", "yes", "no");
        LocalitySearcher searcher = new LocalitySearcher();
        Boolean wordInStream = searcher.findWordsInStream(words, "yes", "yeah");
        assertThat(wordInStream, is(true));
    }
}