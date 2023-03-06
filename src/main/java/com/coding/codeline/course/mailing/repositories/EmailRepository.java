package com.coding.codeline.course.mailing.repositories;

import com.coding.codeline.course.mailing.models.EmailDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository {

    String sendSimpleMailToMany(EmailDetails emailDetails);
    String sendSimpleMail(EmailDetails emailDetails);
    String sendMailWithAttachmentToMany(EmailDetails emailDetails);
    String sendMailWithAttachment(EmailDetails emailDetails);
}
