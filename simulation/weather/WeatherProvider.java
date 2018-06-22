package simulation.weather;

import java.util.*;

import simulation.aircraft.*;
import simulation.weather.*;

public class WeatherProvider
{
    private static WeatherProvider weatherProvider = null;
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
    
    private WeatherProvider(){}

    public static WeatherProvider getProvider() 
    {
        if (weatherProvider == null)
            weatherProvider = new WeatherProvider();
        return (weatherProvider);    
    }

    public String getCurrentWeather(Coordinates coordinates) 
    {
        Random randWeather = new Random();

        int nWeather = 0; 
        nWeather = randWeather.nextInt(4);
        return (weather[nWeather]);
    }
}