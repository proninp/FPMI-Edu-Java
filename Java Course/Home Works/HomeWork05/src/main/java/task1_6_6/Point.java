package task1_6_6;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Point {
    private final int x;
    private final int y;

    @Override
    public String toString() {
        return String.format("{%s; %s}", x, y);
    }
}
