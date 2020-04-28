package com.hutb.cfs.solidity;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple4;
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
public class Detail extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50610b48806100206000396000f3006080604052600436106100775763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416636b2c2336811461007c5780637c393035146100b25780639d66a9cd146100df578063a748e5db1461010f578063a7eace931461013f578063fdac32541461015f575b600080fd5b34801561008857600080fd5b5061009c610097366004610847565b610172565b6040516100a99190610a48565b60405180910390f35b3480156100be57600080fd5b506100d26100cd3660046107fa565b610184565b6040516100a991906109ef565b3480156100eb57600080fd5b506100ff6100fa366004610847565b610204565b6040516100a994939291906109b1565b34801561011b57600080fd5b5061012f61012a36600461092a565b610243565b6040516100a99493929190610a00565b34801561014b57600080fd5b506100d261015a36600461086d565b610452565b6100d261016d366004610847565b6105a3565b60009081526001602052604090205490565b6040805160808101825273ffffffffffffffffffffffffffffffffffffffff9485168152602080820194855260008284018181526060808501838152968352928290529390209151825473ffffffffffffffffffffffffffffffffffffffff19169616959095178155925160018401555160028301555160039091015590565b600090815260208190526040902080546001820154600283015460039093015473ffffffffffffffffffffffffffffffffffffffff9092169390929190565b60008281526001602052604081208054606092839283928291908790811061026757fe5b906000526020600020906004020190508060000181600101826002018360030154838054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561031d5780601f106102f25761010080835404028352916020019161031d565b820191906000526020600020905b81548152906001019060200180831161030057829003601f168201915b5050865460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152959950889450925084019050828280156103ab5780601f10610380576101008083540402835291602001916103ab565b820191906000526020600020905b81548152906001019060200180831161038e57829003601f168201915b5050855460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152959850879450925084019050828280156104395780601f1061040e57610100808354040283529160200191610439565b820191906000526020600020905b81548152906001019060200180831161041c57829003601f168201915b5050505050915094509450945094505092959194509250565b600085815260208190526040902060038101546060919015806104785750828160030154105b156104b85760408051808201909152600181527f300000000000000000000000000000000000000000000000000000000000000060208201529150610599565b6003810180548490039055600087815260016020818152604080842081516080810183528b81528084018b9052918201899052606082018890528054938401808255908552938290208151805192946004029091019261051d928492909101906106ec565b50602082810151805161053692600185019201906106ec565b50604082015180516105529160028401916020909101906106ec565b50606082015181600301555050506040805190810160405280600181526020017f310000000000000000000000000000000000000000000000000000000000000081525091505b5095945050505050565b60008181526020819052604090819020815181546c0100000000000000000000000073ffffffffffffffffffffffffffffffffffffffff909116028152915191829003601401909120606091907fc5d2460186f7233c927e7db2dcc703c0e500b653ca82273b7bfad8045d85a470146106af57805460405173ffffffffffffffffffffffffffffffffffffffff909116903480156108fc02916000818181858888f1935050505015801561065b573d6000803e3d6000fd5b5060028101805434908101909155600382018054909101905560408051808201909152600181527f3100000000000000000000000000000000000000000000000000000000000000602082015291506106e6565b60408051808201909152600181527f3000000000000000000000000000000000000000000000000000000000000000602082015291505b50919050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061072d57805160ff191683800117855561075a565b8280016001018555821561075a579182015b8281111561075a57825182559160200191906001019061073f565b5061076692915061076a565b5090565b61078491905b808211156107665760008155600101610770565b90565b60006107938235610aaf565b9392505050565b6000601f820183136107ab57600080fd5b81356107be6107b982610a83565b610a5c565b915080825260208301602083018583830111156107da57600080fd5b6107e5838284610ac8565b50505092915050565b60006107938235610784565b60008060006060848603121561080f57600080fd5b600061081b8686610787565b935050602061082c868287016107ee565b925050604061083d868287016107ee565b9150509250925092565b60006020828403121561085957600080fd5b600061086584846107ee565b949350505050565b600080600080600060a0868803121561088557600080fd5b600061089188886107ee565b955050602086013567ffffffffffffffff8111156108ae57600080fd5b6108ba8882890161079a565b945050604086013567ffffffffffffffff8111156108d757600080fd5b6108e38882890161079a565b935050606086013567ffffffffffffffff81111561090057600080fd5b61090c8882890161079a565b925050608061091d888289016107ee565b9150509295509295909350565b6000806040838503121561093d57600080fd5b600061094985856107ee565b925050602061095a858286016107ee565b9150509250929050565b61096d81610aaf565b82525050565b600061097e82610aab565b808452610992816020860160208601610ad4565b61099b81610b04565b9093016020019392505050565b61096d81610784565b608081016109bf8287610964565b6109cc60208301866109a8565b6109d960408301856109a8565b6109e660608301846109a8565b95945050505050565b602080825281016107938184610973565b60808082528101610a118187610973565b90508181036020830152610a258186610973565b90508181036040830152610a398185610973565b90506109e660608301846109a8565b60208101610a5682846109a8565b92915050565b60405181810167ffffffffffffffff81118282101715610a7b57600080fd5b604052919050565b600067ffffffffffffffff821115610a9a57600080fd5b506020601f91909101601f19160190565b5190565b73ffffffffffffffffffffffffffffffffffffffff1690565b82818337506000910152565b60005b83811015610aef578181015183820152602001610ad7565b83811115610afe576000848401525b50505050565b601f01601f1916905600a265627a7a72305820f18386d9f40598bf2caa506ea8795418764705c1ca67e64d0dedf7c1cd2609286c6578706572696d656e74616cf50037";

    public static final String FUNC_GETPHASESIZE = "getPhaseSize";

    public static final String FUNC_CREATEDETAIL = "createDetail";

    public static final String FUNC_GETDETAIL = "getDetail";

    public static final String FUNC_GETPHASE = "getPhase";

    public static final String FUNC_CREATEPHASE = "createPhase";

    public static final String FUNC_DONATION = "donation";

    @Deprecated
    protected Detail(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Detail(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Detail(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Detail(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<BigInteger> getPhaseSize(BigInteger _project_id) {
        final Function function = new Function(FUNC_GETPHASESIZE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_project_id)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> createDetail(String _wallet_address, BigInteger _target_amount, BigInteger _project_id) {
        final Function function = new Function(
                FUNC_CREATEDETAIL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_wallet_address), 
                new org.web3j.abi.datatypes.generated.Uint256(_target_amount), 
                new org.web3j.abi.datatypes.generated.Uint256(_project_id)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple4<String, BigInteger, BigInteger, BigInteger>> getDetail(BigInteger _project_id) {
        final Function function = new Function(FUNC_GETDETAIL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_project_id)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple4<String, BigInteger, BigInteger, BigInteger>>(
                new Callable<Tuple4<String, BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple4<String, BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<String, BigInteger, BigInteger, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue());
                    }
                });
    }

    public RemoteCall<Tuple4<String, String, String, BigInteger>> getPhase(BigInteger _project_id, BigInteger _index) {
        final Function function = new Function(FUNC_GETPHASE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_project_id), 
                new org.web3j.abi.datatypes.generated.Uint256(_index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple4<String, String, String, BigInteger>>(
                new Callable<Tuple4<String, String, String, BigInteger>>() {
                    @Override
                    public Tuple4<String, String, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<String, String, String, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> createPhase(BigInteger _project_id, String _time, String _title, String _description, BigInteger _spend) {
        final Function function = new Function(
                FUNC_CREATEPHASE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_project_id), 
                new org.web3j.abi.datatypes.Utf8String(_time), 
                new org.web3j.abi.datatypes.Utf8String(_title), 
                new org.web3j.abi.datatypes.Utf8String(_description), 
                new org.web3j.abi.datatypes.generated.Uint256(_spend)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> donation(BigInteger _project_id, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_DONATION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_project_id)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    @Deprecated
    public static Detail load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Detail(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Detail load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Detail(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Detail load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Detail(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Detail load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Detail(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Detail> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Detail.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Detail> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Detail.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Detail> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Detail.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Detail> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Detail.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
