package com.argPrograma.Services;

import com.argPrograma.Entities.Departamento;
import com.argPrograma.Entities.Empleado;
import com.argPrograma.dao.DepartamentosDAO;

import java.text.NumberFormat;
import java.util.Scanner;

public class DepartamentosService {
    Scanner sc;
    Departamento departamento;
    DepartamentosDAO deptoDao = new DepartamentosDAO();
    MenuService menu = new MenuService();
    public void menuDepartamentos() {
        try {
            sc = new Scanner(System.in);
            System.out.println("\nMenú Departamentos\n");
            System.out.println("Elige una opción:");
            System.out.println("1 - Listar los departamentos");
            System.out.println("2 - Mostrar Empleados de cada departamento");
            System.out.println("3 - Eliminar un departamento");
            System.out.println("4 - Volver al Menú Principal");
            System.out.println("5 - Salir");
            int opcion = Integer.parseInt(sc.nextLine());

            if (opcion <= 0 || opcion > 5) {
                throw new RuntimeException("Error: Opción Inválida. Por favor elegir entre las opciones disponibles.");
            } else {
                switch (opcion) {
                    case 1: {
                        System.out.println(deptoDao.listarDepto());
                        menuDepartamentos();
                    }
                    case 2: {
                        System.out.println(deptoDao.mostrarConEmpleados());
                        menuDepartamentos();
                    }
                    case 3: {
                        delete();
                        menuDepartamentos();
                    }
                    case 4: {
                        menu.menuPrincipal();
                    }
                    case 5: {
                        System.out.println("Programa Finalizado!");
                        Runtime.getRuntime().exit(1);
                    }
                }
            }
        }catch (NullPointerException e) {
            System.out.println("No se puede agregar un campo vacío. " + e.getMessage());
            e.printStackTrace();
        }catch (NumberFormatException e) {
            System.out.println("Solo se permiten caracteres numéricos. " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void delete() {
        sc = new Scanner(System.in);
        try {
            System.out.println("Ingrese el 'ID' del Departamento que desea Eliminar: ");
            int id = Integer.parseInt(sc.nextLine());

            for (Departamento em : deptoDao.listarDepto()) {
                if (id == em.getId_dpto()){
                    deptoDao.eliminarDepto(id);
                    break;
                }
            }
            menuDepartamentos();
        }catch (NullPointerException e) {
            System.out.println("No se puede agregar un campo vacío. " + e.getMessage());
            e.printStackTrace();
        }catch (NumberFormatException e) {
            System.out.println("Solo se permiten caracteres numéricos. " + e.getMessage());
            e.printStackTrace();
        }
    }
}
