package org.spu.Email;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/spu-sam_cards_creation/send_grid_emails")
public class SendGridEmailsController {
	@Autowired
	SendGridEmailsEngine sendGridEmailsEngine;

	@RequestMapping(value = "/sendEmail", method = RequestMethod.POST, consumes = "multipart/form-data")
	public String sendEmail(@RequestParam String refNo, @RequestParam String refType,
			@RequestParam String[] v_receipient_email, @RequestParam String subject, @RequestParam String content,
			@RequestParam (required = false, value = "attachment") MultipartFile attachment,
			@RequestParam(required = false, value = "attachmentName") String attachmentName) throws Exception {

		File attachmentObj = attachment == null ? null : convertMultipartFiletoFile(attachment);

		return sendGridEmailsEngine.sendEmail(v_receipient_email, subject, content, attachmentObj, attachmentName);

	}

	public File convertMultipartFiletoFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		convFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}
}
