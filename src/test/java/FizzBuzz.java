import java.util.stream.Collectors;

import static java.util.stream.IntStream.rangeClosed;

public class FizzBuzz {
    public String run() {
        final String newline = "-";
        return rangeClosed(1, 20)
            .mapToObj(this::singleElement)
            .collect(Collectors.joining(newline, "", newline));
    }

    private String singleElement(int i) {
        String s;
        if (i % 3 == 0) {
            s = "Fizz";
        } else {
            s = Integer.toString(i);
        }
        return s;
    }
}
