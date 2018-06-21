package simulation.aircraft;

import simulation.aircraft.*;
import simulation.weather.*;

public class Baloon extends Aircraft implements Flyable
{
    //private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) 
    {
        super(name, coordinates);
        System.out.println("new baloon: " + name);
    }

    public void updateConditions() 
    {
        
    }

    public void registerTower(WeatherTower weatherTower) 
    {
        weatherTower.register(this);
    }
}