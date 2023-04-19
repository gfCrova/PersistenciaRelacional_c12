package com.argPrograma.dao;

import com.argPrograma.Entities.Departamento;
import com.argPrograma.Entities.Empleado;
import com.argPrograma.factory.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DepartamentosDAO {

    public List<Departamento> listarDepto() {

        List<Departamento> lista = new ArrayList<>();
        Connection con = ConexionDB.getConnection();

        try (con) {
            System.out.println("Lista de Departamentos:");

            final PreparedStatement statement = con.prepareStatement("SELECT * FROM departamentos");

            try (statement) {
                statement.execute();
                final ResultSet rs = statement.getResultSet();

                try (rs) {
                    while (rs.next()) {
                        Departamento depto = new Departamento(
                                rs.getInt("id_departamento"),
                                rs.getString("nombre"),
                                rs.getInt("presupuesto")
                        );
                        lista.add(depto);
                    }
                }
                System.out.println("\n");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public List<Departamento> mostrarConEmpleados() {
        List<Departamento> resultado = new ArrayList<>();
        Connection con = ConexionDB.getConnection();

        try {
            System.out.println("\n Lista de Departamentos con sus respectivos Empleados: \n");

            String sql = "SELECT d.id_departamento, d.nombre, d.presupuesto, e.id_empleados, e.nombre, e.apellido, e.dni, e.nacionalidad FROM departamentos d INNER JOIN empleados e ON d.id_departamento = e.dpto_id";
            final PreparedStatement statement = con.prepareStatement(sql);

            try (statement) {
                final ResultSet resultSet = statement.executeQuery();

                try (resultSet) {
                    while (resultSet.next()) {
                        Integer dptoId = resultSet.getInt("d.id_departamento");
                        String dptoNombre = resultSet.getString("d.nombre");
                        Integer dptoPresupuesto = resultSet.getInt("d.presupuesto");

                        var depto = resultado
                                .stream()
                                .filter(dto -> Objects.equals(dto.getId_dpto(), dptoId))
                                .findAny().orElseGet(() -> {
                                    Departamento cat = new Departamento(dptoId, dptoNombre, dptoPresupuesto);
                                    resultado.add(cat);
                                    return cat;
                                });

                        Empleado producto = new Empleado(
                                resultSet.getInt("e.id_empleados"),
                                resultSet.getString("e.nombre"),
                                resultSet.getString("e.apellido"),
                                resultSet.getInt("e.dni"),
                                resultSet.getString("e.nacionalidad"));
                        depto.agregar(producto);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }

    public void eliminarDepto(int id) {

        Connection con = ConexionDB.getConnection();

        try (con) {

            final PreparedStatement statement = con.prepareStatement("DELETE FROM departamentos WHERE id_departamento = ?");

            try (statement) {

                statement.setInt(1, id);
                statement.execute();
                System.out.println("EL DEPARTAMENTO FUE ELIMINADO! \n");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
