package models;

public class City {
    private int id;
    private String country;
    private String name;
    private boolean capital;
    private double latitude;
    private double longitude;

    public City(String country, String name, boolean capital, double latitude, double longitude) {
        this.country = country;
        this.name = name;
        this.capital = capital;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    public double getDistanceTo(City destination) {
        double myLatitudeInRadians = Math.toRadians(this.latitude);
        double myLongitudeInRadians = Math.toRadians(this.longitude);
        double destinationLatitudeInRadians = Math.toRadians(destination.getLatitude());
        double destinationLongitudeInRadians = Math.toRadians(destination.getLongitude());

        double distanceLatitude = destinationLatitudeInRadians - myLatitudeInRadians;
        double distanceLongitude = destinationLongitudeInRadians - myLongitudeInRadians;

        double haversineFormula = Math.pow(Math.sin(distanceLatitude / 2), 2) + Math.cos(myLatitudeInRadians) * Math.cos(destinationLatitudeInRadians) * Math.pow(Math.sin(distanceLongitude / 2),2);

        double haversineFormulaSqrt = 2 * Math.asin(Math.sqrt(haversineFormula));

        double radiusOdEarthInKilometers = 6371;

        return haversineFormulaSqrt * radiusOdEarthInKilometers;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCapital() {
        return capital;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "City{" +
                "country='" + country + '\'' +
                ", name='" + name + '\'' +
                ", capital=" + capital +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
