import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSVFile {
    public static String[] find(String filePath, String movieName) {
        String csvFile = "data/movies.csv";
        String line = "";
        String csvSplitBy = ",";


        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            Integer c = 0;
            while (c < 10000 && (line = br.readLine()) != null) {
                if (line.contains(movieName)) {
                    String[] row = line.split(csvSplitBy);
                    return row;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

