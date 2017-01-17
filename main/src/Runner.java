public class Runner {
    public static void main(String[] args) {

        InputVariables input = new InputVariables(args);
        LocalitySearcher localitySearcher = new LocalitySearcher();

        if (localitySearcher.search(input)){
            System.out.println("Both words were found proximal to one another");
        } else {
            System.out.println("The words were not found proximal to one another");
        }
    }
}
