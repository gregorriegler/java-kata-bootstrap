import java.util.stream.Collectors;

import static java.util.stream.IntStream.rangeClosed;

public class FizzBuzz {
    public String run() {
        final String newline = "-";
        final int upperLimit = 20;
        return rangeClosed(1, upperLimit)
            .mapToObj(this::turn)
            .collect(Collectors.joining(newline, "", newline));
    }

    private String turn(int number) {
        if (number % 3 == 0) {
            return "Fizz";
        } 
        if (number % 5 == 0) {
            return "Buzz";
        } 

        return Integer.toString(number);
    }
}
