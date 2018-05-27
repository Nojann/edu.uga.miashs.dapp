package edu.uga.miashs.engine;


public class Main {
	
	public static void main(String[] args) throws Exception {
		
		Ident user = new Ident("00x","/home/xvg/Documents/DAPP/wallet/UTC--2018-02-15T16-22-25.679000000Z--c1ef8e5d87342b1094ba82a8ab81f54124d26163.json");
		LinkEthereum linkEthereum = new LinkEthereum();
		
		linkEthereum.connection();
		linkEthereum.testNetwork(user);
		
		
	}

}
