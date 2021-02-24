package sample.States;

public class HeaterOff implements HeaterState
{

  @Override public void Up(Heater heater)
  {
    heater.setState(new HeaterPowerOne());
  }

  @Override public void Down(Heater heater)
  {
    //Nothing
  }

  @Override public int status(Heater heater)
  {
    return 0;
  }
}
