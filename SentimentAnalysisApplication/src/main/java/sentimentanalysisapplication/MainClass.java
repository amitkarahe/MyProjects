package sentimentanalysisapplication;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) throws FileNotFoundException {

        int start;
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> m = WordWithoutStop.getWordCount();
        Map<String, Integer> m1 = WordWithoutStop.getCharacterCount();
        do {
            System.out.println("1 for Word Count  With Stop Words - ");
            System.out.println("2 for Sentence Count  With Stop Words - ");
            System.out.println("3 for Character Count With Stop Words - ");
            System.out.println("4 for Sentence Count  Without Stop Words - ");
            System.out.println("5 for Character Count Without Stop Words - ");
            System.out.println("6 for WordCount Without Stop Words - ");
            System.out.println("7 for Top Counted Words Without Stop Words - ");
            System.out.println("8 for Least Counted Words Without Stop Words - ");
            System.out.println("9 for Top Counted Characters Without Stop Words - ");
            System.out.println("10 for Least Counted Characters Without Stop Words - ");
            System.out.println("11 to Search a word Count Without Stop Words - ");
            System.out.println("12 to Search 5 Words Count Without Stop Words - ");

            int count = sc.nextInt();

            switch (count) {

                case 1:
                    WordWithStop.getWordCount();
                    break;
                case 2:
                    WordWithStop.getSentenceCount();
                    break;
                case 3:
                    WordWithStop.getCharacterCount();
                    break;
                case 4:
                    WordWithoutStop.getSentenceCount();
                    break;
                case 5:
                    for (Map.Entry<String, Integer> entry : m1.entrySet()) {
                        Object key = entry.getKey();
                        Object value = entry.getValue();
                        System.out.println(key + " " + value);
                    }
                    break;
                case 6:
                    for (Map.Entry<String, Integer> entry : m.entrySet()) {
                        Object key = entry.getKey();
                        Object value = entry.getValue();
                        System.out.println(key + " " + value);
                    }
                    break;
                case 7:
                    WordWithoutStop.getTopWords(m);
                    break;
                case 8:
                    WordWithoutStop.getleastWords(m);
                    break;
                case 9:
                    WordWithoutStop.getTopChar(m1);
                    break;
                case 10:
                    WordWithoutStop.getLeastChar(m1);
                    break;
                case 11:
                    Scanner s = new Scanner(System.in);
                    System.out.println("Enter The Word to be Search - ");
                    String string = s.nextLine();
                    System.out.println(WordWithoutStop.getWordSearch(m, string));
                    break;
                case 12:
                    WordWithoutStop.getWordSet(m);

                    break;
            }
            Scanner st = new Scanner(System.in);
            System.out.println("press 1 to continue and any other key to exit.......");
            start = st.nextInt();

        } while (start == 1);
    }
}
