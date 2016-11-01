/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swbdlibrary;

import java.util.ArrayList;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author loveless
 */
public class MetodosRegistrar {
    MetodosSQL msql = new MetodosSQL();
    String IDl=null;
    public boolean Comparar(String datoLibro,String datoClien,int Selec){
//        System.out.println(dato);
        boolean cerrar = false;
        boolean encontradoL= false;
        boolean encontradoR= false;
      List<String> nombres = msql.NombreLibros(Selec);
      List<String> IDs = msql.IDNombre();
      List<String> IDli = msql.IDLibros(Selec);
      String []nombre = new String[nombres.size()];
      String []id = new String[nombres.size()];
      nombre = nombres.toArray(nombre);
       id = IDli.toArray(id);
      if (((encontrar(nombre,id, datoLibro ))==true)||((encontrar(id,id, datoClien))==true) ) {
          System.out.println("si valido");
          registrar(datoClien,IDl);
          cerrar = true;
      }else{
          JOptionPane.showMessageDialog(null,"NO ENCONTRADO","ERROR", JOptionPane.ERROR_MESSAGE);
      }
      return cerrar;
    }
    
    
    public boolean encontrar(String []nombre,String[]id,String dato){
         boolean encontradoL= false;
         int con = 0;
      for (String a : nombre) {
            if (a.equals(dato) ) {
                encontradoL = true;
                System.out.println("entro al ciclo booleano");
                IDl = id[con];
                
            } 
         con++;
        }
      return encontradoL;
    }
    public void registrar(String datocliente,String Datolibro){
        System.out.println("si valido");
        msql.IngresarPrestamo(Datolibro, datocliente);
        
        
    }
    
}
