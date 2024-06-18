package task_1_6_10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CityTest {
    @Test
    void citiesTest() {
        City a = new City("A");
        City b = new City("B");
        City c = new City("C");
        City d = new City("D");
        City e = new City("E");
        City f = new City("F", new Route(b, 1), new Route(e, 2));

        List<City> cities = new ArrayList<>(List.of(a, b, c, d, e, f));

        Route ab = new Route(b, 5);
        a.addRoute(ab);
        a.addRoute(d, 6);
        a.addRoute(f, 1);

        b.addRoute(new Route(a, 5));
        b.addRoute(new Route(c, 3));

        c.addRoute(new Route(b, 3));
        c.addRoute(new Route(d, 4));

        d.addRoute(a, 6);
        d.addRoute(e, 2);
        d.addRoute(c, 4);

        e.addRoute(f, 2);

        Assertions.assertThrows(IllegalArgumentException.class, () -> a.addRoute(a, 0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> a.addRoute(b, 5));

        a.removeRoute(ab);
        a.addRoute(b, 5);

        cities.forEach(System.out::println);
    }
}