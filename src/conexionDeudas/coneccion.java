/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionDeudas;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author root
 */
public class coneccion {
    Connection conect = null;

    public Connection conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Deudas", "root", "");

            // mostrar();
        } catch (SQLException ex) {
            System.out.println("Error en MySQL: " + ex.getMessage());
        } catch (ClassNotFoundException err) {
            err.printStackTrace();
        } catch (Exception err) {
            System.out.println("se ha encontrado un error inesperado que es " + err.getMessage());
        }
        return conect;
    }
}

