package calculator.Core;

import calculator.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {

  private Scene calculatorScene;
  private Stage stage;
  private ViewModelFactory viewModelFactory;

  public ViewHandler(ViewModelFactory viewModelFactory) {
    this.viewModelFactory = viewModelFactory;
  }

  public void start() {
    stage = new Stage();
    openCalculator();
  }

  public void openCalculator() {
    if (calculatorScene == null) {
      try {
        Parent root = loadFXML("../View/Calculator.fxml");

        stage.setTitle("Calculator");
        calculatorScene = new Scene(root);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    stage.setScene(calculatorScene);
    stage.show();
  }


  private Parent loadFXML(String path) throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource(path));
    Parent root = loader.load();

    ViewController ctrl = loader.getController();
    ctrl.init(this, viewModelFactory);
    return root;
  }
}
