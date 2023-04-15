package weatherreporter.infrastructure;

import weatherreporter.application.WeatherData;
import weatherreporter.application.WeatherExporter;

public class CsvFileWeatherExporter implements WeatherExporter {
    @Override
    public void export(WeatherData weatherData) {
        // write weatherData to CSV File
    }
}
