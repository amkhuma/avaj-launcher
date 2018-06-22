package simulation.aircraft;

import simulation.aircraft.*;
import simulation.weather.*;

public interface Flyable
{
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
}