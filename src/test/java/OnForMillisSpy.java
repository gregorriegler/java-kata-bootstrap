public class OnForMillisSpy implements OnForMillis {

    public String recentCommand;

    @Override
    public void turnOnForMillis(long millis) {
        recentCommand = "turn on for " + millis + "ms";
    }
}
