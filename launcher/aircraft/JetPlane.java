package launcher.aircraft;

import launcher.aircraft.*;
import launcher.weather.*;
import launcher.writer.*;
 
public class JetPlane extends Aircraft implements Flyable
{
    private WeatherTower NweatherTower;

    JetPlane(String name, Coordinates coordinates) 
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
                this.coordinates = new Coordinates(copyLong, copyLat + 5, copyHeight);
                writr.writetofile("JetPlane#" + this.name + "(" + this.id + "): Atleast the dams will be filled");
                break;
            case "SNOW":
                this.coordinates = new Coordinates(copyLong, copyLat, copyHeight - 7);
                writr.writetofile("JetPlane#" + this.name + "(" + this.id + "): I'd love some coffee and a blanket right now!");
                break;
            case "FOG":
                this.coordinates = new Coordinates(copyLong, copyLat + 1, copyHeight);
                writr.writetofile("JetPlane#" + this.name + "(" + this.id + "): Cloud 9 has come to me!");
                break;
            case "SUN":
                this.coordinates = new Coordinates(copyLong, copyLat + 10, copyHeight + 2);
                writr.writetofile("JetPlane#" + this.name + "(" + this.id + "): My skin could crack from these sun burns!!");
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
        writr.writetofile("Tower says: " + "JetPlane#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        this.NweatherTower = weatherTower;
        weatherTower.register(this);
    }

    public void unregisterTower(WeatherTower weatherTower) 
    {
        writr.writetofile("Tower says: " + "JetPlane#" + this.name + "(" + this.id + ")" + " unregisteres from weather tower and lands.");
        this.NweatherTower = weatherTower;
        weatherTower.unregister(this);
    }
}