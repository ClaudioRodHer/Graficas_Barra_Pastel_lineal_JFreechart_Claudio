
package conexionDeudas;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;


public class DeudasSalonPastel extends JFrame {
    coneccion cc = new coneccion();
    Connection cn = cc.conexion();

    JPanel panel;
    public DeudasSalonPastel(){
    setTitle("los que se pasaron de lanza ahora en pastel");
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
        DefaultPieDataset defaultpiedataset = new DefaultPieDataset();
       ResultSet res=null;
        PreparedStatement ps=null;
        try {
            ps=(PreparedStatement) cn.prepareStatement("SELECT * FROM Deuda");
            res=ps.executeQuery();
            while(res.next()){
            defaultpiedataset.setValue(res.getString(2),res.getInt(3));
            }
              //creando el grafico
       // org.jfree.chart.JFreeChart chart = ChartFactory.createPieChart3D("Faltan por pagar",datset, true, true, false);
        org.jfree.chart.JFreeChart chart=ChartFactory.createPieChart3D("Faltan por pagar", defaultpiedataset,
                true, true, false);
            PiePlot3D pieplot3d=(PiePlot3D)chart.getPlot();
            pieplot3d.setDepthFactor(0.5);
            pieplot3d.setStartAngle(290D);
            pieplot3d.setDirection(Rotation.CLOCKWISE);
            pieplot3d.setForegroundAlpha(0.5F);
        
        //mostrar grafico
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);
        
        } catch (Exception e) {
            System.out.println("el error es: "+e);
        }
      

        
    }

    public static void main(String[] args) {
        new DeudasSalonPastel().setVisible(true);
    }

}
