package task_3_2_4;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import task_3_1_2.Point;

public class Circle extends Figure {
    private final Point point;
    @Getter
    private final int radius;

    public Circle(Point point, int radius) {
        this.point = new Point(point.getX(), point.getY());
        this.radius = radius;
    }

    public Point getPoint() {
        return new Point(point.getX(), point.getY());
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double length() {
        return 2 * Math.PI * radius;
    }
}
