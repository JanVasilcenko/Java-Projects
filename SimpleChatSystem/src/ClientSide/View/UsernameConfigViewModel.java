package ClientSide.View;

import ClientSide.Model.Chat;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UsernameConfigViewModel
{
  private Chat chat;
  private StringProperty username;
  private StringProperty error;

  public UsernameConfigViewModel(Chat chat)
  {
    this.chat=chat;
    this.username = new SimpleStringProperty();
    this.error = new SimpleStringProperty();
  }
  StringProperty getError(){return error;}
  StringProperty getUsername(){return username;}

  boolean setUsername()
  {
    String newusername = username.get();
    if(newusername != null && !"".equals(newusername))
    {
    chat.setUsername(newusername);
      return true;
    }
    else
      {
        error.set("First you must choose username");
        return false;
      }
  }
}
