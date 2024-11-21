package com.example.projetofinal.views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projetofinal.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEntradas = findViewById(R.id.btnEntradas);
        btnEntradas.setOnClickListener(v -> openSection("Entradas"));

        Button btnPratos = findViewById(R.id.btnPratos);
        btnPratos.setOnClickListener(v -> openSection("Pratos Principais"));
    }

    private void openSection(String sectionType) {
        Intent intent = new Intent(this, MenuSectionActivity.class);
        intent.putExtra("SECTION_TYPE", sectionType);
        startActivity(intent);
    }
}
