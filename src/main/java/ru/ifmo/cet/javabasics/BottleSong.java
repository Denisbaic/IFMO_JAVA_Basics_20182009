package ru.ifmo.cet.javabasics;


class BottleSong {
    private Integer bottleTakenAtOnce;
    public BottleSong(int _bottleTakenAtOnce) {
        bottleTakenAtOnce=_bottleTakenAtOnce;
    }
    public String getBottleSongLyrics() {
        if(bottleTakenAtOnce<=0 ||bottleTakenAtOnce>99) throw new IllegalArgumentException();
        String Song="";
        Integer bottleCount=99;
        while (bottleCount>0){
            if(bottleCount<bottleTakenAtOnce){
                bottleTakenAtOnce=bottleCount;
            }
            if(bottleCount==1){
                Song += bottleCount.toString() + " bottle of beer on the wall, " + bottleCount.toString() + " bottle of beer.\n";
                Song += "Take " + getFullNum(bottleTakenAtOnce) + " down and pass around, no more bottles of beer on the wall.\n";
                break;
            }else{
                if(bottleCount.equals(bottleTakenAtOnce)){
                    Song += bottleCount.toString() + " bottles of beer on the wall, " + bottleCount.toString() + " bottles of beer.\n"+
                            "Take " + getFullNum(bottleTakenAtOnce) + " down and pass around, no more bottles of beer on the wall.\n";
                    break;
                }else {
                    Song += bottleCount.toString() + " bottles of beer on the wall, " + bottleCount.toString() + " bottles of beer.\n";
                    bottleCount -= bottleTakenAtOnce;
                    if(bottleCount==1) {
                        Song += "Take " + getFullNum(bottleTakenAtOnce) + " down and pass around, " + bottleCount.toString() + " bottle of beer on the wall.\n";
                    } else {
                        Song += "Take " + getFullNum(bottleTakenAtOnce) + " down and pass around, " + bottleCount.toString() + " bottles of beer on the wall.\n";
                    }
                }
            }
        }
        Song += "No more bottles of beer on the wall, no more bottles of beer.\n" + "Go to the store and buy some more, 99 bottles of beer on the wall.\n";
        return Song;
    }

    private String getSingleNum(Integer single_num){
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
            default:break;
        }
        return word;
    }
    private String getSecondNum(Integer single_num){
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
            default: break;
        }
        return word;
    }
    public String getFullNum(Integer num){
        Integer temp_num=num;
        String Full_word="";
        int rank=0;
        int temp_first=0;
        while(temp_num!=0){
            rank++;
            int temp=temp_num;
            temp_num=temp_num/10;
            int single_num= (int) (temp-temp_num*Math.pow(10,rank));

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
                        default: Full_word="";break;
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
