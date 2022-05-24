package br.com.guilhermebehs.school.infra.recommendation;

import br.com.guilhermebehs.school.application.recommendation.SendRecommendationEmail;
import br.com.guilhermebehs.school.domain.student.Student;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;


public class SendRecommendationEmailWithJavaMail implements SendRecommendationEmail {

    @Override
    public void sendTo(Student recommendedStudent) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication()
                    {
                        return new PasswordAuthentication("seuemail@gmail.com",
                                "suasenha123");
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("seuemail@gmail.com"));
            //Remetente

            Address[] toStudent = InternetAddress
                    .parse(recommendedStudent.getEmail().getAddress());

            message.setRecipients(Message.RecipientType.TO, toStudent);
            message.setSubject("Indicação");//Assunto
            message.setText("Olá, "+recommendedStudent.getName()+".\nVocê foi indicado.");
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
