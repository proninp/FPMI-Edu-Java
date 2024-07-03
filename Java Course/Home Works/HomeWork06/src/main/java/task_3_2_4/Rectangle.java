package task_3_2_4;

import lombok.Getter;
import task_3_1_2.Point;

public class Rectangle extends Figure {
    @Getter
    private int width;
    @Getter
    private int height;
    private Point point;

    public Rectangle(int x, int y, int width, int height) {
        this(new Point(x, y), width, height);
    }

    public Rectangle(Point point, int width, int height) {
        setWidth(width);
        setHeight(height);
        this.point = new Point(point.getX(), point.getY());
    }

    private void setHeight(int height) {
        checkSide(height);
        this.height = height;
    }

    public void setWidth(int width) {
        checkSide(width);
        this.width = width;
    }

    public Point getPoint() {
        return new Point(point.getX(), point.getY());
    }

    private void checkSide(int side) {
        if (side <= 0)
            throw new IllegalArgumentException("Длина стороны прямоугольника должна быть положительной");
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double length() {
        return 2 * height + 2 * width;
    }
}
