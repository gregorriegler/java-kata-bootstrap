package weatherreporter.application;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class WeatherReporterTest {

    @Test
    public void exports_fed_weather() {
        WeatherData expectedWeather = new WeatherData();
        WeatherExporterSpy exporterSpy = new WeatherExporterSpy();
        WeatherReporter weatherReporter = new WeatherReporter(() -> expectedWeather, exporterSpy);

        weatherReporter.reportNow();

        assertThat(exporterSpy.lastExported).isEqualTo(expectedWeather);
    }

    private static class WeatherExporterSpy implements WeatherExporter {
        public WeatherData lastExported;

        @Override
        public void export(WeatherData weatherData) {
            lastExported = weatherData;
        }
    }
}
