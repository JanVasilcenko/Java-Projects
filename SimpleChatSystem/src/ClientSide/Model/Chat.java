package ClientSide.Model;

import Shared.SharedObjects.Message;
import Shared.Util.Subject;

import java.util.List;

public interface Chat extends Subject
{
  Message newMessage(String text);
    List<Message> getMessages();
    void setUsername(String username);
    String getNumber();
    void decrementClient();
}
