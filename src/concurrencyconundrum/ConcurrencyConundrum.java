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
public class ConcurrencyConundrum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //Elf elf1 = new Elf("main elf");
        Sleigh s = new Sleigh(120);
        Timer t = new Timer();

        
        Santa s1 = new Santa(s, 10, "Santa Nick", t);
        Santa s2 = new Santa(s, 10, "Santa John", t);
        Santa s3 = new Santa(s, 10, "Santa Barry", t);
//        Santa s4 = new Santa(s, 10, "Santa James", t);
        Elf elf1 = new Elf("Elf Tom", s, t);
        Elf elf2 = new Elf("Elf Garry", s, t);
        Elf elf3 = new Elf("Elf Stuart", s, t);
        Elf elf4 = new Elf("Elf David", s, t);
        Elf elf5 = new Elf("Elf Jack", s, t);
        Elf elf6 = new Elf("Elf Bill", s, t);
//        Elf elf7 = new Elf("ELF Chris", s, t);
//        Elf elf8 = new Elf("Elf Matt", s, t);
//        Elf elf9 = new Elf("Elf Alex", s, t);
//        Elf elf10 = new Elf("Elf Joe", s, t);
        System.out.println("***STARTING***");
        t.start();
        s1.start();
        s2.start();
        s3.start();
//        s4.start();
        elf1.start();
        elf2.start();
        elf3.start();
        elf4.start();
        elf5.start();
        elf6.start();
//        elf7.start();
//        elf8.start();
//        elf9.start();
//        elf10.start();
        try {

            elf1.join();
            elf2.join();
            elf3.join();
            elf4.join();
            elf5.join();
            elf6.join();
//            elf7.join();
//            elf8.join();
//            elf9.join();
//            elf10.join();

        } catch (InterruptedException ex) {
        }
        //s.insert(null);
        try {
            s1.join();
            s2.join();
            s3.join();
//            s4.join();
        } catch (InterruptedException ex) {
        }
        
//        System.out.println("Total Presents Wrapped: " + s.TotalAdded());
//        System.out.println("Total Presents Distributed: " + s.TotalTaken());
//        System.out.println("Total Presents Left in Sleigh  " + s.GetSleighCount());
//        int check =0;
//        check = s.TotalAdded() - s.TotalTaken() - s.GetSleighCount();
//        System.out.println("Check:  " + check);

    }

}
