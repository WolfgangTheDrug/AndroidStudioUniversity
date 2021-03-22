package com.example.zad1_6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new ArrayAdapter<String>(this, R.layout.activity_main);
        adapter.add("Pierwszy element");
        adapter.add("Drugi element");
        adapter.add("Trzeci element");
        setListAdapter(adapter);
        getListView().setOnItemClickListener(listener);
    }

    private AdapterView.OnItemClickListener listener =
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String element = adapter.getItem(position);
                    Toast toast = Toast.makeText(getApplicationContext(), element, Toast.LENGTH_LONG);
                    toast.show();
                }
            };
}