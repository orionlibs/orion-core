package io.github.orionlibs.core.web.service.cloud.aws.rds;

import io.github.orionlibs.core.abstraction.OrionService;
import io.github.orionlibs.core.web.service.cloud.aws.AWSService;
import io.github.orionlibs.core.web.service.cloud.aws.rds.tasks.GetAWSRDSInstanceDetailsTask;

public class AWSRDSService extends OrionService
{
    public static AWSRDSDetailsModel getAWSRDSInstanceDetails()
    {
        return GetAWSRDSInstanceDetailsTask.run(AWSService.getDefaultClientConfiguration());
    }
}