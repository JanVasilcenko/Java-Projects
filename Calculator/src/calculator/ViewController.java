package calculator;

import calculator.Core.ViewHandler;
import calculator.Core.ViewModelFactory;

public interface ViewController
{
  void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory);
}
