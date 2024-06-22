package io.github.orionlibs.core.web.emailer;

import io.github.orionlibs.core.abstraction.Orion;
import jakarta.mail.Session;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
class EmailMessageDependencies extends Orion
{
    private Session emailSession;
    private String emailSender;
    private String emailSenderName;
    private String emailRecipient;
    private String emailSubject;
    private String emailMessage;
    private String messageMIMEType;
    private boolean hasAttachment;
    private boolean loadAttachmentFromFileSystem;
    private String attachmentFileURL;
    private String attachmentFileName;
}