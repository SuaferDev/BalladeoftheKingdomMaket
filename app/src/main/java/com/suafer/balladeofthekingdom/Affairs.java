package com.suafer.balladeofthekingdom;

public class Affairs {

    public static class AffairsItem{
        public int id;
        public int image_id;

        public String text;
        public String answer1;
        public String answer2;
        public String answer3;

        public AffairsItem(int id, int image_id, String text, String answer1, String answer2, String answer3){
            this.id = id;
            this.image_id = image_id;
            this.text = text;
            this.answer1 = answer1;
            this.answer2 = answer2;
            this.answer3 = answer3;
        }

        public String getText() {return text;}
        public String getAnswer1() {return answer1;}
        public String getAnswer2() {return answer2;}
        public String getAnswer3() {return answer3;}

    }

    public static AffairsItem getAffairs(int id){

        if(id==-23)return new AffairsItem(-23, R.drawable.knightportrain2, "Крестьяне на вражеского территории против нашего похода и ведут себя агрессивно по отношению к солдатам. Может стоит показать им силу?", "Да, они сами напрашиваются", "Не трогайте их", "");
        if(id==-22)return new AffairsItem(-22, R.drawable.knightportrain2 , "Мы взяли пленных во время боя. Решите их судьбу", "Казнить врагов", "Используем для обмена", "Отпустить");
        if(id==-21)return new AffairsItem(-21, R.drawable.knightportrain1, "Наши войска смогли взять вражеский замок, что делать с ним?", "Можете разграбить всё", "Не трогайте ничего", "Возьмите только королевское имущество, не трогайте обычных жителей");


        if(id==-15)return new AffairsItem(-15 ,R.drawable.citizen2, "Участились случаи мародерства в домах погибших", "Пусть их родственники защищают имущество", "Стража этим займется", "Теперь это собственность государства");
        if(id==-14)return new AffairsItem(-14,R.drawable.citizen1, "Что делать с телами погибших от чумы?", "Храните согласно традициям", "Трупы надо сжечь","");
        if(id==-13)return new AffairsItem(-13,R.drawable.adviser1,"Похоже, Вы заболели чумой, к кому обратиться за помощью?","Позвать лекарей","Пусть священики помолются за меня, это поможет","Мне не нужно лечение");
        if(id==-12)return new AffairsItem(-12,R.drawable.adviser1,"Лекари не справляются, кому помогать в приоритете?","Лечите знать","Лечите людей","Лечите рыцарей");
        if(id==-11)return new AffairsItem(-11,R.drawable.adviser2,"В королевстве началась чума. Может быть закроем ворота Вашего замка?","Да, и никого не впускать","Нет, я открыт для своего народа","");

        if(id==0)return new AffairsItem(0, R.drawable.citizen2, "На улицах очень много грязи это может привести к распространению болезни", "Построим канализацию", " Главное, что в замке чисто", "") ;
        if(id==1)return new AffairsItem(1,R.drawable.adviser1,"Нужно ли изменить величину налога?","Увеличить, крестьяне и так богатые","Уменьшить","Не менять");
        if(id==2)return new AffairsItem(2,R.drawable.knightportrain1, "Солдаты не довольны своим жалованием и хотят его повышения!","Хорошо, можно и повысить","Нет необходимости","Им можно и понизить");
        if(id==3)return new AffairsItem(3,R.drawable.adviser1,"Церковь предлагает открыть школу для обучения крестьянских детей, но построить её нужно будет Вам.","Это отличная идея","Знания будут мешать им работать","");
        if(id==4)return new AffairsItem(4,R.drawable.knightportrain2,"Мне кажется, или в нашей армии стало меньше солдат? Может быть стоит объявить набор новобранцев?","Да, это повысит нашу мощь","Это лишнее, наша армия и так сильна как никогда","");
        if(id==5)return new AffairsItem(5,R.drawable.citizen1,"В одной деревне начался голод из-за неурожая и жители просят еды. Стоит ли им раздать запасы?","Конечно","Нет, нам запасы нужнее","");
        if(id==6)return new AffairsItem(6,R.drawable.citizen4,"Во время грозы у одного из крестьян загорелся дом, его не смогли потушить. Он просит Вас о помощи.","Дайте ему необходимые материалы","Это не моя проблема","");
        if(id==7)return new AffairsItem(7,R.drawable.citizen2,"Бандиты на главной дороге терроризируют крестьян. Последние просят помощи!","Армия этим займется","Пусть крестьяне сами решают свои проблемы","Наймите наемников, пусть они этим занимаются");
        if(id==8)return new AffairsItem(8,R.drawable.adviser2,"Появились заболевшие, с признаками чумы. Что с ними делать?","Их нужно изолировать и подождать","Я ясно вижу, что это не чума","Нельзя допустить эпидемии, их нужно убить");
        if(id==9)return new AffairsItem(9,R.drawable.citizen1,"Крестьяне говорят, что в ближних лесах появились монстры. И просят помощи!","Пошлите солдат, пусть разберутся","Это всё сказки","");
        if(id==10)return new AffairsItem(10,R.drawable.knightportrain3,"Если на нас нападут, нам не помешали бы гарнизоны в городах. Это повысит защищенность городов.","Создайте из солдат","Это не нужно мы не будет ни с кем воевать","Дайте крестьянам оружие, они усилят оборону");
        if(id==11)return new AffairsItem(11,R.drawable.adviser1,"Приближается годовщина Вашего восхождения на престол, стоит ли это отпраздновать?","Да, устроим пир","Сейчас не время, надо затянуть пояса","");
        if(id==12)return new AffairsItem(12,R.drawable.citizen3,"Крестьяне обвиняют ону девушку в колдовстве и хотят сжечь её","Это их дело, сами разберутся","Остановите их, это варварство","");
        if(id==13)return new AffairsItem(13,R.drawable.adviser2,"Какой-то крестьяне сеет смуту - публично критикуя Вас. Что делать с неверным?","Заточите глупца в карцер","Очевидно, что его никто не послушает","Казните неверного");
        if(id==14)return new AffairsItem(14,R.drawable.citizen3,"Торговцы просят снизить торговые пошлины, ссылаясь на низкий доход","Хорошо, но на немного","А кто тогда будет деньги в казну приносить?","Их можно и вообще отменить");
        if(id==15)return new AffairsItem(15,R.drawable.knightportrain1,"Наши окраины начали атаковать кочевники. Что с этим делать","Отправим туда больше солдат","Построим укрепления","Ну можно ничего и не делать");
        if(id==16)return new AffairsItem(16,R.drawable.adviser1,"Другой феодал предлагает Вам жениться на его дочери для укрепления отношений между родами","Это хорошее решение","Вы вообще видели его дочь? Конечно нет","");
        if(id==17) return new AffairsItem(17, R.drawable.adviser2, "В соседних странах вывели культуру, дающую большой урожай. Может быть стоит её закупить? ","Да, почему бы и нет ","Нет, наши посеву и так хороши","");
        if(id==18)return new AffairsItem(18, R.drawable.adviser2, "Глава церкви хочет начать крестовый поход и он собирает рыцарей с королевств", "Дать рыцарей", "Они сейчас нужнее дома", "");
        if(id==19)return new AffairsItem(19,R.drawable.citizen2,"Наши инструменты для земледелия устарели,их нужно заменить","Купим у соседей","Сейчас денег нет, но вы пашите","Так можно сделать свои");
        if(id==20)return new AffairsItem(20,R.drawable.citizen1,"В деревне вспыхнул пожар и его не получается потушить. Что лучше спасти?","Спасайте людей","Спасайте провизию","Спасайте материалы");
        if(id==21)return new AffairsItem(21,R.drawable.adviser1,"В казне не достаёт золота, кто-то его украл.","Виновата стража","Виноват казначей","Виноват советник");
        if(id==22)return new AffairsItem(22,R.drawable.knightportrain3,"Вооружение нашей армии устарело, нужно срочно решить эту проблему!","Можно купить у соседней страны","Это вам так кажется, снаряжение в порядке","Надо произвести самим");
        if(id==23)return new AffairsItem(23,R.drawable.knightportrain1,"Рыцари устроили грабеж на месте своей стоянки, крестьяне хотят справедливости!","Накажите виновных","Скорее всего крестьяне врут","");
        if(id==24)return new AffairsItem(24,R.drawable.adviser2,"Советник подготовил денежную реформу, которая может поднять доход!","Хорошо, давайте применим её","Реформы нам не нужны, у нас всё хорошо","");
        if(id==25)return new AffairsItem(25,R.drawable.adviser1,"Советник разработал реформу сельского хозяйства, стоит ли её использовать","Да, почему нет","Лучше оставить всё как есть","");
        if(id==26)return new AffairsItem(26,R.drawable.adviser1,"Скульптор подготовил новый план замка, но он очень затратный","У великого Короля должен быть великий замок","Лучше использовать эти ресурсы на благо королевства","");
        if(id==27)return new AffairsItem(27,R.drawable.citizen4,"Многие крестьяне стали заболевать, может быть стоит построить лазарет?","Это хорошая идея","Народная медицина должна помочь","");
        if(id==28)return new AffairsItem(28,R.drawable.adviser2,"Некоторые лекари просят разрешение на вскрытие тел погибших для изучения","Если только во имя науки","Нет, это богохульство","");
        if(id==29)return new AffairsItem(29,R.drawable.citizen2,"Земледелие сильно истощает почву, может быть стоит уменьшить посевы?","Только есть это необходимо","Сейчас нужен большой урожай, о будущем пусть думают другие","");
        if(id==30)return new AffairsItem(30,R.drawable.adviser2,"Крестьяне отказываются платить налог, говоря, что он слишком высокий","Ладно, понизим","Пусть рыцари заставят платить","Подождем, сами устанут");
        if(id==31)return new AffairsItem(31,R.drawable.adviser1,"В казне оказалось больше золота, чем ожидалось, что делать с ним?","Не трогать, пусть лежат","Вложить в армию","Вложить в земледелие");
        if(id==32)return new AffairsItem(32,R.drawable.adviser2,"Месса и пир, устроенный одним из дворян в один и тот же день, а что пойти?","На мессу, Бог всё видит","На пир, друзья важны","");
        if(id==33)return new AffairsItem(33,R.drawable.adviser2,"Королю нужны солдаты для военного похода и он собирает их со всех феодалов?","Предоставить отряд","Мои рыцари мне нужнее","");
        if(id==34)return new AffairsItem(34,R.drawable.knightportrain2,"Рыцари сидят без дела, что на счёт рыцарского турнира?","Да, народ развлечется","Пусть лучше дальше тренируются","");
        if(id==35)return new AffairsItem(35,R.drawable.citizen3,"Церковь предлагает построить новый монастырь и ждет от Вас ресурсов","Хорошо, пусть строят","А не кажется, что монастырей и так достаточно","");
        if(id==36)return new AffairsItem(36,R.drawable.citizen4,"Народ несчастен, может быть ситуация изменится, если провести средневековый фестиваль?","Да, так будет лучше","Народ и так счастлив, ведь я им правлю","");
        if(id==37)return new AffairsItem(37,R.drawable.knightportrain2,"Стража поймала банду бандитов. Они предлагают золота, за сохранение","За кражу одно наказание - смерть","Золото есть золото - помилуем их","");
        if(id==38)return new AffairsItem(38,R.drawable.adviser1,"Не все купцы из соседних стран торгуют у нас. Может быть снизить торговые пошлины?","Хорошая идея, мы открыты для соседей","Нет, это может ослабить наших купцов","");
        if(id==39)return new AffairsItem(39,R.drawable.citizen4,"Какое-то существо по ночам нападает на крестьян, что делать?","Для этого есть рыцари","А точно нападает?","Нанять авантюристов");
        if(id==40)return new AffairsItem(40,R.drawable.citizen2,"Крестьянин утверждает, что обладает очень важными знаниями и расскажет их за вознаграждение.","Дать ему золота","Он не знает больше чем знаю я","");
        if(id==41)return new AffairsItem(41,R.drawable.adviser2,"Феодал из соседнего королевства предлагает поучаствовать в походе на кочевников.","Дать отряд рыцарей","Бессмысленная затея","Лично присоединиться к походу");
        if(id==42)return new AffairsItem(42,R.drawable.citizen4,"Крестьяне просят решить спор: Один убил корову другого за то, что она зашла на его земли и съела всё сено. Кто прав?","Тот чья корова","Тот чье сено","Пусть сами решают");
        if(id==43)return new AffairsItem(43,R.drawable.citizen3,"Лекари хотят тестировать новые лекарства на живых людях. Они жду Вашего решения.","Да, если это поможет","Нет, это бесчеловечно","");
        if(id==44)return new AffairsItem(44,R.drawable.adviser1,"Соседний феодал ведет себя слишком вызывающие по отношению к Вам, может стоит организовать старый, добрый военных поход","","","");
        if(id==45)return new AffairsItem(45,R.drawable.knightportrain1,"Есть крестьяне, которым надоела мирная жизнь и они хотят стать солдатами, может стоит объявить набор в арми?","Хорошо, если они так сильно хотят","Пусть лучше землю пашут","");
        if(id==46)return new AffairsItem(46,R.drawable.adviser1,"Феодал из соседних земель прислал Вам в знак уважения красивый меч","Найдите лучших мастеров, пусть скуют меч - сделаем ответный подарок","Я напишу благодарственное письмо","А мне меч не нравится, выбросите");
        if(id==47)return new AffairsItem(47, R.drawable.adviser2, "В соседнем королевстве началась чума и к нам бегут беженцы. Что с ними делать?", "Ничего, вернуться к себе когда всё закончится", "Не впускайте их, нам чума не нужна", "Поможем им - дайте им все необходимое для выживания");
        if(id==48)return new AffairsItem(48,R.drawable.adviser2,"НАСТОЯЩИЙ ДРАКОН поселился в наших горах и что с этим делать","Я возглавлю поход","Отправить рыцарей","Ну поселился и поселился не велика так-то проблема");
        /*
        if(id==51)return new AffairsItem("","","","");
        if(id==52)return new AffairsItem("","","","");
        if(id==53)return new AffairsItem("","","","");
        if(id==54)return new AffairsItem("","","","");
        if(id==55)return new AffairsItem("","","","");
        if(id==56)return new AffairsItem("","","","");
        if(id==57)return new AffairsItem("","","","");
        if(id==58)return new AffairsItem("","","","");
        if(id==59)return new AffairsItem("","","","");
        if(id==60)return new AffairsItem("","","","");
        if(id==61)return new AffairsItem("","","","");
        if(id==62)return new AffairsItem("","","","");
        if(id==63)return new AffairsItem("","","","");
        if(id==64)return new AffairsItem("","","","");
        if(id==65)return new AffairsItem("","","","");
        if(id==66)return new AffairsItem("","","","");
        if(id==67)return new AffairsItem("","","","");
        if(id==68)return new AffairsItem("","","","");
        if(id==69)return new AffairsItem("","","","");
        if(id==70)return new AffairsItem("","","","");
        if(id==71)return new AffairsItem("","","","");
        if(id==72)return new AffairsItem("","","","");
        if(id==73)return new AffairsItem("","","","");
        if(id==74)return new AffairsItem("","","","");
        if(id==75)return new AffairsItem("","","","");
        if(id==76)return new AffairsItem("","","","");
        if(id==77)return new AffairsItem("","","","");
        if(id==78)return new AffairsItem("","","","");
        if(id==79)return new AffairsItem("","","","");
        if(id==80)return new AffairsItem("","","","");
        if(id==81)return new AffairsItem("","","","");
        if(id==82)return new AffairsItem("","","","");
        if(id==83)return new AffairsItem("","","","");
        if(id==84)return new AffairsItem("","","","");
        if(id==85)return new AffairsItem("","","","");
        if(id==86)return new AffairsItem("","","","");
        if(id==87)return new AffairsItem("","","","");
        if(id==88)return new AffairsItem("","","","");
        if(id==89)return new AffairsItem("","","","");
        if(id==90)return new AffairsItem("","","","");
        if(id==91)return new AffairsItem("","","","");
        if(id==92)return new AffairsItem("","","","");
        if(id==93)return new AffairsItem("","","","");
        if(id==94)return new AffairsItem("","","","");
        if(id==95)return new AffairsItem("","","","");
        if(id==96)return new AffairsItem("","","","");
        if(id==97)return new AffairsItem("","","","");
        if(id==98)return new AffairsItem("","","","");
        if(id==99)return new AffairsItem("","","","");
        if(id==100)return new AffairsItem(100, "","","","");

         */

        return new AffairsItem(-999999999,R.drawable.adviser1,"","","","");
    }

    public static void answerOnClick(int id, int answerNumber){
        if (id == 0) {
            if (answerNumber == 1) { //
                Castle.material-=2;
                return;
            }
            if (answerNumber == 2) { //
                Castle.effectList.add(Effect.getEffect(2));
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //Нужно ли изменить величену налога?
        if (id == 1) {
            if(answerNumber==1){ //Увеличить, крестьяне и так богатые
                Castle.gold++; Castle.people=Math.max(0,Castle.people-2); return;
            }
            if(answerNumber==2){ //Уменьшить
                Castle.gold=Math.max(0, Castle.gold-2); Castle.people+=1; return;
            }
            if(answerNumber==3){ //Не менять
                Castle.people=Math.max(0,Castle.people-1); return;
            }
        }

        //Солдаты не довольны своим жалованием и хотят его повышения!
        if (id == 2) {
            if(answerNumber==1){ //Хорошо, можно и повысить
                Castle.gold=Math.max(0, Castle.gold-2); Castle.knight+=2; return;
            }
            if(answerNumber==2){ //Нет необходимости
                Castle.knight=Math.max(0, Castle.knight-1); return;
            }
            if(answerNumber==3){ //Им можно и понизить
                Castle.knight=Math.max(0, Castle.knight-2); Castle.gold++;
                return;
            }
        }

        //Церковь предлагает открыть школу для обучения крестьянских детей, но построить её нужно будет Вам.
        if (id == 3) {
            if(answerNumber==1){ //Это отличная идея
                Castle.people++; Castle.material=Math.max(0, Castle.gold-3); Castle.gold=Math.max(0, Castle.gold-1);
                return;
            }
            if(answerNumber==2){ //Знания будут мешать
                Castle.people=Math.max(0, Castle.people-2);
                return;
            }
            if(answerNumber==3){ //
                return;
            }
        }

        //Мне кажется, или в нашей армии стало меньше солдат? Может быть стоит объявить набор новобранцов?
        if (id == 4) {
            if(answerNumber==1){ //Да, это повысет нашу мощь
                Castle.knight+=2; Castle.gold=Math.max(0, Castle.gold-2);
                return;
            }
            if(answerNumber==2){ //Это лишнее, наша армия и так сильна как никогда
                Castle.knight=Math.max(0, Castle.knight-2);
                return;
            }
            if(answerNumber==3){ //
                return;
            }
        }

        //В одной деревне начался голод из-за неурожая и жители просят еды. Стоит ли им раздать запасы?
        if (id == 5) {
            if(answerNumber==1){ //Конечно
                Castle.people++; Castle.food=Math.max(0, Castle.food-2);
                return;
            }
            if(answerNumber==2){ //Нет, нам запасы нужнее
                Castle.people=Math.max(0, Castle.people-3);
                return;
            }
            if(answerNumber==3){ //
                return;
            }
        }

        //Во время грозы у одного из крестьян загорелся дом, его не смогли потушить. Он просит Вас о помощи.
        if (id == 6) {
            if(answerNumber==1){ //Дайте ему необходимые материалы
                Castle.people++; Castle.material=Math.max(0, Castle.material-2);
                return;
            }
            if(answerNumber==2){ //Это не моя проблема
                Castle.people=Math.max(0, Castle.people-2);
                return;
            }
            if(answerNumber==3){ //
                return;
            }
        }

        //Бандиты на главной дороге терроризируют крестьян. Последние просят помощи!
        if (id == 7) {
            if(answerNumber==1){ //Армия этим займется
                Castle.knight=Math.max(0, Castle.knight-1); Castle.people++;
                return;
            }
            if(answerNumber==2){ //Пусть крестьяне сами решают свои проблемы
                Castle.people=Math.max(0, Castle.people-2);
                return;
            }
            if(answerNumber==3){ //Наймите наемников, пусть они этим занимаются
                Castle.gold=Math.max(0, Castle.gold-2); Castle.people++;
                return;
            }
        }

        //Появились заболевшие, с признаками чумы. Что с ними делать?"
        if (id == 8) {
            if(answerNumber==1){ //Их нужно изолировать и подождать
                Castle.people=Math.max(0, Castle.people-1);
                return;
            }
            if(answerNumber==2){ //Я ясно вижу, что это не чума
                Castle.people=Math.max(0, Castle.people-3);
                return;
            }
            if(answerNumber==3){ //Нельзя допустить эпидемии, их нужно убить
                Castle.people=Math.max(0, Castle.people-2);
                return;
            }
        }

        //Крестьяне говорят, что в ближних лесах появились монстры. И просят помощи!
        if (id == 9) {
            if(answerNumber==1){ //Пошлите солдат, пусть разберутся
                Castle.people++; Castle.knight--;
                return;
            }
            if(answerNumber==2){ //Это всё сказки
                Castle.people=Math.max(0, Castle.people-2);
                return;
            }
            if(answerNumber==3){ //
                return;
            }
        }

        //Если на нас нападут, нам не помешали бы гарнизоны в городах. Это повысит защищенность городов.
        if (id == 10) {
            if(answerNumber==1){ //Создайте из солдат
                Castle.knight=Math.max(0, Castle.knight-2);
                return;
            }
            if(answerNumber==2){ //Это не нужно, мы не будет ни с кем воевать
                return;
            }
            if(answerNumber==3){ //Дайте крестьянам оружие, они усилят оборону

                return;
            }
        }

        //Приближается годовщина Вашего восхождения на престол, стоит ли это отпраздновать?
        if (id == 11) {
            if(answerNumber==1){ //Да, устроим пир
                Castle.food=Math.max(0, Castle.food-3);
                Castle.people+=1;
                return;
            }
            if(answerNumber==2){ //Сейчас не время, надо затянуть пояса
                Castle.people=Math.max(0, Castle.people-2);
                return;
            }
            if(answerNumber==3){ //
                return;
            }
        }

        //Крестьяне обвиняют ону девушку в колдовстве и хотят сжечь её","Это их дело, сами разберутся","Остановите их, это варварство","");
        if (id == 12) {
            if(answerNumber==1){ //Это их дело, сами разберутся
                Castle.people++;
                return;
            }
            if(answerNumber==2){ //Остановите их, это варварство
                Castle.people=Math.max(0, Castle.people-2);
                return;
            }
            if(answerNumber==3){ //
                return;
            }
        }

        //Какой-то крестьянин сеет смуту - публично критикуя Вас. Что делать с неверным?
        if (id == 13 ) {
            if (answerNumber == 1) { //Заточите глупца в карцер
                Castle.people=Math.max(0, Castle.people-2);
                return;
            }
            if (answerNumber == 2) { //
                Castle.effectList.add(Effect.getEffect(4));
                return;
            }
            if (answerNumber == 3) { //Казните неверного
                Castle.people=Math.max(0, Castle.people-3);
                return;
            }
        }

        //Крестьяне жалуются, что в соседних лесах стало много волков. Нужно ли что-нибудь сделать?
        if (id == 14) {
            if (answerNumber == 1) { //Устройте охоту
                Castle.food+=1; Castle.people+=2;
                return;
            }
            if (answerNumber == 2) { //Так-то это их проблема
                Castle.people=Math.max(0, Castle.people-2);
                return;
            }
            if (answerNumber == 3) { //Дайте им оружие, пусть сами справляются
                Castle.people=Math.max(0, Castle.people-1);
                return;
            }
        }

        //Несколько жителей стали верить в другую религию, это похоже ересь
        if (id == 15) {
            if (answerNumber == 1) { //Разогнать неверных
                Castle.people=Math.max(0, Castle.people-2);
                return;
            }
            if (answerNumber == 2) { //Пусть верят во что хотят, это выбор каждого
                Castle.people--; Castle.effectList.add(Effect.getEffect(7));
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //Может быть устроить пир, это повысит всем настроение?","Почему бы и нет","Сейчас не то время для подобных развлечений","");
        if (id == 16) {
            if (answerNumber == 1) { //Почему бы и нет
                Castle.people=Math.max(0, Castle.people-2);
                return;
            }
            if (answerNumber == 2) { //Сейчас не то время для подобных развлечений
                Castle.people++; Castle.food=Math.max(0, Castle.food-2);
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //Крестьянин уверяет, что может создать философский камень и просит дать ему необходимые ресурсы.
        if (id == 17) {
            if (answerNumber == 1) { //Дайте то, что нужно, мы станем богатыми
                Castle.gold=Math.max(0, Castle.gold-2);
                return;
            }
            if (answerNumber == 2) { //Это явный обман
                Castle.people=Math.max(0, Castle.people-1);
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //Торговцы просят снизить торговые пошлины, ссылаясь на низкий доход
        if (id == 18) {
            if (answerNumber == 1) { //Хорошо, но на немного
                Castle.gold=Math.max(0, Castle.gold-1);
                return;
            }
            if (answerNumber == 2) { //А кто тогда будет деньги в казну приносить?
                Castle.people=Math.max(0, Castle.people-2);
                return;
            }
            if (answerNumber == 3) { //Их можно и вообще отменить
                Castle.gold=Math.max(0, Castle.gold-3);
                return;
            }
        }

        //Наши инструменты для земледелия устарели, их нужно заменить
        if (id == 19) {
            if (answerNumber == 1) { //Купим у соседей
                Castle.gold=Math.max(0, Castle.gold-3);
                Castle.effectList.add(Effect.getEffect(7));
                return;
            }
            if (answerNumber == 2) { //Сейчас денег нет, но вы пашите
                Castle.food=Math.max(0, Castle.food-2);
                return;
            }
            if (answerNumber == 3) { //Так можно сделать свои
                Castle.material=Math.max(0, Castle.material-2);

                return;
            }
        }

        //В деревне вспыхнул пожар и его не получается потушить. Что лучше спасти?
        if (id == 20) {
            if (answerNumber == 1) { //Спасайте людей
                Castle.people+=2; Castle.food=Math.max(0, Castle.food-2); Castle.material=Math.max(0, Castle.material-2);
                return;
            }
            if (answerNumber == 2) { //Спасайте провизию
                Castle.people=Math.max(0, Castle.people-2); Castle.food+=2; Castle.material=Math.max(0, Castle.material-2);
                return;
            }
            if (answerNumber == 3) { //Спасайте материалы
                Castle.people=Math.max(0, Castle.people-2); Castle.food=Math.max(0, Castle.food-2); Castle.material+=2;
                return;
            }
        }

        //В казне не достаёт золота, кто-то его украл.","Виновата стража","Виноват казначей","Виноват советник
        if (id == 21) {
            if (answerNumber == 1) { //Виновата стража
                Castle.knight=Math.max(0, Castle.knight-2); Castle.gold=Math.max(0, Castle.gold-2);
                return;
            }
            if (answerNumber == 2) { //Виноват казначей
                Castle.gold=Math.max(0, Castle.gold-2);
                return;
            }
            if (answerNumber == 3) { //Виноват советник
                Castle.effectList.add(Effect.getEffect(8)); Castle.gold=Math.max(0, Castle.gold-2);
                return;
            }
        }

        //Вооружение нашей армии устарело, нужно срочно решить эту проблему!
        if (id == 22) {
            if (answerNumber == 1) { //Можно купить у соседней страны
                Castle.knight+=2; Castle.gold=Math.max(0, Castle.gold-3);
                return;
            }
            if (answerNumber == 2) { //Это вам так кажется, снаряжение в порядке
                Castle.knight-=2;
                return;
            }
            if (answerNumber == 3) { //Надо произвести самим
                Castle.knight+=1; Castle.material-=2;
                return;
            }
        }

        //Рыцари устроили грабеж на месте своей стоянки, крестьяне хотят справедливости!
        if (id == 23) {
            if (answerNumber == 1) { //Накажите виновных
                Castle.knight=Math.max(0, Castle.knight-2);
                return;
            }
            if (answerNumber == 2) { //Скорее всего крестьяне врут
                Castle.people=Math.max(0, Castle.people-2);
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //Советник подготовил денежную реформу, которая может поднять доход!
        if (id == 24) {
            if (answerNumber == 1) { //Хорошо, давайте применим её
                int r = (int) ( 1+Math.random()*2);
                if(r==1){
                    Castle.gold+=2;
                }else{
                    Castle.gold=Math.max(0, Castle.gold-2);
                }
                return;
            }
            if (answerNumber == 2) { //Реформы нам не нужны, у нас всё хорошо
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //Советник разработал реформу сельского хозяйства, стоит ли её использовать
        if (id == 25) {
            if (answerNumber == 1) { //Да, почему нет
                int r = (int) ( 1+Math.random()*2);
                if(r==1){
                    Castle.food+=2;
                }else{
                    Castle.food=Math.max(0, Castle.food-2);
                }
                return;
            }
            if (answerNumber == 2) { //Лучше оставить всё как есть
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //Скульптор подготовил новый план замка, но он очень затратный
        if (id == 26) {
            if (answerNumber == 1) { //У великого Короля должен быть великий замок
                if(Castle.gold!=0)Castle.gold=1;
                if(Castle.food!=0)Castle.food=1;
                if(Castle.material!=0)Castle.material=1;
                return;
            }
            if (answerNumber == 2) { //Лучше использовать эти ресурсы на благо королевства
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //Многие крестьяне стали заболевать, может быть стоит построить лазарет?","Это хорошая идея","Народная медицина должна помочь","");
        if (id == 27) {
            if (answerNumber == 1) { //Это хорошая идея
                Castle.material=Math.max(0, Castle.material-2); Castle.gold=Math.max(0, Castle.gold-2); Castle.people+=2;
                return;
            }
            if (answerNumber == 2) { //Народная медицина должна помочь
                Castle.people=Math.max(0, Castle.people-2);
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //Некоторые лекари просят разрешение на вскрытие тел погибших для изучения","Если только во имя науки","Нет, это богохульство","");
        if (id == 28) {
            if (answerNumber == 1) { //Если только во имя науки
                Castle.effectList.add(Effect.getEffect(7));
                Castle.effectList.add(Effect.getEffect(11));
                return;
            }
            if (answerNumber == 2) { //Нет, это богохульство
                Castle.people+=1;
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //Земледелие сильно истощает почву, может быть стоит уменьшить посевы?
        if (id == 29) {
            if (answerNumber == 1) { //Только есть это необходимо
                Castle.food=Math.max(0, Castle.food-2);
                return;
            }
            if (answerNumber == 2) { //Сейчас нужен большой урожай, о будущем пусть думают другие
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //Крестьяне отказываются платить налог, говоря, что он слишком высокий","Подождем, сами устанут");
        if (id == 30) {
            if (answerNumber == 1) { //Ладно, понизим
                Castle.people++; Castle.gold=Math.max(0, Castle.gold-2);
                return;
            }
            if (answerNumber == 2) { //Пусть рыцари заставят платить
                Castle.people=Math.max(0, Castle.people-3);Castle.knight=Castle.gold=Math.max(0, Castle.knight-2);
                Castle.gold++;
                return;
            }
            if (answerNumber == 3) { //Подождем, сами устанут
                Castle.gold=Math.max(0, Castle.gold-2); Castle.people=Math.max(0, Castle.people-1);
                return;
            }
        }

        //В казне оказалось больше золота, чем ожидалось, что делать с ним?","Не трогать, пусть лежат","Вложить в армию","Вложить в земледелие"
        if (id == 31) {
            if (answerNumber == 1) { //Не трогать, пусть лежат
                Castle.gold+=2;
                return;
            }
            if (answerNumber == 2) { //Вложить в армию
                Castle.knight+=3;
                return;
            }
            if (answerNumber == 3) { //Вложить в земледелие
                Castle.effectList.add(Effect.getEffect(5));
                return;
            }
        }

        //Месса и пир, устроенный одним из дворян в один и тот же день, а что пойти?","На мессу, Бог всё видит","На пир, друзья важны","");
        if (id == 32) {
            if (answerNumber == 1) { //На мессу, Бог всё видит
                Castle.effectList.add(Effect.getEffect(8));
                return;
            }
            if (answerNumber == 2) { //На пир, друзья важны
                Castle.effectList.add(Effect.getEffect(7));
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //Королю нужны солдаты для военного похода и он собирает их со всех феодалов?","Предоставить отряд","Мои рыцари мне нужнее",
        if (id == 33) {
            if (answerNumber == 1) { //Предоставить отряд
                Castle.knight=Math.max(0, Castle.knight-3);
                return;
            }
            if (answerNumber == 2) { //Мои рыцари мне нужнее
                Castle.effectList.add(Effect.getEffect(12));
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //Рыцари сидят без дела, что на счёт рыцарского турнира?
        if (id == 34) {
            if (answerNumber == 1) { //Да, народ развлечется
                Castle.gold=Math.max(0, Castle.gold-2);
                Castle.food=Math.max(0, Castle.food-2);
                Castle.material=Math.max(0, Castle.material-2);
                Castle.knight+=2;
                return;
            }
            if (answerNumber == 2) { //Пусть лучше дальше тренируются
                Castle.knight=Math.max(0, Castle.knight-2);
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //Церковь предлагает построить новый монастырь и ждет от Вас ресурсов
        if (id == 35) {
            if (answerNumber == 1) { //Хорошо, пусть строят
                Castle.material=Math.max(0, Castle.material-3);
                Castle.people+=1;

                return;
            }
            if (answerNumber == 2) { //А не кажется, что монастырей и так достаточно
                Castle.effectList.add(Effect.getEffect(7));
                Castle.people--;
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //Народ несчастен, может быть ситуация изменится, если провести средневековый фестиваль?
        if (id == 36) {
            if (answerNumber == 1) {//Да, так будет лучше
                Castle.food=Math.max(0,Castle.food-2);
                Castle.people=Math.min(10, Castle.people+1);
                return;
            }
            if (answerNumber == 2) { //Народ и так счастлив, ведь я им правлю
                Castle.people=Math.max(0, Castle.people-2);
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //Стража поймала банду бандитов. Они предлагают золота, за сохранение","За кражу одно наказание - смерть","Золото есть золото - помилуем их
        if (id == 37) {
            if (answerNumber == 1) {//За кражу одно наказание - смерть
                Castle.people=Math.min(10, Castle.people+2);
                return;
            }
            if (answerNumber == 2) { //Золото есть золото - помилуем их
                Castle.people = Math.max(0,Castle.people-2);
                Castle.gold+=3;
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //Не все купцы из соседних стран торгуют у нас. Может быть снизить торговые пошлины?","Хорошая идея, мы открыты для соседей","Нет, это может ослабить наших купцов
        if (id == 38) {
            if (answerNumber == 1) {//Хорошая идея, мы открыты для соседей
                Castle.gold = Math.max(0,Castle.gold-2);
                return;
            }
            if (answerNumber == 2) { //Нет, это может ослабить наших купцов
                Castle.gold = Math.max(0,Castle.gold-3);
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //Какое-то существо по ночам нападает на крестьян, что делать?","Для этого есть рыцари","А точно нападает?","Нанять авантюристов
        if (id == 39) {
            if (answerNumber == 1) {//Для этого есть рыцари
                Castle.knight = Math.max(0,Castle.knight-2);
                Castle.people = Math.min(8,Castle.people+1);
                return;
            }
            if (answerNumber == 2) { //А точно нападает?
                Castle.knight = Math.max(0,Castle.knight-2);
                return;
            }
            if (answerNumber == 3) { //Нанять авантюристов
                Castle.gold = Math.max(0,Castle.gold-2);
                Castle.people = Math.min(8,Castle.people+1);
                return;
            }
        }

        //Крестьянин утверждает, что обладает очень важными знаниями и расскажет их за вознаграждение.
        if (id == 40) {
            if (answerNumber == 1) {//Дать ему золота
                Castle.gold = Math.max(0,Castle.gold-2);
                return;
            }
            if (answerNumber == 2) { //Он не знает больше чем знаю я
                Castle.people = Math.max(0,Castle.people-1);
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //Феодал из соседнего королевства предлагает поучаствовать в походе на кочевников.","Дать отряд рыцарей","Бессмысленная затея","Лично присоединиться к походу");
        if (id == 41) {
            if (answerNumber == 1) {//Дать отряд рыцарей
                Castle.knight = Math.max(0,Castle.knight-2);
                return;
            }
            if (answerNumber == 2) { //Бессмысленная затея
                return;
            }
            if (answerNumber == 3) { //Лично присоединиться к походу
                return;
            }
        }

        //Крестьяне просят решить спор: Один убил корову другого за то, что она зашла на его земли и съела всё сено. Кто прав?","Тот чья корова","Тот чье сено","Пусть сами решают"
        if (id == 42) {
            if (answerNumber == 1) {//Тот чья корова
                Castle.people = Math.min(8,Castle.people+1);
                return;
            }
            if (answerNumber == 2) { //Тот чье сено
                Castle.people = Math.max(0,Castle.people-2);
                return;
            }
            if (answerNumber == 3) { //Пусть сами решают
                Castle.people = Math.max(0,Castle.people-2);
                return;
            }
        }

        //Лекари хотят тестировать новые лекарства на живых людях. Они жду Вашего решения.","Да, если это поможет","Нет, это бесчеловечно",""
        if (id == 43) {
            if (answerNumber == 1) {//
                Castle.effectList.add(Effect.getEffect(11));
                Castle.people = Math.max(0,Castle.people-2);
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //Соседний феодал ведет себя слишком вызывающие по отношению к Вам, может стоит организовать старый, добрый военных поход","","","");
        if (id == 44) {
            if (answerNumber == 1) {//Собирайте рыцарей он ответит за свою наглость
                return;
            }
            if (answerNumber == 2) { //Нет, это не слишком
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //Есть крестьяне, которым надоела мирная жизнь и они хотят стать солдатами, может стоит объявить набор в арми?","Хорошо, если они так сильно хотят","Пусть лучше землю пашут","");
        if (id == 45) {
            if (answerNumber == 1) {//Хорошо, если они так сильно хотят
                Castle.knight+=2;
                Castle.people = Math.min(10,Castle.people+1);
                return;
            }
            if (answerNumber == 2) { //Пусть лучше землю пашут
                Castle.people = Math.max(0,Castle.people-2);
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //Феодал из соседних земель прислал Вам в знак уважения красивый меч","Найдите лучших мастеров, пусть скуют меч - сделаем ответный подарок","Я напишу благодарственное письмо","А мне меч не нравится, выбросите
        if (id == 46) {
            if (answerNumber == 1) {//Найдите лучших мастеров, пусть скуют меч - сделаем ответный подарок
                Castle.gold = Math.max(0,Castle.gold-2);
                return;
            }
            if (answerNumber == 2) { //Я напишу благодарственное письмо
                return;
            }
            if (answerNumber == 3) { //А мне меч не нравится, выбросите
                return;
            }
        }

        //В соседнем королевстве началась чума и к нам бегут беженцы. Что с ними делать?
        if (id == 47) {
            if (answerNumber == 1) {//Ничего, вернуться к себе когда всё закончится
                Castle.people = Math.min(8,Castle.people+1);
                Castle.effectList.add(Effect.getEffect(2));
                return;
            }
            if (answerNumber == 2) { //Не впускайте их, нам чума не нужна
                Castle.people = Math.max(0,Castle.people-2);
                return;
            }
            if (answerNumber == 3) { //Поможем им - дайте им все необходимое для выживания
                Castle.food = Math.max(0,Castle.food-3);
                Castle.people = Math.min(8,Castle.people+2);
                Castle.effectList.add(Effect.getEffect(2));
                return;
            }
        }

        //НАСТОЯЩИЙ ДРАКОН поселился в наших горах и что с этим делать","Я возглавлю поход","Отправить рыцарей","Ну поселился и поселился не велика так-то проблема
        if (id == 48) {
            if (answerNumber == 1) {//Я возглавлю поход
                Castle.knight = Math.max(0,Castle.knight-3);
                Castle.people = Math.min(8,Castle.people+2);
                return;
            }
            if (answerNumber == 2) { //Отправить рыцарей
                Castle.knight = Math.max(0,Castle.knight-3);
                Castle.people = Math.min(8,Castle.people+1);
                return;
            }
            if (answerNumber == 3) { //Ну поселился и поселился не велика так-то проблема
                Castle.people = Math.max(0,Castle.people-2);
                return;
            }
        }

        //Наши окраины начали атаковать кочевники. Что с этим делать","Отправим туда больше солдат","Построим укрепления","Ну можно ничего и не делать");
        if (id == 49) {
            if (answerNumber == 1) {//Отправим туда больше солдат
                Castle.people = Math.min(8,Castle.people+1);
                Castle.knight = Math.max(0,Castle.knight-2);
                return;
            }
            if (answerNumber == 2) { //Построим укрепления
                Castle.people = Math.min(8,Castle.people+1);
                Castle.knight = Math.max(0,Castle.knight-1);
                Castle.material = Math.max(0,Castle.material-2);
                return;
            }
            if (answerNumber == 3) { //Ну можно ничего и не делать
                Castle.people = Math.max(0,Castle.people-2);
                return;
            }
        }

        //Другой феодал предлагает Вам жениться на его дочери для укрепления отношений между родами","Это хорошее решение","Вы вообще видели его дочь? Конечно нет
        if (id == 50) {
            if (answerNumber == 1) {//Это хорошее решение
                Castle.people = Math.min(8,Castle.people+1);
                return;
            }
            if (answerNumber == 2) { //Вы вообще видели его дочь? Конечно нет

                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //В соседних странах вывели культуру, дающую большой урожай. Может быть стоит её закупить? ","Да, почему бы и нет ","Нет, наши посеву и так хороши","");
        if (id == 51) {
            if (answerNumber == 1) {//Да, почему бы и нет
                Castle.effectList.add(Effect.getEffect(5));
                Castle.gold = Math.max(0,Castle.gold-3);
                return;
            }
            if (answerNumber == 2) { //Нет, наши посеву и так хороши
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //Глава церкви хочет начать крестовый поход и он собирает рыцарей с королевств", "Дать рыцарей", "Они сейчас нужнее дома", "");
        if (id == 52) {
            if (answerNumber == 1) {//Дать рыцарей
                Castle.knight = Math.max(0,Castle.knight-3);
                return;
            }
            if (answerNumber == 2) { //Они сейчас нужнее дома
                Castle.effectList.add(Effect.getEffect(7));
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 53) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 54) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 55) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 56) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 57) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 58) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 59) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 60) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 61) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 62) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 63) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 64) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 65) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 66) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 67) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 68) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 69) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 70) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 71) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 72) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 73) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 74) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 75) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 76) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 77) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 78) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 79) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 80) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 81) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 82) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 83) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 84) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 85) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 86) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 87) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 88) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 89) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 90) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 91) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 92) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 93) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 94) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 95) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 96) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 97) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 98) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 99) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

        //
        if (id == 100) {
            if (answerNumber == 1) { //
                return;
            }
            if (answerNumber == 2) { //
                return;
            }
            if (answerNumber == 3) { //
                return;
            }
        }

    }


}

/*
if(i == 1000000){return new String[]{"Тест","тест 1","тест2", "тест 3"};}
if(i == 4){return new String[]{"Провести реформу армии?","Увеличть количество","Уменьшить количество","Не менять"};}
if(i == 18){return new String[]{"Ваши советники обещают большой урожай в этом году!","Повысить налоги","Ничего не делать",""};}
if(i == 20){return new String[]{"Прибыли послы кочевников и предлагают заплатить дань, обещая не начинать набег.","Согласиться","Отказаться",""};}
if(i == 29){return new String[]{"Времена неспокойные сейчас, может быть создать специальный отряд стражи?","Да","Нет",""};}
if(i == 30){return new String[]{"В городах стало больше преступлений. Может быть усилить отряды стражи?","Да","Нет","Дать крестьянам оружие"};}
if(i == 38){return new String[]{"Может быть создать государсвтенный банк?","Да","Нет",""};}
if(i == 39){return new String[]{"На уличах антисанитария, что с этим делать?","Построить канализацию","Сейчас это не важно",""};}

 */


