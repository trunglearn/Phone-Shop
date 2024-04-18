package helpers;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class SendMail {

    public static void sendEmail(String recipient, String senderEmail, String senderPassword) throws MessagingException {
        // Cài đặt các thuộc tính
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.starttls.enable", "true");

        // Tạo phiên làm việc với SMTP server
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        // Tạo email
        Message message = prepareMessage(session, senderEmail, recipient);

        // Gửi email
        Transport.send(message);
        System.out.println("Message sent successfully");
    }

    private static Message prepareMessage(Session session, String email, String recipient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("Test Email from Java App");

            // Explicitly set content type to text/plain and charset to UTF-8
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent("Hello, this is a test email from my Java application(7/3/2024).", "text/plain; charset=utf-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);
            
            return message;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        // Thay thế bằng email người gửi và mật khẩu
        String senderEmail = "trung12082003@gmail.com";
        final String password = "kjjo licc xuno jbxq";

        // Thay thế bằng email người nhận
        String recipient = "trung20030812@gmail.com";

        try {
            sendEmail(recipient, senderEmail, password);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
