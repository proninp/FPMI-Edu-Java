package task_3_1_2;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import task_3_3_5.Lengthable;

@Getter
@RequiredArgsConstructor
public class Point implements Lengthable {
    private final int x;
    private final int y;

    public double length(Point point) {
        return Math.sqrt(Math.pow(this.getX() - point.getX(), 2) +
                Math.pow(this.getY() - point.getY(), 2));
    }
    @Override
    public String toString() {
        return String.format("{%s; %s}", x, y);
    }

    @Override
    public double length() {
        return 0;
    }
}
