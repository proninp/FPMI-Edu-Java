package task_3_2_4;

import lombok.Getter;

import task_3_1_2.CircuitPolyline;
import task_3_1_2.Point;
import task_3_1_2.Polyline;

public class Square extends Figure {
    private final Point point;
    @Getter
    private int side;

    public Square(Point point, int side) {
        setSide(side);
        this.point = new Point(point.getX(), point.getY());
    }

    public Square(int x, int y, int side) {
        this(new Point(x, y), side);
    }

    public Point getPoint() {
        return new Point(point.getX(), point.getY());
    }

    public Polyline polyline() {
        return new CircuitPolyline(this.point,
                new Point(this.point.getX() + side, this.point.getY()),
                new Point(this.point.getX() + side, this.point.getY() - side),
                new Point(this.point.getX(), this.point.getY() - side),
                this.point);
    }

    public void setSide(int side) {
        checkSide(side);
        this.side = side;
    }

    private void checkSide(int side) {
        if (side <= 0)
            throw new IllegalArgumentException("Длина стороны квадрата должна быть положительной");
    }

    @Override
    public String toString() {
        return String.format("Квадрат в точке %s со стороной %d", this.point, side);
    }

    @Override
    public double area() {
        return side * side;
    }

    @Override
    public double length() {
        return 4 * side;
    }
}
