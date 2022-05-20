import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class TranslatorTest {
    protected abstract Translator createTranslator();

    /**
     * translator bekommt ein text, übersetzt den text ins englische
     *
     * testcase, high level, wiederverwenden als unit-test und e2e-test
     *
     * CLI
     * $ translate Hallo
     * > Hello
     *
     *
     * Given I have a text Hallo
     *
     * When I translate Hallo
     *
     * I receive Hello
     */
    @Test
    void testTranslate() {
        Translator translator = createTranslator();

        String result = translator.translate("Hallo");

        assertThat(result).isEqualTo("Hello");
    }
}
