package ClientSide.View;

import ClientSide.Model.Chat;
import Shared.SharedObjects.Message;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class ChatWindowViewModel
{
  private Chat chat;
  private ObservableList<Message> list;
  private StringProperty message;
  private StringProperty number;

  public ChatWindowViewModel(Chat chat)
  {
    this.chat=chat;
    this.message=new SimpleStringProperty();
    this.number = new SimpleStringProperty();
    chat.addListener("NewMsgEntry", this::onNewChatEntry);
  }

  private void onNewChatEntry(PropertyChangeEvent propertyChangeEvent)
  {
    Platform.runLater(()->list.add((Message)propertyChangeEvent.getNewValue()));
  }

  public ObservableList<Message> getList(){return list;}
  public StringProperty getMessage(){return message;}
  public void loadMessages()
  {
    List<Message> list = chat.getMessages();
    this.list=FXCollections.observableArrayList(list);
  }
  public void sendMessage()
  {
    chat.newMessage(message.get());
  }

  public StringProperty numberProperty()
  {
    return number;
  }
  public void getNumber()
  {
    number.set(chat.getNumber());
  }
}
