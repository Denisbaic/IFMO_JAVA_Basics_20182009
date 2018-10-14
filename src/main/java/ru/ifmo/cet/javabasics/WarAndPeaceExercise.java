package ru.ifmo.cet.javabasics;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;


public class WarAndPeaceExercise {

    public static String warAndPeace() throws IOException {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");
        final Charset charset = Charset.forName("windows-1251");
        List<String> strings = Files.readAllLines(tome12Path, charset);
        strings.addAll(Files.readAllLines(tome34Path, charset));
        List<String> words = new ArrayList<>();

        strings.stream().map(s->s.toLowerCase()).map(s -> s.replaceAll("[^a-zа-я]", " ")).
                map(replace -> asList(replace.split(" "))).forEach(list-> words.addAll(list));
        List<String> finalWords=words.stream().filter(s->s.length()>=4).collect(Collectors.toList());

        Map<String,Integer> dictionary=new LinkedHashMap<>();
        finalWords.forEach(key -> {
            Integer integer = (dictionary.containsKey(key)) ? (dictionary.put(key, dictionary.get(key) + 1)) : (dictionary.put(key, 1));
        });
        dictionary.entrySet().removeIf(entires->entires.getValue()<10);

        List<Map.Entry<String, Integer>> sorted_dictionaty = new ArrayList(dictionary.entrySet());
        sorted_dictionaty.sort(Map.Entry.comparingByKey());
        sorted_dictionaty.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        String result=sorted_dictionaty.stream().map(entry->entry.getKey() + " - " + entry.getValue()).collect(Collectors.joining("\n"));
        return result;


        //throw new UnsupportedOperationException();
    }


}