package Shared.SharedObjects;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Reservation implements Serializable
{
  private long cpr;
  private int id;
  private LocalDate datefrom;
  private LocalDate datedue;
  private LocalDate dateto;
  private int fine;
  private int finepaid;

  public Reservation(long cpr, int id, LocalDate datefrom, LocalDate datedue,
      LocalDate dateto, int fine, int finepaid)
  {
    this.cpr = cpr;
    this.id = id;
    this.datefrom = datefrom;
    this.datedue = datedue;
    this.dateto = dateto;
    this.fine = fine;
    this.finepaid = finepaid;
  }

  public long getCpr()
  {
    return cpr;
  }

  public int getId()
  {
    return id;
  }

  public LocalDate getDatefrom()
  {
    return datefrom;
  }

  public LocalDate getDatedue()
  {
    return datedue;
  }

  public LocalDate getDateto()
  {
    return dateto;
  }

  public void setDatefrom(LocalDate datefrom)
  {
    this.datefrom = datefrom;
  }

  public void setDatedue(LocalDate datedue)
  {
    this.datedue = datedue;
  }

  public void setDateto(LocalDate dateto)
  {
    this.dateto = dateto;
  }

  public int getFine()
  {
    return fine;
  }

  public int getFinepaid()
  {
    return finepaid;
  }

@Override
public boolean equals(Object o)
{
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  Reservation that = (Reservation) o;
  return getCpr() == that.getCpr() &&
          getId() == that.getId() &&
          getFine() == that.getFine() &&
          getFinepaid() == that.getFinepaid() &&
          getDatefrom().equals(that.getDatefrom()) &&
          getDatedue().equals(that.getDatedue()) &&
          getDateto().equals(that.getDateto());
}

@Override
public int hashCode()
{
  return Objects.hash(getCpr(), getId(), getDatefrom(), getDatedue(), getDateto(), getFine(), getFinepaid());
}
}
