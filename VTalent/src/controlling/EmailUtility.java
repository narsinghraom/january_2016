package controlling;
import java.util.Date;
import java.util.Properties;
 

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class EmailUtility {
	
	public static void sendEmail(String host, String port,
            final String userName, final String password, String candidate_Name,
            String candidate_Email, String candidate_MobileNo, String candidate_Technology) throws AddressException,
            MessagingException {
 
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
 
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
 
        Session session = Session.getInstance(properties, auth);
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
        String message_send="Name = "+candidate_Name + "\n" + "E-Mail = " +candidate_Email + "\n" + "Mobil No = " +candidate_MobileNo + "\n" +"Technology = " +candidate_Technology;
 
        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(userName) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(candidate_Technology);
        msg.setSentDate(new Date());
        msg.setText(message_send);
 
        // sends the e-mail
        Transport.send(msg);
 
    }

}
