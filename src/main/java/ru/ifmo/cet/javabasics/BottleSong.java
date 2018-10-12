package ru.ifmo.cet.javabasics;

/**
 * Нужно реализовать констурктор и метод, возвращающий слова песни про бутылки на стене.
 * <p>
 * Слова следующие:
 * <p>
 * 99 bottles of beer on the wall, 99 bottles of beer
 * Take one down, pass it around, 98 bottles of beer
 * 98 bottles of beer on the wall, 98 bottles of beer
 * Take one down, pass it around, 97 bottles of beer
 * 97 bottles of beer on the wall, 97 bottles of beer
 * Take one down, pass it around, 96 bottles of beer
 * 96 bottles of beer on the wall, 96 bottles of beer
 * Take one down, pass it around, 95 bottles of beer
 * 95 bottles of beer on the wall, 95 bottles of beer
 * ...
 * <p>
 * 3 bottles of beer on the wall, 3 bottles of beer
 * Take one down, pass it around, 2 bottles of beer
 * 2 bottles of beer on the wall, 2 bottles of beer
 * Take one down, pass it around, 1 bottles of beer
 * 1 bottle of beer on the wall, 1 bottle of beer
 * Take one down, pass it around, no more bottles of beer on the wall
 * No more bottles of beer on the wall, no more bottles of beer
 * Go to the store and buy some more, 99 bottles of beer on the wall
 * <p>
 * Дело усложняется тем, что текст песни переменный:
 * За раз может быть взято несколько бутылок.
 * Значение передается в качестве параметра конструктора
 * Нужно ограничить возможность взятия бутылок натуральным число не более 99 бутылок за раз.
 */
public class BottleSong {
    //пожалуйста, не смотрите на этот код, он плохой
    private Integer bottleTakenAtOnce;
    public BottleSong(int _bottleTakenAtOnce) {
        bottleTakenAtOnce=_bottleTakenAtOnce;
    }



    public String getBottleSongLyrics() {
        if(bottleTakenAtOnce<=0 ||bottleTakenAtOnce>99) throw new IllegalArgumentException();
        String Song="";
        Integer bottleCount=99;
        while (bottleCount!=0){
            if(bottleCount<bottleTakenAtOnce){
                bottleTakenAtOnce=bottleCount;
            }
            if(bottleCount==1){
                Song = Song + bottleCount.toString() + " bottle of beer on the wall, " + bottleCount.toString() + " bottle of beer.\n";
                Song = Song +"Take "+getFullNum(bottleTakenAtOnce)+ " down and pass around, no more bottles of beer on the wall.\n";
                break;
            }else{
                if(bottleCount.equals(bottleTakenAtOnce)){
                    Song = Song + bottleCount.toString() + " bottles of beer on the wall, " + bottleCount.toString() + " bottles of beer.\n";
                    Song = Song +"Take "+getFullNum(bottleTakenAtOnce)+ " down and pass around, no more bottles of beer on the wall.\n";
                    break;
                }else {
                    Song = Song + bottleCount.toString() + " bottles of beer on the wall, " + bottleCount.toString() + " bottles of beer.\n";
                    bottleCount -= bottleTakenAtOnce;
                    if(bottleCount==1){
                        Song = Song + "Take " + getFullNum(bottleTakenAtOnce) + " down and pass around, " + bottleCount.toString() + " bottle of beer on the wall.\n";
                    }
                    else{
                        Song = Song + "Take " + getFullNum(bottleTakenAtOnce) + " down and pass around, " + bottleCount.toString() + " bottles of beer on the wall.\n";
                    }
                }
            }
        }
        Song=Song+"No more bottles of beer on the wall, no more bottles of beer.\n" +
                "Go to the store and buy some more, 99 bottles of beer on the wall.\n";
        return Song;


    }

    public String getSingleNum(Integer single_num){
        String word = "";
        switch(single_num){
            case 0: word="zero";break;
            case 1: word= "one"; break;
            case 2: word= "two";break;
            case 3: word= "three";break;
            case 4: word= "four";break;
            case 5: word= "five";break;
            case 6: word= "six";break;
            case 7: word= "seven";break;
            case 8: word= "eight";break;
            case 9: word= "nine";break;
            default: word="zero";
        }
        return word;
    }
    public String getSecondNum(Integer single_num){
        String word="";
        switch(single_num){
            case 2: word= "twenty";break;
            case 3: word= "thirty";break;
            case 4: word= "forty";break;
            case 5: word= "fifty";break;
            case 6: word= "sixty";break;
            case 7: word= "seventy";break;
            case 8: word= "eighty";break;
            case 9: word= "ninety";break;
            default: word="zero";
        }
        return word;
    }
    public String getFullNum(Integer num){
        String Full_word="";
        int rank=0;
        int temp_first=0;
        while(num!=0){
            rank++;
            int temp=num;
            num=num/10;
            int single_num= (int) (temp-num*Math.pow(10,rank));

            if(rank==1){
                Full_word=(getSingleNum(single_num));
                temp_first=single_num;
            }
            else if(rank==2){
                if(single_num==1){
                    switch (temp_first){
                        case 0: Full_word=("ten"); break;
                        case 1: Full_word=("eleven"); break;
                        case 2: Full_word=( "twelve");break;
                        case 3: Full_word=( "thirteen");break;
                        case 4: Full_word=( "fourteen");break;
                        case 5: Full_word=( "fifteen");break;
                        case 6: Full_word=( "sixteen");break;
                        case 7: Full_word=( "seventeen");break;
                        case 8: Full_word=( "eighteen");break;
                        case 9: Full_word=( "nineteen");break;
                    }
                }else{
                    if(temp_first==0){
                        Full_word=getSecondNum(single_num);
                    }else{
                        Full_word= String.join(" ",getSecondNum(single_num),Full_word);
                    }
                }

            }
            else if(rank==3){
                Full_word= String.join(" ","hundred",Full_word);
                Full_word= String.join(" ",getSingleNum(single_num),Full_word);
            }
        }
        return Full_word;
    }
}
