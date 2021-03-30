package com.example.zad1_9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Person> listOfPerson = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listOfPerson.add(new Person("Jan", "Kowalski"));
        listOfPerson.add(new Person("Michał", "Kowalski"));
        listOfPerson.add(new Person("Krzysiek", "Kowalski"));
        listOfPerson.add(new Person("Marta", "Kowalska"));
        listOfPerson.add(new Person("Stefan", "Kowalski"));

        PersonAdapter adapter = new PersonAdapter(this, listOfPerson);
        ListView listView = new ListView(this);
        listView.setAdapter(adapter);
        this.setContentView(listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long rowId) {
                String message = "Wybrales " + listOfPerson.get(position).firstName + " " + listOfPerson.get(position).lastName;
//                Snackbar.make(adapterView, message, Snackbar.LENGTH_LONG).show();
                Snackbar snackbar = Snackbar.make(adapterView, message, Snackbar.LENGTH_LONG);
                snackbar.setAction("Potwierdź usunięcie", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listOfPerson.remove(position);
                        adapter.notifyDataSetChanged();
                        View contextView = findViewById(android.R.id.content);
                        Snackbar.make(contextView, "Usunięto", Snackbar.LENGTH_SHORT).show();
                    }
                });
                snackbar.setActionTextColor(Color.RED);
                snackbar.show();
            }
        });
    }

    private static class Person {
        String firstName;
        String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }

    private static class PersonAdapter extends ArrayAdapter<Person> {
        private final Context context;

        public PersonAdapter(Context context, List<Person> persons) {
            super(context, R.layout.activity_main, persons);
            this.context = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            if (convertView == null) {
                //pobieram standardową instancję LayoutInflaterI,
                //która jest podłączona do bieżacego kontekstu
                LayoutInflater inflater =
                        (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                //ustawiam układ xml
                view = inflater.inflate(R.layout.activity_main, parent, false);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.firstName = (TextView) view.findViewById(R.id.first_name);
                viewHolder.lastName = (TextView) view.findViewById(R.id.last_name);
                //ustawia viewHolder jako tag – dodatkowa informacja w view
                view.setTag(viewHolder);
            } else {
                view = convertView;
            }
            //pobieram uchwyty do widoków, w których maja być wyswietlone dane
            TextView firstName = ((ViewHolder)view.getTag()).firstName;
            TextView lastName = ((ViewHolder)view.getTag()).lastName;
            //wstawiam do widokow dane osoby z listy o indeksie position
            Person person = this.getItem(position);
            firstName.setText(person.firstName);
            lastName.setText(person.lastName);
            return view;
        }
    }

    private static class ViewHolder {
        TextView firstName;
        TextView lastName;

    }
}


