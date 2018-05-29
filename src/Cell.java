import java.util.stream.Stream;

public class Cell {
    private Boolean[] neighbours;

    public boolean neighbourTwoOrTree() {
        Stream<Boolean> stream = Stream.of(this.neighbours);
        long count = stream.filter(n -> n.equals(true)).count();
        return (2 <= count && count <= 3);
    }

    public void addNeighbours(Boolean... neighbours) {
        this.neighbours = neighbours;
    }

    public boolean next() {
        return neighbourTwoOrTree();
    }
}
