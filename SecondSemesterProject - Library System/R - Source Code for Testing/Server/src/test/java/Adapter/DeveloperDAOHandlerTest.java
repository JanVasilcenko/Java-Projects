package Adapter;

import ServerSide.Adapter.DeveloperDAOHandler;
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
class DeveloperDAOHandlerTest
{
    private static DeveloperDAOHandler dao;

    @Mock
    private ResultSet resultSet;

    @BeforeAll
    static void setUp()
    {
        dao = new DeveloperDAOHandler(null);
    }

    @Test
    void testConvertDeveloper() throws SQLException
    {
        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);
        Mockito.when(resultSet.getString("developername")).thenReturn("CD Projekt Red");

        var result = dao.convertDeveloper(resultSet);

        var expected = List.of("CD Projekt Red");

        assertEquals(expected, result);


    }
}