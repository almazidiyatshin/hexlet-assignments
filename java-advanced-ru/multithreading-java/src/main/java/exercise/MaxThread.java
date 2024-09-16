package exercise;

// BEGIN
public class MaxThread extends Thread {
    private int[] numbers;
    private int max;

    public MaxThread(int[] numbers) {
        super();
        this.numbers = numbers;
    }

    @Override
    public void run() {
        for (int i = 0; i < numbers.length; i++) {
            max = Math.max(max, numbers[i]);
        }
    }

    public int getMax() {
        return max;
    }
}
// END
