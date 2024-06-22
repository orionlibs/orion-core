package io.github.orionlibs.core.web.service.cloud.aws.s3;

import io.github.orionlibs.core.abstraction.OrionService;
import io.github.orionlibs.core.configuration.ConfigurationService;
import io.github.orionlibs.core.file_system.file.FileService;
import io.github.orionlibs.core.web.service.cloud.aws.AWSService;
import io.github.orionlibs.core.web.service.cloud.aws.s3.tasks.DeleteFileFromAWSS3Task;
import io.github.orionlibs.core.web.service.cloud.aws.s3.tasks.GetAWSS3DetailsTask;
import io.github.orionlibs.core.web.service.cloud.aws.s3.tasks.UploadFileToAWSS3AndGetFileURLTask;
import io.github.orionlibs.core.web.urls.URLService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.web.multipart.MultipartFile;

public class AWSS3Service extends OrionService
{
    public static String uploadFileAndGetFileURL(MultipartFile file, String bucketFolderName, String fileNamePrefix)
    {
        File tempFile = FileService.saveTemporaryFileToServer(file, fileNamePrefix, ConfigurationService.getProp("file.upload.temporary.path.on.aws.ec2.tomcat"));
        return uploadFileAndGetFileURL(tempFile, bucketFolderName);
    }


    public static String uploadFileAndGetFileURL(String fileNameToUse, MultipartFile file, String bucketFolderName)
    {
        File tempFile = FileService.saveTemporaryFileToServer(fileNameToUse, ConfigurationService.getProp("file.upload.temporary.path.on.aws.ec2.tomcat"), file);
        return uploadFileAndGetFileURL(tempFile, bucketFolderName);
    }


    public static String uploadFileAndGetFileURL(File file, String bucketFolderName)
    {
        String fileURL = UploadFileToAWSS3AndGetFileURLTask.run(AWSService.getDefaultClientConfiguration(), file, bucketFolderName);

        try
        {
            FileService.deleteFile(file);
        }
        catch(IOException e)
        {
        }

        return URLService.decodeURLWithUTF8(fileURL);
    }


    public static String uploadFileAndGetFileURL(InputStream file, String fileName, String bucketFolderName)
    {
        String fileURL = UploadFileToAWSS3AndGetFileURLTask.run(AWSService.getDefaultClientConfiguration(), file, fileName, bucketFolderName);
        return URLService.decodeURLWithUTF8(fileURL);
    }


    public static boolean deleteFile(String fileID)
    {
        DeleteFileFromAWSS3Task.run(AWSService.getDefaultClientConfiguration(), fileID);
        return true;
    }


    public static AWSS3DetailsModel getAWSS3Details()
    {
        return GetAWSS3DetailsTask.run(AWSService.getDefaultClientConfiguration());
    }
}