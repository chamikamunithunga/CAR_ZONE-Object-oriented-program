package Controller;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSendCustomer {
    public static void sendMail(String customerMail) {

        // Recipient's email ID needs to be mentioned.
        String to = customerMail;

        // Sender's email ID needs to be mentioned
        String from = "car.zone008@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(from, "phtknygiuselcunn");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Car Care Order status update !");

            message.setContent("<h2>Your Order has been completed!</h2>"


                            + "<h3>Please contact Car Care to get more details..</h3>",
                    "text/html");

            // Send message
            Transport.send(message);
//            JOptionPane.showMessageDialog(this, "Message Sent Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

}
