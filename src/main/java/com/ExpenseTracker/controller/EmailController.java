package com.ExpenseTracker.controller;
import com.ExpenseTracker.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EmailController {

        @Autowired
        private EmailService emailService;

    @GetMapping("/sendEmail")
    public String sendEmail(
            @RequestParam String toEmail,
            @RequestParam String subject,
            @RequestParam String body) {
        emailService.sendSimpleEmail(toEmail, subject, body);
        return "Email sent successfully";
    }
}
