package simulation.aircraft;

import javax.lang.model.util.ElementScanner6;

import simulation.aircraft.*;
import simulation.weather.*;

public class Helicopter extends Aircraft implements Flyable
{
    private WeatherTower NweatherTower;

    Helicopter(String name, Coordinates coordinates) 
    {
        super(name, coordinates);
    }

    public void updateConditions() 
    {
        String weather = this.NweatherTower.getWeather(this.coordinates);
        if (weather == "RAIN")
        {
            System.out.println("HELICOPTER SAYS: its rainy");
        }
        else if (weather == "SNOW")
        {
            System.out.println("HELICOPTER SAYS: its snowy");
        }
        else if (weather == "FOG")
        {
            System.out.println("HELICOPTER SAYS: its foggy");
        }
        else if (weather == "SUN")
        {
            System.out.println("HELICOPTER SAYS: its sunny");
        }
        else
            System.out.println("unknown weather: ");
    }

    public void registerTower(WeatherTower weatherTower) 
    {
        System.out.println("Tower says: " + "Helicopter#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        this.NweatherTower = weatherTower;
        weatherTower.register(this);
    }
}