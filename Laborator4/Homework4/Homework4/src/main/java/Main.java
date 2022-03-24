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

        Streets[] streets = new Streets[16];

        streets[0] = new Streets(fakeStreet.address().streetName(), 2, nodes[0], nodes[1]);
        streets[1] = new Streets(fakeStreet.address().streetName(), 3, nodes[1], nodes[2]);
        streets[2] = new Streets(fakeStreet.address().streetName(), 1, nodes[2], nodes[3]);
        streets[3] = new Streets(fakeStreet.address().streetName(), 1, nodes[3], nodes[4]);
        streets[4] = new Streets(fakeStreet.address().streetName(), 2, nodes[0], nodes[6]);
        streets[5] = new Streets(fakeStreet.address().streetName(), 3, nodes[6], nodes[5]);
        streets[6] = new Streets(fakeStreet.address().streetName(), 3, nodes[5], nodes[4]);
        streets[7] = new Streets(fakeStreet.address().streetName(), 2, nodes[0], nodes[7]);
        streets[8] = new Streets(fakeStreet.address().streetName(), 2, nodes[7], nodes[8]);
        streets[9] = new Streets(fakeStreet.address().streetName(), 1, nodes[8], nodes[4]);
        streets[10] = new Streets(fakeStreet.address().streetName(), 1, nodes[6], nodes[7]);
        streets[11] = new Streets(fakeStreet.address().streetName(), 2, nodes[7], nodes[1]);
        streets[12] = new Streets(fakeStreet.address().streetName(), 1, nodes[2], nodes[5]);
        streets[13] = new Streets(fakeStreet.address().streetName(), 2, nodes[5], nodes[7]);
        streets[14] = new Streets(fakeStreet.address().streetName(), 1, nodes[8], nodes[3]);
        streets[15] = new Streets(fakeStreet.address().streetName(), 2, nodes[2], nodes[4]);

        List<Streets> streetsList = new LinkedList<>();

        for (Streets street : streets) {
            streetsList.add(street);
        }

        Collections.sort(streetsList, Streets::sortedStreets);

        Map<Intersection, List<Streets>> map = new HashMap<>();

        for (var intersection :nodes){
            List<Streets> sortedStreetsList = new ArrayList<>();
            for (Streets street : streets) {
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
                .toArray(Streets[]::new);

        System.out.println(Arrays.toString(result));

        TownHall townHall = new TownHall(Arrays.asList(nodes), streetsList);

        System.out.println(townHall);
        townHall.setCamera();


    }
}
