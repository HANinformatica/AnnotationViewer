package NL.HAN.PG2.Help;

import javax.swing.JInternalFrame;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

/**
 * Created by Heleen 26/3/2015
 */

public class HelpFrame extends JInternalFrame implements InternalFrameListener  {
    JTextArea helptxt;

    public HelpFrame(String header) {
        super("Help", true, true, true, true);
        setSize(400,400);
        setLocation(40,40);
        setBounds(100,50,400,400);
        initText();
        addInternalFrameListener(this);
    }

    private void initText() {
        helptxt = new JTextArea(3, 30);
        helptxt.setText("Dit is de help tekst");
        helptxt.setEditable(false);
        JScrollPane textScroller = new JScrollPane(helptxt);
        textScroller.setPreferredSize(new Dimension(200, 75));
        textScroller.setMinimumSize(new Dimension(10, 10));
        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.PAGE_AXIS));
        contentPane.add(Box.createRigidArea(new Dimension(0, 5)));
        contentPane.add(textScroller);
        this.setContentPane(contentPane);
    }
    
    public void setframeText() {
        // change the tekst
        helptxt.setText("nieuwe help tekst");
    }
    
    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
        displayMessage("Internal frame closing", e);
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {
        displayMessage("Internal frame closed", e);
    }

    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
        displayMessage("Internal frame opened", e);
    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {
        displayMessage("Internal frame iconified", e);
    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {
        displayMessage("Internal frame deiconified", e);
    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {
        displayMessage("Internal frame activated", e);
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {
        displayMessage("Internal frame deactivated", e);
    }
    
    void displayMessage(String prefix, InternalFrameEvent e) {
        String s = prefix + ": " + e.getSource();
        //System.out.println(s);
    }
    
}
