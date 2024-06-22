package io.github.orionlibs.core.web.service.cloud.aws.s3.tasks;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.PartETag;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.UploadPartResult;
import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.logger.LoggingService;
import io.github.orionlibs.core.web.service.cloud.aws.CloudAWSErrorType;
import io.github.orionlibs.core.web.service.cloud.aws.s3.AWSS3Credentials;
import io.github.orionlibs.core.web.service.cloud.aws.s3.CloudAWSS3Errors;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UploadFileToAWSS3AndGetFileURLTask extends Orion
{
    public static String run(ClientConfiguration clientConfiguration, File file, String bucketFolderName)
    {
        return run(clientConfiguration, file, bucketFolderName, CannedAccessControlList.PublicRead);
    }


    public static String run(ClientConfiguration clientConfiguration, InputStream file, String fileName, String bucketFolderName)
    {
        return run(clientConfiguration, file, fileName, bucketFolderName, CannedAccessControlList.PublicRead);
    }


    public static String run(ClientConfiguration clientConfiguration, File file, String bucketFolderName, CannedAccessControlList fileAccessMode)
    {

        if(file != null)
        {
            AWSS3Credentials credentials = AWSS3Credentials.populate(clientConfiguration);
            String keyName = bucketFolderName + "/" + file.getName();
            long contentLength = file.length();
            long partSize = 5 * 1024 * 1024;

            try
            {
                List<PartETag> partETags = new ArrayList<>();
                InitiateMultipartUploadRequest initRequest = new InitiateMultipartUploadRequest(credentials.getBucketName(), keyName);
                initRequest.setCannedACL(CannedAccessControlList.PublicRead);
                InitiateMultipartUploadResult initResponse = credentials.getClient().initiateMultipartUpload(initRequest);
                long filePosition = 0;

                for(int i = 1; filePosition < contentLength; i++)
                {
                    //Because the last part could be less than 5 MB, adjust the part size as needed.
                    partSize = Math.min(partSize, (contentLength - filePosition));
                    UploadPartRequest uploadRequest = new UploadPartRequest()
                                    .withBucketName(credentials.getBucketName())
                                    .withKey(keyName)
                                    .withUploadId(initResponse.getUploadId())
                                    .withPartNumber(i)
                                    .withFileOffset(filePosition)
                                    .withFile(file)
                                    .withPartSize(partSize);
                    //.withCannedAcl(CannedAccessControlList.PublicRead)
                    UploadPartResult uploadResult = credentials.getClient().uploadPart(uploadRequest);
                    partETags.add(uploadResult.getPartETag());
                    filePosition += partSize;
                }

                CompleteMultipartUploadRequest compRequest = new CompleteMultipartUploadRequest(credentials.getBucketName(), keyName, initResponse.getUploadId(), partETags);
                CompleteMultipartUploadResult result = credentials.getClient().completeMultipartUpload(compRequest);
                return result.getLocation();
            }
            catch(AmazonServiceException e)
            {
                LoggingService.logError(e, null,
                                null,
                                CloudAWSErrorType.AWSS3.get(),
                                CloudAWSS3Errors.AWSS3FileUploadProcessingProblem);
            }
            catch(SdkClientException e)
            {
                LoggingService.logError(e, null,
                                null,
                                CloudAWSErrorType.AWSS3.get(),
                                CloudAWSS3Errors.AWSS3UnreachableProblem);
            }
            catch(Exception e)
            {
                LoggingService.logError(e, null,
                                null,
                                CloudAWSErrorType.AWSS3.get(),
                                CloudAWSS3Errors.AWSS3FileUploadProcessingProblem);
            }

        }

        return null;
    }


    public static String run(ClientConfiguration clientConfiguration, InputStream file, String fileName, String bucketFolderName, CannedAccessControlList fileAccessMode)
    {

        if(file != null)
        {
            AWSS3Credentials credentials = AWSS3Credentials.populate(clientConfiguration);
            String keyName = bucketFolderName + "/" + fileName;
            int contentLength = 0;

            try
            {
                contentLength = file.available();
            }
            catch(IOException e)
            {
                throw new RuntimeException(e);
            }

            long partSize = 5 * 1024 * 1024;

            try
            {
                List<PartETag> partETags = new ArrayList<>();
                InitiateMultipartUploadRequest initRequest = new InitiateMultipartUploadRequest(credentials.getBucketName(), keyName);
                initRequest.setCannedACL(CannedAccessControlList.PublicRead);
                InitiateMultipartUploadResult initResponse = credentials.getClient().initiateMultipartUpload(initRequest);
                long filePosition = 0;

                for(int i = 1; filePosition < contentLength; i++)
                {
                    //Because the last part could be less than 5 MB, adjust the part size as needed.
                    partSize = Math.min(partSize, (contentLength - filePosition));
                    UploadPartRequest uploadRequest = new UploadPartRequest()
                                    .withBucketName(credentials.getBucketName())
                                    .withKey(keyName)
                                    .withUploadId(initResponse.getUploadId())
                                    .withPartNumber(i)
                                    .withFileOffset(filePosition)
                                    .withInputStream(file)
                                    .withPartSize(partSize);
                    //.withCannedAcl(CannedAccessControlList.PublicRead)
                    UploadPartResult uploadResult = credentials.getClient().uploadPart(uploadRequest);
                    partETags.add(uploadResult.getPartETag());
                    filePosition += partSize;
                }

                CompleteMultipartUploadRequest compRequest = new CompleteMultipartUploadRequest(credentials.getBucketName(), keyName, initResponse.getUploadId(), partETags);
                CompleteMultipartUploadResult result = credentials.getClient().completeMultipartUpload(compRequest);
                return result.getLocation();
            }
            catch(AmazonServiceException e)
            {
                LoggingService.logError(e, null,
                                null,
                                CloudAWSErrorType.AWSS3.get(),
                                CloudAWSS3Errors.AWSS3FileUploadProcessingProblem);
            }
            catch(SdkClientException e)
            {
                LoggingService.logError(e, null,
                                null,
                                CloudAWSErrorType.AWSS3.get(),
                                CloudAWSS3Errors.AWSS3UnreachableProblem);
            }
            catch(Exception e)
            {
                LoggingService.logError(e, null,
                                null,
                                CloudAWSErrorType.AWSS3.get(),
                                CloudAWSS3Errors.AWSS3FileUploadProcessingProblem);
            }

        }

        return null;
    }
}