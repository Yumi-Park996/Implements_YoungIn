import model.dto.Repo;
import util.file.CSVReader;
import util.file.CSVReaderImpl;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Logger;

public class Application {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Application.class.getName());
        CSVReader reader = new CSVReaderImpl();
        try {
            List<Repo> repos = reader.read("til.csv");
            logger.info(repos.toString());
        } catch (FileNotFoundException e) {
            logger.severe(e.getMessage());
        }
    }
}
