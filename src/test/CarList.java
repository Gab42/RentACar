package test;

import org.junit.Before;
import org.junit.Test;

import com.lyft.ListCars;

import static org.junit.Assert.*;

public class CarList {
	@Test
	public void test() {
		 ListCars service = new ListCars();
		 String message = service.test();
		 assertEquals( "test", message );
	}
}
