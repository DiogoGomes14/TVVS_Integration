package Bank.BankArtifact;

import java.util.ArrayList;

public class Bank {
	
	private ArrayList<Client> clients = new ArrayList<Client>();
	
	
	public Bank() {
		
	}
	
	/**
	 * @param client
	 * @param amount
	 * @return -1 if there isn't enough amount or 0 if the transaction went as expected
	 */
	public int withdrawClientAccount(Client client, float amount) {
		return client.withdrawMoney(amount);
	}
	
	public void depositAccount(Client client, float amount) {
		client.depositMoney(amount);
	}
	
	public void addClient(Client client) {
		clients.add(client);
	}
	
	public Client getClientByName(String name) {
		for(int i=0;i<clients.size();i++) {
			if(clients.get(i).getName() == name) {
				return clients.get(i);
			}
		}
		return null;
	}

	public int transfer(Client from, Client to, float amount) {
		if(from.withdrawMoney(amount) != -1) {
			to.depositMoney(amount);
			return 0;
		}
		return -1;
		
	}
}
