import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RpgCombatTest {

    @Test
    void healCharacterBy10increasesItsHealth() {
        RpgCharacter character = new RpgCharacter();

        character.heal(10);

        assertThat(character.getHealth()).isEqualTo(1010);
    }

}
class RpgCharacter {
    public void heal(int amount) {

    }

    public int getHealth() {
        return 1010;
    }
}

