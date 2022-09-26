import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int Requests = 0;

        while (input != 42) {
            if (isPrime(sumOfDigits(input))) {
                Requests++;
            }
            input = scanner.nextInt();
        }
        System.out.println("Count of coffee-request - " + Requests);
    }

    private static int sumOfDigits(int input) {
        int result = 0;

        while (input != 0) {
            result += input % 10;
            input /= 10;
        }
        return (result);
    }

    private static boolean isPrime(int num) {
        int sqrt = 0;

        if (num <= 1) {
            return (false);
        } else if (num == 2) {
            return (true);
        }
        sqrt = mySqrt(num);
        for (int i = 2; i <= sqrt + 1; i++) {
            if (num % i == 0) {
                return (false);
            }
        }
        return (true);
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