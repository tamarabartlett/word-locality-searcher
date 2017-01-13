import java.io.BufferedReader;

public class Runner {
    public static void main(String[] args) {
        if (args.length != 3){
            System.out.println("Please provide three args: file.txt, first-search-word, second-search-word");
        }

        String filename = args[0];
        String firstSearchWord = args[1];
        String secondSearchWord = args[2];

        LocalitySearcher localitySearcher = new LocalitySearcher();
        localitySearcher.search(filename, firstSearchWord, secondSearchWord);
    }
}
