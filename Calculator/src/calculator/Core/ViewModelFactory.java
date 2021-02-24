package calculator.Core;

import calculator.View.CalculatorViewModel;

public class ViewModelFactory
{
  private final ModelFactory modelFactory;
  private CalculatorViewModel calculatorViewModel;

  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
  }

  public CalculatorViewModel getCalculatorViewModel()
  {
    if(calculatorViewModel == null)
      calculatorViewModel = new CalculatorViewModel(modelFactory.getLogicModel());
    return calculatorViewModel;
  }
}
