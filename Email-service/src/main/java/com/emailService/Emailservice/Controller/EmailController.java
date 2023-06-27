package com.emailService.Emailservice.Controller;

import com.emailService.Emailservice.Model.mailInfo;
import com.emailService.Emailservice.Service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class EmailController {
    @Autowired
    private EmailService sender;

    @PostMapping("/email")
    public void triggerMail(@RequestBody mailInfo mailInfo) throws MessagingException {
        String role=mailInfo.getRole().substring(5);

        sender.sendRegisterationEmail(mailInfo.getEmail(),
                "Congratulations "+mailInfo.getUserName()+" !  You have successfully registered to Assessment Portal as a "+role+" . Your UserId is "+mailInfo.getId(), "Registration confirmation");

    }

}
