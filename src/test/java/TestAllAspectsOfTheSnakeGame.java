import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// each identifier has to be 20 characters long
// each line has to be less than 80 characters
// thisis20charactersss
public class TestAllAspectsOfTheSnakeGame {

    @Test
    void a_snake_starts_at_a_particular_location() {
        OriginalGrowingSnake systemUnderTestSnake;
        systemUnderTestSnake = new OriginalGrowingSnake();

        LocationOnTheGameBoard actualLocationOnBoard;
        actualLocationOnBoard = systemUnderTestSnake.getLocationOnTheBoard();

        LocationOnTheGameBoard expectedLocationOnBoard;
        expectedLocationOnBoard = new LocationOnTheGameBoard();

        assertThat(actualLocationOnBoard).isEqualTo(expectedLocationOnBoard);
    }

}

class LocationOnTheGameBoard {

    public LocationOnTheGameBoard() {

    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass().equals(LocationOnTheGameBoard.class);
    }
}


class OriginalGrowingSnake {
    public LocationOnTheGameBoard getLocationOnTheBoard() {
        return new LocationOnTheGameBoard();
    }
}