package reto4;

import javax.swing.JFrame;
import java.awt.*;
import reto4.view.ReportesView;

public class App {
    public static void main( String[] args){
        var reportesView3 = new ReportesView();
        FlowLayout flowLayout = new FlowLayout();
        reportesView3.setLayout(flowLayout);
        reportesView3.setMinimumSize(new Dimension(600,400));
        reportesView3.setVisible(true);
        reportesView3.setResizable(true);
        reportesView3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        reportesView3.setLocationRelativeTo(null);
    }
}