package com.example.projetofinal.presenter;

import com.example.projetofinal.models.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class MenuPresenter {
    public List<MenuItem> getMenuItems() {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Salada Caesar", "Entradas", "Meio", 12.00));
        menuItems.add(new MenuItem("Salada Caesar", "Entradas", "Inteiro", 20.00));
        menuItems.add(new MenuItem("Filet Mignon", "Prato Principal", "Meio", 35.00));
        menuItems.add(new MenuItem("Filet Mignon", "Prato Principal", "Inteiro", 60.00));
        menuItems.add(new MenuItem("Pudim", "Sobremesas", "", 15.00));
        return menuItems;
    }
}
