package sample.States;

import sample.Model.Model;
import java.beans.PropertyChangeSupport;

public class Heater
{
  private HeaterState state;

  private Model model;

  public Heater(Model model)
  {
    setState(new HeaterOff());
    this.model=model;
  }

  public void Up()
  {
    state.Up(this);
  }

  public void Down()
  {
    state.Down(this);
  }

  public void setState(HeaterState state)
  {
    this.state = state;
  }

  public int getStatus()
  {
    return state.status(this);
  }


}

