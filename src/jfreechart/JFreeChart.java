
package jfreechart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.data.general.DefaultPieDataset;

public class JFreeChart {

    
    public static void main(String[] args) {
        //fuente de datos
        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("C", 40);
        data.setValue("Java", 45);
        data.setValue("Pyton", 15);
        //Creando el Grafico
        org.jfree.chart.JFreeChart chart = ChartFactory.createPieChart("Ejemplo Rapido de Grafico en un CHartFrame",
                data,
                true,
                true,
                false);
        //mostrar grafico
        ChartFrame frame = new ChartFrame("JFreeChart", chart);
        frame.pack();
        frame.setVisible(true);
    }

}
