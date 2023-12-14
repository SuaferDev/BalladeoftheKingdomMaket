package com.suafer.balladeofthekingdom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewGameStart extends AppCompatActivity {

    //private SharedPreferences SaveStatus;
    private SharedPreferences SaveFood, SaveMaterial, SaveGold, SaveKnight, SavePeople, SaveTurn, SaveAffairs, SaveMap, SaveEffects;
    List<Affairs.AffairsItem> affairsItems;
    List<Tile.TileItem> map;
    List<Effect.EffectItem> effectList;

    Intent i = new Intent();
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game_start);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.new_game_color));

        LinearLayout main_linear = findViewById(R.id.main_linear);

        Animation mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        mFadeInAnimation.setAnimationListener(animationFadeInListener);
        main_linear.startAnimation(mFadeInAnimation);

        //SaveStatus = getSharedPreferences("status", Activity.MODE_PRIVATE);
        SaveFood = getSharedPreferences("food",Activity.MODE_PRIVATE); SaveMaterial = getSharedPreferences("material", Activity.MODE_PRIVATE);
        SaveGold = getSharedPreferences("gold",Activity.MODE_PRIVATE); SaveKnight = getSharedPreferences("knight", Activity.MODE_PRIVATE);
        SaveTurn = getSharedPreferences("turn",Activity.MODE_PRIVATE); SaveAffairs = getSharedPreferences("affairsItems", MODE_PRIVATE);
        SaveMap = getSharedPreferences("map",Activity.MODE_PRIVATE); SavePeople = getSharedPreferences("people", Activity.MODE_PRIVATE);
        SaveEffects = getSharedPreferences("effectList", Activity.MODE_PRIVATE);
        affairsItems = new ArrayList<>(); map = new ArrayList<>(); effectList = new ArrayList<>();

        generateMap();
        SharedPreferences saveFirstScreen = getSharedPreferences("firstscreen", Activity.MODE_PRIVATE);
        if(Integer.parseInt(saveFirstScreen.getString("firstscreen", ""))==0){
            mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_out);
            mFadeInAnimation.setAnimationListener(animationFadeInListener);
            main_linear.startAnimation(mFadeInAnimation);
            i.setClass(getApplicationContext(), Castle.class);
            save();
            startActivity(i);
            finish();
        }

        mediaPlayer = MediaPlayer.create(this, R.raw.startgametheme);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);

        TextView startgame = findViewById(R.id.startgame);

        startgame.setOnClickListener(view -> {
            save();
            if(mediaPlayer!=null){mediaPlayer.stop();}
            i.setClass(getApplicationContext(), Castle.class);
            startActivity(i);
            finish();
        });
    }

    private void save(){
        //SaveStatus.edit().putString("status",String.valueOf(0)).apply();
        SaveFood.edit().putString("food",String.valueOf(5)).apply();
        SaveMaterial.edit().putString("material",String.valueOf(5)).apply();
        SaveGold.edit().putString("gold",String.valueOf(5)).apply();
        SaveKnight.edit().putString("knight",String.valueOf(5)).apply();
        SavePeople.edit().putString("people",String.valueOf(5)).apply();
        SaveTurn.edit().putString("turn",String.valueOf(1)).apply();

        SharedPreferences.Editor editor = SaveAffairs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(affairsItems);
        editor.putString("affairsItems", json);
        editor.apply();

        SharedPreferences.Editor editorMap = SaveMap.edit();
        Gson gsonMap = new Gson();
        String jsonMap = gsonMap.toJson(map);
        editorMap.putString("map", jsonMap);
        editorMap.apply();

        SharedPreferences.Editor editorEffect = SaveEffects.edit();
        Gson gsonEffect = new Gson();
        String jsonEffect = gsonEffect.toJson(effectList);
        editorEffect.putString("effectList", jsonEffect);
        editorEffect.apply();
    }

    private void generateMap(){

        for(int i=0; i<16;i++){
            Random r = new Random();
            if(i==1 || i==5) {
                if (i == 1) {
                    map.add(Tile.getTile(1, 21));
                } else {
                    map.add(Tile.getTile(1, 11));
                }
            }else{
                map.add(Tile.getTile(1,(1+r.nextInt(3))));
            }
        }
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
    public void onStop() {
        super.onStop();
        save();
        if(mediaPlayer!=null){mediaPlayer.stop();}
    }
}
/** Не работает

 int tile_id = ThreadLocalRandom.current().nextInt(1, 4);
 if(tile_id==2 && !checkWasteland()){
 while(tile_id==2){
 tile_id = ThreadLocalRandom.current().nextInt(1, 4);
 }
 }
 map.add(Tile.getTile(tile_id,0));
 */