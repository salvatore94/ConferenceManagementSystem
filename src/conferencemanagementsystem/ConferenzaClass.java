/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conferencemanagementsystem;

import java.time.*;

/**
 *
 * @author salvatore
 */
public class ConferenzaClass {
    private int id;
    private int idChair;
    private String nome;
    private String tema;
    private String luogo;
    private int numeroArticoli;
    
    private LocalDate inizo;
    private LocalDate fine;

    private LocalDate scadenzaSottomissioneArticoli;
    private LocalDate scadenzaReview;
    private LocalDate scadenzaSottomissioneCorretti;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }
    
    
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void setNumeroArticoli(int numeroArticoli) {
        this.numeroArticoli = numeroArticoli;
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

    public int getIdChair() {
        return idChair;
    }

    public void setIdChair(int idChair) {
        this.idChair = idChair;
    }

    public LocalDate getInizio() {
        return inizo;
    }

    public void setInizo(LocalDate inizo) {
        this.inizo = inizo;
    }

    public LocalDate getFine() {
        return fine;
    }

    public void setFine(LocalDate fine) {
        this.fine = fine;
    }

    public LocalDate getScadenzaSottomissioneArticoli() {
        return scadenzaSottomissioneArticoli;
    }

    public void setScadenzaSottomissioneArticoli(LocalDate scadenzaSottomissioneArticoli) {
        this.scadenzaSottomissioneArticoli = scadenzaSottomissioneArticoli;
    }

    public LocalDate getScadenzaReview() {
        return scadenzaReview;
    }

    public void setScadenzaReview(LocalDate scadenzaReview) {
        this.scadenzaReview = scadenzaReview;
    }

    public LocalDate getScadenzaSottomissioneCorretti() {
        return scadenzaSottomissioneCorretti;
    }

    public void setScadenzaSottomissioneCorretti(LocalDate scadenzaSottomissioneCorretti) {
        this.scadenzaSottomissioneCorretti = scadenzaSottomissioneCorretti;
    }

    
}
