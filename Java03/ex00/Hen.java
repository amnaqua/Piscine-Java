public class Hen extends Thread {
    private int count;

    public void startThread(int count) {
        this.count = count;
    }

    public void execute() {
        for (int i = 0; i < count; i++) {
            System.out.println("Hen");
        }
    }
}
