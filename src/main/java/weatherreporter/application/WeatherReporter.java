package weatherreporter.application;

public class WeatherReporter {
    private final WeatherFeed weatherFeed;
    private final WeatherExporter weatherExporter;

    public WeatherReporter(WeatherFeed weatherFeed, WeatherExporter weatherExporter) {
        this.weatherFeed = weatherFeed;
        this.weatherExporter = weatherExporter;
    }

    public void reportNow() {
        WeatherData weatherData = weatherFeed.read();
        weatherExporter.export(weatherData);
    }
}
