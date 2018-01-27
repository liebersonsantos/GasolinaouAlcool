package com.example.lieberson.gasolinaoualcool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        private EditText precoAlcool;
        private EditText precoGasolina;
        private Button botaoVerificar;
        private TextView textoResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoAlcool = findViewById(R.id.precoAlcoolId);
        precoGasolina = findViewById(R.id.precoGasolinaId);
        botaoVerificar = findViewById(R.id.botaoVerificarId);
        textoResultado = findViewById(R.id.textoResuldadoId);

        botaoVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //recuperando valores digitados
                String textoPrecoAlcool = precoAlcool.getText().toString();
                String textoPrecoGasollina = precoGasolina.getText().toString();


                if (textoPrecoAlcool.trim().equals("") || textoPrecoGasollina.trim().equals("")){

                    Toast.makeText(getApplicationContext(), "Preencha o espaço em branco", Toast.LENGTH_LONG).show();
                }else {
                    Double valorAlcool = Double.parseDouble(textoPrecoAlcool);
                    Double valorGasolina = Double.parseDouble(textoPrecoGasollina);

                    Double resultado = valorAlcool / valorGasolina;

                    if (resultado >= 0.7){
                        textoResultado.setText("É melhor usar Gasolina");
                    }else {
                        textoResultado.setText("É melhor usar Álcool");
                    }


                }

            }


        });



    }
}
