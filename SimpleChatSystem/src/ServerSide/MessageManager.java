package ServerSide;

import Shared.SharedObjects.Message;
import Shared.Util.Subject;

import java.util.List;

public interface MessageManager extends Subject
{
  Message newMessage(Message arg);
  List<Message> getMessage();
  String getNumberofClients();
  void addClient();
  void removeClient();
}
