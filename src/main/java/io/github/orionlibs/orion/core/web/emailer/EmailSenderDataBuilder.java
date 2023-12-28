package io.github.orionlibs.orion.core.web.emailer;

import io.github.orionlibs.orion.core.abstraction.Orion;
import io.github.orionlibs.orion.core.configuration.ConfigurationService;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

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