package Adapter;

import ServerSide.Adapter.ProductionCompanyDAOHandler;
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

class ProductionCompanyDAOHandlerTest
{
private static ProductionCompanyDAOHandler dao;

@Mock
private ResultSet resultSet;

@BeforeAll
static void setUp()
{
    dao = new ProductionCompanyDAOHandler(null);
}

@Test
void testConvertProductionCompanies() throws SQLException
{
    Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);
    Mockito.when(resultSet.getString("productioncompanyname")).thenReturn("Thunder Road Pictures");

    var result = dao.convertProductionCompanies(resultSet);

    var expected = List.of("Thunder Road Pictures");

    assertEquals(expected, result);

}


}