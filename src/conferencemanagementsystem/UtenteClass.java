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
public class UtenteClass {
    private String nomeUtente;
    private String email;
    private String password;
    private String ruolo;
    
    public void setNomeUtente(String nome) {
        nomeUtente = nome;     
    }
    
    public void setEmail(String emailStr){
        email = emailStr;
    }
    
    public void setPassword (String pass) {
        password = pass;
    }
    
    public void setRuolo (String r) {
        ruolo = r;
    }
    
    public final String getNomeUtente(){
        return nomeUtente;
    }
    
    public final String getEmail(){
        return email;
    }
    
    public final String getPassword() {
        return password;
    }
    
    public final String getRuolo () {
        return ruolo;
    }
}
