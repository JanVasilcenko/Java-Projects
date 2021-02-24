package ServerSide;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer
{
  private MessageManager messageManager;
  private ServerSocket serverSocket;

  public SocketServer(MessageManager messageManager) throws IOException
  {
    this.messageManager= messageManager;
    serverSocket = new ServerSocket(1234);
  }

  public void startServer()
  {
    try
    {


      while(true)
      {
        Socket socket = serverSocket.accept();
        Thread thread = new Thread(new SocketHandler(socket,messageManager));
        thread.setDaemon(true);
        thread.start();
//        new Thread(new SocketHandler(socket,messageManager)).start();
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
