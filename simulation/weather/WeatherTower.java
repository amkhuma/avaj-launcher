package simulation.weather;

import simulation.aircraft.*;
import simulation.weather.*;

public class WeatherTower extends Tower
{
    public String getWeather(Coordinates coordinates) 
    {
        String weather = WeatherProvider.getProvider().getCurrentWeather(coordinates);
        return weather;
    }

    protected void changeWeather() 
    {
        this.conditionsChanged();     
    }
}