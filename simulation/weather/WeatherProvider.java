package simulation.weather;

import java.util.*;

import simulation.aircraft.*;
import simulation.weather.*;

public class WeatherProvider
{
    private WeatherProvider weatherProvider = null;
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
    
    private WeatherProvider(){}

    public WeatherProvider getProvider() 
    {
        weatherProvider = new WeatherProvider();
        return (weatherProvider);    
    }

    public String getCurrentWeather() 
    {
        Random randWeather = new Random();

        int nWeather = randWeather.nextInt(4);
        //System.out.println(weather[nWeather]);
        return (weather[nWeather]);
    }
}