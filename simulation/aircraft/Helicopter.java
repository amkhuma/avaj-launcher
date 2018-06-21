package simulation.aircraft;

import simulation.aircraft.*;
import simulation.weather.*;

public class Helicopter extends Aircraft implements Flyable
{
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) 
    {
        super(name, coordinates);
        System.out.println("new heli: " + name);
    }

    /*public void updateConditions() 
    {
        String weather = weatherTower.getWeather();
        System.out.println(weather);
    }*/

    public void registerTower(WeatherTower weatherTower) 
    {
        weatherTower.register(this);
    }
}