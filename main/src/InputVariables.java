public class InputVariables {

    private String filename;
    private String firstSearchWord;
    private String secondSearchWord;
    private int proximityNumber;

    private String genericInputWarning = "Please provide four args: file.txt, first-search-word, second-search-word, number of words between search words";

    public InputVariables(String[] args) {
        if (args.length > 4) {
            System.out.println("Too many args. " + genericInputWarning);
        } else if (args.length < 4) {
            System.out.println("Too few args. " + genericInputWarning);
        } else {
            initializeFields(args);
        }
    }

    private void initializeFields(String[] args) {
        filename = args[0].toLowerCase();
        firstSearchWord = args[1].toLowerCase();
        secondSearchWord = args[2].toLowerCase();
        try {
            proximityNumber = Integer.parseInt(args[3]);
        } catch (NumberFormatException e) {
            System.out.println("ProximityNumber must be a number. " + genericInputWarning);
        }
    }

    public String getFilename() {
        return filename;
    }

    public String getFirstSearchWord() {
        return firstSearchWord;
    }

    public String getSecondSearchWord() {
        return secondSearchWord;
    }

    public int getProximityNumber() {
        return proximityNumber;
    }
}
