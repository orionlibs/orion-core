package io.github.orionlibs.orion.core.web.service.cloud.aws.ec2;

import io.github.orionlibs.orion.core.abstraction.OrionService;
import io.github.orionlibs.orion.core.web.service.cloud.aws.AWSService;
import io.github.orionlibs.orion.core.web.service.cloud.aws.ec2.tasks.GetAWSEC2DetailsTask;

public class AWSEC2Service extends OrionService
{
    public static AWSEC2DetailsModel getAWSEC2Details()
    {
        return GetAWSEC2DetailsTask.run(AWSService.getDefaultClientConfiguration());
    }
}