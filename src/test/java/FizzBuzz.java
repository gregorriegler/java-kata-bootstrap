public class FizzBuzz {
    public String run() {
        var sb = new StringBuilder();
        for (var i = 1; i <= 20; i++) {
            if (i%3 == 0) {
                sb.append("Fizz");
            } else {
                sb.append(i);
            }
            sb.append("-");
        }
        return sb.toString();
    }
}
