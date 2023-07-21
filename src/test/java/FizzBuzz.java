public class FizzBuzz {
    public String run() {
        var sb = new StringBuilder();
        for (var i = 1; i <= 20; i++) {
            sb.append(i + "-");
        }
        return sb.toString();
    }
}
