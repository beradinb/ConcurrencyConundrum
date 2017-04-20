/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrencyconundrum;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author BERADINB
 */
public class Elf extends Thread {

    String[] presentArr = {"train", "doll", "dinosaur", "whistle", "fake tattoo", "bracelet"};
    String[] genderArr = {"boy", "girl"};

    Present toy;
    Sleigh sleigh;
    String elfName;
    int presentNum = 0;
    Timer countTime;
    PrintWriter writer;
    int totalSpentTime = 0;


    public Elf(String elfName, Sleigh s, Timer t) {
        this.elfName = elfName;
        toy = new Present();
        sleigh = s;
        countTime = t;

    }

    private void OpenWriteFile() {
        try {
            writer = new PrintWriter(elfName + ".txt", "UTF-8");
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

    private void SelectGift() {
        try {
            sleep((int) (Math.random() * 1000));
        } catch (InterruptedException ex) {
        }
        toy.presentName = RandomToy(presentArr);
        toy.gender = RandomToy(genderArr);
        WriteLineToFile("Time: " + countTime.TimePassed() + ": " + elfName + ":     Selected toy " + toy.presentName + ", " + toy.gender);

    }

    private void WrapGift() {
        try {
            sleep((int) (Math.random() * 1000));
        } catch (InterruptedException ex) {
        }
        toy.isWrapped = true;
        presentNum++;
        WriteLineToFile("Time: " + countTime.TimePassed() + ": " + elfName + ":     Wrapped toy " + toy.presentName + ", " + toy.gender);

    }

    private void AddToSleigh() {
        try {
            sleep((int) (Math.random() * 1000));
        } catch (InterruptedException ex) {
        }
        int startTime = 0;
        int endTime = 0;
        int waitingTime = 0;
        boolean isSleighFull = sleigh.IsFull();
        if (isSleighFull) {
            startTime = countTime.TimePassed();
        }
        sleigh.insert(toy);
        WriteLineToFile("Time: " + countTime.TimePassed() + ": " + elfName + ":     Placed toy " + toy.presentName + ", " + toy.gender);

        if (isSleighFull) {
            endTime = countTime.TimePassed();
            waitingTime = endTime - startTime;
            totalSpentTime = totalSpentTime + waitingTime;
        }
    }

    public static String RandomToy(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    private void HourlyReport(int time) {
        System.out.println(elfName + " Hourly Report: " + time);
        System.out.println("Presents wrapped: " + presentNum);
        System.out.println("Total time spent at the sleigh: " + totalSpentTime);
        System.out.println(" ");
        
    }
    private void FinalReport(int time) {
        System.out.println(elfName + " Final Report: " + time);
        System.out.println("Total Presents wrapped: " + presentNum);
        System.out.println("Total time spent at the sleigh: " + totalSpentTime);
        System.out.println(" ");
        
    }

    public void run() {
        OpenWriteFile();
        while (!countTime.DayFinished() && !sleigh.IsFull()) {
            try {
                sleep((int) (Math.random() * 1000));
            } catch (InterruptedException ex) {
            }
            SelectGift();
            WrapGift();
            AddToSleigh();
            if (countTime.TimePassed() % 60 == 0 && countTime.TimePassed() != 481) {

                HourlyReport(countTime.TimePassed());
                //WriteLineToFile(" Time  " + countTime.TimePassed() + ": " + elfName + " Selected toy " + toy.presentName + ", " + toy.gender);
            }

        }
        FinalReport(countTime.TimePassed());
        CloseFile();

    }

}
