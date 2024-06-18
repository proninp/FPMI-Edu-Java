package task_1_6_10;

import lombok.Getter;

import java.util.*;

public class City {
    @Getter
    private String name;
    private Set<Route> routes;

    public City(String name, Route...routes) {
        this(name);
        for (Route route: routes) {
            addRoute(route);
        }
    }

    public City(String name) {
        this.name = name;
        routes = new HashSet<>();
    }

    /**
     * Функция добавления нового маршрута
     * @param newRoute маршрут для добавления
     */
    public boolean addRoute(Route newRoute) {
        if (!checkNewRoute(newRoute))
            return false;
        this.routes.add(newRoute);
        return true;

    }

    /**
     * Функция добавления нового маршрута
     * @param city город нового маршрута
     * @param price стоимость маршрута
     */
    public boolean addRoute(City city, double price) {
        return addRoute(new Route(city, price));
    }

    public boolean removeRoute(Route route) {
        return routes.remove(route);
    }

    public boolean removeRoute(City city) {
        return removeRoute(new Route(city, 0));
    }

    // Проверка маршрута перед добавлением
    private boolean checkNewRoute(Route newRoute) {
        if (newRoute.getCity().getName().equals(this.getName())) {
            return false;
        }
        return (!routes.contains(newRoute));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return name.equals(city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Arrays.hashCode(routes.toArray()));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("City \"%s\" with routes:%n", getName()));
        for (var route: routes)
            sb.append(route).append("; ");
        return sb.substring(0, sb.length() - 2);
    }
}