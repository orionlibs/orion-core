package io.github.orionlibs.core.web.service.cloud.aws.rds;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.rds.AmazonRDS;
import com.amazonaws.services.rds.AmazonRDSClientBuilder;
import io.github.orionlibs.core.abstraction.Orion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AWSRDSCredentials extends Orion
{
    private Regions clientRegion;
    private AmazonRDS client;


    public static AWSRDSCredentials populate(ClientConfiguration clientConfiguration)
    {
        return AWSRDSCredentials.builder()
                        .clientRegion(Regions.EU_WEST_2)
                        .client(AmazonRDSClientBuilder.standard()
                                        .withRegion(Regions.EU_WEST_2)
                                        .withCredentials(new ProfileCredentialsProvider())
                                        .withClientConfiguration(clientConfiguration)
                                        .build())
                        .build();
    }
}