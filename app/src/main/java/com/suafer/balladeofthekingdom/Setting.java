package com.suafer.balladeofthekingdom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Setting extends AppCompatActivity {

    Toast toast, toastMessage;
    private SharedPreferences SaveLang, SaveAutoStart, SaveFirstScreen, SaveSkip;

    private Animation mFadeInAnimation;
    Intent i = new Intent();

    private int lang, autostart, firstscreen, skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.setting_color));
        setContentView(R.layout.activity_setting);

        /*
         Window window = getWindow();

// Устанавливаем флаги для скрытия цифр и изменения цвета статус-бара
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_VISIBLE);
        window.setStatusBarColor(Color.parseColor("#00000000"));
         */



        LinearLayout main_linear = findViewById(R.id.main_linear);
        ImageView image_back = findViewById(R.id.image_back);
        ImageView image_lang_ru = findViewById(R.id.image_lang_ru); TextView text_lang_ru = findViewById(R.id.text_lang_rus);
        ImageView image_autostart = findViewById(R.id.image_autostart); TextView text_autostart = findViewById(R.id.text_autostart);
        ImageView image_firstscreen = findViewById(R.id.image_firstscreen); TextView text_firstscreen = findViewById(R.id.text_firstscreen);
        //ImageView image_skip = findViewById(R.id.image_skip); TextView text_skip = findViewById(R.id.text_skip);

        mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        mFadeInAnimation.setAnimationListener(animationFadeInListener);
        main_linear.startAnimation(mFadeInAnimation);

        SaveLang = getSharedPreferences("lang", Activity.MODE_PRIVATE); lang = Integer.parseInt(SaveLang.getString("lang", ""));
        SaveAutoStart = getSharedPreferences("autostart", Activity.MODE_PRIVATE); autostart = Integer.parseInt(SaveAutoStart.getString("autostart", ""));
        SaveFirstScreen = getSharedPreferences("firstscreen", Activity.MODE_PRIVATE); firstscreen = Integer.parseInt(SaveFirstScreen.getString("firstscreen", ""));
        SaveSkip = getSharedPreferences("skip", Activity.MODE_PRIVATE); skip = Integer.parseInt(SaveSkip.getString("skip", ""));

        Toast.makeText(Setting.this, String.valueOf(firstscreen), Toast.LENGTH_LONG).show();

        if(autostart==1){image_autostart.setImageResource(R.drawable.settingon);}
        else {image_autostart.setImageResource(R.drawable.settingoff);}

        if(firstscreen==1){image_firstscreen.setImageResource(R.drawable.settingon);}
        else {image_firstscreen.setImageResource(R.drawable.settingoff);}

        /*
        if(skip==1){image_autostart.setImageResource(R.drawable.settingon);}
        else {image_autostart.setImageResource(R.drawable.settingoff);}
         */

        image_lang_ru.setOnClickListener(view -> {
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_toast_setting, findViewById(R.id.linear));
            toast = new Toast(getApplicationContext());
            toast.setGravity(Gravity.CENTER_HORIZONTAL,0, 0);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();
        });
        text_lang_ru.setOnClickListener(view ->{
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_toast_setting, findViewById(R.id.linear));
            toast = new Toast(getApplicationContext());
            toast.setGravity(Gravity.CENTER_HORIZONTAL,0, 0);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();
        });

        image_autostart.setOnClickListener(view ->{
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_toast_setting_message, findViewById(R.id.linear));
            TextView text = (TextView) layout.findViewById(R.id.text);
            if(autostart==1){
                text.setText("Авто продолжение игры выключено");
                image_autostart.setImageResource(R.drawable.settingoff); autostart=0;
            }else{
                text.setText("Авто продолжение игры включено");
                image_autostart.setImageResource(R.drawable.settingon); autostart=1;
            }
            toastMessage = new Toast(getApplicationContext());
            toastMessage.setGravity(Gravity.CENTER_HORIZONTAL,0, 0);
            toastMessage.setDuration(Toast.LENGTH_LONG);
            toastMessage.setView(layout);
            toastMessage.show();
        });
        text_autostart.setOnClickListener(view -> {
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_toast_setting_message, findViewById(R.id.linear));
            TextView text = (TextView) layout.findViewById(R.id.text);
            if(autostart==1){
                text.setText("Авто продолжение игры выключено");
                image_autostart.setImageResource(R.drawable.settingoff); autostart=0;
            }else{
                text.setText("Авто продолжение игры включено");
                image_autostart.setImageResource(R.drawable.settingon); autostart=1;
            }
            toastMessage = new Toast(getApplicationContext());
            toastMessage.setGravity(Gravity.CENTER_HORIZONTAL,0, 0);
            toastMessage.setDuration(Toast.LENGTH_LONG);
            toastMessage.setView(layout);
            toastMessage.show();
        });

        image_firstscreen.setOnClickListener(view ->{
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_toast_setting_message, findViewById(R.id.linear));
            TextView text = (TextView) layout.findViewById(R.id.text);
            if(firstscreen==1){
                text.setText("Начальный экран выключен");
                image_firstscreen.setImageResource(R.drawable.settingoff); firstscreen=0;
            }else{
                text.setText("Начальный экран включен");
                image_firstscreen.setImageResource(R.drawable.settingon); firstscreen=1;
            }
            toastMessage = new Toast(getApplicationContext());
            toastMessage.setGravity(Gravity.CENTER_HORIZONTAL,0, 0);
            toastMessage.setDuration(Toast.LENGTH_LONG);
            toastMessage.setView(layout);
            toastMessage.show();
        });
        text_firstscreen.setOnClickListener(view -> {
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_toast_setting_message, findViewById(R.id.linear));
            TextView text = (TextView) layout.findViewById(R.id.text);
            if(firstscreen==1){
                text.setText("Авто продолжение игры выключено");
                image_firstscreen.setImageResource(R.drawable.settingoff); firstscreen=0;
            }else{
                text.setText("Авто продолжение игры включено");
                image_firstscreen.setImageResource(R.drawable.settingon); firstscreen=1;
            }
            toastMessage = new Toast(getApplicationContext());
            toastMessage.setGravity(Gravity.CENTER_HORIZONTAL,0, 0);
            toastMessage.setDuration(Toast.LENGTH_LONG);
            toastMessage.setView(layout);
            toastMessage.show();
        });

        /*
        image_skip.setOnClickListener(view ->{
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_toast_setting_message, findViewById(R.id.linear));
            TextView text = (TextView) layout.findViewById(R.id.text);
            if(skip==1){
                text.setText("Начальный экран выключен");
                image_skip.setImageResource(R.drawable.settingoff); skip=0;
            }else{
                text.setText("Начальный экрна включен");
                image_skip.setImageResource(R.drawable.settingon); skip=1;
            }
            toastMessage = new Toast(getApplicationContext());
            toastMessage.setGravity(Gravity.CENTER_HORIZONTAL,0, 0);
            toastMessage.setDuration(Toast.LENGTH_LONG);
            toastMessage.setView(layout);
            toastMessage.show();
        });
        text_skip.setOnClickListener(view -> {
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_toast_setting_message, findViewById(R.id.linear));
            TextView text = layout.findViewById(R.id.text);
            if(skip==1){
                text.setText("Авто продолжение игры выключено");
                image_skip.setImageResource(R.drawable.settingoff); skip=0;
            }else{
                text.setText("Авто продолжение игры включено");
                image_skip.setImageResource(R.drawable.settingon); skip=1;
            }
            toastMessage = new Toast(getApplicationContext());
            toastMessage.setGravity(Gravity.RIGHT|Gravity.BOTTOM, 0, 0);
            toastMessage.setDuration(Toast.LENGTH_LONG);
            toastMessage.setView(layout);
            toastMessage.show();
        });

         */

        image_back.setOnClickListener(view ->{
            i.setClass(getApplicationContext(), Menu.class);
            startActivity(i);
        });

    }

    Animation.AnimationListener animationFadeInListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationEnd(Animation animation) {}

        @Override
        public void onAnimationRepeat(Animation animation) {}

        @Override
        public void onAnimationStart(Animation animation) {}
    };

    @Override
    public void onStop(){
        super.onStop();
        SaveLang.edit().putString("lang", String.valueOf(lang)).apply();
        SaveAutoStart.edit().putString("autostart", String.valueOf(autostart)).apply();
        SaveFirstScreen.edit().putString("firstscreen", String.valueOf(firstscreen)).apply();
        SaveSkip.edit().putString("skip", String.valueOf(skip)).apply();
    }
}