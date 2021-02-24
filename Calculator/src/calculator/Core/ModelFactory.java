package calculator.Core;

import calculator.Model.ILogicModel;
import calculator.Model.LogicModel;

public class ModelFactory
{
  private ILogicModel logicModel;

  public ILogicModel getLogicModel()
  {
    if(logicModel == null)
      logicModel = new LogicModel();
    return  logicModel;
  }
}
