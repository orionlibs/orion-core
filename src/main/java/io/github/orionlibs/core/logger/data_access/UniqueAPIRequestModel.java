package io.github.orionlibs.core.logger.data_access;

import io.github.orionlibs.core.abstraction.OrionModel;
import io.github.orionlibs.core.calendar.SQLTimestamp;
import io.github.orionlibs.core.object.CloningService;
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
public class UniqueAPIRequestModel implements OrionModel
{
    private String requestID;
    private Long requestEpochInNanoseconds;
    private SQLTimestamp requestDateTime;
    private String status;
    private String userID;


    public static UniqueAPIRequestModel of()
    {
        return UniqueAPIRequestModel.builder().build();
    }


    public static UniqueAPIRequestModel of(String requestID)
    {
        return UniqueAPIRequestModel.builder().requestID(requestID).build();
    }


    public static UniqueAPIRequestModel ofUserID(String userID)
    {
        return UniqueAPIRequestModel.builder().userID(userID).build();
    }


    @Override
    public UniqueAPIRequestModel clone()
    {
        return (UniqueAPIRequestModel)CloningService.clone(this);
    }


    @Override
    public UniqueAPIRequestModel getCopy()
    {
        return this.clone();
    }
}