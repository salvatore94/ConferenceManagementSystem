/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conferencemanagementsystem.Utils;

/**
 *
 * @author salvatore
 */
public class UtenteClass {
    private int idUtente;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    
    public UtenteClass (){}
    
    public UtenteClass(int _idUtente, String _nome, String _cognome, String _email, String _password) {
        this.setId(_idUtente);
        this.setNome(_nome);
        this.setCognome(_cognome);
        this.setPassword(_password);
    }
    
    public void setId (int _idUtente){
        this.idUtente = _idUtente;
    }
    
    public void setNome(String _nome) {
        this.nome = _nome;     
    }
    
    public void setCognome (String _cognome) {
        this.cognome = _cognome;
    }
    
    public void setEmail(String _email){
        this.email = _email;
    }
    
    public void setPassword (String _password) {
        this.password = _password;
    }
    
    public int getId(){
        return idUtente;
    }
    
    public final String getNome(){
        return nome;
    }
    
    public final String getCognome(){
        return cognome;
    }
    
    public final String getEmail(){
        return email;
    }
    
    public final String getPassword() {
        return password;
    }
}
