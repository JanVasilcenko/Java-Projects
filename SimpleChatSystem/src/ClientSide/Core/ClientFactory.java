package ClientSide.Core;

import ClientSide.Network.Client;
import ClientSide.Network.SocketClient;

public class ClientFactory
{
  private Client client;

  public Client getClient()
  {
    if(client==null)
    {
      client = new SocketClient();
    }
    return client;
  }
}
