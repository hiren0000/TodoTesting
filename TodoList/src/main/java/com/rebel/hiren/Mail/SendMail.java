package com.rebel.hiren.Mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;

public class SendMail
{
	private String userEmail;
	private String hash;
	private String userEmailFor;
	private int userId;
	
	public SendMail(String userEmail, String hash)
	{
		this.userEmail = userEmail;
		this.hash = hash;
	}
	
	public SendMail(String userEmailFor, int userId)
	
	{
		this.userEmailFor = userEmailFor;
		this.userId = userId;
		
	}
	
	
	public void sendMail()
	{
		//sender's email
		final String email = "";
		final String password = "";
		
		String host = "smtp.gmail.com";
		
		Properties properties = new Properties();
		
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.ssl.enable", "true");
		
		
		
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, password);
			}
			
			
		});
		
		try {
				MimeMessage msg = new MimeMessage(session);
				
				msg.setFrom(new InternetAddress(email));
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));
				msg.setSubject("Verification link in Hiren's first website...");
				msg.setText("Click here :: "+"http://localhost:8080/TodoList/AccountActivation?key1="+userEmail+"&key2="+hash);
			
				Transport.send(msg);
			
		} catch (Exception e) {
			System.out.println("prb with mail clss"+ e);
		}
		
	}
	
	
	public void forgotPassword()
	{
		//sender's email
			String email = "";
			String password = "";
		
			String host = "smtp.gmail.com";
			
			Properties pro = new Properties();
			
			pro.setProperty("mail.smtp.host", host);
			pro.setProperty("mail.smtp.port", "465");
			pro.setProperty("mail.smtp.auth", "true");
			pro.setProperty("mail.smtp.ssl.enable", "true");
			
			
			Session session2 = Session.getDefaultInstance(pro, new Authenticator() {
				
				protected PasswordAuthentication getPasswordAuthentication()
				{
					return new PasswordAuthentication(email, password);
				}
				
				
			});
			
			
			try {
							
				MimeMessage mi = new MimeMessage(session2);
				mi.setFrom(new InternetAddress(email));
				mi.setRecipient(Message.RecipientType.TO, new InternetAddress(userEmailFor));
				mi.setSubject("Forgot Password Link :: )");				
				mi.setText("Click here to change your password :: "+"http://localhost:8080/TodoList/NewPassword.jsp?key1="+userId);
				mi.setDescription("please click above the button to change your password ::)");
				
				Transport.send(mi);
				
				
			} catch (Exception e) {
				System.err.println("sm prb wid forgot pass email"+ e);
			}
		
		
	}
		
	
	
}
