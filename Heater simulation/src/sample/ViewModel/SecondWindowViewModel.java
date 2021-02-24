package sample.ViewModel;

import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sample.Model.Model;
import sample.States.HeaterState;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SecondWindowViewModel implements PropertyChangeListener
{
  private Model model;
  private StringProperty power;

  public SecondWindowViewModel(Model model)
  {
    this.model=model;
    this.power=new SimpleStringProperty();
    model.addListener("power", this);
  }

  public StringProperty powerProperty()
  {
    return power;
  }
  public void upPower()
  {
    model.upPower();
  }
  public void downPower()
  {
    model.downPower();
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    Platform.runLater(() ->
        {
          power.setValue(evt.getNewValue().toString());
        }
        );
  }
}
