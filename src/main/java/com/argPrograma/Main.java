package com.argPrograma;

import com.argPrograma.Services.MenuService;

public class Main {

    public static void main(String[] args) {

        try {
            MenuService menuService = new MenuService();
            menuService.menuPrincipal();
        } catch (NullPointerException e) {
            e.getMessage();
        }
    }
}