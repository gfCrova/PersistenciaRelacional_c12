package com.argPrograma.Entities;

public class Empleado {

    private int id_empleados;
    private String nombre;
    private String apellido;
    private int dni;
    private String nacionalidad;


    public Empleado() {
    }

    public Empleado(String nombre, String apellido, int dni, String nacionalidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.nacionalidad = nacionalidad;
    }

    public Empleado(int id_empleados, String nombre, String apellido, int dni, String nacionalidad) {
        this.id_empleados = id_empleados;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.nacionalidad = nacionalidad;
    }

    public int getId_empleados() {
        return id_empleados;
    }

    public void setId_empleados(int id_empleados) {
        this.id_empleados = id_empleados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "\t ID: " + id_empleados + ", " + nombre + ", " + apellido + ", DNI:" + dni + ", " + nacionalidad + "\n";
    }
}
