package edu.uga.miashs.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.2.0.
 */
public class Fight extends Contract {
    private static final String BINARY = "6080604052348015600f57600080fd5b5060405160608060ae83398101604090815281516020830151919092015160018054600160a060020a0319908116600160a060020a0395861617909155600280548216938516939093179092556000805490921692169190911781556035908190607990396000f3006080604052600080fd00a165627a7a72305820b83acb1841db9a1c40523fa18bb95ef2f9ca580409f4839b1acff9ea381937920029";

    protected Fight(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Fight(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static RemoteCall<Fight> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, Address _provoker, Address _card, Address _bookmaker) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_provoker, _card, _bookmaker));
        return deployRemoteCall(Fight.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<Fight> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, Address _provoker, Address _card, Address _bookmaker) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_provoker, _card, _bookmaker));
        return deployRemoteCall(Fight.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static Fight load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Fight(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Fight load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Fight(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
