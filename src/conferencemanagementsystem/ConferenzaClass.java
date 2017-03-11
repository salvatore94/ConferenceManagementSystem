/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conferencemanagementsystem;

import java.util.Date;

/**
 *
 * @author salvatore
 */
public class ConferenzaClass {
    private String nome;
    private String tema;
    private int numeroArticoli;
    
    private Date inizo;
    private Date fine;

    private Date scadenzaSottomissioneArticoli;
    private Date scadenzaReview;
    private Date scadenzaSottomissioneCorretti;
    
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void setNumeroArticoli(int numeroArticoli) {
        this.numeroArticoli = numeroArticoli;
    }

    public void setInizo(Date inizo) {
        this.inizo = inizo;
    }

    public void setFine(Date fine) {
        this.fine = fine;
    }
    
    public void setScadenzaSottomissioneArticoli(Date scadenzaSottomissioneArticoli) {
        this.scadenzaSottomissioneArticoli = scadenzaSottomissioneArticoli;
    }

    public void setScadenzaReview(Date scadenzaReview) {
        this.scadenzaReview = scadenzaReview;
    }

    public void setScadenzaSottomissioneCorretti(Date scadenzaSottomissioneCorretti) {
        this.scadenzaSottomissioneCorretti = scadenzaSottomissioneCorretti;
    }

    public String getNome() {
        return nome;
    }

    public String getTema() {
        return tema;
    }

    public int getNumeroArticoli() {
        return numeroArticoli;
    }

    public Date getInizo() {
        return inizo;
    }

    public Date getFine() {
        return fine;
    }
    
    public Date getScadenzaSottomissioneArticoli() {
        return scadenzaSottomissioneArticoli;
    }

    public Date getScadenzaReview() {
        return scadenzaReview;
    }

    public Date getScadenzaSottomissioneCorretti() {
        return scadenzaSottomissioneCorretti;
    }
    
}
