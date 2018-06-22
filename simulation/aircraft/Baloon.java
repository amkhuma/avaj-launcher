package simulation.aircraft;

import simulation.aircraft.*;
import simulation.weather.*;

public class Baloon extends Aircraft implements Flyable
{
    private WeatherTower NweatherTower;

    Baloon(String name, Coordinates coordinates) 
    {
        super(name, coordinates);
    }

    public void updateConditions() 
    {
        String weather = this.NweatherTower.getWeather(this.coordinates);
        System.out.println(weather);
    }

    public void registerTower(WeatherTower weatherTower) 
    {
        System.out.println("Tower says: " + "Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        this.NweatherTower = weatherTower;
        weatherTower.register(this);
    }
}