package com.suafer.balladeofthekingdom;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class CustomTileAdapter extends ArrayAdapter {

    private final List<Tile.TileAction> arr;
    private Context mContext;

    public CustomTileAdapter(Context context, List<Tile.TileAction> arr) {
        super(context, R.layout.custom_tile_element, arr);
        this.arr = arr;
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.custom_tile_element, parent, false);
        }
        ImageView tile_image = view.findViewById(R.id.tile_image);
        TextView tile_button1 = view.findViewById(R.id.tile_button1);


        ImageView image1 = view.findViewById(R.id.image1); TextView text1 = view.findViewById(R.id.text1);
        ImageView image2 = view.findViewById(R.id.image2); TextView text2 = view.findViewById(R.id.text2);
        ImageView image3 = view.findViewById(R.id.image3); TextView text3 = view.findViewById(R.id.text3);
        List<Tile.TileResource> ttr = arr.get(position).tileResources;
        if(ttr.size()>0){
            image1.setImageResource(ttr.get(0).getImage()); text1.setText(String.valueOf(ttr.get(0).getCount()));
        }
        if(ttr.size()>1){
            image2.setImageResource(ttr.get(1).getImage()); text2.setText(String.valueOf(ttr.get(1).getCount()));
        }
        if(ttr.size()>2){
            image3.setImageResource(ttr.get(2).getImage()); text3.setText(String.valueOf(ttr.get(2).getCount()));
        }

        tile_image.setImageResource(arr.get(position).getImage());
        tile_button1.setText(arr.get(position).getText());


        return view;
    }
}