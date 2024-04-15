package com.example.sendEmail.emailsend.service.impl;

import com.example.sendEmail.emailsend.object.EmailDTO;
import com.example.sendEmail.emailsend.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    private Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Override
    public void sendEmail(EmailDTO emailDTO) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(emailDTO.getTo());
        simpleMailMessage.setSubject(emailDTO.getSubject());
        simpleMailMessage.setText(emailDTO.getMessage());
        simpleMailMessage.setFrom(emailDTO.getFrom());

        javaMailSender.send(simpleMailMessage);
        logger.info("Mail Send Successfully.......");
    }

    @Override
    public void sendEmail(String[] to, String subject, String message) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("gargiagrahari2@gmail.com");
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setSentDate(Date.from(Instant.now()));
        mailMessage.setText(message);
        javaMailSender.send(mailMessage);

    }

    @Override
    public void sendHtmlContent(String to, String subject, String htmlCOntent) {

        MimeMessage mailMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mailMessage,true,"UTF-8");
            helper.setTo(to);
            helper.setFrom("gargiagrahari2@gmail.com");
            helper.setSubject(subject);
            helper.setText(htmlCOntent,true);
            javaMailSender.send(mailMessage);
            logger.info("Html Content Email has sent .... ");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void sendFile(String to, String subject, String message, File file) {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            helper.setFrom("gargiagrahari2@gmail.com");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(message);
            FileSystemResource fileSystemResource = new FileSystemResource(file);
            helper.addAttachment(fileSystemResource.getFilename(), file);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }


    }
}
