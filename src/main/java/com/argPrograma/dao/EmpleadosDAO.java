package com.argPrograma.dao;

import com.argPrograma.Entities.Empleado;
import com.argPrograma.factory.ConexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadosDAO {


    // Registrar un nuevo empleado
    public void registrarEmpleado(Empleado empleado) {

        Connection con = ConexionDB.getConnection();

        try (con) {
            final PreparedStatement statement = con.prepareStatement("INSERT INTO empleados"
                    + "(nombre, apellido, dni, nacionalidad, dpto_id) "
                    + "VALUES (?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            try (statement) {
                statement.setString(1, empleado.getNombre());
                statement.setString(2, empleado.getApellido());
                statement.setInt(3, empleado.getDni());
                statement.setString(4, empleado.getNacionalidad());
                statement.setInt(5, empleado.getDpto_id());

                statement.execute();
                final ResultSet rs = statement.getGeneratedKeys();

                try (rs) {
                    while(rs.next()) {
                        empleado.setId_empleados(rs.getInt(1));
                        System.out.println("SE AGREGÓ EL NUEVO EMPLEADO: " + empleado + "\n");
                    }
                }
            }
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Listar todos los empleados
    public List<Empleado> listarEmpleado() {

        List<Empleado> lista = new ArrayList<>();
        Connection con = ConexionDB.getConnection();

        try (con) {
            System.out.println("Lista de Empleados en la empresa:");

            final PreparedStatement statement = con.prepareStatement("SELECT * FROM empleados");

            try (statement) {
                statement.execute();
                final ResultSet rs = statement.getResultSet();

                try (rs) {
                    while (rs.next()) {
                        Empleado empleado = new Empleado(
                                rs.getInt("id_empleados"),
                                rs.getString("nombre"),
                                rs.getString("apellido"),
                                rs.getInt("dni"),
                                rs.getString("nacionalidad"));
                        lista.add(empleado);
                    }
                }
                System.out.println("\n");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    // Modificar la nacionalidad de un empleado
    public void modificarNac(String nacionalidad, int id) {

        Connection con = ConexionDB.getConnection();

        try (con) {

            final PreparedStatement statement = con.prepareStatement("UPDATE empleados SET nacionalidad = ? WHERE id_empleados = ? ");

            try (statement) {

                statement.setString(1, nacionalidad);
                statement.setInt(2, id);
                statement.execute();
                System.out.println("¡LA MODIFICACIÓN SE REALIZÓ CON ÉXITO! \n");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminar(int id) {

        Connection con = ConexionDB.getConnection();

        try (con) {

            final PreparedStatement statement = con.prepareStatement("DELETE FROM empleados WHERE id_empleados = ?");

            try (statement) {

                statement.setInt(1, id);
                statement.execute();
                System.out.println("EL EMPLEADO FUE ELIMINADO! \n");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
