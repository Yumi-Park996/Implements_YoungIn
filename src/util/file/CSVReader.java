package util.file;

import java.io.FileNotFoundException;

public interface CSVReader {
    String[] read(String path) throws FileNotFoundException;
}
