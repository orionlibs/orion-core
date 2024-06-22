package io.github.orionlibs.core.web.service.cloud.aws.s3.tasks;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.calendar.date.Date;
import io.github.orionlibs.core.calendar.datetime.DateTime;
import io.github.orionlibs.core.calendar.time.Time;
import io.github.orionlibs.core.web.service.cloud.aws.s3.AWSS3BucketDetailsModel;
import io.github.orionlibs.core.web.service.cloud.aws.s3.AWSS3Credentials;
import io.github.orionlibs.core.web.service.cloud.aws.s3.AWSS3DetailsModel;
import java.util.ArrayList;
import java.util.List;

public class GetAWSS3DetailsTask extends Orion
{
    public static AWSS3DetailsModel run(ClientConfiguration clientConfiguration)
    {
        AWSS3Credentials credentials = AWSS3Credentials.populate(clientConfiguration);
        AWSS3DetailsModel allDetailsModel = new AWSS3DetailsModel();
        List<Bucket> buckets = credentials.getClient().listBuckets();
        allDetailsModel.setNumberOfBuckets(buckets.size());
        List<AWSS3BucketDetailsModel> bucketsDetails = new ArrayList<>();

        for(Bucket bucket : buckets)
        {
            ListObjectsV2Result bucketFiles = credentials.getClient().listObjectsV2(bucket.getName());
            java.util.Date bucketCreationDateTime = bucket.getCreationDate();
            Date date = Date.of(bucketCreationDateTime.getYear() + 1900, bucketCreationDateTime.getMonth() + 1, bucketCreationDateTime.getDate());
            Time time = Time.of(bucketCreationDateTime.getHours(), bucketCreationDateTime.getMinutes(), bucketCreationDateTime.getSeconds());
            DateTime bucketCreationDateTimeTemp = DateTime.of(date, time);
            AWSS3BucketDetailsModel model = AWSS3BucketDetailsModel.builder()
                            .name(bucket.getName())
                            .numberOfFilesInBucket(bucketFiles.getKeyCount())
                            .creationDateTime(bucketCreationDateTimeTemp)
                            .build();
            bucketsDetails.add(model);
        }

        allDetailsModel.setBuckets(bucketsDetails);
        credentials.getClient().shutdown();
        return allDetailsModel;
    }
}