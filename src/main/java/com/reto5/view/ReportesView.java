package com.reto5.view;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.table.DefaultTableModel;

import com.reto5.model.vo.*;
import com.reto5.controller.ReportesController;

import java.awt.*;
import java.awt.event.*;

public class ReportesView extends JFrame implements ActionListener {
    private ReportesController controller;
    private JMenuBar mMenuBar;
    private JMenu menu;
    private JMenuItem item1, item2, item3;
    private DefaultTableModel modelo;
    private JTable table;
    private JLabel lblTitulo, lblConsulta;

    public ReportesView() {
        controller = new ReportesController();
        menu();
        etiqueta1();
        etiqueta2();
        tabla();

    
    }

    public void etiqueta1() {
        lblTitulo = new JLabel("Informes reto 5");
        lblTitulo.setPreferredSize(new Dimension(500, 30));
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 25));
        lblTitulo.setForeground(Color.blue);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setVerticalAlignment(SwingConstants.CENTER);
        add(lblTitulo);

    }

    public void etiqueta2() {
        lblConsulta = new JLabel();
        lblConsulta.setPreferredSize(new DimensionUIResource(500, 30));
        lblConsulta.setFont(new Font("Arial", Font.BOLD, 14));
        lblConsulta.setForeground(Color.blue);
        add(lblConsulta);

    }

    public void tabla() {
        table = new JTable(modelo);
        table.setPreferredScrollableViewportSize(new Dimension(500, 200));
        add(table);
        table.getTableHeader().setFont(new Font("Arial", 1, 14));
        table.getTableHeader().setBackground(Color.blue);
        table.getTableHeader().setForeground(Color.white);
        JScrollPane pane = new JScrollPane(table);
        add(pane);
    }

    public void menu() {
        mMenuBar = new JMenuBar();
        setJMenuBar(mMenuBar);
        menu = new JMenu("Informes");
        mMenuBar.add(menu);
        mMenuBar.setBackground(Color.BLUE);
        menu.setBackground(Color.magenta);
        mMenuBar.setOpaque(true);
        menu.setOpaque(true);
        mMenuBar.setBackground(Color.BLUE);
        menu.setBackground(Color.magenta);
        mMenuBar.setOpaque(true);
        menu.setOpaque(true);
        item1 = new JMenuItem("Lideres");
        item2 = new JMenuItem("Proyectos");
        item3 = new JMenuItem("Compras");
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);
    }
    
    public void informe1() {
        try {
            List<PrimerInformeVo> compras = controller.listarLideresCompras();

            // creación del modelo
            modelo = new DefaultTableModel();
            modelo.addColumn("Id");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Ciudad");
            for (PrimerInformeVo com : compras) {
                Object[] fila = new Object[4];
                fila[0] = com.getId();
                fila[1] = com.getNombre();
                fila[2] = com.getApellido();
                fila[3] = com.getCiudad();
                modelo.addRow(fila);
            }
            table.setModel(modelo);
            modelo.fireTableDataChanged();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void informe2() {
        try {
            List<SegundoInformeVo> proyectos = controller.listarProyectosPorCiudades();
            modelo = new DefaultTableModel();
            modelo.addColumn("Id Proyecto");
            modelo.addColumn("Constructora");
            modelo.addColumn("Habitaciones");
            modelo.addColumn("Ciudad");
            for (SegundoInformeVo proy : proyectos) {
                Object[] fila = new Object[4];
                fila[0] = proy.getId();
                fila[1] = proy.getConstructora();
                fila[2] = proy.getHabitaciones();
                fila[3] = proy.getCiudad();
                modelo.addRow(fila);
            }
            table.setModel(modelo);
            modelo.fireTableDataChanged();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public void informe3() {
        try {
            List<TercerInformeVo> compras = controller.listarProyectosPorProveedor();
            modelo = new DefaultTableModel();
            modelo.addColumn("Id compra");
            modelo.addColumn("Constructora");
            modelo.addColumn("Banco");
            for (TercerInformeVo compra : compras) {
                Object[] fila = new Object[3];
                fila[0] = compra.getId();
                fila[1] = compra.getConstructora();
                fila[2] = compra.getBanco();
                modelo.addRow(fila);
            }
            table.setModel(modelo);
            modelo.fireTableDataChanged();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == item1) {
            informe1();
            lblConsulta.setText("Informe Lideres");
        }
        if (e.getSource() == item2) {
            informe2();
            lblConsulta.setText("Informe proyectos casa campestre");
        }
        if (e.getSource() == item3) {
            informe3();
            lblConsulta.setText("Informe compras por proyectos");
        }

    }

    
    
}
