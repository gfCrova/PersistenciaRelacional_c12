package com.argPrograma.Services;

import java.util.Scanner;

public class MenuService {

    public void menuPrincipal() {
        try {
            Scanner sc = new Scanner(System.in);
            EmpleadosService empleadosService = new EmpleadosService();
            DepartamentosService deptoService = new DepartamentosService();

            System.out.println("\nMenú Qatar2022\n");
            System.out.println("1 - Empleados");
            System.out.println("2 - Departamentos");
            System.out.println("3 - Salir");
            int elegirOpcion = Integer.parseInt(sc.nextLine());

            if (elegirOpcion == 1) {
                empleadosService.menuEmpleados();
            } else if (elegirOpcion == 2) {
                deptoService.menuDepartamentos();
            } else if (elegirOpcion == 3) {
                System.out.println("Programa Finalizado!");
            } else {
                throw new RuntimeException("Error: Opción Inválida. Por favor elegir entre las opciones disponibles.");
            }
        }  catch (NullPointerException e) {
            e.getMessage();
        }
    }
}
