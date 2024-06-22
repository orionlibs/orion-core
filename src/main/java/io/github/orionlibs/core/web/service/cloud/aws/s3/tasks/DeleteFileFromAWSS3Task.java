package io.github.orionlibs.core.web.service.cloud.aws.s3.tasks;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.logger.LoggingService;
import io.github.orionlibs.core.web.service.cloud.aws.CloudAWSErrorType;
import io.github.orionlibs.core.web.service.cloud.aws.s3.AWSS3Credentials;
import io.github.orionlibs.core.web.service.cloud.aws.s3.CloudAWSS3Errors;

public class DeleteFileFromAWSS3Task extends Orion
{
    public static void run(ClientConfiguration clientConfiguration, String fileID)
    {

        if(fileID != null)
        {
            AWSS3Credentials credentials = AWSS3Credentials.populate(clientConfiguration);

            try
            {
                credentials.getClient().deleteObject(new DeleteObjectRequest(credentials.getBucketName(), fileID));
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

    }
}