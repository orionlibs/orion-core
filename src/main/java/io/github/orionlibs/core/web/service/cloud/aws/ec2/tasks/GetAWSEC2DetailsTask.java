package io.github.orionlibs.core.web.service.cloud.aws.ec2.tasks;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.Reservation;
import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.web.service.cloud.aws.ec2.AWSEC2Credentials;
import io.github.orionlibs.core.web.service.cloud.aws.ec2.AWSEC2DetailsModel;

public class GetAWSEC2DetailsTask extends Orion
{
    public static AWSEC2DetailsModel run(ClientConfiguration clientConfiguration)
    {
        AWSEC2Credentials credentials = AWSEC2Credentials.populate(clientConfiguration);
        AWSEC2DetailsModel allDetailsModel = new AWSEC2DetailsModel();
        int numberOfInstances = 0;
        DescribeInstancesResult response = credentials.getClient().describeInstances();

        for(Reservation reservation : response.getReservations())
        {
            numberOfInstances += reservation.getInstances().size();
        }

        //String platform = client.describeInstances().
        /*
         * String platform =
         * client.describeImages().getImages().get(0).getPlatformDetails();
         * allDetailsModel.setOperatingSystemName(platform); //DescribeInstancesRequest
         * request = new DescribeInstancesRequest(); boolean done = false; int
         * numberOfInstances = 0; while(!done) { //DescribeInstancesResult response =
         * client.describeInstances(request); DescribeInstancesResult response =
         * client.describeInstances(); for(Reservation reservation :
         * response.getReservations()) { numberOfInstances +=
         * reservation.getInstances().size(); }
         * //request.setNextToken(response.getNextToken()); if(response.getNextToken()
         * == null) { done = true; } }
         */
        allDetailsModel.setNumberOfInstances(numberOfInstances);
        credentials.getClient().shutdown();
        return allDetailsModel;
    }
}