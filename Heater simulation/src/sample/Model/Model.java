package sample.Model;

import sample.States.Heater;
import sample.Utilities.NamedPropertyChangeSubject;

public interface Model
    extends NamedPropertyChangeSubject
{
  void addTemperature(String id, double temperature);

  Temperature getLastInsertedTemperature();

  Temperature getLastInsertedTemperature(String id);

  int heaterStatus();
  void upPower();
  void downPower();
}
