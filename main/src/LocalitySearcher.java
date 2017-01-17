import java.util.List;

public class LocalitySearcher {
    public boolean search(InputVariables input) {
        List<String> textStreamFromInputFile = InputFileReader.getTextStreamFromFile(input.getFilename());

        return findWordsInStream(textStreamFromInputFile, input.getFirstSearchWord(), input.getSecondSearchWord(), input.getProximityNumber());
    }

    public boolean findWordsInStream(List<String> textStreamFromInputFile, String firstSearchWord, String secondSearchWord, int proximityNumber) {
        boolean wordsNextToEachOther = false;
        int textStreamLength = textStreamFromInputFile.size();

        for (int currentWordIndex = 0; currentWordIndex < textStreamLength; currentWordIndex++) {
            String currentWord = textStreamFromInputFile.get(currentWordIndex);

            if (wordsAreMatching(firstSearchWord, currentWord)) {
                wordsNextToEachOther = wordsAreWithinProximityOfEachOther(textStreamFromInputFile, secondSearchWord, currentWordIndex, proximityNumber);
                if (wordsNextToEachOther) break;
            }

            if (wordsAreMatching(secondSearchWord, currentWord)) {
                wordsNextToEachOther = wordsAreWithinProximityOfEachOther(textStreamFromInputFile, firstSearchWord, currentWordIndex, proximityNumber);
                if (wordsNextToEachOther) break;
            }
        }

        return wordsNextToEachOther;
    }

    private boolean wordsAreWithinProximityOfEachOther(List<String> textStreamFromInputFile, String otherSearchWord, int searchWordIndex, int proximityNumber) {
        boolean wordsAreWithinProximity = false;

        for (int numberOfWordsPastSearchWord = 1; numberOfWordsPastSearchWord <= proximityNumber + 1; numberOfWordsPastSearchWord++) {
            int currentWordIndex = searchWordIndex + numberOfWordsPastSearchWord;
            if (currentWordIndex < textStreamFromInputFile.size()) {
                String currentWord = textStreamFromInputFile.get(currentWordIndex);
                if (wordsAreMatching(otherSearchWord, currentWord)) {
                    wordsAreWithinProximity = true;
                    break;
                }
            }
        }

        return wordsAreWithinProximity;
    }

    private boolean wordsAreMatching(String firstSearchWord, String word) {
        return word.compareTo(firstSearchWord) == 0;
    }
}
