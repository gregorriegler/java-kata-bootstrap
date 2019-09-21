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
    void inflictDamageOnTargetDecreasesItsHealth() {
        var target = defaultCharacter();
        var attacker = defaultCharacter();

        target.damage(attacker, 100);

        assertIsAlive(target, 900);
    }

    @Test
    void inflictDamageOnTarget5LevelsHigherDecreasesItsHealthBy50Percent() {
        var target = aCharacter(6);
        var attacker = defaultCharacter();

        target.damage(attacker, 100);

        assertIsAlive(target, 950);
    }

    @Test
    void inflictedDamageGreaterThanHealthKillsTarget() {
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

    private RpgCharacter aCharacter(int level) {
        return new RpgCharacter(level);
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

