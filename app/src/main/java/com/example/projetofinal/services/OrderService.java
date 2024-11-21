package com.example.projetofinal.services;

import com.example.projetofinal.models.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private final List<MenuItem> orderItems = new ArrayList<>();

    public void addItem(MenuItem item) {
        orderItems.add(item);
    }

    public List<MenuItem> getOrderItems() {
        return orderItems;
    }

    public double getTotal() {
        return orderItems.stream().mapToDouble(MenuItem::getPrice).sum();
    }

    public void clearOrder() {
        orderItems.clear(); // Limpa a lista de itens
    }
}

