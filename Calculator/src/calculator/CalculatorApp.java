package calculator;

import calculator.Core.ModelFactory;
import calculator.Core.ViewHandler;
import calculator.Core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class CalculatorApp extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        ModelFactory modelFactory = new ModelFactory();
        ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
        ViewHandler viewHandler = new ViewHandler(viewModelFactory);
        viewHandler.start();
    }
}
