import java.util.Objects;

public class Street {

    public String name;
    public int length;
    private Intersection i1;
    private Intersection i2;

    public Street(String name, int length, Intersection i1, Intersection i2) {
        this.name = name;
        this.length = length;
        this.i1 = i1;
        this.i2 = i2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Intersection getI1() {
        return i1;
    }

    public void setI1(Intersection i1) {
        this.i1 = i1;
    }

    public Intersection getI2() {
        return i2;
    }

    public void setI2(Intersection i2) {
        this.i2 = i2;
    }

    public static int sortedStreets(Object o1, Object o2) {
        if(!(o1 instanceof Street) || !(o2 instanceof Street) )
            throw new ClassCastException ("Uncomparable");

        Street s1 = (Street) o1;
        Street s2 = (Street) o2;

        return Integer.compare(s1.getLength(), s2.getLength());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Street streets = (Street) o;
        return length == streets.length && Objects.equals(name, streets.name) && Objects.equals(i1, streets.i1) && Objects.equals(i2, streets.i2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, length, i1, i2);
    }

    @Override
    public String toString() {
        return "Streets{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", i1=" + i1 +
                ", i2=" + i2 +
                '}';
    }
}
