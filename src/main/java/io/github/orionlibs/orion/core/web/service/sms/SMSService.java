package io.github.orionlibs.orion.core.web.service.sms;

import com.infobip.ApiCallback;
import com.infobip.ApiClient;
import com.infobip.ApiException;
import com.infobip.ApiKey;
import com.infobip.BaseUrl;
import com.infobip.api.SmsApi;
import com.infobip.model.SmsAdvancedTextualRequest;
import com.infobip.model.SmsDestination;
import com.infobip.model.SmsResponse;
import com.infobip.model.SmsTextualMessage;
import io.github.orionlibs.orion.core.abstraction.OrionService;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SMSService extends OrionService
{
    public static void sendSMS(String phoneNumber, String message)
    {
        SMSProviderCredentials credentials = SMSProviderCredentials.populate();
        ApiClient apiClient = ApiClient.forApiKey(ApiKey.from(credentials.getApiKey()))
                        .withBaseUrl(BaseUrl.from(credentials.getBaseURL()))
                        .build();
        SmsApi smsApi = new SmsApi(apiClient);
        var smsMessage = new SmsTextualMessage()
                        .from(credentials.getSenderName())
                        .addDestinationsItem(new SmsDestination().to(phoneNumber))
                        .text(message);
        var smsMessageRequest = new SmsAdvancedTextualRequest()
                        .messages(Collections.singletonList(smsMessage));
        var smsResponse = smsApi.sendSmsMessage(smsMessageRequest).executeAsync(new ApiCallback<>()
        {
            @Override
            public void onSuccess(SmsResponse result, int responseStatusCode, Map<String, List<String>> responseHeaders)
            {
                //update DB
            }


            @Override
            public void onFailure(ApiException exception, int responseStatusCode, Map<String, List<String>> responseHeaders)
            {
                //update DB
            }
        });
    }
}