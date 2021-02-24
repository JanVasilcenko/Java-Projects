package sample.States;

public class HeaterPowerOne implements HeaterState
{

  @Override public void Up(Heater heater)
  {
    heater.setState(new HeaterPowerTwo());
  }

  @Override public void Down(Heater heater)
  {
  heater.setState(new HeaterOff());
  }

  @Override public int status(Heater heater)
  {
    return 1;
  }
}
