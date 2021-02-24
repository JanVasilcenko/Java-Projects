package Adapter;

import ServerSide.Adapter.AuthorDAOHandler;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class AuthorDAOHandlerTest
{

    private static AuthorDAOHandler dao;
    @Mock
    private ResultSet resultSet;


    @BeforeAll
    static void setUp() {
        dao = new AuthorDAOHandler(null);
    }

    @Test
    void testConvertAuthors() throws SQLException
    {
        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);
        Mockito.when(resultSet.getString("authorname")).thenReturn("J. R. R. Tolkien");

        List<String> result = dao.convertAuthors(resultSet);

        List<String> expected = List.of("J. R. R. Tolkien");

        assertEquals(expected, result);
    }


}