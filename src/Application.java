import util.file.CSVReader;
import util.file.CSVReaderImpl;

import java.io.FileNotFoundException;
import java.util.logging.Logger;

public class Application {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Application.class.getName());
        CSVReader reader = new CSVReaderImpl();
        try {
            reader.read("til.csv");
        } catch (FileNotFoundException e) {
            logger.severe(e.getMessage());
        }
    }
}
