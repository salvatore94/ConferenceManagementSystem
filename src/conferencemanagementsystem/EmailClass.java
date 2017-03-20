/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conferencemanagementsystem;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;


/**
 *
 * @author salvatore
 */

public class EmailClass {
    private String mittente;
    private String destinatario;
    private String oggetto;
    private String corpo;
    private String smtpHost = "out.virgilio.it";

    public EmailClass (String mittente, String destinatario, String oggetto, String corpo) {
        this.mittente = mittente;
        this.destinatario = destinatario;
        this.oggetto = oggetto;
        this.corpo = corpo;
        
    }
    
    
    public void inviaEmail() throws MessagingException {
        Properties proprieta = System.getProperties ();
        proprieta.put("out.virgilio.it", smtpHost);
        
        Session sessione = Session.getDefaultInstance(proprieta, null);
        MimeMessage messaggio = new MimeMessage (sessione);
        
        try {
            messaggio.setFrom (new InternetAddress (mittente));
            messaggio.addRecipient (Message.RecipientType.TO, new InternetAddress (destinatario));
            messaggio.setSubject (oggetto);
            messaggio.setText (corpo);
            
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
