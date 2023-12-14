package com.suafer.balladeofthekingdom;

import android.app.Dialog;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Tile {

    public static class TileItem{
        private final int background; //id background
        private final int object; //id object
        private final String name; //Название
        private final boolean status;
        private final String description; //Описание
        private final int background_image; //картинка background
        private int object_image; //картинка object
        private final List<TileAction> actionList;

        public TileItem(int background, int object, boolean status){
            this.background = background;
            this.object = object;
            this.status = status;
            this.name = getTileName(object);
            this.description = getTileDescription(object);
            this.background_image = getBackgroundImage(background);
            this.object_image = getObjectImage(object);
            this.actionList = new ArrayList<>();
            getTileAction(object, actionList);
        }

        public int getBackground(){return background_image;}
        public int getObject(){return object_image;}
        public void setObject(int new_image){object_image=new_image;}
        public int getBackgroundID(){return background;}
        public int getObjectID(){return object;}
        public String getName(){return name;}
        public String getDescription() {return description;}
        public List<TileAction> getActionList(){return actionList;}

    }
    /** Установить картинки */

    //Установить задний фон и объект
    private static void setTitle(TileItem t, ImageView imageView){
        imageView.setBackgroundResource(t.getBackground());
        imageView.setImageResource(t.getObject());
    }

    /** */
    public static TileItem getTile(int backID, int objID){
        return new TileItem(backID,objID,true);
    }



    /** УСТАНОВИТЬ НАЗВАНИЕ И ОПИСАНИЕ ДЛЯ ПОЛЯ */
    private static String getTileName(int id){
        if(id==1)return "Равнина";
        if(id==2)return "Лес";
        if(id==3)return "Камни";
        if(id==11)return "Маленькое поселение";
        if(id==12)return "Поселение";
        if(id==13)return "Деревня";
        if(id==15)return "Ферма";
        if(id==16)return "Домик дровосека";
        if(id==17)return "Каменоломня";
        if(id==18)return "Домик рыбака";
        if(id==19)return "Порт";
        if(id==21)return "Маленький замок";
        if(id==22)return "Замок";
        if(id==25)return "Крепость";
        return "";
    }
    private static String getTileDescription(int id){
        if(id==1)return "Идеальное место для строительства и земледелия";
        if(id==2)return "Величесвтнный лес из дубовых деревьев";
        if(id==3)return "Величественые горы из разных пород";
        if(id==4)return "Небольшой пляж, перед водой";
        if(id==5)return "";
        if(id==6)return "";
        if(id==8)return "";
        if(id==11)return "\"Тут живут и работают крестьяне\"\nДаёт 1 единицу провизию каждую фазу. Строится на свободном поле с равниной. Можно достроить до поселения.";
        if(id==12)return "\"Здесь стало больше домиков с прошлого раза\"\nДаёт 2 единицы провизии каждую фазу. Строится на поле с маленьким поселением. Можно достроить до деревни.";
        if(id==13)return "\"Словно маленьктй замок, но без каменных стен\"\nПриносит 3 единицы провизии каждую фазу. Строится на поле с поселением. Можно превратить в Маленький замок.";
        if(id==15)return "Ферма";
        if(id==16)return "Приносит 1 единицу материала кажую фазу";
        if(id==17)return "Приносит 2 единицы материала каждую фазу";
        if(id==18)return "Домик рыбака";
        if(id==19)return "";
        if(id==21)return "\"Поселение, защищенное стенами\"\nДаёт 1 единицу золота каждый ход, можно улучшить до обычного замка. Строится на ";
        if(id==22)return "\"Классический замок - символ средневековья\"\nДаёт 2 единцы золота каждый ход";
        if(id==25)return "Крепость";
        return "";
    }

    private static int getObjectImage(int id){
        if(id==1){return R.drawable.none_image;}
        if(id==2){return R.drawable.forest;}
        if(id==3){return R.drawable.object_mountain;}
        if(id==11)return R.drawable.object_village1;
        if(id==12)return R.drawable.object_village2;
        if(id==13)return R.drawable.object_village3;
        if(id==15)return R.drawable.object_farm;
        if(id==16)return R.drawable.object_sawmill;
        if(id==17)return R.drawable.object_quarry;
        if(id==18)return R.drawable.none_image;
        if(id==19)return R.drawable.none_image;
        if(id==21)return R.drawable.object_castle1;
        if(id==22)return R.drawable.object_castle2;
        if(id==25)return R.drawable.object_fortress;

        return R.drawable.none_image;
    }


    //Получить картинку для заднего фона
    private static int getBackgroundImage(int i){
        if(i==1){return R.drawable.grass;}

        if(i==2){return R.drawable.wasteland;}

        if(i==3){return R.drawable.forest;}

        if(i==4){return R.drawable.grass;}

        if(i==5){return R.drawable.grass;}

        if(i==6){return R.drawable.grass;}

        if(i==7){return R.drawable.grass;}

        return R.drawable.grass;
    }




    public static class TileAction{
        private final int id;
        private final String text;
        private final int image;
        public final List<TileResource> tileResources;

        public TileAction(int id, String text, int image){
            this.id=id;
            this.text=text;
            this.image=image;
            this.tileResources = new ArrayList<>();
            getTileResource(id,tileResources);
        }

        public int getID(){return id;}
        public String getText(){return text;}
        public int getImage(){return image;}
    }

    private static void getTileAction(int objectID, List<TileAction> actionList){
        if(objectID==1){
            actionList.add(new TileAction(11, "Построить", R.drawable.object_village1));
            actionList.add(new TileAction(15, "Построить", R.drawable.object_farm));
            return;
        }
        if(objectID==2){
            actionList.add(new TileAction(16, "Построить", R.drawable.object_sawmill));
            actionList.add(new TileAction(0, "Срубить", R.drawable.action_image));
            return;
        }
        if(objectID==3){
            actionList.add(new TileAction(17, "Построить", R.drawable.object_quarry));
            actionList.add(new TileAction(0, "Собрать", R.drawable.action_image));
            return;
        }
        if(objectID==11){
            actionList.add(new TileAction(12, "Построить", R.drawable.object_village2));
            return;
        }
        if(objectID==12){
            actionList.add(new TileAction(13, "Построить", R.drawable.object_village3));
            return;
        }
        if(objectID==13){
            actionList.add(new TileAction(21, "Построить", R.drawable.object_castle1));
            return;
        }
        if(objectID==21){
            actionList.add(new TileAction(22, "Построить", R.drawable.object_castle2));
            return;
        }
    }

    public static void tileActionSetOnClick(int id, int n, Dialog dialog){
        if(id==0){
            Castle.map.set(n, new TileItem(1,1,true));
            Castle.material=Castle.material+2;
            dialog.dismiss();
            return;
        }

        if(id==11){
            Castle.map.set(n, new TileItem(1,11,true));
            Castle.food=Math.max(0, Castle.food-2);
            Castle.material=Math.max(0, Castle.material-2);
            dialog.dismiss();
            return;
        }

        if(id==12){
            Castle.map.set(n, new TileItem(1,12,true));
            Castle.food=Math.max(0, Castle.food-3);
            Castle.material=Math.max(0, Castle.material-3);
            dialog.dismiss();
            return;
        }

        if(id==13){
            Castle.map.set(n, new TileItem(1,13,true));
            Castle.food=Math.max(0, Castle.food-4);
            Castle.material=Math.max(0, Castle.material-3);
            dialog.dismiss();
            return;
        }

        if(id==16){
            Castle.map.set(n, new TileItem(1,16,true));
            Castle.food=Math.max(0, Castle.food-2);
            Castle.material=Math.max(0, Castle.material-3);
            dialog.dismiss();
            return;
        }

        if(id==15){
            Castle.map.set(n, new TileItem(1,15,true));
            Castle.food=Math.max(0, Castle.food-2);
            Castle.material=Math.max(0, Castle.material-3);
            dialog.dismiss();
            return;
        }
        if(id==17){
            Castle.map.set(n, new TileItem(1,17,true));
            Castle.food=Math.max(0, Castle.food-2);
            Castle.material=Math.max(0, Castle.material-3);
            dialog.dismiss();
            return;
        }

        if(id==21){
            Castle.map.set(n, new TileItem(1,21,true));
            Castle.food=Math.max(0, Castle.food-2);
            Castle.material=Math.max(0, Castle.material-2);
            Castle.gold=Math.max(0, Castle.gold-2);
            dialog.dismiss();
        }
    }

    private static void getTileResource(int id, List<TileResource> tileResources){
        if(id==11){
            tileResources.add(new TileResource(R.drawable.icon_food,2));
            tileResources.add(new TileResource(R.drawable.icon_material,2));
            return;
        }
        if(id==12){
            tileResources.add(new TileResource(R.drawable.icon_food,3));
            tileResources.add(new TileResource(R.drawable.icon_material,3));
            return;
        }
        if(id==13){
            tileResources.add(new TileResource(R.drawable.icon_food,4));
            tileResources.add(new TileResource(R.drawable.icon_material,3));
            return;
        }
        if(id==15){
            tileResources.add(new TileResource(R.drawable.icon_food,2));
            tileResources.add(new TileResource(R.drawable.icon_material,3));
            return;
        }
        if(id==16){
            tileResources.add(new TileResource(R.drawable.icon_food,2));
            tileResources.add(new TileResource(R.drawable.icon_material,3));
            return;
        }
        if(id==17){
            tileResources.add(new TileResource(R.drawable.icon_food,2));
            tileResources.add(new TileResource(R.drawable.icon_material,3));
            return;
        }
        if(id==21){
            tileResources.add(new TileResource(R.drawable.icon_food,3));
            tileResources.add(new TileResource(R.drawable.icon_material,2));
            tileResources.add(new TileResource(R.drawable.icon_gold,2));
        }
        if(id==22){
            tileResources.add(new TileResource(R.drawable.icon_food,4));
            tileResources.add(new TileResource(R.drawable.icon_material,5));
            tileResources.add(new TileResource(R.drawable.icon_gold,3));
        }

    }

    public static class TileResource{
        private final int image;
        private final int count;

        public TileResource(int image, int count){
            this.image=image;
            this.count=count;
        }
        public int getImage(){return image;}
        public int getCount(){return count;}
    }


}
