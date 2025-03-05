import model.dto.Repo;
import model.dto.TIL;
import service.github.TILService;
import service.github.TILServiceImpl;
import util.file.CSVReader;
import util.file.CSVReaderImpl;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Logger;

public class Application {
    static List<Repo> repos;
    static List<TIL> tils;

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Application.class.getName());
        CSVReader reader = new CSVReaderImpl();

        try {
            repos = reader.read("til.csv");
            logger.info(repos.toString());
        } catch (FileNotFoundException e) {
            logger.severe(e.getMessage());
        }

        TILService service = new TILServiceImpl();
        tils = service.getTIL(repos);
        logger.info(tils.toString());
    }
}
