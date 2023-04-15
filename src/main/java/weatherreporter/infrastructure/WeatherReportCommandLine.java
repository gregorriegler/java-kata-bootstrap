package weatherreporter.infrastructure;

import weatherreporter.application.WeatherReporter;

public class WeatherReportCommandLine {
    private final String[] args;
    private final WeatherReporter weatherReporter;

    public WeatherReportCommandLine(String[] args, WeatherReporter weatherReporter) {
        this.args = args;
        this.weatherReporter = weatherReporter;
    }
    
    public void execute() {
        // parse args and behave according to it
        weatherReporter.reportNow();
    }
}
