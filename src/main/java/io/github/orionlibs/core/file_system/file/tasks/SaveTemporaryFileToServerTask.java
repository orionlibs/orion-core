package io.github.orionlibs.core.file_system.file.tasks;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.file_system.file.FileService;
import io.github.orionlibs.core.uuid.UUIDSecurityService;
import java.io.File;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public class SaveTemporaryFileToServerTask extends Orion
{
    public static File run(MultipartFile file, String fileNamePrefix, String tempFolder)
    {

        if(file != null)
        {
            File tempFile = null;

            try
            {
                String fileExtension = FileService.getFileExtension(file.getOriginalFilename());
                String tempFileName = tempFolder;

                if(fileNamePrefix != null && !fileNamePrefix.isEmpty())
                {
                    tempFileName += fileNamePrefix + "-";
                }

                tempFileName += UUIDSecurityService.generateUUIDWithoutHyphens() + "." + fileExtension;
                tempFile = new File(tempFileName);
                FileService.saveFile(file, tempFile);
                return tempFile;
            }
            catch(IOException e)
            {
                return null;
            }

        }

        return null;
    }


    public static File run(String fileNameToUse, String tempFolder, MultipartFile file)
    {

        if(file != null)
        {
            File tempFile = null;

            try
            {
                tempFile = new File(tempFolder + fileNameToUse);
                FileService.saveFile(file, tempFile);
                return tempFile;
            }
            catch(IOException e)
            {
                return null;
            }

        }

        return null;
    }
}