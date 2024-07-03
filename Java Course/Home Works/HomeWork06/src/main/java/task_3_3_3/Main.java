package task_3_3_3;

import task_3_1_2.Point;
import task_3_2_4.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Figure> figures = new ArrayList<>();
        figures.add(new Circle(new Point(10, 6), 4));
        figures.add(new Circle(new Point(-2, 4), 6));
        figures.add(new Circle(new Point(0, 0), 2));
        figures.add(new Square(12, 20, 5));
        figures.add(new Rectangle(8, 8, 4, 3));

        double totalArea = figures.stream()
                .mapToDouble(Figure::area)
                .sum();
        System.out.println("Total area is: " + totalArea);
    }
}
