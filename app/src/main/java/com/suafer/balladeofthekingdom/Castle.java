package com.suafer.balladeofthekingdom;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class Castle extends AppCompatActivity {

    private ListView listView;
    private ListView listviewActionTile;
    //TextView с подсчётом ресурсов
    private TextView phasetext, foodtext, goldtext, materialtext, knighttext, peoplestatustext, textAffairs;
    private LinearLayout main_linear;
    private ImageView tile1, tile2, tile3, tile4, tile5, tile6, tile7, tile8, tile9, tile10, tile11, tile12, tile13, tile14, tile15, tile16;
    private ImageView nextturnimage, effect1, effect2, effect3, effect4;

    private ValueAnimator colorAnimation;

    public static int food;
    public static int material;
    public static int gold;
    public static int knight;
    public static int people;

    public int turn, status;
    public static List<Tile.TileItem> map;
    public static List<Affairs.AffairsItem> affairsItems;
    public static List<Affairs.AffairsItem> lastAffairs;
    public static List<Effect.EffectItem> effectList = new ArrayList<>();

    //private SharedPreferences SaveStatus;
    private SharedPreferences SaveFood;
    private SharedPreferences SaveMaterial;
    private SharedPreferences SaveGold;
    private SharedPreferences SaveKnight;
    private SharedPreferences SavePeople;
    private SharedPreferences SaveTurn;
    private SharedPreferences SaveAffairs;
    private SharedPreferences SaveMap;
    private SharedPreferences SaveEffects;

    Intent i = new Intent();
    public SharedPreferences SaveGame;
    private Animation mFadeInAnimation;
    private RotateAnimation animation;

    private Dialog dialogAffairs;

    //private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_castle);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.menu_color));

        /* Определиение id*/
        nextturnimage = findViewById(R.id.nextturnimage);
        phasetext = findViewById(R.id.phasetext); textAffairs = findViewById(R.id.textAffairs);
        LinearLayout affairsButton = findViewById(R.id.affairsButton);
        main_linear = findViewById(R.id.main_linear);

        mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        mFadeInAnimation.setAnimationListener(animationFadeInListener);
        main_linear.startAnimation(mFadeInAnimation);

        foodtext = findViewById(R.id.foodtext); materialtext = findViewById(R.id.materialtext);
        goldtext = findViewById(R.id.goldtext); knighttext = findViewById(R.id.knighttext);
        peoplestatustext = findViewById(R.id.peoplestatustext);
        lastAffairs = new ArrayList<>(); map = new ArrayList<>();

        tile1 = findViewById(R.id.tile1); tile2 = findViewById(R.id.tile2); tile3 = findViewById(R.id.tile3);
        tile4 = findViewById(R.id.tile4); tile5 = findViewById(R.id.tile5); tile6 = findViewById(R.id.tile6);
        tile7 = findViewById(R.id.tile7); tile8 = findViewById(R.id.tile8); tile9= findViewById(R.id.tile9);
        tile10 = findViewById(R.id.tile10); tile11 = findViewById(R.id.tile11); tile12 = findViewById(R.id.tile12);
        tile13 = findViewById(R.id.tile13); tile14 = findViewById(R.id.tile14); tile15 = findViewById(R.id.tile15);
        tile16 = findViewById(R.id.tile16);

        effect1 = findViewById(R.id.effect1); effect2 = findViewById(R.id.effect2); effect3 = findViewById(R.id.effect3); effect4 = findViewById(R.id.effect4);

        /* Получение сохранения*/
        //SaveStatus = getSharedPreferences("status",Activity.MODE_PRIVATE);
        SaveFood = getSharedPreferences("food", Activity.MODE_PRIVATE); SaveMaterial = getSharedPreferences("material", Activity.MODE_PRIVATE);
        SaveGold = getSharedPreferences("gold", Activity.MODE_PRIVATE); SaveKnight = getSharedPreferences("knight", Activity.MODE_PRIVATE);
        SaveTurn = getSharedPreferences("turn", Activity.MODE_PRIVATE); SaveGame = getSharedPreferences("game", Context.MODE_PRIVATE);
        SaveAffairs = getSharedPreferences("affairsItems", MODE_PRIVATE); SaveMap = getSharedPreferences("map",Activity.MODE_PRIVATE);
        SavePeople = getSharedPreferences("people", MODE_PRIVATE);
        SaveEffects = getSharedPreferences("effectList", MODE_PRIVATE);

        food = Integer.parseInt(SaveFood.getString("food","")); material = Integer.parseInt(SaveMaterial.getString("material",""));
        gold = Integer.parseInt(SaveGold.getString("gold","")); knight = Integer.parseInt(SaveKnight.getString("knight",""));
        people = Integer.parseInt(SavePeople.getString("people",""));
        turn = Integer.parseInt(SaveTurn.getString("turn",""));
        //status = Integer.parseInt(SaveStatus.getString("status",""));

        String json = SaveAffairs.getString("affairsItems", "");
        String jsonMap = SaveMap.getString("map","");
        String jsonEffect = SaveEffects.getString("effectList", "");

        Gson gson = new Gson();
        Type type = new TypeToken<List<Affairs.AffairsItem>>() {}.getType();
        affairsItems = gson.fromJson(json, type);

        Gson gsonMap = new Gson();
        Type typeMap = new TypeToken<List<Tile.TileItem>>() {}.getType();
        map = gsonMap.fromJson(jsonMap, typeMap);
        setMap();

        Gson gsonEffect = new Gson();
        Type typeEffect = new TypeToken<List<Tile.TileItem>>() {}.getType();
        effectList = gsonEffect.fromJson(jsonEffect, typeEffect);
        setEffect();

        foodtext.setText(String.valueOf(food)); materialtext.setText(String.valueOf(material));
        goldtext.setText(String.valueOf(gold)); knighttext.setText(String.valueOf(knight));
        peoplestatustext.setBackgroundResource(setPeopleImageCount());
        phasetext.setText("Ход " + turn);
        textAffairs.setText(String.valueOf("События "+ affairsItems.size()));


        tile1.setOnClickListener(view -> {createTileDialog(map.get(0),0);});
        tile2.setOnClickListener(view -> {createTileDialog(map.get(1),1);});
        tile3.setOnClickListener(view -> {createTileDialog(map.get(2),2);});
        tile4.setOnClickListener(view -> {createTileDialog(map.get(3),3);});
        tile5.setOnClickListener(view -> {createTileDialog(map.get(4),4);});
        tile6.setOnClickListener(view -> {createTileDialog(map.get(5),5);});
        tile7.setOnClickListener(view -> {createTileDialog(map.get(6),6);});
        tile8.setOnClickListener(view -> {createTileDialog(map.get(7),7);});
        tile9.setOnClickListener(view -> {createTileDialog(map.get(8),8);});
        tile10.setOnClickListener(view -> {createTileDialog(map.get(9),9);});
        tile11.setOnClickListener(view -> {createTileDialog(map.get(10),10);});
        tile12.setOnClickListener(view -> {createTileDialog(map.get(11),11);});
        tile13.setOnClickListener(view -> {createTileDialog(map.get(12),12);});
        tile14.setOnClickListener(view -> {createTileDialog(map.get(13),13);});
        tile15.setOnClickListener(view -> {createTileDialog(map.get(14),14);});
        tile16.setOnClickListener(view -> {createTileDialog(map.get(15),15);});


        colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), Color.WHITE, Color.DKGRAY, Color.WHITE);
        colorAnimation.setDuration(2500);
        colorAnimation.setRepeatCount(ValueAnimator.INFINITE);
        colorAnimation.setRepeatMode(ValueAnimator.REVERSE);

        colorAnimation.addUpdateListener(animator -> textAffairs.setTextColor((int) animator.getAnimatedValue()));

        //Toast.makeText(Castle.this, String.valueOf(affairsItems.get(0).id), Toast.LENGTH_SHORT).show();

        animation = new RotateAnimation(
                0f, 360f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);

        animation.setDuration(60000);
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(Animation.INFINITE);
        nextturnimage.startAnimation(animation);
        //if(status!=-1){nextturnimage.startAnimation(animation);}
/*
        timer = new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {}
            public void onFinish() {changeTurn(0);}
        };
        if(status!=-1){timer.start();}

 */
        checkDead();



        if(affairsItems.size()>0){
            colorAnimation.start();
        }

        nextturnimage.setOnClickListener(view ->{changeTurn(1);});

        affairsButton.setOnClickListener(view ->{createAffairsDialog();});
    }

    private void createAffairsDialog(){
        dialogAffairs = new Dialog(Castle.this);
        dialogAffairs.setContentView(R.layout.custom_dialog_affairs);
        dialogAffairs.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialogAffairs.setCancelable(true);
        listView = dialogAffairs.findViewById(R.id.listView);
        dialogAffairs.show();

        CustomAffairsAdapter adapter = new CustomAffairsAdapter(this, listToArray());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {createAffairsElementDialog(affairsItems.get(position), position);});
    }

    private void createAffairsElementDialog(Affairs.AffairsItem affairsItem, int id){
        Dialog dialog = new Dialog(Castle.this);
        dialog.setContentView(R.layout.custom_dialog_affairs_element);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(true);

        TextView textaffairs = dialog.findViewById(R.id.textaffairs);
        TextView answer1text = dialog.findViewById(R.id.answer1text);
        TextView answer2text = dialog.findViewById(R.id.answer2text);
        TextView answer3text = dialog.findViewById(R.id.answer3text);
        TextView text_position_answer1 = dialog.findViewById(R.id.text_position_answer1);
        TextView text_position_answer2 = dialog.findViewById(R.id.text_position_answer2);
        TextView text_position_answer3 = dialog.findViewById(R.id.text_position_answer3);
        ImageView imageaffairs = dialog.findViewById(R.id.imageaffairs);

        textaffairs.setText(affairsItem.getText());
        answer1text.setText(affairsItem.getAnswer1()); answer2text.setText(affairsItem.getAnswer2());
        answer3text.setText(affairsItem.getAnswer3());
        imageaffairs.setImageResource(affairsItem.image_id);
        dialog.show();

        if(answer1text.getText()!=""){
            text_position_answer1.setText("▸");
        }
        if(answer2text.getText()!=""){
            text_position_answer2.setText("▸");
        }
        if(answer3text.getText()!=""){
            text_position_answer3.setText("▸");
        }

        int last_food = food; int last_material = material; int last_gold = gold; int last_knight = knight;
        answer1text.setOnClickListener(view -> {
            AffairsElementDialogOnClick(affairsItem, id,1, dialog);
            startAnimation(foodtext, last_food, food); startAnimation(materialtext, last_material, material);
            startAnimation(goldtext, last_gold, gold); startAnimation(knighttext, last_knight, knight);
            foodtext.setText(String.valueOf(food)); materialtext.setText(String.valueOf(material));
            goldtext.setText(String.valueOf(gold)); knighttext.setText(String.valueOf(knight));
            peoplestatustext.setBackgroundResource(setPeopleImageCount());
            setEffect();
            checkDead();
        });
        answer2text.setOnClickListener(view -> {
            AffairsElementDialogOnClick(affairsItem, id,2, dialog);
            startAnimation(foodtext, last_food, food); startAnimation(materialtext, last_material, material);
            startAnimation(goldtext, last_gold, gold); startAnimation(knighttext, last_knight, knight);
            foodtext.setText(String.valueOf(food)); materialtext.setText(String.valueOf(material));
            goldtext.setText(String.valueOf(gold)); knighttext.setText(String.valueOf(knight));
            peoplestatustext.setBackgroundResource(setPeopleImageCount());
            setEffect();
            checkDead();
        });
        answer3text.setOnClickListener(view -> {
            if(affairsItem.getAnswer3().length()!=0){
                AffairsElementDialogOnClick(affairsItem, id,3, dialog);
                startAnimation(foodtext, last_food, food); startAnimation(materialtext, last_material, material);
                startAnimation(goldtext, last_gold, gold); startAnimation(knighttext, last_knight, knight);
                foodtext.setText(String.valueOf(food)); materialtext.setText(String.valueOf(material));
                goldtext.setText(String.valueOf(gold)); knighttext.setText(String.valueOf(knight));
                peoplestatustext.setBackgroundResource(setPeopleImageCount());
                checkDead();
                setEffect();
            }
        });
    }

    private void createTileDialog(Tile.TileItem tile, int n){
        Dialog dialog = new Dialog(Castle.this);
        dialog.setContentView(R.layout.custom_dialog_tile);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(true);

        listviewActionTile = dialog.findViewById(R.id.listviewActionTile);
        TextView tile_name = dialog.findViewById(R.id.tile_name);
        TextView tile_info = dialog.findViewById(R.id.tile_info);
        ImageView tile_image = dialog.findViewById(R.id.tile_image);

        tile_name.setText(tile.getName());
        tile_info.setText(tile.getDescription());
        tile_image.setBackgroundResource(tile.getBackground());
        tile_image.setImageResource(tile.getObject());

        dialog.show();

        CustomTileAdapter adapter = new CustomTileAdapter(this, tile.getActionList());
        listviewActionTile.setAdapter(adapter);

        int last_food = food; int last_material = material; int last_gold = gold; int last_knight = knight;
        listviewActionTile.setOnItemClickListener((parent, view, position, id) -> {
            Tile.tileActionSetOnClick(tile.getActionList().get(position).getID(), n, dialog);
            setMap();
            startAnimation(foodtext, last_food, food); startAnimation(materialtext, last_material, material);
            startAnimation(goldtext, last_gold, gold); startAnimation(knighttext, last_knight, knight);
            foodtext.setText(String.valueOf(food)); materialtext.setText(String.valueOf(material));
            goldtext.setText(String.valueOf(gold)); knighttext.setText(String.valueOf(knight));
            peoplestatustext.setBackgroundResource(setPeopleImageCount());
            checkDead();
        });
    }

    private void AffairsElementDialogOnClick(Affairs.AffairsItem affairsItem, int id, int pos, Dialog dialog){
        Affairs.answerOnClick(affairsItem.id,pos);
        foodtext.setText(String.valueOf(food)); materialtext.setText(String.valueOf(material));
        goldtext.setText(String.valueOf(gold)); knighttext.setText(String.valueOf(knight));
        affairsItems.remove(id);
        CustomAffairsAdapter adapter = new CustomAffairsAdapter(this, listToArray());
        listView.setAdapter(adapter);
        if(affairsItems.size()==0)colorAnimation.end();
        textAffairs.setText(String.valueOf("События "+ affairsItems.size()));
        checkDead();
        dialog.dismiss();
    }

    private Affairs.AffairsItem[] listToArray(){
        Affairs.AffairsItem[] arr = new Affairs.AffairsItem[affairsItems.size()];
        for(int i=0; i<affairsItems.size(); i++){arr[i]=affairsItems.get(i);}
        return arr;
    }

    private void startAnimation(TextView textview, int last_value, int new_value) {
        if(last_value>new_value){
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                private boolean isRed = true;
                @Override
                public void run() {
                    runOnUiThread(() -> {
                        if (isRed) {
                            textview.setTextColor(Color.RED);
                            textview.append("⇩");
                        } else {
                            textview.setTextColor(Color.WHITE);
                            String text = textview.getText().toString();
                            if (text.length() > 0 && text.charAt(text.length() - 1) == '⇩') {textview.setText(text.substring(0, text.length() - 1));}
                        }
                        isRed = !isRed;
                    });
                }
            }, 0, 200);
            new Handler().postDelayed(() -> {
                if (timer != null) {timer.cancel();}
            }, 1050);
            return;
        }
        if(last_value<new_value){
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                private boolean isRed = true;
                @Override
                public void run() {
                    runOnUiThread(() -> {
                        if (isRed) {
                            textview.setTextColor(Color.GREEN);
                            textview.append("⇧");
                        } else {
                            textview.setTextColor(Color.WHITE);
                            String text = textview.getText().toString();
                            if (text.length() > 0 && text.charAt(text.length() - 1) == '⇧') {textview.setText(text.substring(0, text.length() - 1));}
                        }
                        isRed = !isRed;
                    });
                }
            }, 0, 200);
            new Handler().postDelayed(() -> {
                if (timer != null) {timer.cancel();}
            }, 1050);
        }
    }

    private void changeTurn(int id){
        setFarm();
        if(turn%2==0){
            if(affairsItems.size()!=0){
                createAffairsDialog();
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.custom_toast_affairs, findViewById(R.id.linear));
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.BOTTOM,0, 0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();
                return;
            }
            addAffairs();
            if(affairsItems.size()>0){
                colorAnimation.start();
            }
            textAffairs.setText("События " + affairsItems.size());
        }
        mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        mFadeInAnimation.setAnimationListener(animationFadeInListener);
        main_linear.startAnimation(mFadeInAnimation);
        if(turn%3==0){
            int last_food = food; int last_gold = gold; int last_material = material; int last_knight = knight;
            setResource();
            startAnimation(foodtext, last_food, food); startAnimation(materialtext, last_material, material);
            startAnimation(goldtext, last_gold, gold); startAnimation(knighttext, last_knight, knight);
            foodtext.setText(String.valueOf(food)); materialtext.setText(String.valueOf(material));
            goldtext.setText(String.valueOf(gold)); knighttext.setText(String.valueOf(knight));
            peoplestatustext.setBackgroundResource(setPeopleImageCount());
            checkDead();
        }
        turn++;
        phasetext.setText("Ход " + turn);
        nextturnimage.startAnimation(animation);
    }

    private void setResource(){
        for(Tile.TileItem tt : map){
            if(tt.getObjectID()==11){food++;}
            if(tt.getObjectID()==12){food+=2;}
            if(tt.getObjectID()==13){food+=3;}
            if(tt.getObjectID()==15){food+=2;}
            if(tt.getObjectID()==16){material++;}
            if(tt.getObjectID()==17){material+=2;}
            if(tt.getObjectID()==18){food++;}
            if(tt.getObjectID()==21){food-=2;gold++;}
            if(tt.getObjectID()==22){food-=3;gold=gold+2;}
            if(tt.getObjectID()==25){food-=2;}
        }
    }

    private void setMap(){
        tile1.setImageResource(map.get(0).getObject()); tile1.setBackgroundResource(map.get(0).getBackground());
        tile2.setImageResource(map.get(1).getObject()); tile2.setBackgroundResource(map.get(1).getBackground());
        tile3.setImageResource(map.get(2).getObject()); tile3.setBackgroundResource(map.get(2).getBackground());
        tile4.setImageResource(map.get(3).getObject()); tile4.setBackgroundResource(map.get(3).getBackground());
        tile5.setImageResource(map.get(4).getObject()); tile5.setBackgroundResource(map.get(4).getBackground());
        tile6.setImageResource(map.get(5).getObject()); tile6.setBackgroundResource(map.get(5).getBackground());
        tile7.setImageResource(map.get(6).getObject()); tile7.setBackgroundResource(map.get(6).getBackground());
        tile8.setImageResource(map.get(7).getObject()); tile8.setBackgroundResource(map.get(7).getBackground());
        tile9.setImageResource(map.get(8).getObject()); tile9.setBackgroundResource(map.get(8).getBackground());
        tile10.setImageResource(map.get(9).getObject()); tile10.setBackgroundResource(map.get(9).getBackground());
        tile11.setImageResource(map.get(10).getObject()); tile11.setBackgroundResource(map.get(10).getBackground());
        tile12.setImageResource(map.get(11).getObject()); tile12.setBackgroundResource(map.get(11).getBackground());
        tile13.setImageResource(map.get(12).getObject()); tile13.setBackgroundResource(map.get(12).getBackground());
        tile14.setImageResource(map.get(13).getObject()); tile14.setBackgroundResource(map.get(13).getBackground());
        tile15.setImageResource(map.get(14).getObject()); tile15.setBackgroundResource(map.get(14).getBackground());
        tile16.setImageResource(map.get(15).getObject()); tile16.setBackgroundResource(map.get(15).getBackground());

    }

    private void setEffect(){
        if(effectList.size()>0){
            effect1.setImageResource(effectList.get(0).getImageId());
        }
        if(effectList.size()>1){
            effect2.setImageResource(effectList.get(1).getImageId());
        }
        if(effectList.size()>2){
            effect3.setImageResource(effectList.get(2).getImageId());
        }
        if(effectList.size()>1){
            effect4.setImageResource(effectList.get(3).getImageId());
        }
    }

    private void setFarm(){
        for(Tile.TileItem tt : map){
            if(tt.getObjectID()==15){
                if(tt.getObject()==R.drawable.object_farm){
                    tt.setObject(R.drawable.object_farm2);
                }else{
                    if(tt.getObject()==R.drawable.object_farm2){
                        tt.setObject(R.drawable.object_farm3);
                    }else{if(tt.getObject()==R.drawable.object_farm3){tt.setObject(R.drawable.object_farm);}}
                }
            }
        }
    }

    public void addAffairs(){
        int i =  (int) (Math.random() * 3 + 1);
                //ThreadLocalRandom.current().nextInt(1, 3);
        while(i!=0){
            int id = (int) (Math.random() * 48);
                   // ThreadLocalRandom.current().nextInt(1, 53);
            affairsItems.add(Affairs.getAffairs(id));
            Toast.makeText(Castle.this, String.valueOf(id), Toast.LENGTH_LONG).show();
            i--;
        }
        /*
        for(int i = 0; i< ThreadLocalRandom.current().nextInt(1, 3); i++) {
            int id = ThreadLocalRandom.current().nextInt(1, 53);
            while(!check(id)){
                id = ThreadLocalRandom.current().nextInt(1, 53);
            }
            affairsItems.add(Affairs.getAffairs(id));
        }

         */
    }
    private static boolean check(int id){
        for(Affairs.AffairsItem ai : lastAffairs){
            if(ai.id==id)return false;
        }
        return true;
    }

    private void checkDead(){
        if(food==0){createDialodDead(1); return;}
        if(gold==0){createDialodDead(2); return;}
        if(knight==0){createDialodDead(3); return;}
        if(people==0){createDialodDead(4);}
    }

    private void createDialodDead(int status){
        Dialog dialog = new Dialog(Castle.this);
        dialog.setContentView(R.layout.custom_dialog_dead);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);

        TextView text_main = dialog.findViewById(R.id.text_main);
        TextView text_words = dialog.findViewById(R.id.text_words);
        TextView text_new_game = dialog.findViewById(R.id.text_new_game);
        TextView text_menu = dialog.findViewById(R.id.text_menu);

        text_main.setText(getEndScreenInfo(status)[0]);
        text_words.setText(getEndScreenInfo(status)[1]);
        text_new_game.setOnClickListener(view ->{
            i.setClass(getApplicationContext(), NewGameStart.class);
            startActivity(i);
            finish();
        });
        text_menu.setOnClickListener(view ->{
            i.setClass(getApplicationContext(), Menu.class);
            startActivity(i);
            finish();
        });

        dialog.show();
    }

    public String[] getEndScreenInfo(int id){
        if(id==0)return new String[]{"",""};

        if(id==-1)return new String[]{"Старость","Годы идут слишком быстро, Вы отправляетесь на вечный покой из-за старости"};

        if(id==1)return new String[]{"Провизия закончилась","Все жители разбежались в поисках провизии."};
        if(id==2)return new String[]{"Казна пуста","Золото кончилось, в графстве кризис"};
        if(id==3)return new String[]{"Армия распалась","Больше некому защищать Вашу власть, рыцари соседних графств Вас свергли"};
        if(id==4)return new String[]{"Крестьяне недовольны","Все крестьяне разбежались в соседние графства, править больше некем"};
        if(id==5)return new String[]{"Крестьянский бунт","Рыцари не смогли подавить восстание, крестьяне в порыве ярости повесили Вас"};

        if(id==11)return new String[]{"Вас признали еретиком","Папа решил, что Вы ведете антицерковную политику. Вы погибаете при попытке изгнать из Вас дьявола"};
        if(id==12)return new String[]{"Смерть от чумы","Вы не смогли выздороветь и погибли в агонии"};
        if(id==13)return new String[]{"Вас признали врагом народа","Король посчитал Вас мятежным феодалом, объединённые войска вторглись в Ваш замок и заточили Вас в темницу навсегда"};
        if(id==14)return new String[]{"Отравленное вино","Дворяне посчитали Вас обузой, произошёл государственный переворот"};
        if(id==15)return new String[]{"Сожжён заживо","Дракон просто сжёг Вас"};

        return new String[]{"",""};
    }

    private int setPeopleImageCount(){
        if(people==1){return R.drawable.people1;}
        if(people==2){return R.drawable.people2;}
        if(people==3){return R.drawable.people3;}
        if(people==4){return R.drawable.people4;}
        if(people==5){return R.drawable.people5;}
        if(people==6){return R.drawable.people6;}
        if(people==7){return R.drawable.people7;}
        if(people==8){return R.drawable.people8;}
        return R.drawable.people0;
    }

    private void createDialogPause(){
        Dialog dialog = new Dialog(Castle.this);
        dialog.setContentView(R.layout.custom_dialog_exit);
        Objects.requireNonNull(dialog.getWindow()).setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(true);
        TextView textToMenu = dialog.findViewById(R.id.textToMenu);
        TextView textExite = dialog.findViewById(R.id.textExite);

        dialog.show();

        textToMenu.setOnClickListener(view -> {
            save();
            i.setClass(getApplicationContext(), Menu.class);
            startActivity(i);
            finish();
        });
        textExite.setOnClickListener(view -> {
            save();
            finish();
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

    private void save(){
        SaveFood.edit().putString("food", String.valueOf(food)).apply();
        SaveMaterial.edit().putString("material", String.valueOf(material)).apply();
        SaveGold.edit().putString("gold", String.valueOf(gold)).apply();
        SaveKnight.edit().putString("knight", String.valueOf(knight)).apply();
        SavePeople.edit().putString("people", String.valueOf(people)).apply();
        SaveTurn.edit().putString("turn", String.valueOf(turn)).apply();
        //SaveStatus.edit().putString("status",String.valueOf(status)).apply();

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

    @Override
    public void onBackPressed() {
        createDialogPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        save();
    }

/** Не используемо */


/*

Affairs.answerOnClick(affairsItem.id,1);
            foodtext.setText(String.valueOf(food)); materialtext.setText(String.valueOf(material));
            goldtext.setText(String.valueOf(gold)); knighttext.setText(String.valueOf(knight));
            affairsItems.remove(id);
            CustomAffairsAdapter adapter = new CustomAffairsAdapter(this, listToArray());
            listView.setAdapter(adapter);
            if(affairsItems.size()==0)colorAnimation.end();
            textAffairs.setText(String.valueOf("События "+ affairsItems.size()));
            dialog.dismiss();

Affairs.answerOnClick(affairsItem.id,2);
            foodtext.setText(String.valueOf(food)); materialtext.setText(String.valueOf(material));
            goldtext.setText(String.valueOf(gold)); knighttext.setText(String.valueOf(knight));
            affairsItems.remove(id);
            CustomAffairsAdapter adapter = new CustomAffairsAdapter(this, listToArray());
            listView.setAdapter(adapter);
            if(affairsItems.size()==0)colorAnimation.end();
            textAffairs.setText(String.valueOf("События "+ affairsItems.size()));
            dialog.dismiss();

Affairs.answerOnClick(affairsItem.id,3);
                foodtext.setText(String.valueOf(food)); materialtext.setText(String.valueOf(material));
                goldtext.setText(String.valueOf(gold)); knighttext.setText(String.valueOf(knight));
                affairsItems.remove(id);
                CustomAffairsAdapter adapter = new CustomAffairsAdapter(this, listToArray());
                listView.setAdapter(adapter);
                if(affairsItems.size()==0)colorAnimation.end();
                textAffairs.setText(String.valueOf("События "+ affairsItems.size()));
                dialog.dismiss();

    private void setMap(ImageView image1,ImageView image2,ImageView image3,ImageView image4,ImageView image5,ImageView image6,ImageView image7,
                       ImageView image8,ImageView image9,ImageView image10,ImageView image11,ImageView image12){
        setTitle(12,image1);
        setTitle(12,image2);
        setTitle(12,image3);
        setTitle(12,image4);
        setTitle(12,image5);
        setTitle(12,image6);
        setTitle(12,image7);
        setTitle(12,image8);
        setTitle(12,image9);
        setTitle(12,image10);
        setTitle(12,image11);
        setTitle(12,image12);

    }

    private void showDialogMethod(int tile_int){
        Dialog dialog = new Dialog(Castle.this);
        dialog.setContentView(R.layout.custom_dialog_tile);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(true);

        tile_name = dialog.findViewById(R.id.tile_name);
        tile_info = dialog.findViewById(R.id.tile_info);
        tile_image = dialog.findViewById(R.id.tile_image);

        tile_button_linear1 = dialog.findViewById(R.id.tile_button_linear1);
        tile_button_image1 = dialog.findViewById(R.id.tile_button_image1);
        tile_button1 = dialog.findViewById(R.id.tile_button1);

        tile_button_linear2 = dialog.findViewById(R.id.tile_button_linear2);
        tile_button_image2 = dialog.findViewById(R.id.tile_button_image2);
        tile_button2 = dialog.findViewById(R.id.tile_button2);

        setTitle(tile_int,tile_image);
        tile_name.setText(setTitleName(tile_int));
        tile_info.setText(setTitleInfo(tile_int));
        tile_button1.setText(getTitleButtonName(tile_int));
        tile_button_image1.setImageResource(setButtonImage(tile_int));

        if(tile_int==10){

        }else{
            tile_button_linear2.setVisibility(View.INVISIBLE);
        }


        dialog.show();
    }
    */


}