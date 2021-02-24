package ServerSide;

import ServerSide.Adapter.*;
import ServerSide.Model.ServerModelManager;
import ServerSide.Network.Server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class RunServer
{
  public static void main(String[] args)
      throws AlreadyBoundException, RemoteException
  {

    var connection = Database.getInstance().getConnection();

    Server rmiServer = new Server(
        new ServerModelManager(new CustomerDAOHandler(connection), new BookDAOHandler(connection), new AuthorDAOHandler(connection), new MovieDAOHandler(connection),
            new VideoGameDAOHandler(connection), new DeveloperDAOHandler(connection),
            new ProductionCompanyDAOHandler(connection), new CustomerBookDAOHandler(connection),
            new CustomerVideoGameDAOHandler(connection), new CustomerMovieDAOHandler(connection),
            new HasBorrowedBookDAOHandler(connection), new HasBorrowedMovieDAOHandler(connection),
            new HasBorrowedVideoGameDAOHandler(connection), new BookGenreDAOHandler(connection),
            new VideoGameGenreDAOHandler(connection), new MovieGenreDAOHandler(connection)));
    rmiServer.startServer();
  }
}
