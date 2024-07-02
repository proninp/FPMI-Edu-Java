package task_3_2_3;

import java.util.Random;

public class Parrot extends Bird {
    private Random random = new Random();
    private String text;
    public Parrot(String text) {
        this.text = text;
    }
    @Override
    public void Sing() {
        int n = random.nextInt(text.length()) + 1;
        System.out.println(text.substring(0, n));
    }
}
