/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swbdlibrary;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author loveless
 */
public class VentanaMain extends JFrame implements ActionListener {
    /////////////////////7
    MetodosSQL msql = new MetodosSQL();
    Prestamos pr = new Prestamos();
    ///////////7
//<editor-fold desc="Declaracion de elemantos">
JLabel autor,libro,genero,año,editorial;
JButton libros,Clientes,Prestar,Prestamos;
////////////////////////////////////////
JScrollPane Scroll;
JTable  Tabla;
DefaultTableModel MTabla,MCTabla,MRTabla;
Container Contenido;
//</editor-fold>
    public VentanaMain() {
    
           super("Biblioteca");
           this.setSize(950,500);
           this.setVisible(true);
           this.setLayout(null);
           this.setDefaultCloseOperation(3);
           this.setBounds(200,90,940,550);
//<editor-fold desc="Creacion de tablas">
    /***************************************/ 
     MTabla = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
     MTabla.addColumn("Autor");
     MTabla.addColumn("Nombre");
     MTabla.addColumn("Genero");
     MTabla.addColumn("IDLibro");
     MTabla.addColumn("Disponibles");
     MTabla.addColumn("Editorial");
     MTabla.addColumn("N.Paguinas");
     MTabla.addColumn("AÑO");
     /************************************************/
     MCTabla = new DefaultTableModel(){
                        @Override
			public boolean isCellEditable(int row, int column) {
				return false;
       }
     };
     MCTabla.addColumn("Nombre");
     MCTabla.addColumn("Paterno");
     MCTabla.addColumn("Materno");
     MCTabla.addColumn("Registro");
     MCTabla.addColumn("Calle");
     MCTabla.addColumn("Numero");
     MCTabla.addColumn("Colonia");
     MCTabla.addColumn("Telefono");
     MCTabla.addColumn("ID");
     
     /*****************************************/
     /************************************************/
     MRTabla = new DefaultTableModel(){
                        @Override
			public boolean isCellEditable(int row, int column) {
				return false;
       }
     };
     MRTabla.addColumn("ID Libro");
     MRTabla.addColumn("Fecha Salida");
     MRTabla.addColumn("Fecha Regreso");
     MRTabla.addColumn("ID Cliente");
     MRTabla.addColumn("Folio");
     
     
     /*****************************************/
//</editor-fold>
           Contenedor();
    }
    
     private void Contenedor() {
              Contenido = getContentPane();
              Contenido.setLayout(null);
              ////////////////////////////////
              libros = new JButton("Libros");
              libros.setVisible(true);
              libros.setLocation(800,20);
              libros.setSize(120,30);
              libros.addActionListener(this);
              Contenido.add(libros);
              /////////////////////////////////
              Clientes = new JButton("Clientes");
              Clientes.setVisible(true);
              Clientes.setLocation(800,60);
              Clientes.setSize(120,30);
              Clientes.addActionListener(this);
              Contenido.add(Clientes);
              /////////////////////////////////
              Prestar = new JButton("Prestar");
              Prestar.setVisible(true);
              Prestar.setLocation(800,100);
              Prestar.setSize(120,30);
              Prestar.addActionListener(this);
              Contenido.add(Prestar);
              /////////////////////////////////
              Prestamos = new JButton("Prestado");
              Prestamos.setVisible(true);
              Prestamos.setLocation(800,140);
              Prestamos.setSize(120,30);
              Prestamos.addActionListener(this);
              Contenido.add(Prestamos);
              /////////////////////////////////////
              Tabla = new JTable();
              Tabla.setVisible(true);
              Tabla.setSize(30,30);
              Scroll = new JScrollPane();
              Scroll.setBounds(20,130,760,340);
              Scroll.setViewportView(Tabla);
              Contenido.add(Scroll);
              /////////////////////////////////////
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == libros) {
            msql.ActualizarLibros(MTabla,"RLibros");
            Tabla.setModel(MTabla);
        }
        if (e.getSource() == Clientes) {
            msql.ActualizarClientes(MCTabla,"RClientes");
            Tabla.setModel(MCTabla);
        }
        if (e.getSource() == Prestar) {
            pr.setVisible(true);
        }
        if (e.getSource() == Prestamos) {
            msql.ActualizarPrestamos(MRTabla,"Prestamos");
            Tabla.setModel(MRTabla);
        }
        
        
    }

   
}
