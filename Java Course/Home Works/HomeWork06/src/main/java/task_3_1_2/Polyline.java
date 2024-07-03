package task_3_1_2;

import task_3_3_5.Lengthable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Polyline implements Lengthable {
    List<Point> points;

    public Polyline() {
        this.points = new ArrayList<>();
    }

    public Polyline(Point...points) {
        this.points = new ArrayList<>(Arrays.stream(points).toList());
    }

    public Polyline(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public void add(Point point) {
        points.add(point);
    }
    public void add(Point...points) {
        for (var point : points) {
            add(point);
        }
    }

    @Override
    public double length() {
        double length = 0;
        for (int i = 1; i < points.size(); i++) {
            length +=  points.get(i).length(points.get(i - 1));
        }
        return length;
    }

    @Override
    public String toString() {
        if (points.isEmpty())
            return "Линия без точек";
        StringBuilder sb = new StringBuilder(points.get(0).toString());
        for (int i = 1; i < points.size(); i++) {
            sb.append(", ").append(points.get(i).toString());
        }

        return String.format("Линия [%s]", sb);
    }


}
