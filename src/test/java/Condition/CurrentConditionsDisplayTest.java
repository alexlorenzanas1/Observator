package Condition;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CurrentConditionsDisplayTest {
    private WeatherData weatherData;
    private CurrentConditionsDisplay display;

    @Before
    public void setUp() {
        weatherData = new WeatherData();
        display = new CurrentConditionsDisplay(weatherData);
    }

    @Test
    public void updateTest() {
        display.update(80, 65, 30.4f);
        assertEquals(80, display.getTemperature(), 0.01);
        assertEquals(65, display.getHumidity(), 0.01);
    }

    @Test
    public void displayTest() {
        display.update(80, 65, 30.4f);
        display.display();
    }

    @Test
    public void toStringTest() {
        String expected = "CurrentConditionsDisplay{}";
        assertEquals(expected, display.toString());
    }
}
