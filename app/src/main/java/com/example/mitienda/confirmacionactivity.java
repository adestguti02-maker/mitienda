package com.example.mitienda;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class confirmacionactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacionactivity);

        TextView tvDatos = findViewById(R.id.tvDatos);
        Button btnSalir = findViewById(R.id.btnSalir);

        // Se reciben los datos enviados desde el formulario
        String tendero = getIntent().getStringExtra("tendero");
        String tienda = getIntent().getStringExtra("tienda");
        String telefono = getIntent().getStringExtra("telefono");
        String tipo = getIntent().getStringExtra("tipo");
        String controles = getIntent().getStringExtra("controles");

        tvDatos.setText(
                "Tendero: " + tendero + "\n" +
                        "Tienda: " + tienda + "\n" +
                        "Teléfono: " + telefono + "\n" +
                        "Tipo de tienda: " + tipo + "\n" +
                        "Controlará: " + controles
        );

        // Cierra todas las ventanas y sale de la app
        btnSalir.setOnClickListener(v -> finishAffinity());
    }
}