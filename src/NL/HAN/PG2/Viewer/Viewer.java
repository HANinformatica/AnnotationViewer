package NL.HAN.PG2.Viewer;

import NL.HAN.PG2.SubFrame.DNAFrame;
import NL.HAN.PG2.SubFrame.AminoFrame;
import NL.HAN.PG2.SubFrame.FeatureFrame;
import NL.HAN.PG2.Help.HelpFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


/**
 * Created by christiaan on 11-3-2015.
 * Edit Heleen 23/3/2015.
 */
public class Viewer extends JFrame implements ActionListener {

    JDesktopPane desktop;
    HelpFrame helpframe;
    DNAFrame dnaframe;
    AminoFrame aminoframe;
    FeatureFrame featureframe;
    JTextArea aminotext;

    public Viewer(){
        super("Annotation Viewer");
        int inset = 0;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset,inset,screenSize.width - inset * 2,screenSize.height - inset * 2);
        desktop = new JDesktopPane();
        createDNAFrame();
        createAminoFrame();
        createFeatureFrame();
        setContentPane(desktop);
        setJMenuBar(createMenuBar());
        desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);
        menuBar.add(file);

        JMenuItem menuItem = new JMenuItem("New");
        menuItem.setMnemonic(KeyEvent.VK_N);
        menuItem.setActionCommand("new");
        menuItem.addActionListener(this);
        file.add(menuItem);
        
        menuItem = new JMenuItem("Open file");
        //menuItem.setMnemonic(KeyEvent.VK_O);
        menuItem.setActionCommand("openfile");
        menuItem.addActionListener(this);
        file.add(menuItem);

        menuItem = new JMenuItem("Open record");
        //menuItem.setMnemonic(KeyEvent.VK_O);
        menuItem.setActionCommand("openrecord");
        menuItem.addActionListener(this);
        file.add(menuItem);

        menuItem = new JMenuItem("Import/Blast");
        menuItem.setMnemonic(KeyEvent.VK_B);
        menuItem.setActionCommand("blast");
        menuItem.addActionListener(this);
        file.add(menuItem);

        menuItem = new JMenuItem("Print");
        menuItem.setMnemonic(KeyEvent.VK_P);
        menuItem.setActionCommand("print");
        menuItem.addActionListener(this);
        file.add(menuItem);

        menuItem = new JMenuItem("Quit");
        menuItem.setMnemonic(KeyEvent.VK_Q);
        menuItem.setActionCommand("quit");
        menuItem.addActionListener(this);
        file.add(menuItem);

        JMenu create = new JMenu("Create");
        create.setMnemonic(KeyEvent.VK_C);
        menuBar.add(create);

        menuItem = new JMenuItem("ORF");
        menuItem.setMnemonic(KeyEvent.VK_O);
        menuItem.setActionCommand("orfs");
        menuItem.addActionListener(this);
        create.add(menuItem);

        JMenu view = new JMenu("View");
//        view.setMnemonic(KeyEvent.VK_H);
        menuBar.add(view);

        menuItem = new JMenuItem("View DNA Window");
//        menuItem.setMnemonic(KeyEvent.VK_H);
        menuItem.setActionCommand("viewDNA");
        menuItem.addActionListener(this);
        view.add(menuItem);        
        
        menuItem = new JMenuItem("View Amino Acids Window");
//        menuItem.setMnemonic(KeyEvent.VK_H);
        menuItem.setActionCommand("viewAmino");
        menuItem.addActionListener(this);
        view.add(menuItem);        

        menuItem = new JMenuItem("View Feature/Info Window");
//        menuItem.setMnemonic(KeyEvent.VK_H);
        menuItem.setActionCommand("viewFeature");
        menuItem.addActionListener(this);
        view.add(menuItem);        

        JMenu help = new JMenu("Help");
        help.setMnemonic(KeyEvent.VK_H);
        menuBar.add(help);

        menuItem = new JMenuItem("Read Help");
        menuItem.setMnemonic(KeyEvent.VK_H);
        menuItem.setActionCommand("help");
        menuItem.addActionListener(this);
        help.add(menuItem);

        menuItem = new JMenuItem("About");
        menuItem.setMnemonic(KeyEvent.VK_A);
        menuItem.setActionCommand("about");
        menuItem.addActionListener(this);
        help.add(menuItem);

        return menuBar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch (action) {
            case "new": {
                //createFrame("Something",0,0,0,0);
                break;
            }
            case "help": {
                showHelp();
                break;
            }
            case "openfile": {
                openFile();
                break;
            }
            case "about": {
                showAbout();
                break;
            }
            case "viewDNA": {
                createDNAFrame();
                break;
            }
            case "viewAmino": {
                createAminoFrame();
                break;
            }
            case "viewFeature": {
                createFeatureFrame();
                break;
            }
            default: {
                break;
            }
        }
    }

    private void createDNAFrame() {
        if (!(dnaframe == null || dnaframe.isClosed())) {
            return;
        }
        dnaframe = null;
        dnaframe = new DNAFrame("");
        dnaframe.setVisible(true);
        desktop.add(dnaframe);
    }
    
    private void createAminoFrame() {
        if (!(aminoframe == null || aminoframe.isClosed())) {
            return;
        }
        aminoframe = null;
        aminoframe = new AminoFrame("");
        aminoframe.setVisible(true);
        desktop.add(aminoframe);
    }
    
    private void createFeatureFrame() {
        if (!(featureframe == null || featureframe.isClosed())) {
            return;
        }
        featureframe = null;
        featureframe = new FeatureFrame("");
        featureframe.setVisible(true);
        desktop.add(featureframe);
    }
    
//    private void createFrame(String header, int xpos, int ypos, int framewidth, int frameheight) {
//        SubFrame frame = new SubFrame(header);
//        frame.setVisible(true);
//        desktop.add(frame);
//        try {
//            frame.setSelected(true);
//            frame.setBounds(xpos, ypos, framewidth, frameheight);
//        } catch (java.beans.PropertyVetoException e) {}
//    }

    protected void quit() {
        System.exit(0);
    }
    
    protected void showHelp() {
        if (!(helpframe == null || helpframe.isClosed())) {
            return;
        }
        helpframe = null;
        helpframe = new HelpFrame("");
        try {
            helpframe.setSelected(true);
        }
        catch (Exception e) {
            System.out.println("help kan niet getoond worden.");
        }
        desktop.add(helpframe);
        helpframe.setVisible(true);
    }
    
    protected void showAbout() {
        // ff testen
        dnaframe.setframeText();
    }
    
    protected void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        File selectedFile;
        int reply;
        reply = fileChooser.showOpenDialog(this);
        if (reply == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            readFile(selectedFile);
        }
    }

    public void readFile(File selectedFile) {
        BufferedReader inFile;
        StringBuilder sequentie = new StringBuilder();
        try {
            inFile = new BufferedReader(new FileReader(selectedFile));
            String line;
            while ((line = inFile.readLine()) != null) {
                sequentie.append(line);
            }
            inFile.close();
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null,"File Error: " + e.toString());
        }
}

    public static void createAndShowGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        Viewer frame = new Viewer();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }

}
