/**
* @author Jaekyoung(Tony) An
* This is a JUnit test for Chequing class
*/
package test.btp400.a1;

import com.seneca.accounts.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class ChequingTest {

	@Test
	public void chequeConstTest(){
		Chequing cq1, cq2, cq3;
		
		cq3 = new Chequing();
		
		cq1 = new Chequing(null, null, -99.99, -99.99, 0);
		
		assertEquals("", cq1.getFullName());
		assertEquals("", cq1.getAccountNumber());
		assertEquals(0.0, cq1.getBalance().doubleValue(), 0.0f);
		assertEquals(0.0, cq1.getServiceCharge(), 0.0f);
		assertEquals(0, cq1.getMaxTransNum());
		
		assertEquals("", cq3.getFullName());
		assertEquals("", cq3.getAccountNumber());
		assertEquals(0.0, cq3.getBalance().doubleValue(), 0.0f);
		assertEquals(0.25, cq3.getServiceCharge(), 0.0f);
		assertEquals(3, cq3.getMaxTransNum());
		
		cq2 = new Chequing("Tony", "CIBC123", 100.00, 0.25, 2);
		
		assertEquals("Tony", cq2.getFullName());
		assertEquals("CIBC123", cq2.getAccountNumber());
		assertEquals(100.00, cq2.getBalance().doubleValue(), 0.0f);
		assertEquals(0.25, cq2.getServiceCharge(), 0.0f);
		assertEquals(2, cq2.getMaxTransNum());
		
		cq2.withdraw(99.00);
		cq2.deposit(99.00);
		//cq2.withdraw(99.00); // to test exceeding number of transactions
		//cq2.deposit(99.00); // to test exceeding number of transactions
		assertEquals(99.50, cq2.getBalanceFinal(), 0.0f);
		assertEquals(0.50, cq2.getMaxCharges(), 0.0f);
		
		
	}
}