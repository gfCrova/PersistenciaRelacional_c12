package com.argPrograma.Services;

import com.argPrograma.Entities.Empleado;
import com.argPrograma.dao.EmpleadosDAO;

import java.util.Objects;
import java.util.Scanner;

public class EmpleadosService {
    Scanner sc;
    Empleado empleado1 = new Empleado();
    EmpleadosDAO dao = new EmpleadosDAO();
    MenuService menu = new MenuService();
    public void ingresarEmpleado(Empleado empleado) {
        sc = new Scanner(System.in);
        try {
            System.out.println("Ingrese el nombre: ");
            empleado.setNombre(sc.nextLine());
            System.out.println("Ingrese el apellido: ");
            empleado.setApellido(sc.nextLine());
            System.out.println("Ingrese el dni: ");
            empleado.setDni(Integer.parseInt(sc.nextLine()));
            System.out.println("Ingrese la nacionalidad: ");
            empleado.setNacionalidad(sc.nextLine());
            System.out.println("Especifique el Departamento del nuevo empleado: ");
            System.out.println("1 - Logística");
            System.out.println("2 - Sistemas");
            System.out.println("3 - Compras");
            empleado.setDpto_id(Integer.parseInt(sc.nextLine()));

            if (!Objects.equals(empleado.getNombre(), "") && !Objects.equals(empleado.getApellido(), "") && !Objects.equals(empleado.getDni(), 0) && !Objects.equals(empleado.getNacionalidad(), "") && !Objects.equals(empleado.getDpto_id(), 0)) {
                dao.registrarEmpleado(empleado);
                System.out.println("Persona agregada con éxito!! \n");
            } else {
                throw new NullPointerException("No se pueden agregar campos vacíos ");
            }
            menuEmpleados();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void modificarEmpleado() {
        sc = new Scanner(System.in);
        try {
            System.out.println("Ingrese el 'ID' del empleado que quiere Modificar: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.println("Ingrese su Nueva nacionalidad: ");
            String nac = sc.nextLine();

            for (Empleado em : dao.listarEmpleado()) {
                if(id == em.getId_empleados()) {
                    dao.modificarNac(nac, id);
                    break;
                }
            }
            menuEmpleados();
        } catch (NullPointerException e) {
            System.out.println("No se pueden agregar campos vacíos " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Solo se permiten caracteres numéricos. " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void eliminarEmpleado() {
        sc = new Scanner(System.in);
        try {
            System.out.println("Ingrese el 'ID' del empleado que quiere Eliminar: ");
            int id = Integer.parseInt(sc.nextLine());

            for (Empleado em : dao.listarEmpleado()) {
                if (id == em.getId_empleados()){
                    dao.eliminar(id);
                    break;
                }
            }
            menuEmpleados();
        }catch (NullPointerException e) {
            System.out.println("No se pueden agregar campos vacíos " + e.getMessage());
        }catch (NumberFormatException e) {
            System.out.println("Solo se permiten caracteres numéricos. " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void menuEmpleados() {
        try {
            sc = new Scanner(System.in);
            System.out.println("\nMenú Empleados\n");
            System.out.println("Elige una opción:");
            System.out.println("1 - Agregar nuevo empleado");
            System.out.println("2 - Listar todos los empleados");
            System.out.println("3 - Modificar un empleado");
            System.out.println("4 - Eliminar un empleado");
            System.out.println("5 - Volver al Menú Principal");
            System.out.println("6 - Salir");
            int opcion = Integer.parseInt(sc.nextLine());

            if (opcion <= 0 || opcion > 6) {
                throw new RuntimeException("Error: Opción Inválida. Por favor elegir entre las opciones disponibles.");
            } else {
                switch (opcion) {
                    case 1: {
                        ingresarEmpleado(empleado1);
                        menuEmpleados();
                    }
                    case 2: {
                        System.out.println(dao.listarEmpleado());
                        menuEmpleados();
                    }
                    case 3: {
                        modificarEmpleado();
                        menuEmpleados();
                    }
                    case 4: {
                        eliminarEmpleado();
                        menuEmpleados();
                    }
                    case 5: {
                        menu.menuPrincipal();
                    }
                    case 6: {
                        System.out.println("Programa Finalizado!");
                        Runtime.getRuntime().exit(1);
                    }
                }
            }
        }catch (NumberFormatException e) {
            System.out.println("Solo se permiten caracteres numéricos. " + e.getMessage());
            e.printStackTrace();
        }catch (NullPointerException e) {
            System.out.println("No se puede agregar un campo vacío. " + e.getMessage());
            e.printStackTrace();
        }
    }
}
