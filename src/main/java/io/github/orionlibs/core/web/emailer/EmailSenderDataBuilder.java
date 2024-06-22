package io.github.orionlibs.core.web.emailer;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.configuration.ConfigurationService;
import jakarta.mail.NoSuchProviderException;
import jakarta.mail.Session;
import jakarta.mail.internet.MimeMessage;

class EmailSenderDataBuilder extends Orion
{
    static EmailSenderData build(Session emailSession, MimeMessage messageToSend) throws NoSuchProviderException
    {
        return EmailSenderData.builder()
                        .transport(emailSession.getTransport("smtp"))
                        .messageToSend(messageToSend)
                        .SMTPHost(ConfigurationService.getProp("email.administrator.email.address.smtp.host"))
                        .emailAccountUsername(ConfigurationService.getProp("email.administrator.email.address.username"))
                        .emailAccountPassword(ConfigurationService.getProp("email.administrator.email.address.password"))
                        .build();
    }
}