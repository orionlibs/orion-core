package io.github.orionlibs.core.web.service.cloud.aws;

import com.amazonaws.ClientConfiguration;
import io.github.orionlibs.core.abstraction.OrionService;

public class AWSService extends OrionService
{
    public static ClientConfiguration getDefaultClientConfiguration()
    {
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        clientConfiguration.setClientExecutionTimeout(20000);
        clientConfiguration.setConnectionMaxIdleMillis(20000);
        clientConfiguration.setConnectionTimeout(20000);
        clientConfiguration.setMaxErrorRetry(2);
        clientConfiguration.setRequestTimeout(20000);
        return clientConfiguration;
    }
}