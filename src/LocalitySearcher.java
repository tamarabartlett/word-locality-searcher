import java.util.List;

public class LocalitySearcher {
    public void search(String filename, String firstSearchWord, String secondSearchWord) {
        List<String> textStreamFromInputFile = FileReader.getTextStreamFromFile(filename);

        Boolean bothWordsInStream = findWordsInStream(textStreamFromInputFile, firstSearchWord, secondSearchWord);
    }

    public Boolean findWordsInStream(List<String> textStreamFromInputFile, String firstSearchWord, String secondSearchWord) {
        boolean firstWordFound = textStreamFromInputFile.stream().anyMatch(x -> x.compareTo(firstSearchWord) == 0);
        boolean secondWordFound = textStreamFromInputFile.stream().anyMatch(x -> x.compareTo(secondSearchWord) == 0);
        return firstWordFound &&
                secondWordFound;
    }
}
