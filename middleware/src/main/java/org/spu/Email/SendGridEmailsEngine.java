package org.spu.Email;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sendgrid.SendGrid;
import com.sendgrid.SendGridException;

@Service
public class SendGridEmailsEngine {
	@Autowired
	Properties prop;
	InputStream input = null;

	public String sendEmail(String[] v_receipient_email, String subject, String content, File attachment,
			String attachmentName) throws Exception {

		String filename = "application.properties";
		input = getClass().getClassLoader().getResourceAsStream(filename);
		try {
			prop.load(input);
		} catch (IOException e2) {

			e2.printStackTrace();
			return "Email NOT Sent.  : Error loading application.properties " + e2.getMessage();
		}

		String sendgridApiKey = prop.getProperty("SENDGRID_API_KEY");
		String defaultSenderEmail = prop.getProperty("DEFAULT_SENDER_EMAIL");

		SendGrid sendgrid = new SendGrid(sendgridApiKey);
		SendGrid.Email email = new SendGrid.Email();

		email.addTo(v_receipient_email);
		email.setFrom(defaultSenderEmail);
		email.setSubject(subject);

		email.setHtml(content);

		if (attachment != null) {

			try {
				email.addAttachment(attachmentName, attachment);
			} catch (IOException e1) {
				e1.printStackTrace();
				throw new Exception(e1.getMessage());
			}

		}

		try {
			SendGrid.Response response = sendgrid.send(email);

		} catch (SendGridException e) {

			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return "Email Sent Successfully to  " + v_receipient_email;

	}
}
