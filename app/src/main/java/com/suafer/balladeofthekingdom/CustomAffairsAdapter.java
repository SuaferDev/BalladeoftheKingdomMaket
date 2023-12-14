package com.suafer.balladeofthekingdom;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class CustomAffairsAdapter extends ArrayAdapter {
    private final Activity context;
    private final Affairs.AffairsItem[] arr;

    public CustomAffairsAdapter(Activity context, Affairs.AffairsItem[] arr) {
        super(context, R.layout.custom_affairs_element, arr);
        this.context = context;
        this.arr = arr;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutInflater inflater = context.getLayoutInflater();
        if(convertView==null)
            row = inflater.inflate(R.layout.custom_affairs_element, null, true);
        ImageView imageAffairsLogo = row.findViewById(R.id.imageAffairsLogo);
        TextView textName = row.findViewById(R.id.textName);

        textName.setText(arr[position].getText());
        imageAffairsLogo.setImageResource(arr[position].image_id);
        return  row;
    }
}
/*
private Activity context;
    private final Notes[] notesArray;

    public CustomNotesClassAdapter(Activity context, Notes[] notesArray) {
        super(context, R.layout.custom_notes_element);
        this.context = context;
        this.notesArray = notesArray;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutInflater inflater = context.getLayoutInflater();
        if(convertView==null)
            row = inflater.inflate(R.layout.custom_notes_element, null, true);
        TextView textNotesName = row.findViewById(R.id.textNotesName);
        TextView textNotesData = row.findViewById(R.id.textNotesData);

        textNotesName.setText(notesArray[position].getName());
        textNotesData.setText(notesArray[position].getDate());
        return  row;
    }

 */

