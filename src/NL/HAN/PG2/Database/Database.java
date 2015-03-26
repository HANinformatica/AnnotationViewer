package NL.HAN.PG2.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author E. Celik
 */
public class Database {
    
    public static String url = "jdbc:mysql://localhost:3306/";
    public static String dbName = "Annotation";
    public static String driver = "com.mysql.jdbc.Driver"; 
    public static String userName = "root"; 
    public static String password = "";
    
    /**
     * Retourneert integer waarde die indien de insert succsesvol 
     * was, de waarde 1 bevat (niet nul).
     * @param table Tabel naam in database
     * @param values Waardes die ge-insert moeten worden
     */
    public static int insert(String table, String values) {
        int res = 0;
        try { 
            Class.forName(driver).newInstance(); 
            Connection conn = DriverManager.getConnection(url+dbName,userName,password); 
            Statement st = conn.createStatement(); 
            res = st.executeUpdate("INSERT INTO "+table+" VALUES("+values+")"); 
            conn.close(); 
            return res;
        } catch (Exception e) { 
            e.printStackTrace(); 
        }     
        return res;
    }
    
    /**
     * Retourneert integer waarde die indien de update succsesvol 
     * was, de waarde 1 bevat (niet nul).
     * @param table Tabel naam in database
     * @param set Waardes die ge-update moeten worden
     * @param where Where-clausule
     */
    public static int update(String table, String set, String where) {
        int res = 0;
        try { 
            Class.forName(driver).newInstance(); 
            Connection conn = DriverManager.getConnection(url+dbName,userName,password); 
            Statement st = conn.createStatement(); 
            res = st.executeUpdate("INSERT INTO "+table+" SET "+set+" WHERE "+where+""); 
            conn.close(); 
            return res;
        } catch (Exception e) { 
            e.printStackTrace(); 
        }     
        return res;
    }
    
    /**
     * Retourneert string waarin geselecteerde resultaten
     * uit de database zitten. Is leeg indien selectie faalt.
     * @param table Tabel naam in database
     * @param column Kolom naam in tabel
     * @param value Waarde in kolom
     */
    public static String select(String table, String column, String value) {
        String Result = "";
        try { 
            Class.forName(driver).newInstance(); 
            Connection conn = DriverManager.getConnection(url+dbName,userName,password); 
            Statement st = conn.createStatement(); 
            ResultSet res = st.executeQuery("SELECT * FROM "+table+" "+ column != null ? "WHERE "+column+" = "+value+"" : "" +""); 
            while (res.next()) { 
                int id = res.getInt("id"); 
                String msg = res.getString("msg"); 
                Result += id + "\t" + msg + "\n"; 
            }
            conn.close(); 
            return Result;
        } catch (Exception e) { 
            e.printStackTrace(); 
        }  
        return Result;
    }
}
