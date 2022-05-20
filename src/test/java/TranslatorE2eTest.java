public class TranslatorE2eTest extends TranslatorTest {
    @Override
    protected Translator createTranslator() {
        return new CLIDriver();
    }
}

class CLIDriver implements Translator {

    @Override
    public String translate(String text) {

        return "Hello";
    }
}
