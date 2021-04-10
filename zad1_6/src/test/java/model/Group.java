package model;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String groupName;
    private List<Person> children;

    public Group(String groupName, List<Person> children) {
        this.groupName = groupName;
        this.children = new ArrayList<>(children);
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
