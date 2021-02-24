package sample.View;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.util.StringConverter;
import sample.ViewModel.SecondWindowViewModel;

public class SecondWindowController
{
  private Region root;
  private ViewHandler viewHandler;
  private SecondWindowViewModel secondWindowViewModel;
  @FXML private Label heaterPower;

  public void init(ViewHandler viewHandler, SecondWindowViewModel secondWindowViewModel, Region root)
  {
  this.viewHandler=viewHandler;
  this.secondWindowViewModel=secondWindowViewModel;
  this.root=root;
  heaterPower.textProperty().bindBidirectional(secondWindowViewModel.powerProperty());
  }
  public void reset()
  {

  }
  public Region getRoot()
  {
    return root;
  }
  @FXML private void upButton()
  {
    secondWindowViewModel.upPower();
  }
  @FXML private void  downButton()
  {
    secondWindowViewModel.downPower();
  }
  @FXML private void firstWindowButton()
  {
    viewHandler.openView("first");
  }
}
