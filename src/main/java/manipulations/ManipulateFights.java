package manipulations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.uga.miashs.engine.Ident;
import edu.uga.miashs.engine.LinkEthereum;

public class ManipulateFights {
	
	public static void main(String[] args) throws Exception {
	
	final Logger log = LoggerFactory.getLogger(ManipulateFights.class);
	
	Ident user = new Ident("00x","/home/xvg/Documents/DAPP/wallet/UTC--2018-02-15T16-22-25.679000000Z--c1ef8e5d87342b1094ba82a8ab81f54124d26163.json");
	LinkEthereum link = new LinkEthereum();
	
	link.connection();	
	link.testNetwork(user);
	
	
	
	
	}
}
