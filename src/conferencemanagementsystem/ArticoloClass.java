/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conferencemanagementsystem;

/**
 *
 * @author salvatore
 */
public class ArticoloClass {
    private int idArticolo;
    private int idAutore;
    private String titolo;
    private String tema;
    private String file;
    private String file_rivisto;
    private boolean ammesso;

    public String getFile_rivisto() {
        return file_rivisto;
    }

    public void setFile_rivisto(String file_rivisto) {
        this.file_rivisto = file_rivisto;
    }

    
    private UtenteClass autore;

    public ArticoloClass(int idArticolo, int idAutore, String titolo, String tema, String file) {
        this.idArticolo = idArticolo;
        this.idAutore = idAutore;
        this.titolo = titolo;
        this.tema = tema;
        this.file = file;
        
       // this.setAutore();
        
    }
    public ArticoloClass() {}
    

    
    public int getIdArticolo() {
        return idArticolo;
    }

    public void setIdArticolo(int idArticolo) {
        this.idArticolo = idArticolo;
    }

    public int getIdAutore() {
        return idAutore;
    }

    public void setIdAutore(int idAutore) {
        this.idAutore = idAutore;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public boolean isAmmesso() {
        return ammesso;
    }

    public void setAmmesso(boolean ammesso) {
        this.ammesso = ammesso;
    }

    public UtenteClass getAutore() {
        return autore;
    }

    public void setAutore() {
        //Query per trovare l'autore dal db utenti a partire dell'idUtente
    }
    
}
