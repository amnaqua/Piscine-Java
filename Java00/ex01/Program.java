import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean IsPrime = true;
		int input = scanner.nextInt();
        int exit_code = 0;
        int steps = 0;
        int sqrt;

        if (input <= 1) {
            System.err.println("Illegal argument");
            exit_code = -1;
        } else if (input == 2) {
            System.out.println(IsPrime + " " + 1);
        } else {
            sqrt = mySqrt(input);
            for (int i = 2; i <= sqrt + 1; i++) {
                steps++;
                if (input % i == 0) {
                    IsPrime = false;
                    break;
                }
            }
            System.out.println(IsPrime + " " + steps);
        }
        System.exit(exit_code);
    }

    private static int mySqrt(int input) {
        long start = 1;
        long end = input;
        long ret = 0;
        long mid;

        while (start <= end) {
            mid = (start + end) / 2;
            if (mid * mid == input) {
                return ((int)mid);
            } else if (mid * mid < input) {
                start = mid + 1;
                ret = mid;
            } else {
                end = mid - 1;
			}
		}
		return ((int)ret);
	}
}