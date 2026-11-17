package com.example.mitienda;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        EditText etTendero = findViewById(R.id.etTendero);
        EditText etTienda = findViewById(R.id.etTienda);
        EditText etTelefono = findViewById(R.id.etTelefono);
        RadioGroup rgTipo = findViewById(R.id.rgTipo);
        CheckBox cbInventario = findViewById(R.id.cbInventario);
        CheckBox cbVentas = findViewById(R.id.cbVentas);
        CheckBox cbFiados = findViewById(R.id.cbFiados);
        CheckBox cbReportes = findViewById(R.id.cbReportes);
        Button btnInscribirme = findViewById(R.id.btnInscribirme);

        btnInscribirme.setOnClickListener(v -> {
            String tendero = etTendero.getText().toString().trim();
            String tienda = etTienda.getText().toString().trim();
            String telefono = etTelefono.getText().toString().trim();

            // Validación: los tres campos de texto son obligatorios
            if (tendero.isEmpty() || tienda.isEmpty() || telefono.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            // Tipo de tienda seleccionado en el RadioGroup
            RadioButton seleccionado = findViewById(rgTipo.getCheckedRadioButtonId());
            String tipo = seleccionado.getText().toString();

            // Opciones marcadas en los CheckBox
            StringBuilder controles = new StringBuilder();
            if (cbInventario.isChecked()) controles.append("Inventario, ");
            if (cbVentas.isChecked()) controles.append("Ventas, ");
            if (cbFiados.isChecked()) controles.append("Fiados, ");
            if (cbReportes.isChecked()) controles.append("Reportes, ");

            String controlesTexto;
            if (controles.length() == 0) {
                controlesTexto = "Ninguna";
            } else {
                // Quita la última coma y espacio
                controlesTexto = controles.substring(0, controles.length() - 2);
            }

            // Se envían los datos a la ventana de confirmación
            Intent intent = new Intent(RegistroActivity.this, confirmacionactivity.class);
            intent.putExtra("tendero", tendero);
            intent.putExtra("tienda", tienda);
            intent.putExtra("telefono", telefono);
            intent.putExtra("tipo", tipo);
            intent.putExtra("controles", controlesTexto);
            startActivity(intent);
        });
    }
}