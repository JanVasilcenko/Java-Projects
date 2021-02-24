package Adapter;

import ServerSide.Adapter.MovieDAOHandler;
import Shared.SharedObjects.Movie;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MovieDAOHandlerTest
{
private static MovieDAOHandler dao;

@Mock
private ResultSet resultSet;

@BeforeAll
static void setUp()
{
    dao = new MovieDAOHandler(null);
}

@Test
void testConvertMovies() throws SQLException
{
    Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);
    Mockito.when(resultSet.getInt("item_id")).thenReturn(1);
    Mockito.when(resultSet.getString("movie_title")).thenReturn("The Lord of the Rings: The Return of the King");
    Mockito.when(resultSet.getInt("yearofpublishing")).thenReturn(2003);


    var result = dao.convertMovies(resultSet);

    var expected = List.of(new Movie(1,"The Lord of the Rings: The Return of the King", 2003));

    assertEquals(expected, result);
}
}