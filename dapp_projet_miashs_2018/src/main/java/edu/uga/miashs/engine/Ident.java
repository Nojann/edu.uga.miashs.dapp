package edu.uga.miashs.engine;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

public class Ident {
	
	private Credentials credentials;
	
	private static final Logger log = LoggerFactory.getLogger(Ident.class);
	
	public Ident(String password, String localWallet) throws IOException, CipherException {
		
		credentials =  WalletUtils.loadCredentials(password, localWallet);
		
        log.info("Credentials loaded");  
        
	}
	
	public Credentials getCredentials() {
		return credentials;
	}

}
