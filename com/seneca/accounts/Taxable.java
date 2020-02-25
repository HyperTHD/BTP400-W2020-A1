/**
 * This is the Taxable Interface
 * This defines an interface that explains what a banking account needs to be known as an account that is taxable
 * 
 * @author Abdulbasid Guled
 */
package com.seneca.accounts;

public interface Taxable {
	
	double taxRate = 0.15;

	public void calculateTax();
	public double getTaxAmount();
	public String createTaxStatement();
}
