package Condition;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WeatherDataTest {
    private WeatherData weatherData;

    @Before
    public void setUp() {
        weatherData = new WeatherData();
    }

    @Test
    public void registerObserverTest() {
        Observer observer = new CurrentConditionsDisplay(weatherData);
        assertEquals(1, weatherData.getObservers().size());
    }

    @Test
    public void removeObserverTest() {
        Observer observer = new CurrentConditionsDisplay(weatherData);
        weatherData.removeObserver(observer);
        assertEquals(0, weatherData.getObservers().size());
    }

    @Test
    public void notifyObserversTest() {
        CurrentConditionsDisplay display = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(80, 65, 30.4f);
        assertEquals(80, display.getTemperature(), 0.01);
        assertEquals(65, display.getHumidity(), 0.01);
    }

    @Test
    public void toStringTest() {
        String expected = "WeatherData{}";
        assertEquals(expected, weatherData.toString());
    }
}
