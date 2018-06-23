package simulation.aircraft;

import simulation.aircraft.*;
import simulation.weather.*;
import simulation.writer.*;

public class Helicopter extends Aircraft implements Flyable
{
    private WeatherTower NweatherTower;

    Helicopter(String name, Coordinates coordinates) 
    {
        super(name, coordinates);
    }

    public void updateConditions() 
    {
        int copyHeight = this.coordinates.getHeight();
        int copyLong = this.coordinates.getLongitude(); 
        int copyLat = this.coordinates.getLatitude();
        String weather = this.NweatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "RAIN":
                this.coordinates = new Coordinates(copyLong + 5, copyLat, copyHeight);
                WriteToFile.getFile().writetofile("Helicopter#" + this.name + "(" + this.id + "): its rainy");
                break;
            case "SNOW":
                this.coordinates = new Coordinates(copyLong, copyLat, copyHeight - 12);
                WriteToFile.getFile().writetofile("Helicopter#" + this.name + "(" + this.id + "): its snowy");
                break;
            case "FOG":
                this.coordinates = new Coordinates(copyLong + 1, copyLat, copyHeight);
                WriteToFile.getFile().writetofile("Helicopter#" + this.name + "(" + this.id + "): its foggy");
                break;
            case "SUN":
                this.coordinates = new Coordinates(copyLong + 10, copyLat, copyHeight + 2);
                WriteToFile.getFile().writetofile("Helicopter#" + this.name + "(" + this.id + "): its sunny");
                break;            
            default:
                WriteToFile.getFile().writetofile("unknown weather: ");
                break;
        }
        //WriteToFile.getFile().writetofile("long: " + copyLong + " lat: " + copyLat + " height: " + copyHeight);
        if (this.coordinates.getHeight() <= 0)
        {
            unregisterTower(this.NweatherTower);            
        }
    }

    public void registerTower(WeatherTower weatherTower) 
    {
        WriteToFile.getFile().writetofile("Tower says: " + "Helicopter#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        this.NweatherTower = weatherTower;
        weatherTower.register(this);
    }

    public void unregisterTower(WeatherTower weatherTower) 
    {
        WriteToFile.getFile().writetofile("Tower says: " + "Helicopter#" + this.name + "(" + this.id + ")" + " unregisteres from weather tower.");
        this.NweatherTower = weatherTower;
        weatherTower.unregister(this);
    }
}