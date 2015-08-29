import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by jason on 15-08-21.
 */
public class EmailConnection {
    private String username;
    private String password;
    private static Session session;
    public EmailConnection() {
        username = "XXX";
        password = "XXX";
        session = null;
    }
    private void emailSetUp() {
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
    }

    public void sendemail(String text, String receiver) {
        if (receiver == "N/A") {
            main.newFrame.textArea.append("No Email was sent!");
        } else {
            try {
                this.emailSetUp();

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(receiver));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(receiver));
                message.setSubject("NO-REPLY MESSAGE ABOUT YOUR COURSE!!");
                message.setText(text);

                Transport.send(message);

                main.newFrame.textArea.append("Emailed at" + main.getcurrenttime() + "\n");

            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }
    }

