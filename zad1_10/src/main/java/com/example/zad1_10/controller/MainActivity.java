package com.example.zad1_10.controller;

import android.os.Bundle;
import android.widget.ExpandableListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import com.example.zad1_10.model.Group;
import com.example.zad1_10.model.Person;

public class MainActivity extends AppCompatActivity {
    private List<Group> groups = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Group family = new Group("Rodzina");
        groups.add(family);
        family.addChild(new Person("Zosia", "Kowalska"));
        family.addChild(new Person("Arek ", "Nowak"));
        /* = = = */
        Group friends = new Group("Znajomi");
        groups.add(friends);
        friends.addChild(new Person("Jaś", "Cichomski"));
        friends.addChild(new Person("Kamil", "Zapalski"));
        /* = = = */
        Group work = new Group("Praca");
        groups.add(work);
        work.addChild(new Person("Marta", "Kimsa"));
        work.addChild(new Person("Marta", "Niekimsa"));

        ExpandableListView listView = new ExpandableListView(this);
        PersonListAdapter adapter = new PersonListAdapter(this, groups);
        listView.setAdapter(adapter);

        this.setContentView(listView);
    }
}
