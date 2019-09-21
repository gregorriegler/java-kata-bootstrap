import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GolTest {

    @Test
    @DisplayName("Eine tote Zelle mit genau drei lebenden Nachbarn wird in der Folgegeneration neu geboren")
    void deadCellWithThreeNeighboursBecomesAlive() {
        var result = something(Cell.DEAD, 3);
        assertThat(result).isEqualTo(Cell.ALIVE);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void deadCellWithTooFewNeighboursStaysDead(int numberOfNeighbours) {
        var result = something(Cell.DEAD, 2);
        assertThat(result).isEqualTo(Cell.DEAD);
    }

    // test for > 3 is the same, skipped

    @Test
    void livingCellWithTwoNeighboursStaysAlive() {
        var result = something(Cell.ALIVE, 2);
        assertThat(result).isEqualTo(Cell.ALIVE);
    }

    private Cell something(Cell cell, int neighbours) {
        return cell.withLivingNeighbours(neighbours).nextGeneration();
    }

    private enum Cell {
        DEAD {
            @Override
            public RulesOfDeadCells withLivingNeighbours(int neighbours) {
                return RulesOfDeadCells.with(neighbours);
            }
        },
        ALIVE {
            @Override
            public RulesOfDeadCells withLivingNeighbours(int neighbours) {
                return RulesOfDeadCells.with(neighbours);
            }
        };

        public abstract RulesOfDeadCells withLivingNeighbours(int neighbours);
    }

    private enum RulesOfDeadCells {
        THREE_ALIVE_NEIGHBOURS {
            @Override
            public Cell nextGeneration() {
                return Cell.ALIVE;
            }
        },
        FEW_ALIVE_NEIGHBOURS {
            @Override
            public Cell nextGeneration() {
                return Cell.DEAD;
            }
        };

        private static final Map<Integer, RulesOfDeadCells> rules = Map.of(0, FEW_ALIVE_NEIGHBOURS, //
            1, FEW_ALIVE_NEIGHBOURS, //
            2, FEW_ALIVE_NEIGHBOURS, //
            3, THREE_ALIVE_NEIGHBOURS);

        public static RulesOfDeadCells with(int numberOfAliveNeighbours) {
            return rules.get(numberOfAliveNeighbours);
        }

        public abstract Cell nextGeneration();
    }
}

