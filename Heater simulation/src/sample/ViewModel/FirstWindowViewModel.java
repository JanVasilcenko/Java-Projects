package sample.ViewModel;

import javafx.application.Platform;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sample.Model.Model;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class FirstWindowViewModel implements PropertyChangeListener
{
  public Model model;
  private StringProperty temperature1;
  private StringProperty temperature2;
  private StringProperty error;

  public FirstWindowViewModel(Model model)
  {
    this.model=model;
    this.temperature1=new SimpleStringProperty();
    this.temperature2=new SimpleStringProperty();
    this.error= new SimpleStringProperty();
    model.addListener("temp", this);
  }

  public StringProperty getError(){return error;}


  public StringProperty getFirstTemperature()
  {
    return temperature1;
  }

  public StringProperty getSecondTemperature()
  {
    return temperature2;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    Platform.runLater(() ->
    {
      if(evt.getOldValue()=="t1")
      {
        temperature1.setValue(evt.getNewValue().toString());
      }
      if(evt.getOldValue()=="t2")
      {
        temperature2.setValue(evt.getNewValue().toString());
      }

    });
  }
}
