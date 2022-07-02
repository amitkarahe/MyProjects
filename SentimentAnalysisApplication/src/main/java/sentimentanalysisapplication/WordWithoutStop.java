package sentimentanalysisapplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class WordWithoutStop {

    public static Map<String, Integer> getWordCount() throws FileNotFoundException {
        File file = new File("C:\\Users\\Lenovo\\Documents\\amit.txt");
        Scanner sc = new Scanner(file);
        File file1 = new File("C:\\Users\\Lenovo\\Documents\\SpecialCharacters.txt");
        Scanner sc1 = new Scanner(file1);
        File file2 = new File("C:\\Users\\Lenovo\\Documents\\StopWords.txt");
        Scanner sc2 = new Scanner(file2);
        String s = "";
        while (sc.hasNext()) {
            s = s.concat(sc.next() + " ");
        }
        
        s = s.toLowerCase();
        s = s.replaceAll("[-+.^:,/';â€™)(]", " ");
        String[] str = s.split(" ");
        
        String stop = "";
        while (sc2.hasNext()) {
            stop = stop.concat(sc2.next() + " ");
        }
        String[] st = stop.split(" ");
        String special = "";
        while(sc1.hasNext()){
            special = special.concat(sc1.next() + " ");
        }
        String[] spec = special.split(" ");
        
        ArrayList<String> arr = new ArrayList<>();
        for (String p : str) {
            arr.add(p);
        }
        ArrayList<String> arr1 = new ArrayList<>();
        for(String l:spec){
            arr1.add(l);
        }
        ArrayList<String> arr2 = new ArrayList<>();
        for (String j : st) {
            arr2.add(j);
        }
        for(String v:arr){
            for(String d:arr1){
             if(v.contains(d)){
                 v.replace(d, " ");
             }   
            }
        }
        TreeSet<String> set = new TreeSet<>(arr);
        
        set.removeAll(arr2);

        ArrayList<String> array = new ArrayList<>(set);

        Map<String, Integer> map = new TreeMap<String, Integer>();

        for (String d : array) {
            map.put(d, Collections.frequency(arr, d));
        }
        return map;
    }

    public static void getSentenceCount() throws FileNotFoundException {
        File file = new File("C:\\Users\\Lenovo\\Documents\\amit.txt");
        Scanner sc = new Scanner(file);
        File file1 = new File("C:\\Users\\Lenovo\\Documents\\SpecialCharacters.txt");
        Scanner sc1 = new Scanner(file1);
        File file2 = new File("C:\\Users\\Lenovo\\Documents\\StopWords.txt");
        Scanner sc2 = new Scanner(file2);
        String s = "";
        while (sc.hasNext()) {
            s = s.concat(sc.next() + " ");
        }
        s = s.toLowerCase();
        s = s.replaceAll("[-+^:,/';â€™)(]", " ");
        String[] str = s.split("[.]");
        String stop = "";
        while (sc2.hasNext()) {
            stop = stop.concat(sc2.next() + " ");
        }
        String[] st = stop.split(" ");
        ArrayList<String> arr = new ArrayList<>();
        for (String p : str) {
            arr.add(p);
        }

        ArrayList<String> arr2 = new ArrayList<>();
        for (String j : st) {
            arr2.add(j);
        }

        TreeSet<String> set = new TreeSet<>(arr);

        set.removeAll(arr2);

        ArrayList<String> array = new ArrayList<>(set);

        Map<String, Integer> map = new TreeMap<String, Integer>();

        for (String d : array) {
            map.put(d, Collections.frequency(arr, d));
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " " + value);
        }
    }

    public static Map<String, Integer> getCharacterCount() throws FileNotFoundException {

        File file = new File("C:\\Users\\Lenovo\\Documents\\amit.txt");
        Scanner sc = new Scanner(file);
        File file1 = new File("C:\\Users\\Lenovo\\Documents\\SpecialCharacters.txt");
        Scanner sc1 = new Scanner(file1);
        File file2 = new File("C:\\Users\\Lenovo\\Documents\\StopWords.txt");
        Scanner sc2 = new Scanner(file2);
        String s = " ";
        while (sc.hasNext()) {
            s = s.concat(sc.next() + " ");
        }
        s = s.toLowerCase();
        s = s.replaceAll("[-+^:.,/';â€™)(]", " ");
        String[] str = s.split("");
        
        String stop = "";
        while (sc2.hasNext()) {
            stop = stop.concat(sc2.next() + " ");
        }
        String[] st = stop.split(" ");
        ArrayList<String> arr = new ArrayList<>();
        for (String p : str) {
            arr.add(p);
        }
        
        ArrayList<String> arr2 = new ArrayList<>();
        for (String j : st) {
            arr2.add(j);
        }

        TreeSet<String> set = new TreeSet<>(arr);

        set.removeAll(arr2);

        ArrayList<String> array = new ArrayList<>(set);

        Map<String, Integer> map = new TreeMap<String, Integer>();

        for (String d : array) {
            map.put(d, Collections.frequency(arr, d));
        }
        

    return map;
    }

    public static void getTopWords(Map<String,Integer> map) {
        List<Map.Entry<String,Integer>> arr = new ArrayList<>(map.entrySet());
Comparator c = new MapSorting();        
        Collections.sort(arr, new Comparator<Map.Entry<String,Integer>>(){
            public int compare(Map.Entry<String,Integer> e1,Map.Entry<String,Integer> e2){
                return e2.getValue()-e1.getValue();
            }
        });
        int index=1;
        for(Map.Entry<String, Integer> e:arr ){
            if(index<=5){
            System.out.println(e.getKey()+" "+e.getValue());
            }
            else{
                break;
            }
            index++;
        }
    }
    public static void getleastWords(Map<String, Integer> map) {
        List<Map.Entry<String,Integer>> arr = new ArrayList<>(map.entrySet());
        
        Collections.sort(arr, new Comparator<Map.Entry<String,Integer>>(){
            public int compare(Map.Entry<String,Integer> e1,Map.Entry<String,Integer> e2){
                return e1.getValue()-e2.getValue();
            }
        });
        int index=1;
        for(Map.Entry<String, Integer> e:arr ){
            if(index<=5){
            System.out.println(e.getKey()+" "+e.getValue());
            }
            else{
                break;
            }
            index++;
        }
    }
    
    public static void getTopChar(Map<String, Integer> map) {
        List<Map.Entry<String,Integer>> arr = new ArrayList<>(map.entrySet());
         
        Collections.sort(arr, new Comparator<Map.Entry<String,Integer>>(){
            public int compare(Map.Entry<String,Integer> e1,Map.Entry<String,Integer> e2){
                return e2.getValue()-e1.getValue();
            }
        });
        int index=1;
        for(Map.Entry<String, Integer> e:arr ){
            if(index<=5){
            System.out.println(e.getKey()+" "+e.getValue());
            }
            else{
                break;
            }
            index++;
        }
    }
    
    public static void getLeastChar(Map<String, Integer> map) {
        List<Map.Entry<String,Integer>> arr = new ArrayList<>(map.entrySet());
        
        Collections.sort(arr, new Comparator<Map.Entry<String,Integer>>(){
            public int compare(Map.Entry<String,Integer> e1,Map.Entry<String,Integer> e2){
                return e1.getValue()-e2.getValue();
            }
        });
        int index=1;
        for(Map.Entry<String, Integer> e:arr ){
            if(index<=5){
            System.out.println(e.getKey()+" "+e.getValue());
            }
            else{
                break;
            }
            index++;
        }
    }
    public static boolean getWordSearch(Map<String,Integer> m,String s){
       boolean b = m.containsKey(s);
       return b;
    }
    public static void getWordSet(Map<String,Integer> map){
        String[] s =new String[5];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 5  values to search ");
        int i=0;
        for(String w:s){
            s[i] = sc.next();
            i++;
        }
        TreeSet<String> tree = new TreeSet<>();
        for(String r:s){
            tree.add(r);
        } 
       for(String x:tree){
            if(map.containsKey(x)){
                System.out.println(x +" "+map.get(x));
            }
            else{
                System.out.println(x + " "+ 0);
            }
        }
    
    }
}
