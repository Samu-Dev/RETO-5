package reto4.view;

import reto4.controller.ReportesController;
import reto4.model.vo.*;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;


public class ReportesView extends JFrame implements ActionListener{
    private ReportesController controller;
    private JMenuBar mMenuBar;
    private JMenu menu;
    private JMenuItem i1,i2,i3;
    private DefaultTableModel modelo;
    private JTable table;
    private JLabel lblTitulo, lblConsulta;


    public ReportesView(){
        super("Reto 5 - Samuel Corredor G45");
        super.setFont(new Font("Calibri", Font.BOLD,24));
        controller = new ReportesController();
        menu();
        etiqueta1();
        etiqueta2();
        tabla();
        //lideresQueMasGastan();
        getContentPane().setBackground(Color.lightGray);
    }

    public void etiqueta1(){
        lblTitulo = new JLabel("Consultas Reto 5");
        lblTitulo.setPreferredSize(new Dimension(500, 50));
        lblTitulo.setFont(new Font("Cooper Black", Font.BOLD,28));
        add(lblTitulo);
    }
    
    public void etiqueta2(){
        lblConsulta = new JLabel();
        lblConsulta.setPreferredSize(new DimensionUIResource(500, 30));
        lblConsulta.setFont(new Font("Calibri", Font.BOLD,18));
        add(lblConsulta);
    }

    public void tabla(){
        table = new JTable(modelo);
        table.setPreferredScrollableViewportSize(new Dimension(500,200));
        add(table);
        JScrollPane pane = new JScrollPane(table);
        add(pane);
    }

    public void menu(){
        mMenuBar = new JMenuBar();
        setJMenuBar(mMenuBar);
        menu = new JMenu("Consultas");
        menu.setFont(new Font("Calibri", Font.BOLD,18));
        mMenuBar.add(menu);
        i1= new JMenuItem("Lideres");
        i1.setFont(new Font("Calibri", Font.BOLD,18));
        i2 = new JMenuItem("Proyectos");
        i2.setFont(new Font("Calibri", Font.BOLD,18));
        i3 = new JMenuItem("Compras");
        i3.setFont(new Font("Calibri", Font.BOLD,18));
        menu.add(i1);
        menu.add(i2);
        menu.add(i3);
        i1.addActionListener(this);
        i2.addActionListener(this);
        i3.addActionListener(this);
    }

    
    public void proyectosFinanciadosPorBanco() {
        try{
            List<ProyectoBancoVo> proyectos = controller.listarProyectosPorBanco();
            modelo = new DefaultTableModel();
            modelo.addColumn("Id Proyecto");
            modelo.addColumn("Constructora");
            modelo.addColumn("Habitaciones");
            modelo.addColumn("Ciudad");
            for (ProyectoBancoVo proy : proyectos){
                Object[] fila = new Object[4];
                fila[0] = proy.getId();
                fila[1] = proy.getConstructora();
                fila[2] = proy.getHabitaciones();
                fila[3] = proy.getCiudad();
                modelo.addRow(fila);                    
            }
            table.setModel(modelo);
            modelo.fireTableDataChanged();
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        
    }
    public void totalAdeudadoPorProyectosSuperioresALimite() {
        try{
            List<DeudasPorProyectoVo> compras = controller.listarTotalAdeudadoProyectos();
            modelo = new DefaultTableModel();
            modelo.addColumn("Id compra");
            modelo.addColumn("Constructora");
            modelo.addColumn("Banco");
            for (DeudasPorProyectoVo compra : compras){
                Object[] fila = new Object[3];
                fila[0] = compra.getId();
                fila[1] = compra.getConstructora();
                fila[2] = compra.getBanco();
                modelo.addRow(fila);                    
            }
            table.setModel(modelo);
            modelo.fireTableDataChanged();
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void lideresQueMasGastan() {
        try{
            List<ComprasDeLiderVo> compras = controller.listarLideresCompras();
            
            // creación del modelo
            modelo = new DefaultTableModel();
            modelo.addColumn("Id");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Ciudad");
            for(ComprasDeLiderVo com: compras){
                Object[] fila = new Object[4];
                fila[0]=com.getId();
                fila[1]=com.getNombre();
                fila[2]=com.getApellido();
                fila[3]=com.getCiudad();
                modelo.addRow(fila);
            }
            table.setModel(modelo);
            modelo.fireTableDataChanged();
            
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == i1){
        lideresQueMasGastan();
        lblConsulta.setText("Consulta Lideres");
    }
    if(e.getSource() == i2){
        proyectosFinanciadosPorBanco();
        lblConsulta.setText("Consulta proyectos casa campestre");
    }
    if(e.getSource() == i3){
        totalAdeudadoPorProyectosSuperioresALimite();
        lblConsulta.setText("Consulta compras por proyectos");
    }
    }
}
