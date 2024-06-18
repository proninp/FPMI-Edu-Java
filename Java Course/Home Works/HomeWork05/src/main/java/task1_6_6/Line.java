package task1_6_6;

public class Line {
    private Point start;
    private Point end;

    public Point getStart() {
        return new Point(start.getX(), start.getY());
    }

    public Point getEnd() {
        return new Point(end.getX(), end.getY());
    }

    public void setStart(Point start) {
        this.start = new Point(start.getX(), start.getY());
    }

    public void setEnd(Point end) {
        this.end = new Point(end.getX(), end.getY());
    }

    public void setStart(int x, int y) {
        this.start = new Point(x, y);
    }

    public void setEnd(int x, int y) {
        this.end = new Point(x, y);
    }

    public Line(Point start, Point end) {
        this(start.getX(), start.getY(), end.getX(), end.getY());
    }

    public Line(int startX, int startY, int endX, int endY) {
        this.start = new Point(startX, startY);
        this.end = new Point(endX, endY);
    }

    public int getDistance() {
        return (int) Math.sqrt(Math.pow(end.getX(),  - start.getX()) + Math.pow(end.getY(),  -start.getY()));
    }

    @Override
    public String toString() {
        return String.format("Линия от %s до %s", start, end);
    }
}
