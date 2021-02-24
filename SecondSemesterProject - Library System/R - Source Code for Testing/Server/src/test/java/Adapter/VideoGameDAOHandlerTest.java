package Adapter;

import ServerSide.Adapter.ProductionCompanyDAOHandler;
import ServerSide.Adapter.VideoGameDAOHandler;
import Shared.SharedObjects.Game;
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
class VideoGameDAOHandlerTest
{
private static VideoGameDAOHandler dao;

@Mock
private ResultSet resultSet;

@BeforeAll
static void setUp()
{
    dao = new VideoGameDAOHandler(null);
}

@Test
void testConvertGames() throws SQLException
{
    // Just an fun thing. There is an actual game item in our database called "Witcher 3: The Wild Hunt" . This is
    // one of items that have been duplicated from the database in the unit tests. However, the database connection is
    // still disabled because of the reasons stated in the Project Description.

    Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);
    Mockito.when(resultSet.getInt("item_id")).thenReturn(512);
    Mockito.when(resultSet.getString("game_title")).thenReturn("The Witcher 3: The Wild Hunt");
    Mockito.when(resultSet.getInt("yearofpublishing")).thenReturn(2015);
    Mockito.when(resultSet.getInt("published_by")).thenReturn(115);

    var result = dao.convertGames(resultSet);

    var expected = List.of(new Game(512, "The Witcher 3: The Wild Hunt", 2015, 115));

    assertEquals(expected, result);
}

}