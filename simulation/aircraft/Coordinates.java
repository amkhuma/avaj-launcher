package simulation.aircraft;

import simulation.aircraft.*;
import simulation.weather.*;

public class Coordinates
{
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height)
    {
        this.longitude = longitude;
        this.latitude = latitude;
        if (height > 100)
        {
            this.height = 100;
        }
        else
            this.height = height;
    }

    public int getLongitude()
    {
        return (this.longitude);
    }

    public int getLatitude()
    {
        return (this.latitude);
    }

    public int getHeight()
    {
        return (this.height);
    }

    public void increaseHeight(int newHeight) 
    {
        this.height = this.height + newHeight;
    }

    public void increaseLatitude(int newLatitude) 
    {
        this.latitude = this.latitude + newLatitude;
    }

    public void increaseLongitude(int newLongitude) 
    {
        this.longitude = this.longitude + newLongitude;
    }

    public void decreaseHeight(int newHeight) 
    {
        this.height = this.height - newHeight;
    }

    public void decreaseLatitude(int newLatitude) 
    {
        this.latitude = this.latitude - newLatitude;
    }

    public void decreaseLongitude(int newLongitude) 
    {
        this.longitude = this.longitude - newLongitude;
    }
}