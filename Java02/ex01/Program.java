import java.io.*;
import java.util.*;

public class Program {
    private static final int MAX_FILE_SIZE_MB = 10;
    private static final String DICTIONARY_PATH = "Dictionary.txt";
    private static final List<String> TXT_A = new ArrayList<>();
    private static final List<String> TXT_B = new ArrayList<>();
    private static final Set<String> DICTIONARY = new HashSet<>();

    public static void main(String[] args) {
        if (args.length != 2) {
            throw new ArgsException();
        }
        try {
            File fileA = new File(args[0]);
            File fileB = new File(args[1]);
            if (fileA.length() / (1024 * 1024) > MAX_FILE_SIZE_MB || fileB.length() / (1024 * 1024) > MAX_FILE_SIZE_MB) {
                throw new FileSizeException();
            }
            BufferedReader readerA = new BufferedReader(new FileReader(args[0]));
            BufferedReader readerB = new BufferedReader(new FileReader(args[1]));
            BufferedWriter writer;
            String str;
            while ((str = readerA.readLine()) != null) {
                TXT_A.addAll(Arrays.asList(str.split("\\P{L}+")));
            }
            while ((str = readerB.readLine()) != null) {
                TXT_B.addAll(Arrays.asList(str.split("\\P{L}+")));
            }
            DICTIONARY.addAll(TXT_A);
            DICTIONARY.addAll(TXT_B);

            FileWriter toDictionary = new FileWriter(DICTIONARY_PATH);
            writer = new BufferedWriter(toDictionary);

            String[] sorted = DICTIONARY.toArray(new String[0]);
            Arrays.sort(sorted);

            for (String w : sorted) {
                writer.write(w + " ");
            }
            readerA.close();
            readerB.close();
            writer.close();

            List<Integer> wordCountA = getWordCount(TXT_A);
            List<Integer> wordCountB = getWordCount(TXT_B);

            double numerator = getNumerator(wordCountA, wordCountB);
            double denominator = getDenominator(wordCountA, wordCountB);
            double similarity = numerator / denominator;
            System.out.format("Similarity = %.2f\n", similarity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Integer> getWordCount(List<String> txt) {
        List<Integer> tmp = new ArrayList<>(DICTIONARY.size());
        int i = 0;
        int counter = 0;
        for (String elem : DICTIONARY) {
            for (String file : txt) {
                if (elem.equals(file)) {
                    counter++;
                }
            }
            tmp.add(i, counter);
            i++;
            counter = 0;
        }
        return (tmp);
    }

    private static double getNumerator(List<Integer> a, List<Integer> b) {
        double res = 0;

        for (int i = 0; i < DICTIONARY.size(); i++) {
            res += a.get(i) * b.get(i);
        }
        return (res);
    }

    private static double getDenominator(List<Integer> a, List<Integer> b) {
        double powA = 0;
        double powB = 0;
        double res;

        for (Integer x : a) {
            powA += x * x;
        }
        for (Integer x : b) {
            powB += x * x;
        }
        res = Math.sqrt(powA) * Math.sqrt(powB);
        return (res);
    }
}
