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
public class Present {

    public String presentName;
    public boolean isWrapped;
    public String gender;
    public Present gift;

    public Present() {

    }

    public Present(Present p) {
        
        presentName = p.presentName;
        gender = p.gender;
    }

}
