public class EggHen {
    private final int count;
    private boolean flag;

    public EggHen(int c) {
        count = c;
        flag = false;
    }

    public synchronized void eggExecute() {
        for (int i = 0; i < count; i++) {
            while (flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Egg");
            flag = true;
            notify();
        }
    }

    public synchronized void henExecute() {
        for (int i = 0; i < count; i++) {
            while (!flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Hen");
            flag = false;
            notify();
        }
    }
}
