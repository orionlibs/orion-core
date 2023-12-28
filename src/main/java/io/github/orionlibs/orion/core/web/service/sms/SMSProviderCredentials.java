package io.github.orionlibs.orion.core.web.service.sms;

import io.github.orionlibs.orion.core.abstraction.Orion;
import io.github.orionlibs.orion.core.configuration.ConfigurationService;
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
public class SMSProviderCredentials extends Orion
{
    private String apiKey;
    private String baseURL;
    private String senderName;


    static SMSProviderCredentials populate()
    {
        return SMSProviderCredentials.builder()
                        .apiKey(ConfigurationService.getProp("sms.api.key"))
                        .baseURL(ConfigurationService.getProp("sms.base.url"))
                        .senderName(ConfigurationService.getProp("sms.sender.name"))
                        .build();
    }
}