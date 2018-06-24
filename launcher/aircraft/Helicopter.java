package launcher.aircraft;

import launcher.aircraft.*;
import launcher.weather.*;
import launcher.writer.*;

public class Helicopter extends Aircraft implements Flyable
{
    private WeatherTower NweatherTower;

    Helicopter(String name, Coordinates coordinates) 
    {
        super(name, coordinates);
    }


    /*
    **  This function is to change the coordinates accordingly of the Flyable depending on the weather 
    */
    public void updateConditions() 
    {
        int copyHeight = this.coordinates.getHeight();
        int copyLong = this.coordinates.getLongitude(); 
        int copyLat = this.coordinates.getLatitude();
        String weather = this.NweatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "RAIN":
                this.coordinates = new Coordinates(copyLong + 5, copyLat, copyHeight);
                writr.writetofile("Helicopter#" + this.name + "(" + this.id + "): It's Raining cats and dogs.");
                break;
            case "SNOW":
                this.coordinates = new Coordinates(copyLong, copyLat, copyHeight - 12);
                writr.writetofile("Helicopter#" + this.name + "(" + this.id + "): I loved SNOW white and the seven dwarfs as a child.");
                break;
            case "FOG":
                this.coordinates = new Coordinates(copyLong + 1, copyLat, copyHeight);
                writr.writetofile("Helicopter#" + this.name + "(" + this.id + "): The Fog does no harm... I've always been short sighted");
                break;
            case "SUN":
                this.coordinates = new Coordinates(copyLong + 10, copyLat, copyHeight + 2);
                writr.writetofile("Helicopter#" + this.name + "(" + this.id + "): Fuck I'm burning! Gimme some Sun screen");
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

    //flyable registers to a weather tower
    public void registerTower(WeatherTower weatherTower) 
    {
        writr.writetofile("Tower says: " + "Helicopter#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        this.NweatherTower = weatherTower;
        weatherTower.register(this);
    }

    //flyable unregisters from the weather tower
    public void unregisterTower(WeatherTower weatherTower) 
    {
        writr.writetofile("Tower says: " + "Helicopter#" + this.name + "(" + this.id + ")" + " unregisteres from weather tower and lands.");
        this.NweatherTower = weatherTower;
        weatherTower.unregister(this);
    }
}