package task_3_1_2;

import java.util.List;

public class CircuitPolyline extends Polyline {
    public CircuitPolyline() {
        super();
    }

    public CircuitPolyline(Point... points) {
        super(points);
    }

    public CircuitPolyline(List<Point> points) {
        super(points);
    }

    @Override
    public double length() {
        double lenght = super.length();
        if (points.size() > 2)
            lenght += points.get(points.size() - 1).length(points.get(0));
        return lenght;
    }
}