package com.EmailSendingwithJava.EmailSending.Controller;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class EmailController {

    private final JavaMailSender mailSender;

    public EmailController(JavaMailSender mailSender){
        this.mailSender=mailSender;
    }

    @RequestMapping("/send-email")
    public String sendEmail(){
        try {
            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom("moviesexplaing@gmail.com");
            message.setTo("moviesexplaing@gmail.com");
            message.setSubject("Simple test mail for movies explaing channel ");
            message.setText("this is a simple email body for mt first email !");


            mailSender.send(message);
            return "Success!";

        } catch (Exception e) {
            return e.getMessage();
        }

    }

    @RequestMapping("/send-email-with-attachment")
    public String sendEmailwithattachment(){
        try {
            MimeMessage message = mailSender.createMimeMessage( );
            MimeMessageHelper helper = new MimeMessageHelper(message, true);



            helper.setFrom("moviesexplaing@gmail.com");
            helper.setTo("moviesexplaing@gmail.com");
            helper.setSubject("Simple test mail for movies explaing channel ");
            helper.setText("this is a simple email body for mt first email !");

            helper.addAttachment("دار المعرفة.jpeg",new File("//Users//sinkusingh//Downloads//دار المعرفة.jpeg"));


            mailSender.send(message);
            return "Success!";

        } catch (Exception e) {
            return e.getMessage();
        }

    }


    @RequestMapping("/user")
    public String user(){
        return "say hello";
    }

}
