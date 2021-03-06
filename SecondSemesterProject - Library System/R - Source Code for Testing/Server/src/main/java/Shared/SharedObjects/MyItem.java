package Shared.SharedObjects;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class MyItem implements Serializable
{
  private int id;
  private String name;
  private LocalDate datefrom;
  private LocalDate datedue;
  private int fine;
  private String type;

  public MyItem(int id, String name, LocalDate datefrom, LocalDate datedue,
      int fine, String type)
  {
    this.id = id;
    this.name = name;
    this.datefrom = datefrom;
    this.datedue = datedue;
    this.fine = fine;
    this.type = type;
  }

  public int getId()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  public LocalDate getDatefrom()
  {
    return datefrom;
  }

  public LocalDate getDatedue()
  {
    return datedue;
  }

  public int getFine()
  {
    return fine;
  }

  public String getType()
  {
    return type;
  }

  @Override
  public String toString()
  {
    return "Id: "+id+ " Title: "+name+" Date from: "+datefrom+" Date due: "+datedue;
  }
  
  @Override public boolean equals(Object o) {
    if (this == o) { return true; }
    if (o == null || getClass() != o.getClass()) { return false; }
    MyItem myItem = (MyItem) o;
    return getId() == myItem.getId() && getFine() == myItem.getFine() && getName().equals(myItem.getName()) &&
           getDatefrom().equals(myItem.getDatefrom()) && getDatedue().equals(myItem.getDatedue()) &&
           getType().equals(myItem.getType());
  }
}
