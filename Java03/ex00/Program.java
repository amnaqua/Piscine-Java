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

        Egg egg = new Egg();
        Hen hen = new Hen();

        egg.startThread(count);
        hen.startThread(count);
        egg.execute();
        hen.execute();

        try {
            egg.join();
            hen.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < count; i++) {
            System.out.println("Human");
        }
    }
}
