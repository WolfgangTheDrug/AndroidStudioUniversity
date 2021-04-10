package com.example.zad1_10.model;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String groupName;
    private List<Person> children;

    public Group(String groupName) {
        this.groupName = groupName;
        this.children = new ArrayList<>();
    }

    public String getGroupName() {
        return groupName;
    }

    public int size() {
        return children.size();
    }

    public void addChild(Person person) {
        children.add(person);
    }

    public Person getChild(int position) {
        return children.get(position);
    }
}
