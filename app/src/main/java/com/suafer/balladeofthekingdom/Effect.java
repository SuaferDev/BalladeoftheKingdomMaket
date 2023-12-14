package com.suafer.balladeofthekingdom;

public class Effect {

    public static class EffectItem{
        private int id;
        private String name;
        private String text;
        private int image_id;
        public EffectItem(int id, String name, String text, int image_id){
            this.id = id;
            this.name = name;
            this.text = text;
            this.image_id = image_id;
        }

        public String getName() {return name;}

        public String getText() {return text;}

        public int getId() {return id;}

        public int getImageId() {return image_id;}
    }

    public static EffectItem getEffect(int id){
        if(id==1)return new EffectItem(1,"Вооружённые крестьяне","Усложняет подавление восстания, если оно произойдёт",R.drawable.effect_icon_1);
        if(id==2)return new EffectItem(2,"Вероятность чумы","Есть заболевшие с признаками чумы, это может перерасти в эпидемию",R.drawable.effect_icon_2);
        if(id==3)return new EffectItem(3,"Чума","Очень много заболевших, лекари не справляются",R.drawable.effect_icon_3);
        if(id==4)return new EffectItem(4,"Семя раздора","Возрастает недовольство Вашим правлением",R.drawable.effect_icon_4);
        if(id==5)return new EffectItem(5,"Мастерство земледелия","Земля приносит больше еды",R.drawable.effect_icon_5);
        if(id==6)return new EffectItem(6,"Война","Ваше королевство в состоянии войны",R.drawable.effect_icon_6);
        if(id==7)return new EffectItem(7,"Вера пошатнулась","В Вас начал сомневаться папа, но он надеется, что Вы встанете на истинный путь веры",R.drawable.effect_icon_7);
        if(id==8)return new EffectItem(8,"Заговор","Элиты не довольны Вашим правлением",R.drawable.effect_icon_8);
        if(id==9)return new EffectItem(9,"Защитники Короля","Специальный отряд рыцарей готов отдать жизнь за Вас",R.drawable.effect_icon_9);
        if(id==10)return new EffectItem(10,"Гарнизоны","Теперь города лучше защищены",R.drawable.effect_icon_10);
        if(id==11)return new EffectItem(11,"Развитие медицины","Уменьшает риск появления чумы",R.drawable.effect_icon_11);
        if(id==12)return new EffectItem(12,"Противник Короля","Вы отказали Королю, подобное может привести к беде",R.drawable.effect_icon_12);





        return new EffectItem(id, "", "", R.drawable.adviser1);
    }

    public static String[] getEffectInfo(int id){

        if(id==5)return new String[]{"Мастерство земледелия","Земля приносит больше еды"};
        if(id==6)return new String[]{"Война","Ваше королевство в состоянии войны"};
        if(id==7)return new String[]{"Вера пошатнулась","В Вас начал сомневаться папа, но он надеется, что Вы встанете на истинный путь веры"};
        if(id==8)return new String[]{"Заговор","Элиты не довольны Вашим правлением"};
        if(id==9)return new String[]{"Защитники Короля","Специальный отряд рыцарей готов отдать жизнь за Вас"};
        if(id==10)return new String[]{"Гарнизоны","Теперь города лучше защищены"};
        if(id==11)return new String[]{"Развитие медицины","Уменьшает риск появления чумы"};
        if(id==12)return new String[]{"Противник Короля","Вы отказали Королю, подобное может привести к беде"};

        return new String[]{"",""};
    }

    public static void addToEffectList(int id){
        for(EffectItem e : Castle.effectList){
            if(e.getId()==id)return;
        }
        Castle.effectList.add(getEffect(id));
    }
}


