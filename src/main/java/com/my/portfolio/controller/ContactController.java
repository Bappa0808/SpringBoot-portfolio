package com.my.portfolio.controller;

import com.my.portfolio.model.ContactForm;
import com.my.portfolio.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private MailService mailService;

    @GetMapping
    public String showContactForm(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "contactForm";
    }

    @PostMapping
    public String sendContactMail(@ModelAttribute ContactForm contactForm, Model model) {
        try {
            // Delegate mail sending to the service
            mailService.sendContactMail(contactForm);
            return "redirect:/success";
        } catch (Exception e) {
            model.addAttribute("message", "Failed to send message: " + e.getMessage());
            return "contactForm";
        }
    }
}
