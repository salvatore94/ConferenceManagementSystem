/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conferencemanagementsystem.Utils;

import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author salvatore
 */

public class EmailClass {
    private String mittente;
    private String destinatario;
    private String oggetto;
    private String corpo;
    private String smtpHost = "smtp.gmail.com";
    
    private final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
    
    public EmailClass (String mittente, String destinatario, String oggetto, String corpo) {
        this.mittente = mittente;
        this.destinatario = destinatario;
        this.oggetto = oggetto;
        this.corpo = corpo;
        
    }
    
    
    public void inviaEmail() throws MessagingException {
        Properties proprieta = System.getProperties ();
        proprieta.setProperty("mail.smtp.host", smtpHost);
        proprieta.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        proprieta.setProperty("mail.smtp.socketFactory.fallback", "false");
        proprieta.setProperty("mail.smtp.port", "465");
        proprieta.setProperty("mail.smtp.socketFactory.port", "465");
        
        proprieta.put("mail.store.protocol", "pop3");
        proprieta.put("mail.transport.protocol", "smtp");
        proprieta.put("mail.smtp.auth", "true");
        proprieta.put("mail.debug", "true");
        
        final String username = "firacms@gmail.com";//
        final String password = "Conference";
        
        Session sessione = Session.getDefaultInstance(proprieta, new Authenticator(){
                             protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(username, password);
                             }});
        Message messaggio = new MimeMessage (sessione);
        
        try {
            messaggio.setFrom (new InternetAddress ("firacms@gmail.com"));
            messaggio.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario, false));
            messaggio.setSubject (oggetto);
            messaggio.setText (corpo);
            messaggio.setSentDate(new Date());
            
            
            Transport.send (messaggio);
        } catch (AddressException ex) {
            Logger.getLogger(EmailClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getMittente() {
        return mittente;
    }

    public void setMittente(String mittente) {
        this.mittente = mittente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getOggetto() {
        return oggetto;
    }

    public void setOggetto(String oggetto) {
        this.oggetto = oggetto;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public String getSmtpHost() {
        return smtpHost;
    }

    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }


}
