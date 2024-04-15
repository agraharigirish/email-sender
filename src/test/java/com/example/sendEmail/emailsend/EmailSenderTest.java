/*
package com.example.sendEmail.emailsend;

import com.example.sendEmail.emailsend.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
public class EmailSenderTest {

    @Autowired
    private EmailService emailService;

    @Test
    void sendEmailTest(){
        System.out.println("Sending Emaail ....");
        String htmlContent = ""
                +"<h1 style='color:red; border: 1px solid red;'>Welcome to Sending mail with HTML Content</h1>"
                +"";
        emailService.sendHtmlContent("agraharigirish@gmail.com","HTML Spring Boot App Test",htmlContent);

    }

    @Test
    void sendEmailTest1(){
        System.out.println("Sending Emaail ....");

        emailService.sendFile("agraharigirish@gmail.com","File Spring Boot App Test","File Sending test using Mail",new File("E:\\learning projects\\emailsend\\src\\main\\resources\\static\\Docker Commands.txt"));

    }
}
*/
