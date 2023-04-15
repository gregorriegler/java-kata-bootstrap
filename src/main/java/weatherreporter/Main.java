package weatherreporter;

import weatherreporter.application.WeatherExporter;
import weatherreporter.application.WeatherFeed;
import weatherreporter.application.WeatherReporter;
import weatherreporter.infrastructure.WeatherReportCommandLine;
import weatherreporter.infrastructure.CsvFileWeatherExporter;
import weatherreporter.infrastructure.WebApiWeatherFeed;

public class Main {
    public static void main(String[] args) {
        WeatherExporter weatherExporter = new CsvFileWeatherExporter(); // Secondary Port/Adapter
        WeatherFeed weatherFeed = new WebApiWeatherFeed(); // Secondary Port/Adapter
        WeatherReporter weatherReporter = new WeatherReporter(weatherFeed, weatherExporter); // The Application
        WeatherReportCommandLine commandLine = new WeatherReportCommandLine(args, weatherReporter); // Primary Adapter
        commandLine.execute(); 
    }
}
