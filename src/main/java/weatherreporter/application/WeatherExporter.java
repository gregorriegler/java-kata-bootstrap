package weatherreporter.application;

@FunctionalInterface
public interface WeatherExporter {
    void export(WeatherData weatherData);
}
