package edu.uga.miashs.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.StaticArray16;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
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
public class Card extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b506040516102e0806105fb833981018060405281019080805190602001909291908051906020019092919080519060200190929190805190602001909291908051906020019092919080519060200190929190919082610200018051906020019092919050505087600060146101000a81548160ff021916908360ff16021790555086600060156101000a81548160ff021916908360ff16021790555085600060166101000a81548160ff021916908360ff16021790555084600060176101000a81548160ff021916908360ff16021790555083600060186101000a81548160ff021916908360ff16021790555082600060196101000a81548160ff021916908360ff16021790555081600190601061012a929190610158565b5060008054600160a060020a031916600160a060020a03929092169190911790555061020c95505050505050565b6001830191839082156101db5791602002820160005b838211156101ac57835183826101000a81548160ff021916908360ff160217905550926020019260010160208160000104928301926001030261016e565b80156101d95782816101000a81549060ff02191690556001016020816000010492830192600103026101ac565b505b506101e79291506101eb565b5090565b61020991905b808211156101e757805460ff191681556001016101f1565b90565b6103e08061021b6000396000f3006080604052600436106100985763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166308a96189811461009d57806340f4b00a146100c857806350437ed8146100dd578063750a4937146100f2578063805439bd146101405780639b597f7e14610155578063dfa6251f1461016a578063f891a6dd1461017f578063fe64d6ff146101bd575b600080fd5b3480156100a957600080fd5b506100b26101ed565b6040805160ff9092168252519081900360200190f35b3480156100d457600080fd5b506100b2610212565b3480156100e957600080fd5b506100b2610233565b3480156100fe57600080fd5b50610107610255565b604051808261020080838360005b8381101561012d578181015183820152602001610115565b5050505090500191505060405180910390f35b34801561014c57600080fd5b506100b26102ae565b34801561016157600080fd5b506100b26102d1565b34801561017657600080fd5b506100b26102f5565b34801561018b57600080fd5b5061019461031b565b6040805173ffffffffffffffffffffffffffffffffffffffff9092168252519081900360200190f35b3480156101c957600080fd5b506101eb73ffffffffffffffffffffffffffffffffffffffff60043516610337565b005b6000547801000000000000000000000000000000000000000000000000900460ff1690565b60005474010000000000000000000000000000000000000000900460ff1690565b6000547501000000000000000000000000000000000000000000900460ff1690565b61025d610394565b6040805161020081019182905290600190601090826000855b825461010083900a900460ff168152602060019283018181049485019490930390920291018084116102765790505050505050905090565b600054760100000000000000000000000000000000000000000000900460ff1690565b60005477010000000000000000000000000000000000000000000000900460ff1690565b600054790100000000000000000000000000000000000000000000000000900460ff1690565b60005473ffffffffffffffffffffffffffffffffffffffff1690565b6000543373ffffffffffffffffffffffffffffffffffffffff90811691161415610391576000805473ffffffffffffffffffffffffffffffffffffffff191673ffffffffffffffffffffffffffffffffffffffff83161790555b50565b6102006040519081016040528060109060208202803883395091929150505600a165627a7a72305820d01cd368d0a63c142a49360d512323ec03e2773599125531fe0de5045806c5e90029";

    protected Card(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Card(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<Uint8> getPolygonGreen() {
        Function function = new Function("getPolygonGreen", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Uint8> getBackgroundRed() {
        Function function = new Function("getBackgroundRed", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Uint8> getBackgroundGreen() {
        Function function = new Function("getBackgroundGreen", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<StaticArray16<Uint8>> getCoordinates() {
        Function function = new Function("getCoordinates", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<StaticArray16<Uint8>>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Uint8> getBackgroundBlue() {
        Function function = new Function("getBackgroundBlue", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Uint8> getPolygonRed() {
        Function function = new Function("getPolygonRed", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Uint8> getPolygonBlue() {
        Function function = new Function("getPolygonBlue", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Address> getAddressID() {
        Function function = new Function("getAddressID", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> changeAddress(Address newAddressID) {
        Function function = new Function(
                "changeAddress", 
                Arrays.<Type>asList(newAddressID), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<Card> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, Uint8 _backgroundRed, Uint8 _backgroundGreen, Uint8 _backgroundBlue, Uint8 _polygonRed, Uint8 _polygonGreen, Uint8 _polygonBlue, StaticArray16<Uint8> _coordinates, Address _owner) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_backgroundRed, _backgroundGreen, _backgroundBlue, _polygonRed, _polygonGreen, _polygonBlue, _coordinates, _owner));
        return deployRemoteCall(Card.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<Card> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, Uint8 _backgroundRed, Uint8 _backgroundGreen, Uint8 _backgroundBlue, Uint8 _polygonRed, Uint8 _polygonGreen, Uint8 _polygonBlue, StaticArray16<Uint8> _coordinates, Address _owner) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(_backgroundRed, _backgroundGreen, _backgroundBlue, _polygonRed, _polygonGreen, _polygonBlue, _coordinates, _owner));
        return deployRemoteCall(Card.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static Card load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Card(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Card load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Card(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
