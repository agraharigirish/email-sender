package com.example.sendEmail.emailsend.service;

import com.example.sendEmail.emailsend.object.EmailDTO;

import java.io.File;

public interface EmailService {

    //send email to single person
    void sendEmail(EmailDTO emailDTO);

    //send email to multiple person

    void sendEmail(String []to,String subject,String message);

    //send email to html content
    void sendHtmlContent(String to ,String subject, String htmlCOntent);

    //send email to file
    void  sendFile(String to , String subject, String message, File file);
}
