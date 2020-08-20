package org.online.booking.bus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.online.booking.bus.model.BookRequest;
import org.online.booking.bus.service.ServiceImpl;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ServiceImplTest {
	
	@Mock
	private ServiceImpl searcher;
	
	@Mock
	private BookRequest request;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@org.junit.jupiter.api.Test
	public void test() {
		System.out.println("Tetsing...");
		when(searcher.bookTicket(request)).thenReturn(1l);
		assertEquals(1l, searcher.bookTicket(request), "Mismatch result");
		System.out.println("Test pass...");
	}
	
	@AfterEach
	public void clean() {
		request=null;
	}
}
