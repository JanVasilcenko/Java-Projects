package sample.States;

public class HeaterPowerTwo implements HeaterState
{
  @Override public void Up(Heater heater)
  {
    heater.setState(new HeaterPowerThree(heater));
  }

  @Override public void Down(Heater heater)
  {
  heater.setState(new HeaterPowerOne());
  }

  @Override public int status(Heater heater)
  {
    return 2;
  }
}
