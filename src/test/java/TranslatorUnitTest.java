public class TranslatorUnitTest extends TranslatorTest {

    @Override
    protected Translator createTranslator() {
        return new FakeTranslator();
    }
}

class FakeTranslator implements Translator {

    @Override
    public String translate(String text) {
        return "Hello";
    }
}
