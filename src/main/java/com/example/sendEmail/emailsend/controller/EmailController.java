package com.example.sendEmail.emailsend.controller;

import com.example.sendEmail.emailsend.object.EmailDTO;
import com.example.sendEmail.emailsend.service.impl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailServiceImpl emailService;

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailDTO emailDTO){

        emailService.sendEmail(emailDTO);
        return "Email Send Successfully.......";
    }
}
