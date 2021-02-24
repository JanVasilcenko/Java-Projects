package Adapter;

import ServerSide.Adapter.BookDAOHandler;
import Shared.SharedObjects.Book;
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
class BookDAOHandlerTest
{
    private static BookDAOHandler dao;
    @Mock
    private ResultSet resultset;

    @BeforeAll
    static void setUp()
    {
        dao = new BookDAOHandler(null);
    }
    @Test
    void testConvertBooks() throws SQLException
    {
        /*
        Mockito.doReturn(true).doReturn(false).when(resultset.next()).then;
        Mockito.doReturn(1).when(resultset.getInt("item_id"));
        Mockito.doReturn("Hobbit").when(resultset.getInt("book_title"));
        Mockito.doReturn(1937).when(resultset.getInt("yearofpublishing"));
        Mockito.doReturn(50).when(resultset.getInt("published_by"));

         */

        Mockito.when(resultset.next()).thenReturn(true).thenReturn(false);
        Mockito.when(resultset.getInt("item_id")).thenReturn(1);
        Mockito.when(resultset.getString("book_title")).thenReturn("Hobbit");
        Mockito.when(resultset.getInt("yearofpublishing")).thenReturn(1937);
        Mockito.when(resultset.getInt("published_by")).thenReturn(50);

        var result = dao.convertBooks(resultset);

        var expected = List.of(new Book(1, "Hobbit", 1937, 50));


        assertEquals(expected, result);

    }
}