package com.example.zad1_8;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends ListActivity {

    private ArrayAdapter<String> adapter;
    private final String CHECKED_SIGNATURE = " OK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new ArrayAdapter<String>(this, R.layout.activity_main);
        adapter.add("hlep");
        adapter.add("mazło");
        adapter.add("pomajdorki");
        adapter.add("brokolik");
        setListAdapter(adapter);
        getListView().setOnItemClickListener(listener);
    }

    private AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String element = adapter.getItem(position);
            Pattern pattern = Pattern.compile(".+"+CHECKED_SIGNATURE); // napis postaci "item OK"
            Matcher matcher = pattern.matcher(element);
            adapter.remove(element); // zawsze usuwamy element, by go zastąpić potem
            if (matcher.find()){ // jeśli ma w sobie " OK", to
                adapter.insert(element.substring(0, element.length()-CHECKED_SIGNATURE.length()), position); // wstaw bez OK
            } else { // w przeciwnym razie
                adapter.insert(element + CHECKED_SIGNATURE, position); // wstaw z dodanym OK
                Toast toast = Toast.makeText(getApplicationContext(), "Kliknięto w " + element, Toast.LENGTH_LONG);
                toast.show();
            }
        }
    };
}