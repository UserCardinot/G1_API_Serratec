package br.com.grupo1.gp1_api.security.services;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
	
	@Autowired
	public JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String emailUsername;
	
	@Value("${spring.mail.host}")
	private String emailServerHost;
	
	@Value("${spring.mail.port}")
	private Integer emailServerPort;
	
	@Value("${spring.mail.password}")
	private String emailPassword;
	
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setUsername(emailUsername);
		mailSender.setHost(emailServerHost);
		mailSender.setPort(emailServerPort);
		mailSender.setPassword(emailPassword);
		
		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.starttls.enable","true");
		return mailSender;
	}
	
	public String emailTeste() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("igorppandre@gmail.com");
		message.setSubject("Teste email");
		message.setText("Testando aplicaçao de email");
		
		try {
			javaMailSender.send(message);
			return "Enviado com Sucesso";
			
		}catch(Exception e) {
			return "Erro de email:" + e.getMessage();
		}
	}

}
