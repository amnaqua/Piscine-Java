public class Program {
    private static int arraySize;
    private static int threadCount;

    public static void main(String[] args) throws InterruptedException {
        if (args.length != 2) {
            System.err.println("Wrong number of arguments");
            System.exit(-1);
        }
        if (args[0].startsWith("--arraySize=") && args[1].startsWith("--threadsCount=")) {
            arraySize = Integer.parseInt(args[0].substring(12));
            threadCount = Integer.parseInt(args[1].substring(15));
        } else if (arraySize < 1 || threadCount < 1) {
            System.err.println("Array size or Thread count is to low");
            System.exit(-1);
        } else {
            System.err.println("Invalid argument");
            System.out.println("Usage: --arraySize=<num> --threadsCount=<num>");
            System.exit(-1);
        }
        Thread[] threads = new Thread[threadCount];
        int[] array = randomArray(arraySize);
        int arraySum = sumOfArray(array);
        System.out.println("Sum: " + arraySum);

        int c, endC, i;
        c = arraySize / threadCount;
        endC = arraySize - c * (threadCount - 1);
        for (i = 0; i < threadCount - 1; ++i) {
            threads[i] = new Thread(new Calculator(array, i * c, i * c - 1, i));
        }
        threads[i] = new Thread(new Calculator(array, i * c, (i) * c + endC - 1, i));
        for (i = 0; i < threadCount; ++i) {
            threads[i].start();
            threads[i].join();
        }
        System.out.println("Sum of threads: " + Calculator.sum);
    }

    private static int[] randomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 150);
        }
        return (array);
    }

    private static int sumOfArray(int[] array) {
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            res += array[i];
        }
        return (res);
    }
}
