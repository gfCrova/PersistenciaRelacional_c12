package com.argPrograma.Services;

import com.argPrograma.Entities.Departamento;
import com.argPrograma.dao.DepartamentosDAO;

import java.util.Scanner;

public class DeptoService {
    Scanner sc;
    Departamento departamento;
    DepartamentosDAO deptoDao = new DepartamentosDAO();
    MenuService menu = new MenuService();
    public void menuDepartamentos() {

        sc = new Scanner(System.in);
        System.out.println("\nMenú Departamentos\n");
        System.out.println("Elige una opción:");
        System.out.println("1 - Listar los departamentos");
        System.out.println("2 - Mostrar Empleados de cada departamento");
        System.out.println("3 - Eliminar un departamento");
        System.out.println("4 - Volver al Menú Principal");
        System.out.println("5 - Salir");
        int opcion = Integer.parseInt(sc.nextLine());

        if (opcion <= 0 || opcion > 5){
            throw new RuntimeException("Error: Opción Inválida. Por favor elegir entre las opciones disponibles.");
        } else {
            switch (opcion) {
                case 1: {
                    System.out.println(deptoDao.listarDepto());
                    menuDepartamentos();
                }
                case 2: {
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
                }
            }
        }
    }

    public void delete() {
        sc = new Scanner(System.in);
        try {
            System.out.println("Ingrese el 'ID' del Departamento que desea Eliminar: ");
            int id = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < deptoDao.listarDepto().size(); i++) {
                if (id == deptoDao.listarDepto().get(i).getId_dpto()){
                    deptoDao.eliminarDepto(id);
                } else {
                    throw new RuntimeException("Error: No se puede eliminar un id que no existe.");
                }
            }
            menuDepartamentos();
        }catch (NullPointerException e) {
            System.out.println("No se pueden agregar campos vacíos " + e.getMessage());
        }
    }
}
