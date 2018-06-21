package simulation.aircraft;

import simulation.aircraft.*;
import simulation.weather.*;
 
public class JetPlane extends Aircraft implements Flyable
{
    //private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) 
    {
        super(name, coordinates);
        System.out.println("new jet: " + name);
    }

    public void updateConditions() 
    {
        
    }

    public void registerTower(WeatherTower weatherTower) 
    {
        weatherTower.register(this);
    }
}