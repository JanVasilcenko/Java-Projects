package sample.Model;



import javafx.application.Platform;
import sample.States.Heater;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelManager implements Model
{
  private TemperatureList temperatureList;
  private PropertyChangeSupport support;
  private Heater heater;

  public ModelManager()
  {
    temperatureList = new TemperatureList();
    this.support = new PropertyChangeSupport(this);
    this.heater = new Heater(this);
    Platform.runLater(()->support.firePropertyChange("power",null,heater.getStatus()));

  }

  @Override public synchronized void addTemperature(String id, double value)
  {
    Temperature temperature = new Temperature(id, value, this);
    Temperature old = getLastInsertedTemperature(id);
    this.temperatureList.addTemperature(temperature);
    if (old != null && old.getValue() != temperature.getValue())
    {

    }
    support.firePropertyChange("temp",temperature.getId(),temperature.getValue());
  }

  @Override public synchronized Temperature getLastInsertedTemperature()
  {
    return temperatureList.getLastTemperature(null);
  }

  @Override public synchronized Temperature getLastInsertedTemperature(
      String id)
  {
    return temperatureList.getLastTemperature(id);
  }

  @Override public synchronized int heaterStatus()
  {
    support.firePropertyChange("power",null,heater.getStatus());
    return heater.getStatus();
  }

  @Override public synchronized void upPower()
  {
    heater.Up();
    support.firePropertyChange("power",null,heater.getStatus());
  }

  @Override public synchronized void downPower()
  {
    heater.Down();
    support.firePropertyChange("power",null,heater.getStatus());
  }

  @Override public void addListener(String propertyName,
      PropertyChangeListener listener)
  {
    if (propertyName == null)
    {
      support.addPropertyChangeListener(listener);
    }
    else
    {
      support.addPropertyChangeListener(propertyName, listener);
    }
  }

  @Override public void removeListener(String propertyName,
      PropertyChangeListener listener)
  {
    if (propertyName == null)
    {
      support.removePropertyChangeListener(listener);
    }
    else
    {
      support.removePropertyChangeListener(propertyName, listener);
    }
  }
}
