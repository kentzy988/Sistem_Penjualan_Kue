package Oraclejava;

import java.sql.SQLException;
import java.text.ParseException;
import database.Koneksi;
import View.TransaksiView;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Oraclejava {

    public static void main(String[] args){
//        new Koneksi();
        try {
            new TransaksiView().show();
        } catch (SQLException ex) {
            Logger.getLogger(Oraclejava.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
