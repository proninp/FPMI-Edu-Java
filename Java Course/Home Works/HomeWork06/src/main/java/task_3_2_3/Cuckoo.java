package task_3_2_3;

import java.util.Random;

public class Cuckoo extends Bird {
    private Random random = new Random();
    @Override
    public void Sing() {
        int n = random.nextInt(10) + 1;
        for (int i = 0; i < n; i++) {
            System.out.println("ку-ку");
        }
    }
}
