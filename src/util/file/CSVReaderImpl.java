package util.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class CSVReaderImpl  implements CSVReader {
    @Override
    public String[] read(String path) throws FileNotFoundException {
        Logger logger = Logger.getLogger(CSVReaderImpl.class.getName());
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNext()) {
                logger.info(scanner.nextLine());
            }
        }
        return new String[0];
    }
}
