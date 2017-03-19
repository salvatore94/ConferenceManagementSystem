/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conferencemanagementsystem;

import java.time.LocalDate;

/**
 *
 * @author salvatore
 */
public class NotificaClass {
    private int idConferenza;
    private int idUtente;
    private int idArticolo;
    private String descrizione;
    private LocalDate data;

    public NotificaClass() {}

    public NotificaClass(int idConferenza, int idUtente, String descrizione) {
        this.idConferenza = idConferenza;
        this.idUtente = idUtente;
        this.descrizione = descrizione;
        this.data = LocalDate.now();
    }
    
    public NotificaClass(int idConferenza, int idUtente, int idArticolo, String descrizione) {
        this.idConferenza = idConferenza;
        this.idUtente = idUtente;
        this.idArticolo = idArticolo;
        this.descrizione = descrizione;
        this.data = LocalDate.now();
    }

    
    
    public int getIdConferenza() {
        return idConferenza;
    }

    public void setIdConferenza(int idConferenza) {
        this.idConferenza = idConferenza;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public int getIdArticolo() {
        return idArticolo;
    }

    public void setIdArticolo(int idArticolo) {
        this.idArticolo = idArticolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    
    
}
