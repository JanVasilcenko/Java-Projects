package Flyweight;

public class GoldNugget implements Valuable
{
  @Override public String getName()
  {
    return "GoldNugget";
  }

  @Override public int getValue()
  {
    return 30;
  }

  @Override public String toString()
  {
    return getName();
  }
}
