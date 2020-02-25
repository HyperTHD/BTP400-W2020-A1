/**
 * JUnit test case for Bank
 * @author Jaekyoung (Tony) An
 */

package test.btp400.a1;

import static org.junit.Assert.*;

import org.junit.Test;
import com.seneca.business.Bank;
import com.seneca.accounts.*;

public class BankTest {

	@Test
	public void testBank() {
		
		Bank b1, b2, b3;
		
		b1 = new Bank(null);
		b2 = new Bank("Dokdo's Resturant");
		b3 = new Bank();
		
		assertEquals("Seneca@York", b1.getName());
		assertEquals("Dokdo's Resturant", b2.getName());
		assertEquals("Seneca@York", b3.getName());
	}
	
	@Test
	public void testSearchByBalance()
	{
		Bank Me = new Bank("Abdulbasid, Guled");
		
		Chequing toCheck = new Chequing("Abdulbasid", "A1234", 1000.00, 0.25, 5);
		Chequing toCheck1 = new Chequing("Abdulbasid", "B1234", 1000.00, 0.25, 5);
		
		Me.addAccount(toCheck);
		Me.addAccount(toCheck1);
	
		Account[] allMine = Me.searchByBalance(1000.00);
		
		assertEquals(toCheck, allMine[0]);
		
	}
	
	@Test
	public void testSearchByName()
	{
		Bank Me = new Bank("Abdulbasid, Guled");
		Bank Tony = new Bank("Jaekyoung, An");
		
		Chequing toCheck = new Chequing("Abdulbasid", "A1234", 1000.00, 0.25, 5);
		Chequing toCheck1 = new Chequing("Tony", "B1234", 1000.00, 0.25, 5);
		GIC toCheck2 = new GIC("Abdulbasid", "A2345", 2000.00, 3, 1.25);
		GIC toCheck3 = new GIC("Tony", "B2345", 2000.00, 3, 1.25);
		
		Me.addAccount(toCheck);
		Me.addAccount(toCheck2);
		Tony.addAccount(toCheck1);
		Tony.addAccount(toCheck3);
		
		Account[] myName = Me.searchByAccountName("Abdulbasid");
		
		assertEquals(toCheck, myName[0]);
	}

}
