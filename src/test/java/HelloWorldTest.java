import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Objects;

import static org.mockito.Mockito.verify;

public class HelloWorldTest {

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
        for (int i = 0; i < count; i++) {
            cell.onEvent(new LifeStateEvent(true));
        }
    }

    private void thenCellShouldReportAliveInNextGeneration() {
        cell.onEvent(new NewGenerationEvent());
        verify(broadcaster).broadcast(new LifeStateEvent(true));
    }

    private void thenCellShouldReportDeathInNextGeneration() {
        cell.onEvent(new NewGenerationEvent());
        verify(broadcaster).broadcast(new LifeStateEvent(false));
    }
    private interface Broadcaster {
        void broadcast(Event event);
    }

    private interface Event {
        void dispatch(EventHandler handler);
    }

    private interface EventHandler {
        void handle(LifeStateEvent event);

        void handle(NewGenerationEvent event);
    }

    private class LifeStateEvent implements Event {
        private final boolean isAlive;

        public LifeStateEvent(boolean isAlive) {
            this.isAlive = isAlive;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            LifeStateEvent that = (LifeStateEvent) o;
            return isAlive == that.isAlive;
        }

        @Override
        public int hashCode() {
            return Objects.hash(isAlive);
        }

        @Override
        public String toString() {
            return "LifeStateEvent{" +
                "isAlive=" + isAlive +
                '}';
        }

        @Override
        public void dispatch(EventHandler handler) {
            handler.handle(this);
        }
    }

    private class Cell implements EventHandler {
        private final Broadcaster broadcaster;
        private int livingNeighbors;

        public Cell(Broadcaster broadcaster, boolean isAlive) {
            this.broadcaster = broadcaster;
        }


        public void onEvent(Event event) {
            event.dispatch(this);
        }

        @Override
        public void handle(LifeStateEvent event) {
            livingNeighbors++;
        }

        @Override
        public void handle(NewGenerationEvent event) {
            boolean shouldBeAlive = livingNeighbors == 4;
            broadcaster.broadcast(new LifeStateEvent(shouldBeAlive));
        }
    }

    private class NewGenerationEvent implements Event {
        @Override
        public void dispatch(EventHandler handler) {
            handler.handle(this);
        }
    }
}

interface Hello {
    void world();
}
