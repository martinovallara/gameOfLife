public class GameOfLife {


    private Cell cell;

    public GameOfLife(Cell cell) {
        this.cell = cell;
    }

    public boolean next() {
        return cell.neighbourTwoOrTree();
    }
}
