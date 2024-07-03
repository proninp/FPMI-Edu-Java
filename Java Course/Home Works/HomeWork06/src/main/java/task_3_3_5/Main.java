package task_3_3_5;

import task_3_1_2.Point;
import task_3_1_2.Polyline;
import task_3_2_4.Circle;
import task_3_2_4.Rectangle;
import task_3_2_4.Square;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        totoalLength();
    }

    public static void totoalLength() {
        List<Lengthable> lengthables = new ArrayList<>();
        lengthables.add(new Polyline(new Point(2, 3), new Point(3, 5), new Point(7, 10)));
        lengthables.add(new Circle(new Point(10, 6), 4));
        lengthables.add(new Circle(new Point(-2, 4), 6));
        lengthables.add(new Circle(new Point(0, 0), 2));
        lengthables.add(new Square(12, 20, 5));
        lengthables.add(new Rectangle(8, 8, 4, 3));

        double totalLength = lengthables.stream()
                .mapToDouble(Lengthable::length)
                .sum();
        System.out.println("Total length is: " + totalLength);
    }
}
