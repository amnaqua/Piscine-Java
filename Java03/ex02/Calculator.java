public class Calculator implements Runnable {

    public static int sum;
    private final int[] array;
    private int num;
    private int begin;
    private int end;

    public Calculator(int[] arr, int begin, int end, int n) {
        array = new int[end - begin + 1];
        num = n;
        this.begin = begin;
        this.end = end;
        for (int i = begin, j = 0; i <= end; ++i, ++j) {
            array[j] = arr[i];
        }
    }

    public void run() {
        int res = 0;
        for (int i = 0; i < array.length; ++i) {
            res += array[i];
        }
        sum += res;
        System.out.println("Thread " + num + ": from " + begin + " to " + end + " sum is " + res);
    }
}

