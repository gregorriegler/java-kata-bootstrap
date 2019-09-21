import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.stream.IntStream;

import static org.mockito.Mockito.verify;

class HelloWorldTest {

    private Broadcaster broadcaster;
    private Cell cell;

    @BeforeEach
    void setUp() {
        broadcaster = Mockito.mock(Broadcaster.class);
    }

    @Test
    void
    cellPublishesInitialState() {
        givenADeadCell();
        cell.onEvent(new NewGenerationEvent());
        verify(broadcaster).broadcast(new LifeStateEvent(false));
    }

    @Test
    void deadCell_withFourLivingNeighbours_becomesAlive() {
        givenADeadCell();
        whenNeighborsReportedAlive(4);
        thenCellShouldReportAliveInNextGeneration();
    }

    @Test
    void livingCell_withOneLivingNeighbor_dies() {
        givenALivingCell();
        whenNeighborsReportedAlive(1);
        thenCellShouldReportDeathInNextGeneration();
    }

    private void givenALivingCell() {
        cell = new Cell(broadcaster, true);
    }

    private void givenADeadCell() {
        cell = new Cell(broadcaster, false);
    }

    private void whenNeighborsReportedAlive(int count) {
        IntStream.range(0, count)
            .forEach(i -> cell.onEvent(new LifeStateEvent(true)));
    }

    private void thenCellShouldReportAliveInNextGeneration() {
        cell.onEvent(new NewGenerationEvent());
        verify(broadcaster).broadcast(new LifeStateEvent(true));
    }

    private void thenCellShouldReportDeathInNextGeneration() {
        cell.onEvent(new NewGenerationEvent());
        verify(broadcaster).broadcast(new LifeStateEvent(false));
    }

}

