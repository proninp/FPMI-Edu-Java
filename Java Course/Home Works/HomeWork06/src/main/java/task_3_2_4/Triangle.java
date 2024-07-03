package task_3_2_4;

import lombok.RequiredArgsConstructor;
import task_3_1_2.Point;

public class Triangle extends Figure {
    private final Point a;
    private final Point b;
    private final Point c;
    private final Double ab;
    private final Double bc;
    private final Double ca;

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this(new Point(x1, y1), new Point(x2, y2), new Point(x3, y3));
    }

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        ab = a.length(b);
        bc = b.length(c);
        ca = c.length(a);
    }

    public Point getA() {
        return new Point(a.getX(), a.getY());
    }

    public Point getB() {
        return new Point(b.getX(), b.getY());
    }

    public Point getC() {
        return new Point(c.getX(), c.getY());
    }

    @Override
    public double area() {
        Double p = (ab + bc + ca) / 2;
        return Math.sqrt(p * (p - ab) * (p - bc) * (p - ca));
    }

    @Override
    public double length() {
        return ab + bc + ca;
    }
}