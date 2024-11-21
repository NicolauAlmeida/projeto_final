package com.example.projetofinal.views;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetofinal.R;
import com.example.projetofinal.adapter.MenuAdapter;
import com.example.projetofinal.models.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MenuSectionActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MenuAdapter menuAdapter;
    private List<MenuItem> menuItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_section);

        // Recupera o tipo de seção passada pela MainActivity
        String sectionType = getIntent().getStringExtra("SECTION_TYPE");

        // Define o título da seção
        TextView sectionTitle = findViewById(R.id.section_title);
        sectionTitle.setText(sectionType);

        // Inicializa o RecyclerView
        recyclerView = findViewById(R.id.menu_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Carrega os itens do menu com base no tipo de seção
        menuItems = loadMenuItems(sectionType);

        // Configura o adaptador do RecyclerView
        menuAdapter = new MenuAdapter(menuItems);
        recyclerView.setAdapter(menuAdapter);
    }

    private List<MenuItem> loadMenuItems(String sectionType) {
        // Exemplo de dados mockados para cada seção
        List<MenuItem> items = new ArrayList<>();
        if ("Entradas".equals(sectionType)) {
            items.add(new MenuItem("Bruschetta", 12.99));
            items.add(new MenuItem("Mini Quiche", 10.50));
        } else if ("Pratos Principais".equals(sectionType)) {
            items.add(new MenuItem("Filé à Parmegiana (1/2)", 24.99));
            items.add(new MenuItem("Filé à Parmegiana (Inteiro)", 39.99));
        }
        // Adicione mais condições para outras seções, como sobremesas e bebidas
        return items;
    }
}
