/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NL.HAN.PG2.SubFrame;

/**
 *
 * @author Heleen
 */
public class DNAFrame extends SubFrame {

    public DNAFrame(String titel) {
        super("DNA Window",0);
    }
        
    @Override
    public void setframeText() {
        this.sequence.setText("meh");
    }
}
