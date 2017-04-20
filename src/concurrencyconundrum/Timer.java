/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrencyconundrum;

import static java.lang.Thread.sleep;



/**
 *
 * @author BERADINB
 */
public class Timer extends Thread{
    
    int timePassed = 0;
    boolean dayFinished = false;
    static int timeLimit = 480;
    
    
    
    public int TimePassed() {
        return timePassed;   
    }
    
    
    public boolean DayFinished() {
        return dayFinished;
    }
    
    

      public void run () {
          while (timePassed < timeLimit)
          {
              timePassed++;
              dayFinished = false;
              try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
              
          } 
          dayFinished = true;
      }  

    
}
