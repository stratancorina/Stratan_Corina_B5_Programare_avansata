package game.components;

import java.util.Objects;

public class Tile {
    private char character;
    private int points;

    private Tile(char character, int points){
        this.character = character;
        this.points = points;
    }

    private Tile(){
        this('a', 0);
    }

    public static Tile makeTile(char character, int points)
    {
        Tile tile = new Tile();
        tile.setCharacter(character);
        tile.setPoints(points);

        return tile;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        if(points < 0) throw new IllegalArgumentException("can't have negative points for a tile");
        this.points = points;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        if(character < 'a' || character > 'z') throw new IllegalArgumentException("character must be a small letter between a and z");
        this.character = character;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return character == tile.character;
    }

    @Override
    public int hashCode() {
        return Objects.hash(character);
    }
}
