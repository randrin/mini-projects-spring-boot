package com.randrin.sending.email.attachment;

import com.randrin.sending.email.attachment.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class SendingEmailAttachmentApplication {

	private static final String toEmail = "dasgivemoi@gmail.com";

	@Autowired
	private SendEmailService sendEmailService;

	public static void main(String[] args) {
		SpringApplication.run(SendingEmailAttachmentApplication.class, args);
	}

//	@EventListener(ApplicationReadyEvent.class)
//	public void triggerSimpleEmail() {
//		sendEmailService.sendSimpleEmail(
//				toEmail,
//				"This is the simple body sending message",
//				"This is the simple subject sending message");
//	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerAttachmentEmail() throws MessagingException {
		sendEmailService.sendEmailWithAttachment(
				toEmail,
				"This is the attachment body sending message",
				"This is the attachment subject sending message",
				"C:\\Users\\Randrin\\Desktop\\ENEXSE IT\\Barometre-des-TJM-2021-1.pdf");
	}
}
