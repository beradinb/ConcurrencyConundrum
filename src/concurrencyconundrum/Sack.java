/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrencyconundrum;

/**
 *
 * @author BERADINB
 */
public class Sack {

    private final int maxPresent = 10;
    private Present[] sack = new Present[maxPresent];
    private int presentCount = 0;
    private int nextIn = 0;
    private int nextOut = 0;
    private String name;

    public Sack(String s) {
        name = s;
    }

    public int PresentNum() {
        return presentCount;
    }

    public int MaxPresentNum() {
        return maxPresent;
    }

    public boolean IsEmpty() {
        return presentCount == 0;
    }

    public boolean IsFull() {
        return presentCount == maxPresent;
    }

    public void Insert(Present item) {

        sack[nextIn] = item;
        nextIn++;
        if (nextIn == sack.length) {
            nextIn = 0;
        }

    }

    public Present Remove() {

        Present gift;
        gift = sack[nextOut];

        nextOut++;
        if (nextOut == sack.length) {
            nextOut = 0;
        }

       presentCount++;
        return gift;
    }

}
