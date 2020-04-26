package com.hutb.cfs.solidity;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.2.0.
 */
public class Test extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50610360806100206000396000f3006080604052600436106100615763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663276f5c2481146100665780636d4ce63c146100995780638418cd99146100cc57806384967206146100f0575b600080fd5b34801561007257600080fd5b5061009773ffffffffffffffffffffffffffffffffffffffff60043516602435610108565b005b3480156100a557600080fd5b506100ae610191565b60408051938452602084019290925282820152519081900360600190f35b61009773ffffffffffffffffffffffffffffffffffffffff60043516602435610206565b3480156100fc57600080fd5b506100976004356102c4565b6000805460019081018083556040805160808101825273ffffffffffffffffffffffffffffffffffffffff968716815260208082019687528183018681526060830187815294875290859052919094209351845473ffffffffffffffffffffffffffffffffffffffff191696169590951783559251908201559151600283015551600390910155565b600160008190526020527fcc69885fda6bcc1a4ace058b4a62bf5e179ea78fd58a1ccd71c22cc9b6887930547fcc69885fda6bcc1a4ace058b4a62bf5e179ea78fd58a1ccd71c22cc9b6887931547fcc69885fda6bcc1a4ace058b4a62bf5e179ea78fd58a1ccd71c22cc9b688793254909192565b6000818152600160208181526040808420600281018054349081019091556003820180548601908190558351808501855273ffffffffffffffffffffffffffffffffffffffff8a81168252818701848152928952600485019096528488209051815473ffffffffffffffffffffffffffffffffffffffff1916908716178155905195019490945580549151909491909216926108fc811502929091818181858888f193505050501580156102be573d6000803e3d6000fd5b50505050565b60008181526001602081905260409091209081015460028201541115610330578054600282015460405173ffffffffffffffffffffffffffffffffffffffff9092169181156108fc0291906000818181858888f1935050505015801561032e573d6000803e3d6000fd5b505b50505600a165627a7a72305820242ba1cc1f94677d8f3aa3207daa5e3265db1934ea45903995532244b2b111250029";

    public static final String FUNC_NEWNEEDER = "NewNeeder";

    public static final String FUNC_GET = "get";

    public static final String FUNC_CONTRIBUTE = "contribute";

    public static final String FUNC_ISCOMPLETE = "IScomplete";

    @Deprecated
    protected Test(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Test(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Test(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Test(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> NewNeeder(String _Funeraddress, BigInteger _goal) {
        final Function function = new Function(
                FUNC_NEWNEEDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_Funeraddress), 
                new org.web3j.abi.datatypes.generated.Uint256(_goal)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple3<BigInteger, BigInteger, BigInteger>> get() {
        final Function function = new Function(FUNC_GET, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple3<BigInteger, BigInteger, BigInteger>>(
                new Callable<Tuple3<BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple3<BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<BigInteger, BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> contribute(String _address, BigInteger _neederAmouont, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_CONTRIBUTE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_address), 
                new org.web3j.abi.datatypes.generated.Uint256(_neederAmouont)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> IScomplete(BigInteger _neederAmouont) {
        final Function function = new Function(
                FUNC_ISCOMPLETE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_neederAmouont)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Test load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Test(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Test load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Test(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Test load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Test(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Test load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Test(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Test> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Test.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Test> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Test.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Test> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Test.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Test> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Test.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
