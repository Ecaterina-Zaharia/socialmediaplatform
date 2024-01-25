package controller;

import entities.EmailTemplate;
import service.EmailService;
import entities.EmailTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.EmailService;

@RestController
@RequestMapping("/notification")
@Slf4j
public class TextEmailController {

    private final EmailService emailService;

    public TextEmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping
    public ResponseEntity<String> getNotification() {
        String notification = "Hello, this is a notification!";
        return ResponseEntity.ok(notification);
    }


    @PostMapping("/textemail")
    public ResponseEntity<String> sendEmail(@RequestBody EmailTemplate emailTemplate) {
        try {
            log.info("Sending Simple Text Email...");
            emailService.sendTextEmail(emailTemplate);
            return ResponseEntity.ok("Email Sent");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error in sending email: " + ex.getMessage());
        }
    }
}
