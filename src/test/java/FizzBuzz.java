import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.rangeClosed;

public class FizzBuzz {
    public String run() {
        var sb = new StringBuilder();
        String collected = rangeClosed(1, 20).mapToObj(i -> {
            String s = singleElement(i);
            sb.append(s);
            sb.append("-");
            return s;
        }).collect(Collectors.joining("-", "", "-"));
        return collected;
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
