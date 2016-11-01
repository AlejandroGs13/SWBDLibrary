/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swbdlibrary;

import java.util.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author loveless
 */
    
public class MetodosSQL {
    
    public void ActualizarLibros(DefaultTableModel Modelo,String NombreTabla){
      try{
        MySQL db = new MySQL();
        db.MySQLConnect();
        
            
            
          
            
            String Query = "SELECT * FROM " + NombreTabla;
            
            
        
            
            db.comando = db.conexion.createStatement();
            db.registro = db.comando.executeQuery(Query);

          
            
           Clear_Table1(Modelo);
            while (db.registro.next()) {
               int con = 0;
                String [] Datos = new String[8];
                for (int i = 1; i < 9; i++) {
                    Datos[con] = db.registro.getString(i);
                    con++;
                }
                Modelo.addRow(Datos);
                
            }
            
                
            
        }
             catch (SQLException ex) {
            Logger.getLogger(MetodosSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void ActualizarClientes(DefaultTableModel Modelo,String NombreTabla){
      try{
        MySQL db = new MySQL();
        db.MySQLConnect();
        
            
            
          
            
            String Query = "SELECT * FROM " + NombreTabla;
            
            
        
            
            db.comando = db.conexion.createStatement();
            db.registro = db.comando.executeQuery(Query);

          
            
           Clear_Table1(Modelo);
            while (db.registro.next()) {
               int con = 0;
                String [] Datos = new String[9];
                for (int i = 1; i < 12; i++) {
                    if (!(i== 5 || i ==10)) {
                        Datos[con] = db.registro.getString(i);
                    con++;
                    }
                    
                }
                Modelo.addRow(Datos);
                
            }
            
                
            
        }
             catch (SQLException ex) {
            Logger.getLogger(MetodosSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     private void Clear_Table1(DefaultTableModel Modelo){
       for (int i = 0; i < Modelo.getRowCount(); i++) {
           Modelo.removeRow(i);
           i-=1;
       }
     }
     
     public List NombreLibros(int selec){
     List<String>  Nombres = new ArrayList<String>();
     try{
        MySQL db = new MySQL();
        db.MySQLConnect();
        
            
            
          
            
            String Query = "SELECT * FROM " + "RLibros";
            
            
        
            
            db.comando = db.conexion.createStatement();
            db.registro = db.comando.executeQuery(Query);

          
            
          
            while (db.registro.next()) {
               int con = 0;
               int op = '\0';
                if (selec == 1) {
                    op = 10;
                }else{ op = 2;}
                        Nombres.add(db.registro.getString(2));
                    con++;
             
            }

        }
             catch (SQLException ex) {
            Logger.getLogger(MetodosSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
         
     return Nombres;
     }
     
     public List IDLibros(int selec){
     List<String>  Nombres = new ArrayList<String>();
     try{
        MySQL db = new MySQL();
        db.MySQLConnect();
        
            
            
          
            
            String Query = "SELECT * FROM " + "RLibros";
            
            
        
            
            db.comando = db.conexion.createStatement();
            db.registro = db.comando.executeQuery(Query);

          
            
          
            while (db.registro.next()) {
               int con = 0;
               int op = '\0';
                if (selec == 1) {
                    op = 10;
                }else{ op = 2;}
                        Nombres.add(db.registro.getString(4));
                    con++;
             
            }

        }
             catch (SQLException ex) {
            Logger.getLogger(MetodosSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
         
     return Nombres;
     }
     
     public List IDNombre(){
     List<String>  Nombres = new ArrayList<String>();
     try{
        MySQL db = new MySQL();
        db.MySQLConnect();
        
            
            
          
            
            String Query = "SELECT * FROM " + "RClientes";
            
            
        
            
            db.comando = db.conexion.createStatement();
            db.registro = db.comando.executeQuery(Query);

          
            
          
            while (db.registro.next()) {
               int con = 0;
               
                        Nombres.add(db.registro.getString(11));
             
            }

        }
             catch (SQLException ex) {
            Logger.getLogger(MetodosSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
         
     return Nombres;
     }
     
     public void IngresarPrestamo(String IDlibro,String IDcliente){
     java.util.Date fecha = new Date();
     try{
        MySQL db = new MySQL();
        db.MySQLConnect();
        
            
            
           String fechas = "";
           fechas = fechas + String.valueOf(fecha.getYear())+"-";
           fechas = fechas + String.valueOf(fecha.getMonth())+"-";
           fechas = fechas + String.valueOf(fecha.getDay());
            
            String Query = "SELECT * FROM " + "Prestamos";
            
            
        
            
            db.comando = db.conexion.createStatement();
            db.registro = db.comando.executeQuery(Query);

          System.out.println(IDlibro);
          System.out.println(fechas);
            
          db.comando.executeUpdate("INSERT INTO Prestamos VALUES('"+IDlibro+"',CURDATE(),NULL,'"+IDcliente+"',NULL)");
         

        }
             catch (SQLException ex) {
            Logger.getLogger(MetodosSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
         
     }
     
     public void ActualizarPrestamos(DefaultTableModel Modelo,String NombreTabla){
      try{
        MySQL db = new MySQL();
        db.MySQLConnect();
        
            
            
          
            
            String Query = "SELECT * FROM " + NombreTabla;
            
            
        
            
            db.comando = db.conexion.createStatement();
            db.registro = db.comando.executeQuery(Query);

          
            
           Clear_Table1(Modelo);
            while (db.registro.next()) {
               int con = 0;
                String [] Datos = new String[5];
                for (int i = 1; i < 6; i++) {
                    Datos[con] = db.registro.getString(i);
                    con++;
                }
                Modelo.addRow(Datos);
                
            }
            
                
            
        }
             catch (SQLException ex) {
            Logger.getLogger(MetodosSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
   
     
    
}
