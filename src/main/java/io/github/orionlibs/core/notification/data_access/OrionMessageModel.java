package io.github.orionlibs.core.notification.data_access;

import io.github.orionlibs.core.abstraction.OrionModel;
import io.github.orionlibs.core.calendar.SQLTimestamp;
import io.github.orionlibs.core.object.CloningService;
import io.github.orionlibs.core.security.annotations.DecodeBase64ForString;
import io.github.orionlibs.core.security.annotations.DecodeXSS;
import io.github.orionlibs.core.security.annotations.DecryptAsData;
import io.github.orionlibs.core.security.annotations.EncodeBase64ForString;
import io.github.orionlibs.core.security.annotations.EncodeXSS;
import io.github.orionlibs.core.security.annotations.EncryptAsData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// This class does not extend OrionModel, because that inheritance does not
// allow
// the use of Lombok's @SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class OrionMessageModel implements OrionModel
{
    private String messageID;
    private String userID;
    @EncryptAsData
    @DecryptAsData
    private String fullName;
    @EncryptAsData
    @DecryptAsData
    private String emailAddress;
    @EncryptAsData
    @DecryptAsData
    private String phoneNumber;
    @EncodeXSS
    @EncodeBase64ForString
    @DecodeXSS
    @DecodeBase64ForString
    private String message;
    private SQLTimestamp messageDateTime;
    private Boolean hasBeenRead;


    public static OrionMessageModel of()
    {
        return OrionMessageModel.builder().build();
    }


    public static OrionMessageModel of(String messageID)
    {
        return OrionMessageModel.builder().messageID(messageID).build();
    }


    @Override
    public OrionMessageModel clone()
    {
        return (OrionMessageModel)CloningService.clone(this);
    }


    @Override
    public OrionMessageModel getCopy()
    {
        return this.clone();
    }
}