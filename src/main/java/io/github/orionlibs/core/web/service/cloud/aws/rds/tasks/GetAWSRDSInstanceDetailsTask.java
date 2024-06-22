package io.github.orionlibs.core.web.service.cloud.aws.rds.tasks;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.services.rds.model.DBInstance;
import com.amazonaws.services.rds.model.DescribeAccountAttributesResult;
import com.amazonaws.services.rds.model.DescribeDBInstancesResult;
import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.calendar.date.Date;
import io.github.orionlibs.core.calendar.datetime.DateTime;
import io.github.orionlibs.core.calendar.time.Time;
import io.github.orionlibs.core.web.service.cloud.aws.rds.AWSRDSCredentials;
import io.github.orionlibs.core.web.service.cloud.aws.rds.AWSRDSDetailsModel;
import io.github.orionlibs.core.web.service.cloud.aws.rds.AWSRDSInstanceDetailsModel;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GetAWSRDSInstanceDetailsTask extends Orion
{
    public static AWSRDSDetailsModel run(ClientConfiguration clientConfiguration)
    {
        AWSRDSCredentials credentials = AWSRDSCredentials.populate(clientConfiguration);
        AWSRDSDetailsModel allDetailsModel = new AWSRDSDetailsModel();
        DescribeAccountAttributesResult accountAttributes = credentials.getClient().describeAccountAttributes();
        long numberOfInstances = accountAttributes.getAccountQuotas()
                        .stream()
                        .filter(quota -> "DBInstances".equals(quota.getAccountQuotaName()))
                        .collect(Collectors.toList())
                        .get(0)
                        .getUsed();
        allDetailsModel.setNumberOfInstances(numberOfInstances);
        DescribeDBInstancesResult databaseInstances = credentials.getClient().describeDBInstances();
        List<DBInstance> instances = databaseInstances.getDBInstances();
        List<AWSRDSInstanceDetailsModel> instancesDetails = new ArrayList<>();

        for(DBInstance instance : instances)
        {
            java.util.Date instanceCreationDateTime = instance.getInstanceCreateTime();
            Date date = Date.of(instanceCreationDateTime.getYear() + 1900, instanceCreationDateTime.getMonth() + 1, instanceCreationDateTime.getDate());
            Time time = Time.of(instanceCreationDateTime.getHours(), instanceCreationDateTime.getMinutes(), instanceCreationDateTime.getSeconds());
            DateTime instanceCreationDateTimeTemp = DateTime.of(date, time);
            AWSRDSInstanceDetailsModel model = AWSRDSInstanceDetailsModel.builder()
                            .storageCapacityInGigaBytes(instance.getAllocatedStorage())
                            .availabilityZone(instance.getAvailabilityZone())
                            .DBInstanceServerType(instance.getDBInstanceClass())
                            .DBInstanceID(instance.getDBInstanceIdentifier())
                            .DBInstanceStatus(instance.getDBInstanceStatus())
                            .connectionURL(instance.getEndpoint().getAddress())
                            .databaseEngineName(instance.getEngine())
                            .databaseEngineVersion(instance.getEngineVersion())
                            .databaseCreationDateTime(instanceCreationDateTimeTemp)
                            .build();
            instancesDetails.add(model);
        }

        allDetailsModel.setInstancesDetails(instancesDetails);
        credentials.getClient().shutdown();
        return allDetailsModel;
    }
}