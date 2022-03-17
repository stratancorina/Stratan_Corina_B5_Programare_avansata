import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        var nodes = IntStream.rangeClosed(1,9)
                .mapToObj(i -> new Intersection("v" + i))
                .toArray(Intersection[]::new);

        List<Intersection> nodeList = new ArrayList<>();
        nodeList.addAll( Arrays.asList(nodes) );

        System.out.println(nodeList);

        List<Intersection> newSortedList = nodeList.stream()
                .sorted(Comparator.comparing(Intersection::getName))
                .collect(Collectors.toList());

        System.out.println(newSortedList);

        List<Streets> streetsList = new LinkedList<>();

        streetsList.add(new Streets("s1",2));
        streetsList.add(new Streets("s2",2));
        streetsList.add(new Streets("s3",2));
        streetsList.add(new Streets("s4",3));
        streetsList.add(new Streets("s5",2));
        streetsList.add(new Streets("s6",2));
        streetsList.add(new Streets("s7",3));
        streetsList.add(new Streets("s8",1));
        streetsList.add(new Streets("s9",2));
        streetsList.add(new Streets("s10",1));
        streetsList.add(new Streets("s11",1));
        streetsList.add(new Streets("s12",1));
        streetsList.add(new Streets("s13",3));
        streetsList.add(new Streets("s14",1));
        streetsList.add(new Streets("s15",2));

        List<Streets> sortedStreetsList = streetsList.stream()
                .sorted(Comparator.comparingInt(Streets::getLength)).toList();
        sortedStreetsList.forEach(streets -> System.out.println(streets.name));

//        Streets[] streets = new Streets[15];
//        streets[0] = new Streets("s1", 2);
//        streets[1] = new Streets("s2", 2);
//        streets[2] = new Streets("s3", 2);
//        streets[3] = new Streets("s4", 3);
//        streets[4] = new Streets("s5", 2);
//        streets[5] = new Streets("s6", 2);
//        streets[6] = new Streets("s7", 3);
//        streets[7] = new Streets("s8", 1);
//        streets[8] = new Streets("s9", 2);
//        streets[9] = new Streets("s10", 1);
//        streets[10] = new Streets("s11", 1);
//        streets[11] = new Streets("s12", 1);
//        streets[12] = new Streets("s13", 3);
//        streets[13] = new Streets("s14", 1);
//        streets[14] = new Streets("s15", 2);

        Map<Intersection, List<Streets>> cityMap = new HashMap<>();
 //       cityMap.put((Intersection) newSortedList, Arrays.asList(streets[0], streets[1], streets[2], streets[3], streets[4]));

        System.out.println(cityMap);
    }
}
