import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import com.github.javafaker.Faker;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        var nodes = IntStream.rangeClosed(1,9)
                .mapToObj(i -> new Intersection("v" + i))
                .toArray(Intersection[]::new);


        Set <Intersection> intersections = new HashSet<>();

        for (Intersection i : nodes) {
            intersections.add(i);
        }

        if (intersections.size() < nodes.length) {
            System.out.println("The streets are repeting");
        }

        Faker fakeStreet = new Faker();

        Street[] streets = new Street[16];

        streets[0] = new Street(fakeStreet.address().streetName(), 2, nodes[0], nodes[1]);
        streets[1] = new Street(fakeStreet.address().streetName(), 3, nodes[1], nodes[2]);
        streets[2] = new Street(fakeStreet.address().streetName(), 1, nodes[2], nodes[3]);
        streets[3] = new Street(fakeStreet.address().streetName(), 1, nodes[3], nodes[4]);
        streets[4] = new Street(fakeStreet.address().streetName(), 2, nodes[0], nodes[6]);
        streets[5] = new Street(fakeStreet.address().streetName(), 3, nodes[6], nodes[5]);
        streets[6] = new Street(fakeStreet.address().streetName(), 3, nodes[5], nodes[4]);
        streets[7] = new Street(fakeStreet.address().streetName(), 2, nodes[0], nodes[7]);
        streets[8] = new Street(fakeStreet.address().streetName(), 2, nodes[7], nodes[8]);
        streets[9] = new Street(fakeStreet.address().streetName(), 1, nodes[8], nodes[4]);
        streets[10] = new Street(fakeStreet.address().streetName(), 1, nodes[6], nodes[7]);
        streets[11] = new Street(fakeStreet.address().streetName(), 2, nodes[7], nodes[1]);
        streets[12] = new Street(fakeStreet.address().streetName(), 1, nodes[2], nodes[5]);
        streets[13] = new Street(fakeStreet.address().streetName(), 2, nodes[5], nodes[7]);
        streets[14] = new Street(fakeStreet.address().streetName(), 1, nodes[8], nodes[3]);
        streets[15] = new Street(fakeStreet.address().streetName(), 2, nodes[2], nodes[4]);

        List<Street> streetsList = new LinkedList<>();

        for (Street street : streets) {
            streetsList.add(street);
        }

        Collections.sort(streetsList, Street::sortedStreets);

        Map<Intersection, List<Street>> map = new HashMap<>();

        for (var intersection :nodes){
            List<Street> sortedStreetsList = new ArrayList<>();
            for (Street street : streets) {
                if (street.getI1() == intersection || street.getI2() == intersection) {
                    sortedStreetsList.add(street);
                }
            }

            map.put(intersection, sortedStreetsList);
        }

        var intersectionsList = Arrays.stream(nodes).filter(node -> map.get(node).size() >= 3)
                .toArray(Intersection[]::new);

        int val = 3;

        var result = Arrays.stream(streets).filter(street -> street.getLength() >= val)
                .filter(street -> (Arrays.asList(intersectionsList).contains(street.getI1()) || Arrays.asList(intersectionsList).contains(street.getI2())))
                .toArray(Street[]::new);

        System.out.println(Arrays.toString(result));

        TownHall townHall = new TownHall(Arrays.asList(nodes), streetsList);

        System.out.println(townHall);
        townHall.setCamera();


    }
}
