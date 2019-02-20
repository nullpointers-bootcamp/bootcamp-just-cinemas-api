package spicinemas.api.config;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Component
public class EmailService {

    public boolean sendMail(String toAddress, String subject, String body) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", "10.134.20.38");
            props.put("mail.smtp.port", "25");
            props.put("mail.debug", "true");
            Session session = Session.getDefaultInstance(props);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("NULL@nullpointers.com"));
            message.setRecipient(RecipientType.TO, new InternetAddress(toAddress));
            message.setSubject(subject);
            message.setText(body, "UTF-8"); // as "text/plain"
            message.setSentDate(new Date());
            Transport.send(message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
