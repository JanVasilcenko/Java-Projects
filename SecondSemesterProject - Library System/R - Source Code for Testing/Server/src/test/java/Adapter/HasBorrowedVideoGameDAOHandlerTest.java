package Adapter;

import ServerSide.Adapter.HasBorrowedMovieDAOHandler;
import ServerSide.Adapter.HasBorrowedVideoGameDAOHandler;
import Shared.SharedObjects.MyItem;
import Shared.SharedObjects.Reservation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith (MockitoExtension.class) class HasBorrowedVideoGameDAOHandlerTest {
	
	private static HasBorrowedVideoGameDAOHandler dao;
	
	@Mock private ResultSet resultSet;
	
	@BeforeAll static void setUp() {
		dao = new HasBorrowedVideoGameDAOHandler(null);
	}
	

	@Test void testConvertReservations() throws SQLException
	{
		
		Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);
		Mockito.when(resultSet.getLong("cpr")).thenReturn((long) 1234567890);
		Mockito.when(resultSet.getInt("item_id")).thenReturn(1);
		Mockito.when(resultSet.getDate("datefrom")).thenReturn(Date.valueOf(LocalDate.parse("2020-05-31")));
		Mockito.when(resultSet.getDate("datedue")).thenReturn(Date.valueOf(LocalDate.parse("2020-06-01")));
		Mockito.when(resultSet.getDate("dateto")).thenReturn(Date.valueOf(LocalDate.parse("2020-06-01")));
		Mockito.when(resultSet.getInt("fine")).thenReturn(0);
		Mockito.when(resultSet.getInt("finepaid")).thenReturn(0);
		
		var result = dao.convertReservations(resultSet);
		
		var expected =
				List.of(new Reservation(1234567890, 1, LocalDate.parse("2020-05-31"), LocalDate.parse("2020-06-01"),
						LocalDate.parse("2020-06-01"), 0, 0));
		
		assertEquals(expected, result);
	}
	
	@Test void testConvertMyVideoGames() throws SQLException
	{
		Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);
		Mockito.when(resultSet.getInt("item_id")).thenReturn(511);
		Mockito.when(resultSet.getString("game_title")).thenReturn("God of War");
		Mockito.when(resultSet.getDate("datefrom")).thenReturn(Date.valueOf(LocalDate.parse("2020-05-31")));
		Mockito.when(resultSet.getDate("datedue")).thenReturn(Date.valueOf(LocalDate.parse("2020-06-01")));
		Mockito.when(resultSet.getInt("fine")).thenReturn(0);
		
		var result = dao.convertMyVideoGames(resultSet);
		
		var expected = List.of(new MyItem(511, "God of War", LocalDate.parse("2020-05-31"), LocalDate.parse("2020-06-01"), 0, "Game"));
		
		assertEquals(expected, result);
		
	}
	@Test void testConvertCount() throws SQLException {
		Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);
		Mockito.when(resultSet.getInt("TOTAL")).thenReturn(5);
		
		var result = dao.convertCount(resultSet);
		
		var expected = 5;
		
		assertEquals(expected, result);
	}
}