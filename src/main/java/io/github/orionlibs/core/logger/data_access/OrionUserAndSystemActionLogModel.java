package io.github.orionlibs.core.logger.data_access;

import io.github.orionlibs.core.abstraction.OrionModel;
import io.github.orionlibs.core.calendar.SQLTimestamp;
import io.github.orionlibs.core.data.source.database.IgnoreForORM;
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
public class OrionUserAndSystemActionLogModel implements OrionModel
{
    @IgnoreForORM
    private long userAndSystemActionLogID;
    private String operationID;
    private String actorType;
    private String actionType;
    private String userID;
    private String IPAddress;
    private String actionDescription;
    private String logDate;
    private SQLTimestamp logDateTime;


    public static OrionUserAndSystemActionLogModel of()
    {
        return OrionUserAndSystemActionLogModel.builder().build();
    }


    public static OrionUserAndSystemActionLogModel of(long userAndSystemActionLogID)
    {
        return OrionUserAndSystemActionLogModel.builder().userAndSystemActionLogID(userAndSystemActionLogID).build();
    }


    public String getLogDateTimeAsString()
    {
        return getLogDateTime().printInInternationalFormat();
    }


    @Override
    public OrionUserAndSystemActionLogModel clone()
    {
        return (OrionUserAndSystemActionLogModel)CloningService.clone(this);
    }


    @Override
    public OrionUserAndSystemActionLogModel getCopy()
    {
        return this.clone();
    }
}