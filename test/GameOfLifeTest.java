import com.geamOfLife.Cell;
import org.junit.Test;

import static com.geamOfLife.Cell.DEAD;
import static com.geamOfLife.Cell.LIVE;
import static org.assertj.core.api.Assertions.assertThat;

public class GameOfLifeTest {


    //   1. Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
    //   2. Any live cell with more than three live neighbours dies, as if by overcrowding.
    //   3. Any live cell with two or three live neighbours lives on to the next generation.
    //   4. Any dead cell with exactly three live neighbours becomes a live cell.


    @Test
    public void cellDiesWhenNeighboursFewerTwo() {
        Cell cell = new Cell(LIVE);
        cell.addNeighbours(LIVE, DEAD);

        assertThat(cell.next()).isEqualTo(DEAD);
    }

    @Test
    public void cellDiesWhenNeighboursMoreTree() {
        Cell cell = new Cell(LIVE);

        cell.addNeighbours(LIVE, LIVE, LIVE, LIVE);

        assertThat(cell.next()).isEqualTo(DEAD);
    }

    @Test
    public void cellLiveWhenNeighboursTwoOrThree() {
        Cell cell = new Cell(LIVE);

        cell.addNeighbours(LIVE, DEAD, LIVE);

        assertThat(cell.next()).isEqualTo(LIVE);

        cell.addNeighbours(LIVE, LIVE, LIVE);
        assertThat(cell.next()).isEqualTo(LIVE);
    }


    @Test
    public void cellLDiedWillLiveWhenNeighboursThree() {
        Cell cell = new Cell(DEAD);

        cell.addNeighbours(LIVE, LIVE, LIVE);

        assertThat(cell.next()).isEqualTo(LIVE);
    }

    @Test
    public void cellLDiedRemainsDeadWhenNeighboursTwo() {
        Cell cell = new Cell(DEAD);

        cell.addNeighbours(LIVE, DEAD, LIVE);

        assertThat(cell.next()).isEqualTo(DEAD);

    }
}
