import java.io.IOException;
import java.util.Scanner;
/**
 * Movie Mate class is the main class that starts running the program.
 *
 */
public class MovieMate {
    private static Storage storage = new Storage();
    private static String filePath = "data/movies.csv";
    private static String watchedListPath = "data/moviemate_watchlist.txt";
    private static String toWatchListPath = "data/moviemate_towatch.txt";
    private static WatchedList watchedList = new WatchedList(storage.load(watchedListPath));
    private static ToWatchList toWatchList = new ToWatchList(storage.load(toWatchListPath));
    private static MovieDatabase movieDatabase;

    static {
        try {
            movieDatabase = new MovieDatabase(storage.loadDatabase());
        } catch (IOException e) {
            System.out.println("Critical error: You might be missing a database file.");
            System.exit(1);
        }
    }

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
                watchedList.add(commandArg);
                break;
            case "remove":
                switch (commandArg) {
                case "watched":
                    //remove from watched list
                    Ui.showListMessage(watchedList);
                    int removeWatchedIndex = Integer.parseInt(inputCommand(scan));
                    watchedList.remove(removeWatchedIndex);
                    break;
                case "towatch":
                    //remove from towatch list
                    Ui.showListMessage(toWatchList);
                    int removeToWatchIndex = Integer.parseInt(inputCommand(scan));
                    toWatchList.remove(removeToWatchIndex);
                    break;
                }
            case "towatch":
                // add to to-watch list
                toWatchList.add(commandArg);
                break;
            case "help":
                Ui.help();
                Ui.printLine();
                break;
            case "list":
                // list the watched list
                watchedList.list();
                Ui.printLine();
                break;
            case "watchlist":
                // list the to-watch list
                toWatchList.list();
                Ui.printLine();   
                break;
            case "addreview":
                // adds review to a movie in the watched list
                break;
            case "deletereview":
                //deletes review of a movie in the watched list
                break;
            case "viewreview":
                // view review written for a movie in the watched list
            case "seedetail":
                // find relevant movie info
                break;
            case "exit":
                // fallthrough
            case "bye":
                exit();
                break;
            default:
                Ui.help();
                break;
            }
        }

    }

    private static void exit() {
        Ui.showExitMessage();
        Ui.printLine();
        storage.writeToFile(watchedListPath, watchedList.getFileWriteFormat());
        storage.writeToFile(toWatchListPath, toWatchList.getFileWriteFormat());
        System.exit(0);
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
