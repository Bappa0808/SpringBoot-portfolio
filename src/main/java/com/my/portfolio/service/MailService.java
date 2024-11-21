package com.my.portfolio.service;

import com.my.portfolio.model.ContactForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendContactMail(ContactForm contactForm) throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("hajhaha225@gmail.com");
        message.setSubject("New Contact Form Submission");
        message.setText(
                "Name: " + contactForm.getName() + "\n" +
                        "Email: " + contactForm.getEmail() + "\n" +
                        "Phone: " + contactForm.getPhone() + "\n" +
                        "Message: " + contactForm.getOpinion()
        );

        // Send the email
        javaMailSender.send(message);
    }
}
