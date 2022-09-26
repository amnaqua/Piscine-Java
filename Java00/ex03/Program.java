import java.util.Scanner;

public class Program {

    private static final int MAX_GRADE = 9;
    private static final int MIN_GRADE = 0;
    private static final int MAX_WEEK = 18;
    private static final String BREAKPOINT = "42";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputWeek = scanner.nextLine();
        int weekNum = 1;
        long allGrades = 0;

        while (weekNum <= MAX_WEEK && !inputWeek.equals(BREAKPOINT)) {
            if (!inputWeek.equals("Week " + weekNum)) {
                System.exit(errorArgument());
            }
            allGrades = packGrade(getMinGrade(scanner), allGrades, weekNum);
            weekNum++;
            inputWeek = scanner.nextLine();
        }
        for (int i = 1; i < weekNum; i++) {
            System.out.print("Week " + i + " ");
            drawGraph(unpackGrade(i, allGrades));
        }
    }

    private static long packGrade(int minGrade, long allGrades, int index) {
        long ret;
        long power = 1;

        for (int i = 1; i < index; i++) {
            power *= 10;
        }
        ret = allGrades + (minGrade * power);
        return (ret);
    }

    private static int unpackGrade(int index, long allGrades) {
        int ret;

        for (int i = 1; i < index; i++) {
            allGrades /= 10;
        }
        ret = (int)(allGrades % 10);
        return (ret);
    }

    private static void drawGraph(int minGrade) {
        for (int i = 0; i < minGrade; i++) {
            System.out.print("=");
        }
        System.out.println(">");
    }

    private static int getMinGrade(Scanner scanner) {
        int min = scanner.nextInt();
        int current;

        if (min < MIN_GRADE || min > MAX_GRADE) {
            System.exit(errorArgument());
        }
        for (int i = 0; i < 4; i++) {
            current = scanner.nextInt();
            if (current < MIN_GRADE || current > MAX_GRADE) {
                System.exit(errorArgument());
            }
            min = (current < min) ? current : min;
        }
        if (!scanner.nextLine().equals("")) {
            System.exit(errorArgument());
        }
        return (min);
    }

    private static int errorArgument() {
        System.err.println("Illegal argument");
        return (-1);
    }
}