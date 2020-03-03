package br.edu.ifsp.arq.dmos5_2020s1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText entradaEditText;
    private Button fareinheit2celsiusButton;
    private TextView saidaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entradaEditText = findViewById(R.id.edittext_entrada);
        saidaTextView = findViewById(R.id.textview_saida);
        fareinheit2celsiusButton = findViewById(R.id.button_fahrenheittocelsius);

        fareinheit2celsiusButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == fareinheit2celsiusButton) {
            paraCelsius();
        }
    }

    public double getEntrada() throws NumberFormatException {
        double entrada;

        try {
            entrada = Double.valueOf(entradaEditText.getText().toString());
        } catch (NumberFormatException ex) {
            entrada = 0;
            throw ex;
        }
        return entrada;
    }

    public void paraCelsius() {
        double temperatura;

        try {
            temperatura = getEntrada();
        } catch (NumberFormatException ex) {
            Toast.makeText(this, "Entrada inválida!", Toast.LENGTH_SHORT).show();
            temperatura = 0;
        }

        saidaTextView.setText(String.format("%.2fºC", (temperatura-32)/1.8));
    }

}
