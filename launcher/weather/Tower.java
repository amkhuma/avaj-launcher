package launcher.weather;

import java.util.*;

import launcher.aircraft.*;
import launcher.weather.*;

/*
    tower class that handles the registration and changing weather conditions for the flyables registered
*/

public class Tower
{
    private List<Flyable> observers = new ArrayList<Flyable>(); // list of all registered flyables
    private List<Flyable> unregistered = new ArrayList<Flyable>(); //opposite of observers

    public void register(Flyable flyable) //add flyables to observers
    {
        if (observers.contains(flyable)) {
			return ;
		}
        observers.add(flyable); 
    }

    public void unregister(Flyable flyable) //add flyables to unregistered
    {
        if (unregistered.contains(flyable))
        {
            return ;
        }
        unregistered.add(flyable);
    }

    protected void conditionsChanged() //change the weather conditions for each flyable
    {
        for (Flyable flyable : observers) {
			flyable.updateConditions();
		}
		observers.removeAll(unregistered); //remove the flyables in unregistered from observers list
    }
}