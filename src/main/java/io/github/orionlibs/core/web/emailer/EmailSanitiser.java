package io.github.orionlibs.core.web.emailer;

import io.github.orionlibs.core.abstraction.Orion;
import io.github.orionlibs.core.content.MIMEType;

class EmailSanitiser extends Orion
{
    static void sanitise(EmailData emailData)
    {

        if(emailData.isReplaceNewLineWithBreakLine() && MIMEType.HTML_UTF8.equals(emailData.getMessageMIMEType()))
        {
            emailData.setEmailMessage(emailData.getEmailMessage().replace("\n", "<br>"));
        }

    }
}