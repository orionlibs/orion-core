package io.github.orionlibs.core.file_system.file.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.exception.Assert;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.web.multipart.MultipartFile;

public class UploadFileTask extends Orion
{
    public static void run(MultipartFile fileToUpload, String filePathToDownloadTo, String fileName) throws IOException
    {
        Assert.notNull(fileToUpload, "fileToUpload input cannot be null.");
        Assert.notEmpty(filePathToDownloadTo, "filePathToDownloadTo input cannot be null/empty.");
        Assert.notEmpty(fileName, "fileName input cannot be null/empty.");
        Path documentsPath = Paths.get(filePathToDownloadTo);
        Files.copy(fileToUpload.getInputStream(), documentsPath.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
    }
}