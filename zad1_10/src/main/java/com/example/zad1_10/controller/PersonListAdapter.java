package com.example.zad1_10.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;


import com.example.zad1_10.R;

import java.util.List;

import com.example.zad1_10.model.Group;
import com.example.zad1_10.model.Person;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class PersonListAdapter extends BaseExpandableListAdapter {
    private static class ViewHolder{
        TextView firstName;
        TextView lastName;
    }

    private final List<Group> groups;
    private final LayoutInflater inflater;

    PersonListAdapter(Context context, List<Group> groups) {
        super();
        this.groups = groups;
        inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return groups.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return groups.get(groupPosition).getChild(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
                             ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.main_list, null);
        }
        TextView tvGroupName = (TextView) convertView;
        tvGroupName.setText(groups.get(groupPosition).getGroupName());
        return convertView;
    }


    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                             View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.child_list, null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.firstName = (TextView) convertView.findViewById(R.id.first_name);
            viewHolder.lastName = (TextView) convertView.findViewById(R.id.last_name);
            convertView.setTag(viewHolder);

        }
        TextView firstName = ((ViewHolder)convertView.getTag()).firstName;
        TextView lastName = ((ViewHolder)convertView.getTag()).lastName;



        Person person = (Person) getChild(groupPosition, childPosition);
        firstName.setText(person.getFirstName());
        lastName.setText(person.getLastName());
        return convertView;
    }


    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
