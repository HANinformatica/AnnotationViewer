package NL.HAN.PG2.SubFrame;

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
 * Created by christiaan on 11-3-2015.
 * Edit Heleen 26/3/2015
 */

public abstract class SubFrame  extends JInternalFrame implements InternalFrameListener  {
    static int openFrameCount = 0;
    static final int yOffset = 0;
    JTextArea sequence;

    protected SubFrame(String header,int fixedpos) {
        super(header, true, true, true, true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int scrheight = screenSize.height/3 - 18;
        int ypos = scrheight*fixedpos + yOffset*fixedpos;
        setSize(screenSize.width, scrheight);
        setLocation(0, ypos+yOffset);
        setBounds(0,ypos+yOffset,screenSize.width,scrheight);
        openFrameCount++;
        /* ik weet niet hoe ik deze anders moet zetten dan  */
        initText(fixedpos);
        addInternalFrameListener(this);
    }

    private void initText(int fixedpos) {
        sequence = new JTextArea(3, 30);
        sequence.setText("blaat frame "+fixedpos);
        sequence.setEditable(false);
        JScrollPane textScroller = new JScrollPane(sequence);
        textScroller.setPreferredSize(new Dimension(200, 75));
        textScroller.setMinimumSize(new Dimension(10, 10));
        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.PAGE_AXIS));
        contentPane.add(Box.createRigidArea(new Dimension(0, 5)));
        contentPane.add(textScroller);
        this.setContentPane(contentPane);
    }
    
    public abstract void setframeText();
    
    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
        displayMessage("Internal frame closing", e);
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {
        displayMessage("Internal frame closed", e);
        openFrameCount--;
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


