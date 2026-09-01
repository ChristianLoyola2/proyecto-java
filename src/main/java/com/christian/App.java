package com.christian;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

    public static void main(String[] args) {

        String mensaje = "Java + Maven + MySQL funcionando correctamente";
        System.out.println(mensaje);

        try (Connection conexion = Database.conectar();
             Statement statement = conexion.createStatement();
             ResultSet resultado = statement.executeQuery(
                     "SELECT id, nombre, email FROM usuarios"
             )) {

            while (resultado.next()) {
                System.out.println(
                        resultado.getInt("id") + " - "
                                + resultado.getString("nombre") + " - "
                                + resultado.getString("email")
                );
            }

        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
    }
}