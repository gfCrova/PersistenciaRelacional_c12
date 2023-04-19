package com.argPrograma.Entities;

import java.util.ArrayList;
import java.util.List;

public class Departamento {

    private int id_dpto;
    private String nombre;
    private int presupuesto;
    private List<Empleado> listEmpleados;


    public Departamento() {
    }

    public Departamento(int id_dpto, String nombre, int presupuesto) {
        this.id_dpto = id_dpto;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
    }

    public int getId_dpto() {
        return id_dpto;
    }

    public void setId_dpto(int id_dpto) {
        this.id_dpto = id_dpto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public void agregar(Empleado empleado) {
        if (this.listEmpleados == null) {
            this.listEmpleados = new ArrayList<>();
        }
        this.listEmpleados.add(empleado);
    }

    @Override
    public String toString() {
        return  id_dpto + " Departamento de " + '\'' + nombre + '\'' + ": Presupuesto = " + presupuesto + "\n" +
                "\t Lista de empleados: \n" +
                "\t" + listEmpleados + "\n";
    }
}
