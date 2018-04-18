
package jfreechart;

import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.data.general.DefaultPieDataset;
import org.omg.CORBA.ORB;
import sun.applet.Main;

public class Ventana extends JFrame{
    JPanel panel;
    
    public Ventana(){
        setTitle("Como Hacer un Grafico en Java");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
          init(); 
    }
    private void init(){
        panel= new JPanel();
        getContentPane().add(panel);
        //fuente de datos
        DefaultPieDataset data=new DefaultPieDataset();
        data.setValue("C", 40);
        data.setValue("Java", 45);
        data.setValue("Pyton", 15);
        
        //creando el grafico
        org.jfree.chart.JFreeChart chart = ChartFactory.createPieChart("Ejemplo Rapido de Grafico en un CHartFrame",
                data,
                true,
                true,
                false);
        //mostrar grafico
        ChartPanel chartpanel=new ChartPanel(chart);
        panel.add(chartpanel);        
    }
    
    public static void main(String[] args) {
        new Ventana().setVisible(true);
    }
    
}
