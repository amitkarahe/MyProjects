package sentimentanalysisapplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class WordWithStop {

    public static void getWordCount() throws FileNotFoundException {
File file = new File("C:\\Users\\Lenovo\\Documents\\amit.txt");
        Scanner sc = new Scanner(file);
        String s = "";
        while (sc.hasNext()) {
            s = s.concat(sc.next() + " ");
        }
        s = s.toLowerCase();

        String[] str = s.split(" ");
        ArrayList<String> arr = new ArrayList<>();
        for (String p : str) {
            arr.add(p);
        }
        
        Map<String,Integer> map = new TreeMap<String,Integer>();
        
        for (String d : str) {
            map.put(d, Collections.frequency(arr, d));
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " " + value);
        }
    }
    public static void getSentenceCount() throws FileNotFoundException{
        File file = new File("C:\\Users\\Lenovo\\Documents\\amit.txt");
        Scanner sc = new Scanner(file);
        String s = "";
        while (sc.hasNext()) {
            s = s.concat(sc.next() + " ");
        }
        s = s.toLowerCase();

        String[] str = s.split("[.]", 0);

        ArrayList<String> arr = new ArrayList<>();
        for (String p : str) {
            arr.add(p);
        }
        Map<String,Integer> map = new TreeMap<String,Integer>();
        
        for (String d : str) {
            map.put(d, Collections.frequency(arr, d));
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " " + value);
        }
    }
    
    public static void getCharacterCount() throws FileNotFoundException{
        File file = new File("C:\\Users\\Lenovo\\Documents\\amit.txt");
        Scanner sc = new Scanner(file);
        String s = " ";
        while (sc.hasNext()) {
            s = s.concat(sc.next() + " ");
        }
        s = s.toLowerCase();

        String[] str = s.split("");

        ArrayList<String> arr = new ArrayList<>();
        for (String p : str) {
            arr.add(p);
        }
        Map<String,Integer> map = new TreeMap<String,Integer>();
        
        for (String d : str) {
            map.put(d, Collections.frequency(arr, d));
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " " + value);
        }
    }
}
