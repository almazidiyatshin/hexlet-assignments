package exercise;

// BEGIN
public class MinThread extends Thread {
    private int[] numbers;
    private int min;

    public MinThread(int[] numbers) {
        super();
        this.numbers = numbers;
    }

    @Override
    public void run() {
        for (int i = 0; i < numbers.length; i++) {
            min = Math.min(min, numbers[i]);
        }
    }

    public int getMin() {
        return min;
    }
}
// END
