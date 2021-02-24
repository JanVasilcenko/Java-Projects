package sample.View;

import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.util.StringConverter;
import sample.ViewModel.FirstWindowViewModel;

public class FirstWindowController
{
  private Region root;
  private ViewHandler viewHandler;
  private FirstWindowViewModel firstWindowViewModel;
  @FXML private Label tempOneLabel;
  @FXML private Label tempTwoLabel;
  @FXML private Label errorLabel;

  public void init(ViewHandler viewHandler, FirstWindowViewModel firstWindowViewModel, Region root)
  {
    this.viewHandler=viewHandler;
    this.firstWindowViewModel=firstWindowViewModel;
    this.root=root;
    tempOneLabel.textProperty().bindBidirectional(firstWindowViewModel.getFirstTemperature());
    tempTwoLabel.textProperty().bindBidirectional(firstWindowViewModel.getSecondTemperature());
    firstWindowViewModel.getFirstTemperature().addListener((obs, oldb, b) -> {
      if(firstWindowViewModel.model.getLastInsertedTemperature("t1").getValue()>20){
      errorLabel.setText("Temperature too high");}else if(firstWindowViewModel.model.getLastInsertedTemperature("t2").getValue()==0){errorLabel.setText("Temperature too low");}else{errorLabel.setText("");}});
  }

  public void reset()
  {

  }
  public Region getRoot()
  {
    return root;
  }
  @FXML private void secondWindowButton()
  {
    viewHandler.openView("second");
  }

}
