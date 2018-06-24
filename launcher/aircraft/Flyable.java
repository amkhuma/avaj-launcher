package launcher.aircraft;

import launcher.aircraft.*;
import launcher.weather.*;
import launcher.writer.*;

/*
    Simple interface that will be implemented by all types of aicrafts
*/

public interface Flyable
{
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
    public void unregisterTower(WeatherTower weatherTower);
}