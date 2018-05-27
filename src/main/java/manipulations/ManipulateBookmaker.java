package manipulations;

import java.math.BigInteger;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;

import edu.uga.miashs.contracts.Bookmaker;
import edu.uga.miashs.contracts.Card;
import edu.uga.miashs.engine.Ident;
import edu.uga.miashs.engine.LinkEthereum;

public class ManipulateBookmaker {
	public static void main(String[] args) throws Exception {
		
		final Logger log = LoggerFactory.getLogger(ManipulateBookmaker.class);
		
		Ident user = new Ident("00x","/home/xvg/Documents/DAPP/wallet/UTC--2018-02-15T16-22-25.679000000Z--c1ef8e5d87342b1094ba82a8ab81f54124d26163.json");
		LinkEthereum link = new LinkEthereum();
		
		link.connection();	
		link.testNetwork(user);
		
		BigInteger price = new BigInteger("7400000");
		BigInteger limit = new BigInteger("7500000");
		Bookmaker contract;
		
		log.info("Bookmaker deploy...");
		
		//Déploiment
		if(true) {
			contract = Bookmaker.deploy(link.getWeb3j(), user.getCredentials(), price, limit).send();
			//0xe7b5fd07f96fd0aa60e9462ae2964de8ef8900ae
		}
		
		log.info("Contract deployed to "+contract.getContractAddress());
		
		Card card = ManipulateCard.createCard();
		Address cardAddress = new Address(card.getContractAddress());
		
		contract.newFight(cardAddress).send();
		
		log.info("New Fight");
		
		DynamicArray<Address> result = contract.getListOfFights().send();
		
		result.getValue();
		
		log.info("List of fight : "+result);
		
	}
}
