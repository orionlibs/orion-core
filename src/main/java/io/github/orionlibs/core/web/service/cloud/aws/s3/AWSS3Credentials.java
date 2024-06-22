package io.github.orionlibs.core.web.service.cloud.aws.s3;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.configuration.ConfigurationService;
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
public class AWSS3Credentials extends Orion
{
    private Regions clientRegion;
    private String bucketName;
    private AmazonS3 client;


    public static AWSS3Credentials populate(ClientConfiguration clientConfiguration)
    {
        return AWSS3Credentials.builder()
                        .clientRegion(Regions.EU_WEST_2)
                        .client(AmazonS3ClientBuilder.standard()
                                        .withRegion(Regions.EU_WEST_2)
                                        .withCredentials(new ProfileCredentialsProvider())
                                        .withClientConfiguration(clientConfiguration)
                                        .build())
                        .bucketName(ConfigurationService.getProp("cloud.aws.s3.bucket.name"))
                        .build();
    }
}