/**
 * JUnit test case for Account class
 * @author Jaekyoung (Tony) An
 */
package test.btp400.a1;

import static org.junit.Assert.*;

import org.junit.Test;

import com.seneca.accounts.Account;

public class AccountTest {

	@Test
	public void testAccount() {

		Account a1, a2, a3;
		
		a1 = new Account("Jaekyoung, An", "A1234", 599.99);
	
		a2 = new Account(null, null, -100.00);
		
		a3 = new Account();
		
		assertEquals("Jaekyoung, An", a1.getFullName());
		assertEquals(0.0, a2.getBalance().doubleValue(), 0.0f);
		assertEquals("", a3.getFullName());
	
	}
	
}
