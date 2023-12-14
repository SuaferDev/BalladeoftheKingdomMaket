package com.suafer.balladeofthekingdom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class CustomEffectAdapter extends ArrayAdapter {

    private final List<Effect.EffectItem> arr;
    private Context mContext;

    public CustomEffectAdapter(Context context, List<Effect.EffectItem> arr) {
        super(context, R.layout.custom_effect_element, arr);
        this.arr = arr;
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.custom_effect_element, parent, false);
        }

        // Получить ссылки на виджеты элемента списка
        ImageView imageEffectLogo = (ImageView) view.findViewById(R.id.imageEffectLogo);

        imageEffectLogo.setImageResource(arr.get(position).getImageId());
        // Получить данные для текущей позиции


        return view;
    }
}