package com.seneca.business;
import java.util.ArrayList;
import com.seneca.accounts.*;

	public class Bank {

		private ArrayList<Account> user;
		private String name;
		
		public Bank()
		{
			this(null);
		}
		
		public Bank(String name)
		{
			this.name = name != null ? name : "Seneca@York";
			user = new ArrayList<Account>();
		}
		
		
		public String getName() { return name; }
		
		public boolean addAccount(Account newAccount)
		{
			boolean result = false; // assume we haven't added any account yet
			
			if (newAccount == null)
			{
				return result; // if the added account is null, immediately return false
			}
					
			else 
			{
				for (Account account : user)
				{
					if (account.getAccountNumber().equals(newAccount.getAccountNumber()))
					{
						return result;
					}
				}
			
				user.add(newAccount);
				result = true;			
			}
			
			return result;
		}
		
		public Account removeAccount(String accountNumber)
		{
			if (accountNumber == null)
				return null;
			
			Account removed = null;
			
			int index = 0;
			
			for (int i = 0; i < user.size(); ++i)
			{
				if (user.get(i).getAccountNumber().equals(accountNumber))
				{
					removed = user.get(i);
					index = i;
					break;
				}
			}
			
			user.remove(index);
			
			return removed;
		}
		
		
		public String toString()
		{

			String result;

			result = "*** Welcome to the Bank of " + 
			this.name + " ***\n" + "It has " + this.user.size() + " user.\n";

			for (int i = 0; i < user.size(); i++) {
				result += i + 1 + ". number: " + this.user.get(i).getAccountNumber() + ", name: " + this.user.get(i).getFullName()
						+ ", balance: $" + String.format("%d", (int) this.user.get(i).getBalance().doubleValue()) + "\n";
			}
			return result;
		}
		
		@Override
		public boolean equals(Object obj)
		{
			boolean result = false; // Assume they aren't equal
			
			if (obj instanceof Bank)
			{
				
				Bank temp = (Bank) obj;
				
				if(this.name.equals(temp.name))
				{
					for (int i = 0; i < user.size(); ++i)
					{
						if(this.user.get(i).equals(temp.user.get(i)))
						{
							result = true;
						}
					}
				}
			}
			return result;
		}
		
		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 1;
			result = prime * result + ((user == null) ? 0 : user.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}
		
		
		public Account[] searchByBalance(double balance)
		{
			int count = 1;
			Account[] found = null;
			ArrayList<Account> toBeCopied = new ArrayList<Account>();
			
			if (balance < 0)
			{
				System.out.println("*** NO ACCOUNT FOUND ***");
				return found;
			}
			
			for (Account acc : user)
			{
				if (acc.getBalance().doubleValue() == balance)
				{	
					toBeCopied.add(acc);
				}
			}
			
			found = new Account[toBeCopied.size()];
			
			found = toBeCopied.toArray(found);
			
			System.out.println("We have found " + found.length + " accounts whose balance is " + String.format("%d", (int)balance) + ".");
			
			for (int i = 0; i < found.length; ++i)
			{
				System.out.println(count + ". number: " + found[i].getAccountNumber() + ", name: " + found[i].getFullName());
				count++;
			}
			
			
			return found;
		}
		
		
		public Account[] searchByAccountName(String accountName)
		{
			ArrayList<Account> sameName = new ArrayList<>();

	        for(Account a: user){
	            if(a.getFullName().matches(accountName)){
	                sameName.add(a);
	            }
	        }

	        Account[] matchArray = new Account[sameName.size()];
	        return sameName.toArray(matchArray);
		}
		
		public int getBankSize()
		{
			return user.size();
		}
		
		public Account[] getAllAccounts()
		{
			Account[] allAccounts = new Account[user.size()];
			
			for (int i = 0; i < user.size(); ++i)
			{
				allAccounts[i] = user.get(i);
			}
			
			return allAccounts;
		}
		
		public Account findAccountToEdit(String accountNumber)
		{
			Account toBeReturned = null;
			
			for (int i = 0; i < user.size(); ++i)
			{
				if (user.get(i).getAccountNumber().equals(accountNumber))
				{
					toBeReturned = user.get(i);
					break;
				}
			}
			return toBeReturned;
		}
		
		public GIC findGICAccount(String fullName)
		{
			for (int i = 0; i < user.size(); ++i)
			{
				if (user.get(i).getFullName().equals(fullName))
				{
					if (user.get(i) instanceof GIC)
					{
						return (GIC) user.get(i);
					}
				}
			}
			return null;
		}
}
