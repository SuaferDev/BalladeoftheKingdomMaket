package com.suafer.balladeofthekingdom;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Education extends AppCompatActivity {

    int progress = 0;

    private TextView text_education1, text_education2, text_education3;
    private ImageView image_education_arrow1, image_education_arrow2, image_education_arrow3;
    private LinearLayout layout_resource, layout_map, layout_button, layout_turn;


    public static int food;
    public static int material;
    public static int gold;
    public static int knight;
    public static int people;

    private ListView listView;
    private ListView listviewActionTile;
    //TextView с подсчётом ресурсов
    private TextView phasetext, foodtext, goldtext, materialtext, knighttext, peoplestatustext, textAffairs;
    private LinearLayout main_linear, affairsButton;
    private ImageView tile1, tile2, tile3, tile4, tile5, tile6, tile7, tile8, tile9, tile10, tile11, tile12;
    private ImageView nextturnimage, effect1, effect2, effect3, effect4;

    private Dialog dialogAffairs;

    private List<Affairs.AffairsItem> affairsItems = new ArrayList<>();
    private List<Effect.EffectItem> effectList = new ArrayList<>();

    private Intent i = new Intent();
    private ValueAnimator colorAnimation;
    private Animation mFadeInAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        layout_resource = findViewById(R.id.layout_resource);
        layout_map = findViewById(R.id.layout_map);
        layout_button = findViewById(R.id.layout_button);
        layout_turn = findViewById(R.id.layout_turn);
        LinearLayout main_linear = findViewById(R.id.main_linear);

        text_education1 = findViewById(R.id.text_education1); text_education2 = findViewById(R.id.text_education2);
        text_education3 = findViewById(R.id.text_education3);
        image_education_arrow1 = findViewById(R.id.image_education_arrow1); image_education_arrow2 = findViewById(R.id.image_education_arrow2);
        image_education_arrow3 = findViewById(R.id.image_education_arrow3);

        mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        mFadeInAnimation.setAnimationListener(animationFadeInListener);
        main_linear.startAnimation(mFadeInAnimation);

        affairsItems.add(Affairs.getAffairs(5));

        textAffairs = findViewById(R.id.textAffairs); affairsButton = findViewById(R.id.affairsButton);
        foodtext = findViewById(R.id.foodtext); materialtext = findViewById(R.id.materialtext);
        goldtext = findViewById(R.id.goldtext); knighttext = findViewById(R.id.knighttext);
        peoplestatustext = findViewById(R.id.peoplestatustext);

        tile1 = findViewById(R.id.tile1); tile2 = findViewById(R.id.tile2); tile3 = findViewById(R.id.tile3);
        tile4 = findViewById(R.id.tile4); tile5 = findViewById(R.id.tile5); tile6 = findViewById(R.id.tile6);
        tile7 = findViewById(R.id.tile7); tile8 = findViewById(R.id.tile8); tile9= findViewById(R.id.tile9);
        tile10 = findViewById(R.id.tile10); tile11 = findViewById(R.id.tile11); tile12 = findViewById(R.id.tile12);

        colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), Color.WHITE, Color.DKGRAY, Color.WHITE);
        colorAnimation.setDuration(2500);
        colorAnimation.setRepeatCount(ValueAnimator.INFINITE);
        colorAnimation.setRepeatMode(ValueAnimator.REVERSE);

        colorAnimation.addUpdateListener(animator -> textAffairs.setTextColor((int) animator.getAnimatedValue()));

        FrameLayout frame_main = findViewById(R.id.frame_main);

        setEducation();

        frame_main.setOnClickListener(view ->{
            progress++;
            if(progress==5){
                createTileDialog(new Tile.TileItem(1,1,true));
            }
            setEducation();
        });

        layout_button.setOnClickListener(view ->{
            if(progress>=6){
                Toast.makeText(Education.this, "7", Toast.LENGTH_LONG).show();
                createAffairsDialog();
            }
        });
    }

    @SuppressLint({"SetTextI18n", "ResourceAsColor"})
    private void setEducation(){
        if(progress==0){
            text_education2.setText(Html.fromHtml("Добро пожаловать в<br>" +
                    "<h1><font color='#FFD52D'><b>Ballade of the Kingdom</b></font></h1><br><br>"));

            text_education3.setText(Html.fromHtml("<font color='#6F6F6F'>Нажимайте на экран для продолжения</font><br><br>"));
        }
        if(progress==1){
            image_education_arrow2.setImageResource(R.drawable.arrow_left);
            layout_resource.setBackgroundColor(Color.TRANSPARENT);
            mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
            mFadeInAnimation.setAnimationListener(animationFadeInListener);
            text_education2.startAnimation(mFadeInAnimation);
            image_education_arrow2.startAnimation(mFadeInAnimation);
            layout_resource.startAnimation(mFadeInAnimation);

            text_education2.setText("В верху находятся Ваши ресурсы* и номер хода\n"+"*Провизия, материалы, золото, рыцари и отношение граждан");
            text_education2.setBackgroundColor(0x99000000);
            text_education3.setText("");

        }
        if(progress==2){
            image_education_arrow2.setImageResource(R.drawable.none_image); text_education2.setText("");  layout_resource.setBackgroundColor(0x90000000);
            text_education2.setBackgroundColor(Color.TRANSPARENT);

            mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
            mFadeInAnimation.setAnimationListener(animationFadeInListener);
            text_education1.startAnimation(mFadeInAnimation);
            image_education_arrow1.startAnimation(mFadeInAnimation);
            layout_map.startAnimation(mFadeInAnimation);

            layout_map.setBackgroundColor(Color.TRANSPARENT);
            image_education_arrow1.setImageResource(R.drawable.arrow_left);
            text_education1.setText("В центре экрана находится карта");
            text_education1.setBackgroundColor(0x99000000);
        }
        if(progress==3){
            mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
            mFadeInAnimation.setAnimationListener(animationFadeInListener);
            text_education1.startAnimation(mFadeInAnimation);
            text_education1.setText("Она интерактивна!");
        }
        if(progress==4){
            mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
            mFadeInAnimation.setAnimationListener(animationFadeInListener);
            text_education1.startAnimation(mFadeInAnimation);
            text_education1.setText("Нажмите на выделенное поле");
            tile5.setBackgroundResource(R.drawable.education_tile);
        }
        if(progress==6){
            mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
            mFadeInAnimation.setAnimationListener(animationFadeInListener);
            text_education1.startAnimation(mFadeInAnimation);
            text_education1.setText("Отлично, так, Вы можете взаимодействовать со всеми полями");
            tile5.setBackgroundResource(R.drawable.education_tile);
        }
        if(progress==7){
            image_education_arrow2.setImageResource(R.drawable.none_image); text_education1.setText(""); image_education_arrow1.setImageResource(R.drawable.none_image);layout_map.setBackgroundColor(0x95000000);
            text_education2.setBackgroundColor(Color.TRANSPARENT);

            mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
            mFadeInAnimation.setAnimationListener(animationFadeInListener);
            text_education2.startAnimation(mFadeInAnimation);
            image_education_arrow3.startAnimation(mFadeInAnimation);
            layout_turn.startAnimation(mFadeInAnimation);
            tile5.setBackgroundResource(R.drawable.grass);

            layout_turn.setBackgroundColor(Color.TRANSPARENT);
            text_education2.setText("Под картой находится место для эффектов\n"+"Эффекты появляются при решении событий. Они немного изменяют игру");
            image_education_arrow3.setImageResource(R.drawable.arrow_left);
        }
        if(progress==8){
            layout_turn.setBackgroundColor(0x97000000);
            mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
            mFadeInAnimation.setAnimationListener(animationFadeInListener);
            text_education2.startAnimation(mFadeInAnimation);
            layout_button.startAnimation(mFadeInAnimation);

            layout_button.setBackgroundColor(Color.TRANSPARENT);
            text_education2.setText(Html.fromHtml("В самом низу экрана находятся два кнопки:<br>"+"<font color='#71BFFF'><b>События и Смена Хода</b></font><br><br>"));
            text_education2.setBackgroundColor(0x99000000);
            colorAnimation.start();
        }
        if(progress==9){
            mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
            mFadeInAnimation.setAnimationListener(animationFadeInListener);
            text_education2.startAnimation(mFadeInAnimation);
            text_education2.setText(Html.fromHtml("Похоже появилось новое "+"<font color='#71BFFF'><b>событие</b></font><br><br>"+"Давайте его решим, для этого нажмите на кнопку События"));
        }
        if(progress==10){
            mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
            mFadeInAnimation.setAnimationListener(animationFadeInListener);
            text_education2.startAnimation(mFadeInAnimation);
            text_education2.setText(Html.fromHtml("События появляются каждые несколько ходов. У Вас будет два хода, чтобы отреагировать на них."));
        }
    }

    private void createAffairsDialog(){
        dialogAffairs = new Dialog(Education.this);
        dialogAffairs.setContentView(R.layout.custom_dialog_affairs);
        dialogAffairs.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialogAffairs.setCancelable(false);

        listView = dialogAffairs.findViewById(R.id.listView);

        dialogAffairs.show();

        CustomAffairsAdapter adapter = new CustomAffairsAdapter(this, listToArray());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            createAffairsElementDialog(affairsItems.get(position), position,dialogAffairs);});
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
        dialog.dismiss();
    }

    private void createAffairsElementDialog(Affairs.AffairsItem affairsItem, int id, Dialog mainDialog){
        Dialog dialog = new Dialog(Education.this);
        dialog.setContentView(R.layout.custom_dialog_affairs_element);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(true);

        TextView textaffairs = dialog.findViewById(R.id.textaffairs);
        TextView answer1text = dialog.findViewById(R.id.answer1text);
        TextView answer2text = dialog.findViewById(R.id.answer2text);
        TextView answer3text = dialog.findViewById(R.id.answer3text);
        ImageView imageaffairs = dialog.findViewById(R.id.imageaffairs);

        textaffairs.setText(affairsItem.getText());
        answer1text.setText(affairsItem.getAnswer1()); answer2text.setText(affairsItem.getAnswer2());
        answer3text.setText(affairsItem.getAnswer3());
        imageaffairs.setImageResource(affairsItem.image_id);
        dialog.show();

        int last_food = food; int last_material = material; int last_gold = gold; int last_knight = knight;
        answer1text.setOnClickListener(view -> {
            AffairsElementDialogOnClick(affairsItem, id,1, dialog);
            startAnimation(foodtext, last_food, food); startAnimation(materialtext, last_material, material);
            startAnimation(goldtext, last_gold, gold); startAnimation(knighttext, last_knight, knight);
            foodtext.setText(String.valueOf(food)); materialtext.setText(String.valueOf(material));
            goldtext.setText(String.valueOf(gold)); knighttext.setText(String.valueOf(knight));
            peoplestatustext.setBackgroundResource(setPeopleImageCount());
            setEffect();
            mainDialog.dismiss();
        });
        answer2text.setOnClickListener(view -> {
            AffairsElementDialogOnClick(affairsItem, id,2, dialog);
            startAnimation(foodtext, last_food, food); startAnimation(materialtext, last_material, material);
            startAnimation(goldtext, last_gold, gold); startAnimation(knighttext, last_knight, knight);
            foodtext.setText(String.valueOf(food)); materialtext.setText(String.valueOf(material));
            goldtext.setText(String.valueOf(gold)); knighttext.setText(String.valueOf(knight));
            peoplestatustext.setBackgroundResource(setPeopleImageCount());
            setEffect();
            mainDialog.dismiss();
        });
        answer3text.setOnClickListener(view -> {
            if(affairsItem.getAnswer3().length()!=0){
                AffairsElementDialogOnClick(affairsItem, id,3, dialog);
                startAnimation(foodtext, last_food, food); startAnimation(materialtext, last_material, material);
                startAnimation(goldtext, last_gold, gold); startAnimation(knighttext, last_knight, knight);
                foodtext.setText(String.valueOf(food)); materialtext.setText(String.valueOf(material));
                goldtext.setText(String.valueOf(gold)); knighttext.setText(String.valueOf(knight));
                peoplestatustext.setBackgroundResource(setPeopleImageCount());
                setEffect();
                mainDialog.dismiss();
            }
        });
    }

    private Affairs.AffairsItem[] listToArray(){
        Affairs.AffairsItem[] arr = new Affairs.AffairsItem[affairsItems.size()];
        for(int i=0; i<affairsItems.size(); i++){arr[i]=affairsItems.get(i);}
        return arr;
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

    private void createTileDialog(Tile.TileItem tile){
        Dialog dialog = new Dialog(Education.this);
        dialog.setContentView(R.layout.custom_dialog_education);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);

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
            tileActionSetOnClick(tile.getActionList().get(position).getID(), dialog);
            progress++;
            tile5.setBackgroundResource(R.drawable.grass);
            startAnimation(foodtext, last_food, food); startAnimation(materialtext, last_material, material);
            startAnimation(goldtext, last_gold, gold); startAnimation(knighttext, last_knight, knight);
            foodtext.setText(String.valueOf(food)); materialtext.setText(String.valueOf(material));
            goldtext.setText(String.valueOf(gold)); knighttext.setText(String.valueOf(knight));
            peoplestatustext.setBackgroundResource(setPeopleImageCount());
            setEducation();
            dialog.dismiss();
            //Toast.makeText(Castle.this, String.valueOf(tile.getActionList().get(position).getText()), Toast.LENGTH_SHORT).show();
        });
    }

    private void tileActionSetOnClick(int id, Dialog dialog){
        if(id==11){
            tile5.setImageResource(new Tile.TileItem(1,11,true).getObject());
            tile5.setBackgroundResource(R.drawable.grass);
            food=Math.max(0, food-2);
            material=Math.max(0, material-2);
            dialog.dismiss();
            return;
        }

        if(id==15){
            tile5.setImageResource(new Tile.TileItem(1,15,true).getObject());
            tile5.setBackgroundResource(R.drawable.grass);
            food=Math.max(0, food-2);
            material=Math.max(0, material-3);
            dialog.dismiss();
            return;
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

}