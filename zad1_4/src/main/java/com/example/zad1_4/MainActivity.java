package com.example.zad1_4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.opengl.ETC1;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText odpPolska;
    private EditText odpNiemcy;
    private EditText odpWlochy;
    private Button sprawdz;
    private TextView rezultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        odpPolska = (EditText) findViewById(R.id.odpPolska);
        odpNiemcy = (EditText) findViewById(R.id.odpNiemcy);
        odpWlochy = (EditText) findViewById(R.id.odpWlochy);
        sprawdz = (Button) findViewById(R.id.sprawdz);
        rezultat = (TextView) findViewById(R.id.rezultat);

        sprawdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sprawdz();
            }
        });
    }

    private void sprawdz() {
        String pl = odpPolska.getText().toString();
        String de = odpNiemcy.getText().toString();
        String it = odpWlochy.getText().toString();
        String brawo = "Brawo! :D";
        String sprobujPonownie = "Spróbuj ponownie :(";

        if (pl.isEmpty() || de.isEmpty() || it.isEmpty()) {
            Toast toast = Toast.makeText(this, "Wypełnił wszystkie pola!", Toast.LENGTH_LONG);
            toast.show();
        } else if (pl.equals("Warszawa") && de.equals("Berlin") && it.equals("Rzym")) {
            rezultat.setText(brawo);
        } else {
            rezultat.setText(sprobujPonownie);
        }
    }
}