import java.util.Arrays;
import java.util.Scanner;
/**
 * Movie Mate class is the main class that starts running the program.
 *
 */
public class MovieMate {
    private static String filePath = "data/movies.csv";
    private static WatchedList watchedList = new WatchedList();
    private static ToWatchList toWatchList = new ToWatchList();
    public static void main(String[] args) {
        Ui.showWelcomeMessage();
        // Initialise Scanner
        Scanner scan = new Scanner(System.in);

        while(true) {
            // Get user input and parse it.
            String userInput = inputCommand(scan);
            String[] commandTypeAndParams = Parser.parseCommand(userInput);
            String commandType = commandTypeAndParams[0];
            String commandArg = commandTypeAndParams[1];

            switch (commandType) {
            case "watched":
                // add to watched list
                String[] movieInfo = ReadCSVFile.find("data/movies.csv", commandArg);
                Movie movie = new Movie(movieInfo[0], movieInfo[2], Integer.parseInt(movieInfo[4]),
                        Integer.parseInt(movieInfo[5]), Arrays.copyOfRange(movieInfo, 5, movieInfo.length));
                watchedList.add(movie);
                break;
            case "towatch":
                // add to to-watch list
                break;
            case "help":
                Ui.help();
                break;
            case "list":
                Ui.showWatchedList(watchedList);
                // list the watched list
                break;
            case "watchlist":
                // list the to-watch list
                break;
            case "bye":
                // TODO: Extract this process and print message, save data, upon exit.
                Ui.showExitMessage();
                System.exit(0);
                break;
            default:
                Ui.help();
                break;
            }
        }

    }
    /**
     * Scan in the user input and trim extra white space.
     * If there is no input, continue to scan the next line for input.
     * @return The string that the user entered
     */
    private static String inputCommand(Scanner scan) {
        String s = "";
        s = scan.nextLine();
        while (s.trim().isEmpty() || s.trim().charAt(0) == '#') {
            s = scan.nextLine();
        }
        return s;
    }
}
