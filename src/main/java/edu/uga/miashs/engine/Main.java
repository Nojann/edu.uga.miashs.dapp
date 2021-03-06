package edu.uga.miashs.engine;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.StaticArray16;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;

import edu.uga.miashs.contracts.Card;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		final Logger log = LoggerFactory.getLogger(Main.class);
		
		Ident user = new Ident("00x","/home/xvg/Documents/DAPP/wallet/UTC--2018-02-15T16-22-25.679000000Z--c1ef8e5d87342b1094ba82a8ab81f54124d26163.json");
		LinkEthereum linkEthereum = new LinkEthereum();
		
		linkEthereum.connection();	
		//linkEthereum.testNetwork(user);
		
		//Déclaration des variables de carte
		Uint8 bgRed = new Uint8(1);
		Uint8 bgGreen = new Uint8(2);
		Uint8 bgBlue = new Uint8(3);
		Uint8 polRed = new Uint8(4);
		Uint8 polBlue = new Uint8(5);
		Uint8 polGreen = new Uint8(6);
		
		StaticArray16<Uint8> coordonnees = new StaticArray16<Uint8>(new Uint8(1),new Uint8(2),new Uint8(3),new Uint8(4),
		new Uint8(5),new Uint8(6), new Uint8(7), new Uint8(8),
		new Uint8(1),new Uint8(2),new Uint8(3),new Uint8(4),
		new Uint8(5),new Uint8(6), new Uint8(7), new Uint8(8));
		
		Address ownerAddress = new Address("c1ef8e5d87342b1094ba82a8ab81f54124d26163");
		
		//Prix + limites : chercher sur internet les valeurs
		BigInteger gasPrice = new BigInteger("7000000");
		BigInteger gasLimit = new BigInteger("7500000"); //Limite autour de 7 millions$
		
		log.info("Card load...");
		
		//Déploiment
		/*Card contract = Card.deploy(
		        linkEthereum.getWeb3j(), user.getCredentials(), gasPrice, gasLimit,
		        bgRed, bgGreen, bgBlue, polGreen, polRed, polBlue, coordonnees, ownerAddress).send();
		
		
		log.info("Contract Card deployed to "+contract.getContractAddress());*/
		
		String contractAddress ="0x788e048b480940ace4ae8103171654c6e576d80b";
		
		Card card = Card.load(contractAddress, linkEthereum.getWeb3j(), user.getCredentials(), gasPrice, gasLimit);
		
		log.info("Card loaded : "+card.getContractAddress());
		
		Uint8 result = card.getPolygonGreen().send();
		
		log.info("PolygonGreen : "+result.getValue());
		
		
		
	}

}
