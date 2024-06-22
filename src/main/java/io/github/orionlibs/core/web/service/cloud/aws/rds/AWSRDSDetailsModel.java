package io.github.orionlibs.core.web.service.cloud.aws.rds;

import io.github.orionlibs.core.abstraction.OrionModel;
import io.github.orionlibs.core.object.CloningService;
import java.util.List;
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
public class AWSRDSDetailsModel implements OrionModel
{
    private long numberOfInstances;
    private List<AWSRDSInstanceDetailsModel> instancesDetails;


    public static AWSRDSDetailsModel of()
    {
        return AWSRDSDetailsModel.builder().build();
    }


    @Override
    public AWSRDSDetailsModel clone()
    {
        return (AWSRDSDetailsModel)CloningService.clone(this);
    }


    @Override
    public AWSRDSDetailsModel getCopy()
    {
        return this.clone();
    }
}