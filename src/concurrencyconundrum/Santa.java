/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrencyconundrum;

import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author BERADINB
 */
public class Santa extends Thread {

    Sleigh sleigh;
    int itemNum;
    String name;
    Timer countTime;
    //Sack sack;
    PrintWriter writer;
    int totalSpentTime = 0;
    private int counter = 0;
    private final int maxPresent = 10;
    private Present[] sack = new Present[maxPresent];

    public Santa(Sleigh s, int itemsNum, String sName, Timer t) {
        sleigh = s;
        itemNum = itemsNum;
        name = sName;
        countTime = t;
        //sack = new Sack(name);
    }

    private void OpenWriteFile() {
        try {
            writer = new PrintWriter(name + ".txt", "UTF-8");
        } catch (IOException e) {
            // do something
        }
    }

    private void WriteLineToFile(String line) {
        writer.println(line);
    }

    private void CloseFile() {
        writer.close();
    }

    private void WalkToDept() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
        WriteLineToFile("Time: " + countTime.TimePassed() + " :  " + name + " " + " Walking to toy department");
    }

    private void WalkBack() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
        WriteLineToFile("Time  " + countTime.TimePassed() + " :  " + name + " " + " Walking back to grotto");
    }

    public void GetPresent() {

        int startTime = 0;
        int endTime = 0;
        int waitingTime = 0;
        boolean isSleighEmpty = false;
        if (sleigh.GetSleighCount() < 6) {
            isSleighEmpty = true;
            startTime = countTime.TimePassed();
        }
        int c = 0;
        while (c < 10 && !countTime.DayFinished()) {
            
            if (sleigh.GetSleighCount() > 5) {

                //Present nextItem = new Present(sleigh.extract());
                sack[c] = sleigh.extract();
                //Present nextItem = new Present();
                //nextItem = sleigh.extract();
                //sack.Insert(nextItem);
                WriteLineToFile("Time  " + countTime.TimePassed() + " :  " + name + " " + " retrieving from sleigh: " + sack[c].presentName + " " + sack[c].gender);
                c++;
            }
        }
        if (isSleighEmpty == true) {
            endTime = countTime.TimePassed();
            waitingTime = endTime - startTime;
            totalSpentTime = totalSpentTime + waitingTime;
        }

    }

    public void GivePresent() {
        int i = 0;
        while (i < 10 && !countTime.DayFinished()) {
            try {
                sleep((int) (Math.random() * 1000));
            } catch (InterruptedException ex) {
            }
            WriteLineToFile("Time  " + countTime.TimePassed() + " :  " + name + " " + " giving to children: " + sack[i].presentName + " " + sack[i].gender);
            sack[i] = null;
            i++;
            counter++;
        }
    }

    private void HourlyReport(int time) {
        System.out.println(name + " Hourly Report: " + time);
        System.out.println("Presents gave away: " + counter);
        System.out.println("Total time spent at the sleigh: " + totalSpentTime);
        System.out.println(" ");

    }

    private void FinalReport(int time) {
        System.out.println(name + " Final Report: " + time);
        System.out.println("Total presents given away: " + counter);
        System.out.println("Total time spent at the sleigh: " + totalSpentTime);
        System.out.println(" ");

    }

    public void run() {
        OpenWriteFile();
        while (!countTime.DayFinished()) {

            WalkToDept();
            GetPresent();
            WalkBack();
            GivePresent();
            if (countTime.TimePassed() % 60 == 0 && countTime.TimePassed() != 481) {

                HourlyReport(countTime.TimePassed());
            }
        }
        FinalReport(countTime.TimePassed());
        CloseFile();

    }

}
