package util.file;

import model.dto.Repo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class CSVReaderImpl implements CSVReader {
    @Override
    public List<Repo> read(String path) throws FileNotFoundException {
        Logger logger = Logger.getLogger(CSVReaderImpl.class.getName());
        List<Repo> repos = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
//                logger.info(scanner.nextLine());
                String[] split = line.split(",");
                logger.info(Arrays.toString(split));
                repos.add(split.length == 3 ? new Repo(

                        split[0], split[1], split[2]
                ) : new Repo(split[0], split[1]));
            }

        }

        return repos;
    }
}
