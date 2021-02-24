package Adapter;

import ServerSide.Adapter.BookGenreDAOHandler;
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
class BookGenreDAOHandlerTest
{

    private static BookGenreDAOHandler dao;

    @Mock
    private ResultSet resultSet;

    @BeforeAll
    static void setUp()
    {
        dao = new BookGenreDAOHandler(null);
    }

    @Test
    void testConvertGenre() throws SQLException
    {
        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);
        Mockito.when(resultSet.getString("genrename")).thenReturn("Fantasy");


        var result = dao.convertGenre(resultSet);

        System.out.println(result);

        var expected = List.of("Fantasy");

        assertEquals(expected, result);

    }
}