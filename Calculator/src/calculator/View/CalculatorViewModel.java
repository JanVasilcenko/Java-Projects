package calculator.View;

import calculator.Model.ILogicModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CalculatorViewModel implements PropertyChangeListener
{
  private ILogicModel logicModel;
  private StringProperty result;
  private StringProperty sign;

  public CalculatorViewModel(ILogicModel logicModel)
  {
    this.logicModel = logicModel;
    result = new SimpleStringProperty();
    sign = new SimpleStringProperty();
    logicModel.addListener("Number",this);
  }

  public StringProperty resultProperty()
  {
    return result;
  }

  public void setNumberTo(int a)
  {
    logicModel.setNumberTo(a);
  }

  public void plusMinusNumber()
  {
    logicModel.plusMinusNumber();
  }
  public void dotSign()
  {
    logicModel.dotSign();
  }
  public void equals()
  {
    logicModel.equals();
  }
  public void reset()
  {
    logicModel.reset();
  }
  public void add()
  {
    logicModel.add();
  }
  public void substract()
  {
    logicModel.substract();
  }
  public void multiply()
  {
    logicModel.multiply();
  }
  public void divide()
  {
    logicModel.divide();
  }
  public void modulus()
  {
    logicModel.modulus();
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
      result.setValue(evt.getNewValue().toString());
  }
}
