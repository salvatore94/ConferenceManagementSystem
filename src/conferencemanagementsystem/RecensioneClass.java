/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conferencemanagementsystem;

/**
 *
 * @author Salvatore
 */
public class RecensioneClass {
    private int idRecensione;
    private int idArticolo;
    private int idRecensore;
    private double votazione;
    private String commento;
    private String commentoRiservato;

    public int getIdRecensione() {
        return idRecensione;
    }

    public int getIdRecensore() {
        return idRecensore;
    }

    public void setIdRecensore(int idRecensore) {
        this.idRecensore = idRecensore;
    }

    public void setIdRecensione(int idRecensione) {
        this.idRecensione = idRecensione;
    }

    public int getIdArticolo() {
        return idArticolo;
    }

    public void setIdArticolo(int idArticolo) {
        this.idArticolo = idArticolo;
    }

    public double getVotazione() {
        return votazione;
    }

    public void setVotazione(double votazione) {
        this.votazione = votazione;
    }

    public String getCommento() {
        return commento;
    }

    public void setCommento(String commento) {
        this.commento = commento;
    }

    public String getCommentoRiservato() {
        return commentoRiservato;
    }

    public void setCommentoRiservato(String commentoRiservato) {
        this.commentoRiservato = commentoRiservato;
    }
    
    
}
