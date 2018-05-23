package edu.uga.miashs.engine;

import java.io.IOException;
import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.exceptions.TransactionException;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

public class LinkEthereum {
	
	private Web3j web3j;
	
	private static final Logger log = LoggerFactory.getLogger(LinkEthereum.class);
	
	public LinkEthereum() {
		
	}
	
	public void connection() throws IOException {
		
		
		web3j = Web3j.build(new HttpService("https://rinkeby.infura.io"));
		log.info("Connected to Ethereum client version: "
                + web3j.web3ClientVersion().send().getWeb3ClientVersion());
		
	}
	
	public void testNetwork(Ident ident) throws InterruptedException, IOException, TransactionException, Exception {
		
		log.info("Sending 1 Wei ("
                + Convert.fromWei("1", Convert.Unit.ETHER).toPlainString() + " Ether)");
        TransactionReceipt transferReceipt = Transfer.sendFunds(
                web3j, ident.getCredentials(),
                "0x19e03255f667bdfd50a32722df860b1eeaf4d635", //Adresse à redefinir, ici aléatoire.
                BigDecimal.ONE, Convert.Unit.WEI)  // 1 wei = 10^-18 Ether
                .send();
        log.info("Transaction complete, view it at https://rinkeby.etherscan.io/tx/"
                + transferReceipt.getTransactionHash());
		
	}
	
	public Web3j getWeb3j() {
		return web3j;
	}
	
	
}
