package sample.Model;


public class Temperature implements Runnable
{
   private String id;
   private double value;
   private DateTime time;
   private Model model;

   public Temperature(String id, double value, Model model)
   {
      this.id = id;
      this.value = value;
      time = new DateTime();
      this.model=model;
   }
   public double getValue()
   {
      return value;
   }
   public String getId() { return id;}
   public DateTime getTime()
   {
      return time;
   }
   public String toString()
   {
      return String.format("%s: %.1f (%s)", id, value, time.getTimestamp());
   }

   @Override public void run()
   {
   model.addTemperature(getId(),getValue());
   }
}
