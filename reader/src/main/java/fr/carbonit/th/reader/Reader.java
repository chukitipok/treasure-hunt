package fr.carbonit.th.reader;

import java.io.File;
import java.util.List;

public interface Reader {
    List<String> read(File file);
}
