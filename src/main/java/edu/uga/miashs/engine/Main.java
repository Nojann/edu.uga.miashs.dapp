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
		linkEthereum.testNetwork(user);
		
		
	}

}
