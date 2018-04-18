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
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author root
 */
public class DeudasSalonLineal extends JFrame{
    
    coneccion cc = new coneccion();
    Connection cn = cc.conexion();

    JPanel panel;
    
    public DeudasSalonLineal() {
        setTitle("los que se pasaron de lanza en linea");
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
        DefaultCategoryDataset line_chart_datset = new DefaultCategoryDataset();
       ResultSet res=null;
        PreparedStatement ps=null;
        try {
            ps=(PreparedStatement) cn.prepareStatement("SELECT * FROM Deuda");
            res=ps.executeQuery();
            while(res.next()){
            line_chart_datset.addValue(res.getInt(3), "Cantidad Deuda", res.getString(2));
            
            }
              //creando el grafico
        org.jfree.chart.JFreeChart chart = ChartFactory.createLineChart3D("Faltan por pagar en lineas :V",
                "Deudores", "Marmaja por pagar", line_chart_datset, PlotOrientation.VERTICAL, true, true, false);
        chart.setBackgroundPaint(Color.BLACK);
        chart.getTitle().setPaint(Color.WHITE);
        
        
        //mostrar grafico
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);
        
        } catch (Exception e) {
            System.out.println("el error es: "+e);
        }
      

        
    }

    public static void main(String[] args) {
        new DeudasSalonLineal().setVisible(true);
    }

}

/*
         line_chart_datset.addValue(80,"visitas","julio");
          line_chart_datset.addValue(300,"visitas","agosto");
           line_chart_datset.addValue(600,"visitas","julio");*/