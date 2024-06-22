package io.github.orionlibs.core.logger.data_access;

import io.github.orionlibs.core.abstraction.OrionModel;
import io.github.orionlibs.core.calendar.SQLTimestamp;
import io.github.orionlibs.core.data.source.database.IgnoreForORM;
import io.github.orionlibs.core.object.CloningService;
import io.github.orionlibs.core.security.annotations.DecodeBase64ForString;
import io.github.orionlibs.core.security.annotations.EncodeBase64ForString;
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
public class OrionErrorLogModel implements OrionModel
{
    @IgnoreForORM
    private long errorLogID;
    private String operationID;
    private String userID;
    private String IPAddress;
    @EncodeBase64ForString
    @DecodeBase64ForString
    private String errorMessage;
    private String errorType;
    private String logDate;
    private SQLTimestamp logDateTime;
    private String comment;
    private SQLTimestamp lastUpdateDateTime;
    private Boolean isBeingInvestigated;
    private Boolean hasBeingInvestigated;
    private Boolean isBeingIgnored;


    public static OrionErrorLogModel of()
    {
        return OrionErrorLogModel.builder().build();
    }


    public static OrionErrorLogModel of(String userID)
    {
        return OrionErrorLogModel.builder().userID(userID).build();
    }


    public String getLogDateTimeAsString()
    {
        return getLogDateTime().printInInternationalFormat();
    }


    @Override
    public OrionErrorLogModel clone()
    {
        return (OrionErrorLogModel)CloningService.clone(this);
    }


    @Override
    public OrionErrorLogModel getCopy()
    {
        return this.clone();
    }
}