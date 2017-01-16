public class Runner {
    public static void main(String[] args) {
        if (args.length != 4){
            System.out.println("Please provide three args: file.txt, first-search-word, second-search-word, number of words between search words");
        }

        String filename = args[0];
        String firstSearchWord = args[1];
        String secondSearchWord = args[2];
        String proximityNumber = args[3];

        LocalitySearcher localitySearcher = new LocalitySearcher();
        localitySearcher.search(filename, firstSearchWord, secondSearchWord, proximityNumber);
    }
}
