/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionDeudas;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author root
 */
public class DeudasSalon extends JFrame {

    coneccion cc = new coneccion();
    Connection cn = cc.conexion();

    JPanel panel;

    public DeudasSalon() {
        setTitle("los que se pasaron de lanza");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        init();
    }

    public void init() {
        panel = new JPanel();
        getContentPane().add(panel);
         //fuente de datos
        DefaultCategoryDataset datset = new DefaultCategoryDataset();
       ResultSet res=null;
        PreparedStatement ps=null;
        try {
            ps=(PreparedStatement) cn.prepareStatement("SELECT * FROM Deuda");
            res=ps.executeQuery();
            while(res.next()){
            datset.setValue(res.getInt(3), res.getString(2), res.getString(1));
            
            }
              //creando el grafico
        org.jfree.chart.JFreeChart chart = ChartFactory.createBarChart3D("Faltan por pagar",
                "Deudores", "Marmaja por pagar", datset, PlotOrientation.VERTICAL, true, true, false);
        chart.setBackgroundPaint(Color.BLACK);
        chart.getTitle().setPaint(Color.WHITE);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.RED);
        
        //mostrar grafico
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);
        
        } catch (Exception e) {
            System.out.println("el error es: "+e);
        }
      

        
    }

    public static void main(String[] args) {
        new DeudasSalon().setVisible(true);
    }

}
 /* datset.setValue(8, "Cantidad", "Tehuas");
        datset.setValue(5, "Cantidad", "Tehuas");
        datset.setValue(7, "Cantidad", "Brian");
        datset.setValue(9, "Cantidad", "Ignacho");
        datset.setValue(2, "Cantidad", "Lucha");*/