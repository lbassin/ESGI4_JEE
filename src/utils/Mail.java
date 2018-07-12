package utils;

import java.util.*;
import javax.mail.*;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.*;

public class Mail {

    public static void send(String emailTo, String emailObject, String emailMessage) {

        final String username = "breizhlink.java.esgi@gmail.com";
        final String password = "rootroot";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("breizhlink.java.esgi@no-reply.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(emailTo));
            message.setSubject(emailObject);
            message.setText(emailMessage);
            Transport.send(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
