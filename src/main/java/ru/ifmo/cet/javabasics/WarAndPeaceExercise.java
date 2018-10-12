package ru.ifmo.cet.javabasics;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class WarAndPeaceExercise {

    public static String warAndPeace() throws IOException {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        HashMap<String,Integer> dictionary=new HashMap<String,Integer>();
        final Charset charset = Charset.forName("windows-1251");

        List<String> strings = Files.readAllLines(tome12Path, charset);
        strings.addAll(Files.readAllLines(tome34Path, charset));
        for (String string: strings) {
            string=string.toLowerCase();
            string=string.replaceAll("[^A-Za-z\u0410-\u042f\u0430-\u044f]", " ");
            String[] words=string.split(" ");


            for (String word:words) {
                if(word.length()<4) continue;
                Integer count=dictionary.get(word);
                if (dictionary.get(word) == null) {
                    dictionary.put(word,1);
                }else{
                    dictionary.put(word,++count);
                }
            }
        }
        int g=4;
        dictionary.entrySet().removeIf(entry -> entry.getValue() < 10);
       int c= "разговором".compareTo("пусть");


        //сортировка и отбор в алфавитном порядке
        ArrayList<String> list_result=new ArrayList<String>();
        while (!dictionary.isEmpty()){
            HashMap.Entry<String, Integer> Max_entry=dictionary.entrySet().iterator().next();
            for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
                if (Max_entry.getValue() < entry.getValue()) {
                    Max_entry = entry;
                } else if (Max_entry.getValue().equals(entry.getValue())) {
                    if (Max_entry.getKey().compareTo(entry.getKey()) > 0) {
                        Max_entry = entry;
                    }
                }
            }
            String string=Max_entry.getKey()+ " - "+Max_entry.getValue();
            list_result.add(string);
            dictionary.remove(Max_entry.getKey());
        }

        String result="";
        for (String s : list_result)
        {
            result += s + "\n";
        }
        result=result.substring(0,result.length()-1);
        return result;
    }
}