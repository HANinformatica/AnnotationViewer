package NL.HAN.PG2.main;

//import NL.HAN.PG2.FileHandeling.FileHandeling;
import NL.HAN.PG2.Viewer.Viewer;

/**
 * Created by christiaan on 11-3-2015.
 */
public class Main {

    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(() -> {
//            Viewer temp = new Viewer();
            Viewer.createAndShowGUI();
        });
//        FileHandeling test = new FileHandeling();
//        test.setFile("C:\\Users\\Chris Cornelisse\\Documents\\GitHub\\AnnotationViewer\\test\\test.fa");
//        System.out.println(test.getType());
//        test.openFile();
    }
}
