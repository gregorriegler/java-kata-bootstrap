package weatherreporter.infrastructure;

import weatherreporter.application.WeatherData;
import weatherreporter.application.WeatherFeed;

public class WebApiWeatherFeed implements WeatherFeed {
    
    @Override
    public WeatherData read() {
        // read http+json api, parse the data and return it 
        return new WeatherData();
    }
}
