package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.External.Thermometer;
import sample.Model.Model;
import sample.Model.ModelManager;
import sample.States.Heater;
import sample.View.ViewHandler;
import sample.ViewModel.ViewModelFactory;

public class MyApplication extends Application
{
  public void start(Stage primaryStage)
  {
    //Model
    Model model = new ModelManager();
    ViewModelFactory viewModelFactory = new ViewModelFactory(model);
    //View
    ViewHandler view = new ViewHandler(viewModelFactory);
    view.start(primaryStage);

    //Threads

    Thermometer t1 = new Thermometer("t1",0,1,model);
    Thermometer t2 = new Thermometer("t2", 0,7,model);
    Thread thread = new Thread(t1);
    Thread thread1 = new Thread(t2);

    thread.setDaemon(true);
    thread1.setDaemon(true);

    thread.start();
    thread1.start();

  }
}