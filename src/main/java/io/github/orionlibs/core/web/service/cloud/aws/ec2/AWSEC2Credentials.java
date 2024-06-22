package io.github.orionlibs.core.web.service.cloud.aws.ec2;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
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
public class AWSEC2Credentials extends Orion
{
    private Regions clientRegion;
    private AmazonEC2 client;


    public static AWSEC2Credentials populate(ClientConfiguration clientConfiguration)
    {
        return AWSEC2Credentials.builder()
                        .clientRegion(Regions.EU_WEST_2)
                        .client(AmazonEC2ClientBuilder.standard()
                                        .withRegion(Regions.EU_WEST_2)
                                        .withCredentials(new ProfileCredentialsProvider())
                                        .withClientConfiguration(clientConfiguration)
                                        .build())
                        .build();
    }
}