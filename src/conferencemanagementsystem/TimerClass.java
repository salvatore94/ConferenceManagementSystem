/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conferencemanagementsystem;

import static conferencemanagementsystem.MainClass.conferenza;
import java.util.TimerTask;
import java.time.*;
import java.util.Timer;
/**
 *
 * @author salvatore
 */
public class TimerClass extends TimerTask {
    
    public void run()
    {
        //write your code here
    }
    
public static void main(String[] args) {

    //Recupero le scadenze dall'oggetto conferenza (che viene istanziato ed inizializzato al login)

    LocalDate inizio = conferenza.getInizio();
    LocalDate fine = conferenza.getFine();
    LocalDate scadenzaSottomissione = conferenza.getScadenzaSottomissioneArticoli();
    LocalDate scadenzaReview = conferenza.getScadenzaReview();
    LocalDate scadenzaSottomissioneRivisti = conferenza.getScadenzaSottomissioneCorretti();
    
    //Now create the time and schedule it
    Timer timer = new Timer();

    //Use this if you want to execute it once
  //  timer.schedule(new TimerClass(), date);

}

}