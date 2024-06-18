package task_1_6_10;

import lombok.Getter;

import java.util.Objects;

public class Route {
    @Getter
    private final City city;
    @Getter
    private final double price;

    public Route(City city, double price) {
        if (city == null)
            throw new IllegalArgumentException("Город в маршруте должен быть указан.");
        this.city = city;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("\"%s: %.1f\"", getCity().getName(), this.getPrice());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return Objects.equals(city, route.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city.getName(), price);
    }
}
