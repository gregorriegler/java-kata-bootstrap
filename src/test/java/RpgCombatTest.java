import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RpgCombatTest {

    @Test
    void healCharacterByAmountIncreasesItsHealth() {
        RpgCharacter character = new RpgCharacter();

        character.heal(10);
        assertThat(character.getHealth()).isEqualTo(1010);

        character.heal(20);
        assertThat(character.getHealth()).isEqualTo(1030);
    }


    @Test
    void inflictDamageOnCharacterDecreasesItsHealth() {
        RpgCharacter character = new RpgCharacter();

        character.damage(100);
        assertThat(character.getHealth()).isEqualTo(900);
    }

    @Test
    void inflictedDamageGreaterThanHealth_killsCharacter() {
        RpgCharacter character = new RpgCharacter();

        character.damage(1001);
        assertThat(character.getHealth()).isEqualTo(0);
        assertThat(character.isAlive()).isFalse();
    }
}
class RpgCharacter {
    private int health = 1000;
    private boolean alive = false;

    public void heal(int amount) {
        this.health += amount;
    }

    public int getHealth() {
        return health;
    }

    public void damage(int damage) {
        this.health -= damage;
    }

    public boolean isAlive() {
        return alive;
    }

}

