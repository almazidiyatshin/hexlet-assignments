package exercise;

// BEGIN
public class ListThread extends Thread {
    private SafetyList list;

    public ListThread(SafetyList list) {
        super();
        this.list = list;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 1000; i++) {
                Thread.sleep(1);
                list.add(i);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
// END
