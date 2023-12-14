package com.suafer.balladeofthekingdom;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    private SharedPreferences SaveTurn, SaveLang, SaveAutoStart, SaveFirstScreen, SaveSkip;
    private Animation mFadeInAnimation;
    Intent i = new Intent();

    private int lang, autostart, firstscreen, skip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.menu_color));

        TextView newgametextview = findViewById(R.id.newgametextview);
        TextView continietextview = findViewById(R.id.continietextview);
        TextView settingtextview = findViewById(R.id.settingtextview);
        LinearLayout main_linear = findViewById(R.id.main_linear);

        mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        mFadeInAnimation.setAnimationListener(animationFadeInListener);
        main_linear.startAnimation(mFadeInAnimation);

        newgametextview.startAnimation(mFadeInAnimation);
        continietextview.startAnimation(mFadeInAnimation);
        settingtextview.startAnimation(mFadeInAnimation);

        SaveTurn = getSharedPreferences("turn", Activity.MODE_PRIVATE);
        if(SaveTurn.getString("turn","").equals("")){
            continietextview.setTextColor(0xFF6F6F6F);
            ImageView image_continie = findViewById(R.id.image_continie);
            image_continie.setImageResource(R.drawable.menu_icon_lock);
        }

        SaveLang = getSharedPreferences("lang", Activity.MODE_PRIVATE);
        if (SaveLang.getString("lang", "").equals("")) {
            SaveLang.edit().putString("lang", "0").apply();
        }
        lang = Integer.parseInt(SaveLang.getString("lang", ""));

        SaveAutoStart = getSharedPreferences("autostart", Activity.MODE_PRIVATE);
        if (SaveAutoStart.getString("autostart", "").equals("")) {
            SaveAutoStart.edit().putString("autostart", "0").apply();
        }
        autostart = Integer.parseInt(SaveAutoStart.getString("autostart", ""));

        SaveFirstScreen = getSharedPreferences("firstscreen", Activity.MODE_PRIVATE);
        if (SaveFirstScreen.getString("firstscreen", "").equals("")) {
            SaveFirstScreen.edit().putString("firstscreen", "1").apply();
        }
        firstscreen = Integer.parseInt(SaveFirstScreen.getString("firstscreen", ""));

        SaveSkip = getSharedPreferences("skip", Activity.MODE_PRIVATE);
        if (SaveSkip.getString("skip", "").equals("")) {
            SaveSkip.edit().putString("skip", "0").apply();
        }
        skip = Integer.parseInt(SaveSkip.getString("skip", ""));

        //if(!SaveTurn.getString("turn","").equals("")){i.setClass(getApplicationContext(), NewGameStart.class);startActivity(i);finish();}

        //setting = WorkMethod.stringToIntArray(SaveSetting.getString("setting", ""));


        Dialog dialog = new Dialog(Menu.this);

        ImageView test_image = findViewById(R.id.test_image);
        test_image.setOnClickListener(view -> {
            i.setClass(getApplicationContext(), Education.class);
            startActivity(i);
            finish();
        });


        /*

        newgametextview.setOnClickListener(view -> {
            if(SaveTurn.getString("turn","").equals("")){
                i.setClass(getApplicationContext(), NewGameStartScreen.class);
                startActivity(i);
            }else{
                dialog.setContentView(R.layout.custom_dialog);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.setCancelable(true);
                dialog.getWindow().getAttributes().windowAnimations = R.style.Theme_TheBalladeOfTheKingdom;

                name = dialog.findViewById(R.id.name);
                name.setText("Новая игра");
                text = dialog.findViewById(R.id.text);
                text.setText("У Вас уже есть начатая игра, если Вы начнете новую игру, то потеряете весь прощлый прогресс!");
                okbuttun = dialog.findViewById(R.id.okbuttun);
                okbuttun.setText("Новая игра");
                nobuttun = dialog.findViewById(R.id.nobuttun);
                nobuttun.setText("Продолжить старую");
                linear = dialog.findViewById(R.id.linear);
                //linear.setBackground(new GradientDrawable() {public GradientDrawable getIns(int a, int b) {this.setCornerRadius(a); this.setColor(b); return this;}}.getIns((int)20, 0xFF2E2F30));

                okbuttun.setOnClickListener(v -> {
                    dialog.dismiss();
                    i.setClass(getApplicationContext(), NewGameStartScreen.class);
                    startActivity(i);
                    finish();
                });
                nobuttun.setOnClickListener(v -> {
                    dialog.dismiss();
                    i.setClass(getApplicationContext(), Castle.class);
                    startActivity(i);
                    finish();
                });
                dialog.show();
            }
        });
*/

        continietextview.setOnClickListener(view -> {
            if(!SaveTurn.getString("turn","").equals("")){
                i.setClass(getApplicationContext(), Castle.class);
                startActivity(i);
                finish();
            }
        });

        newgametextview.setOnClickListener(view -> {
            i.setClass(getApplicationContext(), NewGameStart.class);
            startActivity(i);
            finish();
        });

        settingtextview.setOnClickListener(view -> {
            i.setClass(getApplicationContext(), Setting.class);
            startActivity(i);
        });
    }
    Animation.AnimationListener animationFadeInListener = new Animation.AnimationListener() {
        @Override public void onAnimationEnd(Animation animation) {}
        @Override public void onAnimationRepeat(Animation animation) {}
        @Override public void onAnimationStart(Animation animation) {}
    };

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Выйти из приложения?")
                .setMessage("Вы действительно хотите выйти?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        //SaveSetting.edit().putString("setting",WorkMethod.arrayToString(setting)).apply();
                        Menu.super.onBackPressed();
                    }
                }).create().show();
    }
    @Override
    public void onStop(){
        super.onStop();
        SaveLang.edit().putString("lang", String.valueOf(lang)).apply();
        SaveAutoStart.edit().putString("autostart", String.valueOf(autostart)).apply();
        SaveFirstScreen.edit().putString("firstscreen", String.valueOf(firstscreen)).apply();
        SaveSkip.edit().putString("skip", String.valueOf(skip)).apply();
    }
}