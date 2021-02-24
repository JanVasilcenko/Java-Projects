package Adapter;

import ServerSide.Adapter.BookDAOHandler;
import ServerSide.Adapter.VideoGameGenreDAOHandler;
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
class VideoGameGenreDAOHandlerTest
{
    private static VideoGameGenreDAOHandler dao;
    @Mock
    private ResultSet resultset;

    @BeforeAll
    static void setUp()
{
    dao = new VideoGameGenreDAOHandler(null);
}

    @Test
    void testConvertGenre() throws SQLException
    {
        Mockito.when(resultset.next()).thenReturn(true).thenReturn(false);
        Mockito.when(resultset.getString("genrename")).thenReturn("Rpg");

        var result = dao.convertGenre(resultset);

        var expected = List.of("Rpg");

        assertEquals(expected, result);
    }


}