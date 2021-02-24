package ServerSide.Adapter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookGenreDAOHandler implements BookGenreDAO
{
  private Connection connection;

  public BookGenreDAOHandler(Connection connection)
  {
    this.connection = connection;
  }

  public List<String> convertGenre(ResultSet resultSet)
  {
    ArrayList<String> genres = new ArrayList<>();
    try
    {
      while (resultSet.next())
      {
        String genre = resultSet.getString("genrename");
        genres.add(genre);
      }
      return genres;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return Collections.emptyList();
  }

  @Override
  public ArrayList<String> getGenre(int id)
  {
    try
    {
      String querysql = "SELECT GENRENAME FROM BOOKGENRE WHERE ITEM_ID = ?";
      PreparedStatement selectGenre = connection.prepareStatement(querysql);
      selectGenre.setInt(1, id);
      ResultSet resultSet = selectGenre.executeQuery();

      ArrayList<String> genre = (ArrayList<String>) convertGenre(resultSet);
      resultSet.close();
      selectGenre.close();
      return genre;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }
}
