package weatherreporter.application;

@FunctionalInterface
public interface WeatherFeed {
    WeatherData read();
}
