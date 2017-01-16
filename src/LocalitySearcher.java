import java.util.List;

public class LocalitySearcher {
    public void search(String filename, String firstSearchWord, String secondSearchWord, String proximityNumber) {
        List<String> textStreamFromInputFile = FileReader.getTextStreamFromFile(filename);

        Boolean bothWordsInStream = findWordsInStream(textStreamFromInputFile, firstSearchWord, secondSearchWord);
    }

    public Boolean findWordsInStream(List<String> textStreamFromInputFile, String firstSearchWord, String secondSearchWord) {
        boolean wordsNextToEachOther = false;
        int textStreamLength = textStreamFromInputFile.size();

        for (int i = 0; i < textStreamLength; i++) {
            String currentWord = textStreamFromInputFile.get(i);
            int nextWordIndex = i + 1;

            if (wordsAreMatching(firstSearchWord, currentWord)) {
                wordsNextToEachOther = wordsAreNextToEachOther(textStreamFromInputFile, secondSearchWord, nextWordIndex);
                if (wordsNextToEachOther) break;
            }

            if (wordsAreMatching(secondSearchWord, currentWord)) {
                wordsNextToEachOther = wordsAreNextToEachOther(textStreamFromInputFile, firstSearchWord, nextWordIndex);
                if (wordsNextToEachOther) break;
            }
        }

        return wordsNextToEachOther;
    }

    private boolean wordsAreNextToEachOther(List<String> textStreamFromInputFile, String otherWord, int nextWordIndex) {
        boolean wordsNextToEachOther = false;
        if (nextWordIndex < textStreamFromInputFile.size()) {
            String nextWord = textStreamFromInputFile.get(nextWordIndex);
            if (wordsAreMatching(otherWord, nextWord)) {
                wordsNextToEachOther = true;
            }
        }
        return wordsNextToEachOther;
    }

    private boolean wordsAreMatching(String firstSearchWord, String word) {
        return word.compareTo(firstSearchWord) == 0;
    }
}
