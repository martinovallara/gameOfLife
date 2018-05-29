import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameOfLifeTest {


    //   1. Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
    //   2. Any live cell with more than three live neighbours dies, as if by overcrowding.
    //   3. Any live cell with two or three live neighbours lives on to the next generation.
    //   4. Any dead cell with exactly three live neighbours becomes a live cell.

    static boolean LIVE = true;
    static boolean DEAD = false;

    @Test
    public void cellDiesWhenNeighboursFewerTwo() {
        Cell cell = new Cell();
        cell.addNeighbours(LIVE, DEAD);

        assertThat(cell.next()).isEqualTo(DEAD);
    }

    @Test
    public void cellDiesWhenNeighboursMoreTree() {
        Cell cell = new Cell();

        cell.addNeighbours(LIVE, LIVE, LIVE, LIVE);

        assertThat(cell.next()).isEqualTo(DEAD);
    }

    @Test
    public void cellLiveWhenNeighboursTwoOrThree() {
        Cell cell = new Cell();

        cell.addNeighbours(LIVE, DEAD, LIVE);

        assertThat(cell.next()).isEqualTo(LIVE);
    }
}
