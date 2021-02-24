package calculator.Model;

import calculator.Utilities.NamedPropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LogicModel implements ILogicModel, NamedPropertyChangeSubject
{
  private String number = "0";
  private String sign = "";
  private String operation = "";
  private String savedNumber = "0";
  private PropertyChangeSupport propertyChangeSupport;

  public LogicModel()
  {
    this.propertyChangeSupport = new PropertyChangeSupport(this);
  }
  @Override public void add()
  {
    savedNumber = number;
    operation = "+";
    sign = "";
  }

  @Override public void substract()
  {
    savedNumber = number;
    operation = "-";
    sign = "";
  }

  @Override public void multiply()
  {
    savedNumber = number;
    operation = "*";
    sign = "";
  }

  @Override public void divide()
  {
    savedNumber = number;
    operation = "/";
    sign = "";
  }

  @Override public void modulus()
  {
    savedNumber = number;
    operation = "%";
    sign = "";
  }

  @Override public void equals()
  {
    if(operation.equals("+"))
    {
      number = Float.toString(Float.parseFloat(savedNumber) + Float.parseFloat(number));
      savedNumber = "0";
    }
    else if (operation.equals("/"))
    {
      number = Float.toString(Float.parseFloat(savedNumber) / Float.parseFloat(number));
      savedNumber = "0";
    }
    else if (operation.equals("*"))
    {
      number = Float.toString(Float.parseFloat(savedNumber) * Float.parseFloat(number));
      savedNumber = "0";
    }
    else if (operation.equals("-"))
    {
      number = Float.toString(Float.parseFloat(savedNumber) - Float.parseFloat(number));
      savedNumber = "0";
    }
    else if (operation.equals("%"))
    {
      number = Float.toString(Float.parseFloat(savedNumber) % Float.parseFloat(number));
      savedNumber = "0";
    }

    while (number.substring(number.length()-1).equals("0") && !number.equals("0"))
    {
      number = number.substring(0,number.length()-1);
    }
    if (number.substring(number.length()-1).equals("."))
    {
      number = number.substring(0,number.length()-1);
    }
    operation = "";
    propertyChangeSupport.firePropertyChange("Number",null,number);
  }

  @Override public void setNumberTo(int a)
  {
    if (operation.equals("+") && sign.equals(".") || operation.equals("-") && sign.equals(".") || operation.equals("/") && sign.equals(".") || operation.equals("*") && sign.equals(".") || operation.equals("%") && sign.equals("."))
    {
      number += Integer.toString(a);
    }
    else if (operation.equals("+") || operation.equals("/") || operation.equals("-") || operation.equals("*") || operation.equals("%"))
    {
      number = Integer.toString(a);
    }
    else if(sign.equals("."))
    {
      number += Integer.toString(a);
    }
    else if (number.equals("0"))
    {
      number = Integer.toString(a);
    }
    else
      {
        number += Integer.toString(a);
      }
    propertyChangeSupport.firePropertyChange("Number",null,number);
  }
  @Override public void dotSign()
  {
    if(!number.substring(number.length()-1).equals("."))
    {
      number += ".";
      sign = ".";
    }
    else
      {
        number = number.substring(0,number.length()-1);
        sign = null;
      }
    propertyChangeSupport.firePropertyChange("Number",null,number);
  }

  @Override public void reset()
  {
    number = "0";
    savedNumber = "0";
    sign = "";
    operation = "";
    propertyChangeSupport.firePropertyChange("Number",null,number);
  }

  @Override public void plusMinusNumber()
  {
    if(number.substring(0,1).equals("-"))
    {
      number = number.substring(1);
    }
    else
      {
        number = "-"+number;
      }
    propertyChangeSupport.firePropertyChange("Number",null,number);
  }
  @Override public void addListener(String propertyName,
      PropertyChangeListener listener)
  {
    propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
  }

  @Override public void removeListener(String propertyName,
      PropertyChangeListener listener)
  {
    propertyChangeSupport.removePropertyChangeListener(propertyName, listener);
  }
}
