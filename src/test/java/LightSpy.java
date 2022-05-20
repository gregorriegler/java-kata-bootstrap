public class LightSpy implements Switchable {

    public String recentCommand;

    @Override
    public void turnOnForMillis(long millis) {
        recentCommand = "turn on for " + millis + "ms";
    }
}
