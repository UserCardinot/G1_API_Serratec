package br.com.grupo1.gp1_api.security.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

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
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		return mailSender;
	}

	public String emailPersonalizadoPedido() throws IOException {
		LocalDateTime time = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

		MimeMessage message = javaMailSender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setSubject("Pedido Realizado com Sucesso! APIGAMES - " + time.format(format));
			helper.setTo("lucascardinotdasilva@gmail.com");
			helper.setFrom("lucascardinot2000@gmail.com");

			Path path = Paths.get(new ClassPathResource("templates/index.html").getURI());
			String htmlContent;
			try {
				htmlContent = Files.readString(path);
			} catch (IOException e) {
				return "Erro ao ler o conteúdo do email\n\n" + e.getMessage();
			}

			helper.setText(htmlContent, true);
			javaMailSender.send(message);
			return "Email enviado com sucesso";
		} catch (MessagingException e) {
			return "Erro ao enviar email\n\n" + e.getMessage();
		}
	}

}
