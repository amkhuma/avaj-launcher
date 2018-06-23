package simulation.aircraft;

import simulation.aircraft.*;
import simulation.weather.*;
 
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
                System.out.println("JetPlane#" + this.name + "(" + this.id + "): its rainy");
                break;
            case "SNOW":
                this.coordinates = new Coordinates(copyLong, copyLat, copyHeight - 7);
                System.out.println("JetPlane#" + this.name + "(" + this.id + "): its snowy");
                break;
            case "FOG":
                this.coordinates = new Coordinates(copyLong, copyLat + 1, copyHeight);
                System.out.println("JetPlane#" + this.name + "(" + this.id + "): its foggy");
                break;
            case "SUN":
                this.coordinates = new Coordinates(copyLong, copyLat + 10, copyHeight + 2);
                System.out.println("JetPlane#" + this.name + "(" + this.id + "): its sunny");
                break;            
            default:
                System.out.println("unknown weather: ");
                break;
        }
        //System.out.println("long: " + copyLong + " lat: " + copyLat + " height: " + copyHeight);
        if (this.coordinates.getHeight() <= 0)
        {
            unregisterTower(this.NweatherTower);            
        }
    }

    public void registerTower(WeatherTower weatherTower) 
    {
        System.out.println("Tower says: " + "JetPlane#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        this.NweatherTower = weatherTower;
        weatherTower.register(this);
    }

    public void unregisterTower(WeatherTower weatherTower) 
    {
        System.out.println("Tower says: " + "Helicopter#" + this.name + "(" + this.id + ")" + " unregisteres from weather tower.");
        this.NweatherTower = weatherTower;
        weatherTower.unregister(this);
    }
}