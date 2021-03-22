package com.example.zad1_7;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Gravity;
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
        for (int i = 1; i <= 50; i++) adapter.add(Integer.toString((int) Math.pow(i, 2)));

        setListAdapter(adapter);
        getListView().setOnItemClickListener(listener);
    }

    private AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String element = Integer.valueOf((int) Math.sqrt(Integer.parseInt(adapter.getItem(position)))).toString();
            Toast toast = Toast.makeText(getApplicationContext(), element, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();
        }
    };
}