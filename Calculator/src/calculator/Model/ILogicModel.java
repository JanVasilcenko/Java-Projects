package calculator.Model;

import calculator.Utilities.NamedPropertyChangeSubject;

public interface ILogicModel extends NamedPropertyChangeSubject
{
  void add();
  void substract();
  void multiply();
  void divide();
  void equals();
  void setNumberTo(int a);
  void plusMinusNumber();
  void dotSign();
  void reset();
  void modulus();
}
