package service;

import entities.EmailTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Value("&{email.address}")
    private  String attachedEmailAdr;

    @Async
    public void sendTextEmail(EmailTemplate emailTemplate){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailTemplate.getSendTo());
        message.setSubject(emailTemplate.getSubject());
        message.setText(emailTemplate.getBody());

        mailSender.send(message);
    }
}
