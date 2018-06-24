package launcher.aircraft;

import launcher.aircraft.*;
import launcher.weather.*;
import launcher.writer.*;

public class Baloon extends Aircraft implements Flyable
{
    private WeatherTower NweatherTower;

    Baloon(String name, Coordinates coordinates) 
    {
        super(name, coordinates);
    }

    public void updateConditions() 
    {
        int copyHeight = this.coordinates.getHeight();
        int copyLong = this.coordinates.getLongitude(); 
        int copyLat = this.coordinates.getLatitude();
        String weather = this.NweatherTower.getWeather(this.coordinates);
        switch (weather) 
        {
            case "RAIN":
                this.coordinates = new Coordinates(copyLong, copyLat, copyHeight - 5);
                writr.writetofile("Baloon#" + this.name + "(" + this.id + "): Ahhh, it has been long since I had a good wash, pour on me thou Rain!");
                break;
            case "SNOW":
                this.coordinates = new Coordinates(copyLong, copyLat, copyHeight - 15);
                writr.writetofile("Baloon#" + this.name + "(" + this.id + "): Oh my fucken God can it stop snowing already!");
                break;
            case "FOG":
                this.coordinates = new Coordinates(copyLong, copyLat, copyHeight - 3);
                writr.writetofile("Baloon#" + this.name + "(" + this.id + "): I can't see, I can't see..Oh my a Crash is coming! Damn you Fog.");
                break;
            case "SUN":
                this.coordinates = new Coordinates(copyLong + 2, copyLat, copyHeight + 4);
                writr.writetofile("Baloon#" + this.name + "(" + this.id + "): Finally some Sun, Ulra violets bouncing on me. :)");
                break;            
            default:
            writr.writetofile("unknown weather: ");
                break;
        }
        if (this.coordinates.getHeight() <= 0)
        {
            unregisterTower(this.NweatherTower);            
        }
    }

    public void registerTower(WeatherTower weatherTower) 
    {
        writr.writetofile("Tower says: " + "Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        this.NweatherTower = weatherTower;
        weatherTower.register(this);
    }

    public void unregisterTower(WeatherTower weatherTower) 
    {
        writr.writetofile("Tower says: " + "Baloon#" + this.name + "(" + this.id + ")" + " unregisteres from weather tower and lands.");
        this.NweatherTower = weatherTower;
        weatherTower.unregister(this);
    }
}