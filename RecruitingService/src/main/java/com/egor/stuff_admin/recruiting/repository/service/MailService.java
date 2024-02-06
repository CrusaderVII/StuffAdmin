package com.egor.stuff_admin.recruiting.repository.service;

import jakarta.mail.*;
import com.egor.stuff_admin.recruiting.model.Candidate;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;

@Service
public class MailService {

    private final String userName = "egor.chervonikov@yandex.ru";
    private final String password = "wftjdasnfwaqhlow";
    private final String host = "smtp.yandex.ru";
    private final int port = 465;

    public MailService() {
    }

    @Async
    public void sendMessage(List<Candidate> candidates) {
        String department = candidates.get(0).getDepartment();

        Properties properties = new Properties();

        properties.put("mail.host", host);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        });

        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(userName));
            message.setSubject("Free position in "+department);
            message.setText("Hi! We glad to inform you,"
                    +" that we have free position in "+department+" department. If you are interested in it,"
                    +" please, contact us back using this email.");

            InternetAddress[] addresses = new InternetAddress[candidates.size()];
            for (int i = 0; i< candidates.size(); i++) {
                addresses[i] = new InternetAddress(candidates.get(i).getEmail());
            }

            message.setRecipients(Message.RecipientType.TO, addresses);

            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}