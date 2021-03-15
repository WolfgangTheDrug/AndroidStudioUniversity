package com.example.my1application;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="Cykl zycia";
    private EditText etImie;
    private EditText etNazwisko;
    private TextView tvHello;
    private Button byeButton;
    private Button hiButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etImie = (EditText) findViewById(R.id.etImie);
        etNazwisko = (EditText) findViewById(R.id.etNazwisko);
        tvHello = (TextView) findViewById(R.id.tvHello);
        hiButton = (Button) findViewById(R.id.hiButton);
        byeButton = (Button) findViewById(R.id.byeButton);
        hiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                witaj(v);
            }
        });
        byeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zegnaj(v);
            }
        });


        Log.d(TAG, "Metoda onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "metoda onStart");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "Metoda onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Metoda onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Metoda onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "metoda onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Metoda onDestroy");
    }

    //onCreate(), onStart(), onResume(), onPause(), onStop(), onDestroy(), onRestart()

    public void witaj(View view) {
        String imie = etImie.getText().toString();
        String nazwisko = etNazwisko.getText().toString();
        if (imie.isEmpty() || nazwisko.isEmpty()) {
            Toast toast = Toast.makeText(this, "Wypełnił obydwa pola!", Toast.LENGTH_LONG);
            toast.show();
        } else {
            tvHello.setText(String.format("Dzień dobry, %s %s", imie, nazwisko));
        }
    }

    @SuppressLint("SetTextI18n")
    public void zegnaj(View view) {
        tvHello.setText("Żegnaj!");
    }
}