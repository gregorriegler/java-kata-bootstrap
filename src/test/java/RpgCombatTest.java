import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RpgCombatTest {


    @Test
    void healCharacterByAmountIncreasesItsHealth() {
        var target = defaultCharacter();
        var attacker = defaultCharacter();
        target.damage(attacker, 100);

        target.heal(10);

        assertIsAlive(target, 910);
    }

    @Test
    void healCharacterByAmountMaxesOutAt1000Health() {
        var character = defaultCharacter();

        character.heal(10);

        assertIsAlive(character, 1000);
    }

    @Test
    void inflictDamageOnCharacterDecreasesItsHealth() {
        var target = defaultCharacter();
        var attacker = defaultCharacter();

        target.damage(attacker, 100);

        assertIsAlive(target, 900);
    }

    @Test
    void inflictedDamageGreaterThanHealthKillsCharacter() {
        var target = defaultCharacter();
        var attacker = defaultCharacter();

        target.damage(attacker, 1001);

        assertIsDead(target);
    }

    @Test
    void attackerCannotInflictDamageOnHimself() {
        var attacker = defaultCharacter();

        attacker.damage(attacker, 100);

        assertIsAlive(attacker, 1000);
    }

    private RpgCharacter defaultCharacter() {
        return new RpgCharacter(1);
    }

    private void assertIsAlive(RpgCharacter character, int expectedHealth) {
        assertThat(character.getHealth()).isEqualTo(expectedHealth);
        assertThat(character.isAlive()).isTrue();
    }

    private void assertIsDead(RpgCharacter character) {
        assertThat(character.getHealth()).isEqualTo(0);
        assertThat(character.isAlive()).isFalse();
    }

}

class RpgCharacter {
    private final int level;
    private int health = 1000;
    private boolean alive = true;

    public RpgCharacter(int level) {
        this.level = level;
    }

    public void heal(int amount) {
        this.health = Math.min(1000, this.health + amount);
    }

    public int getHealth() {
        return health;
    }

    public void damage(RpgCharacter attacker, int damage) {
        if (this == attacker) {
            return;
        }

        this.health -= damage;
        if(this.health < 0) {
            this.health = 0;
            this.alive = false;
        }
    }

    public boolean isAlive() {
        return alive;
    }
}

