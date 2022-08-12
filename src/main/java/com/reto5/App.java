package com.reto5;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.*;

import com.reto5.view.ReportesView;

public class App {

    public static void main(String[] args) {
        var ventana = new ReportesView();
        FlowLayout flowLayout = new FlowLayout();
        ventana.setLayout(flowLayout);
        ventana.setMinimumSize(new Dimension(600, 400));
        ventana.setVisible(true);
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);

        ImageIcon icono = new ImageIcon("./img/icono2.jpg");
        ventana.setIconImage(icono.getImage());
        ventana.getContentPane().setBackground(new Color(204, 229, 255));
        
    }
}
