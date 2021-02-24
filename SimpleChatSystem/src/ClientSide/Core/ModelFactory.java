package ClientSide.Core;

import ClientSide.Model.Chat;
import ClientSide.Model.ChatManager;

public class ModelFactory
{
  private final ClientFactory cf;
  private Chat chat;

  public ModelFactory(ClientFactory cf){this.cf=cf;}

  public Chat getChat()
  {
    if(chat==null)
      chat=new ChatManager(cf.getClient());
    return chat;
  }
}
