/**
 * @author Jaekyoung(Tony) An
 * This is a JUnit test for GIC class
 */
package test.btp400.a1;

import com.seneca.accounts.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class GICTest {

	@Test
	public void GICDefaultTest() {
		GIC gicDF;
		
		gicDF = new GIC();
		
		assertEquals("", gicDF.getFullName());
		assertEquals("", gicDF.getAccountNumber());
		assertEquals(0.0, gicDF.getBalance().doubleValue(), 0.0f);
		assertEquals(0.0125, gicDF.getII(), 0.0f);
		assertEquals(1, gicDF.getYears());
		
	}
	@Test
	public void GICNullTest() {
		
		GIC gicEmpty;
		
		gicEmpty = new GIC(null, null, -99.99,-1,-1);
		assertEquals("", gicEmpty.getFullName());
		assertEquals("", gicEmpty.getAccountNumber());
		assertEquals(0, gicEmpty.getBalance().doubleValue(), 0.0f);
		assertEquals(0.0, gicEmpty.getII(), 0.0f);
		assertEquals(0, gicEmpty.getYears());
	}
	@Test
	public void GICWithdrawTest() {
		
		GIC gicWD = new GIC();
		
		assertEquals(false, gicWD.withdraw(100.00));
	}
	@Test
	public void GICDepositTest() {
		GIC gicDP = new GIC("Abdul", "TD123", 500.55, 2, 0.025);
		
		gicDP.deposit(199.99);
		
		assertEquals(500.55, gicDP.getAccountBalance(), 0.0f);
	}
	
	@Test
	public void GICFinalBalCal() {
		GIC gicFB1 = new GIC("Matthew", "RBC321", 302.00, 1, 0.030);
		
		GIC gicFB2 = new GIC("Joshua", "TD321", 400.00, 2, 0.020);
		
		double db1 = gicFB1.getBalance().doubleValue();
		double db2 = gicFB2.getBalance().doubleValue();
		
		assertEquals(311.06, db1, 0.0f);
		assertEquals(416.16, db2, 0.0f);	
	}
	
	@Test
	public void GICInterestIncomeCalTest() {
		GIC gicII1 = new GIC("Kevin", "CIBC543", 202.50, 2, 0.035);
		
		double II1 = (202.50*Math.pow((1+0.035), 2)) - 202.50;
		double II2 = gicII1.getBalance().doubleValue() - 202.50;
		
		assertEquals(II1, II2, 2);
	}
	
	@Test
	public void GICInterestIncomeCalTest2() {
		GIC gicII2 = new GIC("Paul", "TD456", 504.13, 1, 0.015);
		
		double II1 = (504.13*Math.pow((1+0.015), 1)) - 504.13;
		double II2 = gicII2.getBalance().doubleValue() - 504.13;
		
		assertEquals(II1, II2, 2);
	}
}
