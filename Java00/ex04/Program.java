import java.util.Scanner;

public class Program {

    private static final int MAX_CHAR_COUNT = 65535;
    private static final int MAX_HEIGHT = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        short[] charCount = getCharCount(input);
        char[] topTenChars = getTopTen(charCount);
        drawGraph(topTenChars, charCount);
    }

    private static short[] getCharCount(String input) {
        short[] ret = new short[MAX_CHAR_COUNT];
        char[] inputArray = input.toCharArray();

        for (int i = 0; i < input.length(); i++) {
            ret[inputArray[i]]++;
            if (ret[inputArray[i]] >= 1000) {
                System.err.println("Too much symbols");
                System.exit(-1);
            }
        }
        return (ret);
    }

    private static char[] getTopTen(short[] input) {
        char[] ret = new char[MAX_HEIGHT];

        for (int i = 0; i < MAX_CHAR_COUNT; i++) {
            short count = input[i];
            if (count > 0) {
                for (int j = 0; j < MAX_HEIGHT; j++) {
                    if (input[ret[j]] < count) {
                        ret = insertChar(ret, (char)i, j);
                        break;
                    }
                }
            }
        }
        return (ret);
    }

    private static char[] insertChar(char[] base, char c, int index) {
        char[] ret = new char[MAX_HEIGHT];
        for (int i = 0; i < index; i++) {
            ret[i] = base[i];
        }
        ret[index] = c;
        for (int i = index + 1; i < 10; i++) {
            ret[i] = base[i - 1];
        }
        return (ret);
    }

    private static void drawGraph(char[] topTen, short[] charCount) {
        short max = charCount[topTen[0]];
        short maxHeight = max <= 10 ? max : 10;
        short totalLines = (short) (maxHeight + 2);
        short[] graphs = new short[MAX_HEIGHT];

        for (int i = 0; i < MAX_HEIGHT; i ++) {
            if (max <= 10) {
                graphs[i] = charCount[topTen[i]];
            } else {
                graphs[i] = (short) (charCount[topTen[i]] * 10 / max);
            }
        }
        System.out.println();
        for (int i = 0; i < totalLines; i++) {
            for (int j = 0; j < MAX_HEIGHT; j++) {
                if (topTen[j] != 0) {
                    if (i + graphs[j] + 2 == totalLines) {
                        System.out.print(" " + charCount[topTen[j]] + " ");
                    } else if (i == totalLines - 1) {
                        System.out.print(" " + topTen[j] + " ");
                    } else if (i + graphs[j] >= maxHeight) {
                        System.out.print(" # ");
                    }
                    if (j != MAX_HEIGHT - 1 && topTen[j + 1] != 0 && i + graphs[j + 1] >= maxHeight) {
                        System.out.print(' ');
                    }
                }
            }
            System.out.println();
        }
    }
}