package Bank.BankArtifact;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Bank.BankArtifact.Bank;
import Bank.BankArtifact.Client;

public class BankIT {
	public final float floatTolerance = 0.0001f;
	private Bank bank;
	
	@Before
    public void setUp() {
		// this is a simple abstraction from what would be a database connection
		// testing several systems with one simple test
		
		bank = new Bank();
		Client carlos = new Client("Carlos");
		Client melo = new Client("Melo");
		Client rui = new Client("Rui");
		
		bank.addClient(carlos);	bank.addClient(melo); bank.addClient(rui);
    }
	

	@Test
	public void testDepositAmount() {
		// use the functions depositAccount(Client,float) & getClientByName(String) from Bank

		Client carlos = bank.getClientByName("Carlos");
		assertEquals(carlos.getName(), "Carlos");

		float amount = 100;
		bank.depositAccount(carlos, amount);

		assertEquals(carlos.getAccount().getAmount(), amount, floatTolerance);
	}
	
	@Test
	public void testWithdrawAmount() {	
		// use the functions depositAccount(Client), getClientByName(String) & withdrawClientAccount(Client) from Bank
		Client melo = bank.getClientByName("Melo");
		assertEquals(melo.getName(), "Melo");

		float amountDeposited = 100;
		float amountWithdraw = 5.5f;
 		bank.depositAccount(melo, amountDeposited);

		bank.withdrawClientAccount(melo, amountWithdraw);

		assertEquals(melo.getAccount().getAmount(), amountDeposited - amountWithdraw, floatTolerance);
	}
	
	@Test
	public void testTransactionBetweenUsers() {
		// use the functions transfer(Client,Client,float) & getClientByName(String) from Bank
		Client melo = bank.getClientByName("Melo");
		Client rui = bank.getClientByName("Rui");

		assertEquals(melo.getName(), "Melo");
		assertEquals(rui.getName(), "Rui");

		float amountDeposited = 100;
		float transferAmount = 25;

		bank.depositAccount(melo, amountDeposited);

		bank.transfer(melo, rui, transferAmount);

		assertEquals(melo.getAccount().getAmount(), amountDeposited - transferAmount, floatTolerance);
		assertEquals(rui.getAccount().getAmount(), transferAmount, floatTolerance);
	}

}
