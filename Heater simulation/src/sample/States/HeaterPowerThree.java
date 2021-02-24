package sample.States;

public class HeaterPowerThree implements HeaterState
{
  private int timeoutTime=40000;
  private Thread timer;
  private boolean complete;

  public HeaterPowerThree(Heater heater)
  {
    complete=false;
    timer=new Thread(() ->
    {
      try
      {
      Thread.sleep(timeoutTime);
      timeout(heater);
      }
      catch(InterruptedException e)
      {

      }
    });
    timer.start();
  }

  private synchronized void timeout(Heater heater)
 {
  if(!complete)
  {
  heater.setState(new HeaterPowerTwo());
  complete=true;
  }
 }

  @Override public void Up(Heater heater)
  {
    //nothing
  }

  @Override public synchronized void Down(Heater heater)
  {
  if(!complete)
{
  timer.interrupt();
  heater.setState(new HeaterPowerTwo());
  complete=true;
}

  }

  @Override public int status(Heater heater)
  {
    return 3;
  }
}
