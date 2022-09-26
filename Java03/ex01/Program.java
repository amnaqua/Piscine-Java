public class Program {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Wrong number of arguments");
            System.exit(-1);
        }
        int count = 0;
        if (args[0].matches("--count=\\d+")) {
            count = Integer.parseInt(args[0].substring(8));
        } else {
            System.err.println("Invalid argument");
            System.exit(-1);
        }
        if (count < 1) {
            System.err.println("Count is to low");
            System.exit(-1);
        }
        EggHen eggHen = new EggHen(count);

        Thread t1 = new Thread(eggHen::eggExecute);
        Thread t2 = new Thread(eggHen::henExecute);

        t1.start();
        t2.start();
    }
}
