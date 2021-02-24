package calculator.View;

import calculator.Core.ViewHandler;
import calculator.Core.ViewModelFactory;
import calculator.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CalculatorController implements ViewController
{
  @FXML private Label result;
  private ViewHandler viewHandler;
  private CalculatorViewModel calculatorViewModel;

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    this.calculatorViewModel = viewModelFactory.getCalculatorViewModel();
    result.textProperty().bindBidirectional(calculatorViewModel.resultProperty());
    selectNumberZero();
  }
  @FXML private void selectNumberZero()
  {
    calculatorViewModel.setNumberTo(0);
  }
  @FXML private void selectNumberOne()
  {
    calculatorViewModel.setNumberTo(1);
  }
  @FXML private void selectNumberTwo()
  {
    calculatorViewModel.setNumberTo(2);
  }
  @FXML private void selectNumberThree()
  {
    calculatorViewModel.setNumberTo(3);
  }
  @FXML private void selectNumberFour()
  {
    calculatorViewModel.setNumberTo(4);
  }
  @FXML private void selectNumberFive()
  {
    calculatorViewModel.setNumberTo(5);
  }
  @FXML private void selectNumberSix()
  {
    calculatorViewModel.setNumberTo(6);
  }
  @FXML private void selectNumberSeven()
  {
    calculatorViewModel.setNumberTo(7);
  }
  @FXML private void selectNumberEight()
  {
    calculatorViewModel.setNumberTo(8);
  }
  @FXML private void selectNumberNine()
  {
    calculatorViewModel.setNumberTo(9);
  }
  @FXML private void resetCalculator()
  {
    calculatorViewModel.reset();
  }
  @FXML private void plusMinusNumber()
  {
    calculatorViewModel.plusMinusNumber();
  }
  @FXML private void dotSign()
  {
    calculatorViewModel.dotSign();
  }
  @FXML private void equals()
  {
    calculatorViewModel.equals();
  }
  @FXML private void add()
  {
    calculatorViewModel.add();
  }
  @FXML private void substract()
  {
    calculatorViewModel.substract();
  }
  @FXML private void divide()
  {
    calculatorViewModel.divide();
  }
  @FXML private void multiply()
  {
    calculatorViewModel.multiply();
  }
  @FXML private void modulus()
  {
    calculatorViewModel.modulus();
  }
}
