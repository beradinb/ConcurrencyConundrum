/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrencyconundrum;

import java.util.concurrent.Semaphore;

/**
 *
 * @author BERADINB
 */
public class Sleigh {
    
    private Semaphore mutex = new Semaphore(1);
    private Semaphore spaces;
    private Semaphore presents;
    
    private Present [] sleigh;
    private int nextIn=0;
    private int nextOut=0;
    int counter =0;
    int totalPlaced = 0;
    int totalTaken = 0;
    
    public Sleigh(int size){
        sleigh = new Present[size];
        spaces = new Semaphore(size);
        presents = new Semaphore(0);
    }

    public int TotalAdded () {
//        return totalPlaced;
    }
    
    public int TotalTaken() {
//        return totalTaken;
    }
  
    
 
    
    public void insert(Present item){
        try {
            spaces.acquire();
            mutex.acquire();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
//        sleigh[nextIn] = item;
//        nextIn++;
//        counter++;
//        totalPlaced++;
//        if(nextIn == sleigh.length){
//            nextIn = 0;
//            
//        }
//        
        presents.release();
        mutex.release();
    }
    
    public Present extract(){
        try {
            presents.acquire();
            mutex.acquire();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
//       Present gift = new Present(sleigh[nextOut]);
//
//        
//        if (gift==null) {
//            gift.presentName = "invalid item";
//        }
//        nextOut++;
//        if (nextOut==sleigh.length){
//            nextOut=0;
//        }
//        counter--;
//        totalTaken++;
        spaces.release();
        mutex.release();
        
        return gift;
    }
    
    public int GetSleighCount(){
        int c = 0;
         try {
            
            mutex.acquire();
            c = counter;
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
         
         mutex.release();
        return c;

    }
    
    public boolean IsFull () {
//        return counter == 120;
    }
    
    public boolean IsEmpty () {
//        return counter == 0;
    }
    
  
    
    
    
}
