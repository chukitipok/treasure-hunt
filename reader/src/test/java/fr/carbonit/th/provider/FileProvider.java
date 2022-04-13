package fr.carbonit.th.provider;

import java.io.File;

public interface FileProvider <T> {
    File provide(T fileType);
}
