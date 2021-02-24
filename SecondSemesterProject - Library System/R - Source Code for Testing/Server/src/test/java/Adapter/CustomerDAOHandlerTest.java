package Adapter;

import ServerSide.Adapter.CustomerDAOHandler;
import Shared.SharedObjects.Customer;
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
class CustomerDAOHandlerTest
{

    private static CustomerDAOHandler dao;

    @Mock
    private ResultSet resultSet;

    @BeforeAll
    static void setUp()
    {
        dao = new CustomerDAOHandler(null);
    }

    @Test
    void testConvertCpr() throws SQLException
    {
        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);
        Mockito.when(resultSet.getLong("cpr")).thenReturn((long) 1234567890);

        var result = dao.convertCpr(resultSet);

        var expected = List.of((long) 1234567890);

        assertEquals(expected, result);

    }

    @Test
    void testConvertPassword() throws SQLException
    {
        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
        Mockito.when(resultSet.getString("password")).thenReturn("123456");

        var result = dao.convertPassword(resultSet);

        var expected = List.of("123456", "123456");

        assertEquals(expected, result);

    }

    @Test
    void testConvertCustomer() throws SQLException
    {
        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);
        Mockito.when(resultSet.getLong("cpr")).thenReturn((long) 1234567890);
        Mockito.when(resultSet.getString("name")).thenReturn("Bob");
        Mockito.when(resultSet.getString("password")).thenReturn("123456");
        Mockito.when(resultSet.getString("address")).thenReturn("Kamtjatka");
        Mockito.when(resultSet.getLong("creditCard")).thenReturn((long) 1234567890123456L);

        var result = dao.convertCustomer(resultSet);

        var expected = List.of(new Customer((long) 1234567890, "Bob", "123456",  "Kamtjatka", (long) 1234567890123456L));

        assertEquals(expected, result);

    }




}