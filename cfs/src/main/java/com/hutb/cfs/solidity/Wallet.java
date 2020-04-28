package com.hutb.cfs.solidity;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
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
public class Wallet extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50610c87806100206000396000f30060806040526004361061006c5763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166308f20630811461007157806316db5156146100a757806340668f79146100d4578063b3c0f143146100f6578063b5918ad114610116575b600080fd5b34801561007d57600080fd5b5061009161008c366004610a8c565b610136565b60405161009e9190610b76565b60405180910390f35b3480156100b357600080fd5b506100c76100c2366004610a8c565b6101bb565b60405161009e9190610b8a565b3480156100e057600080fd5b506100f46100ef3660046109e3565b6102b8565b005b34801561010257600080fd5b506100c7610111366004610a8c565b6103bd565b34801561012257600080fd5b506100c7610131366004610ac9565b61066e565b6000806000836040518082805190602001908083835b6020831061016b5780518252601f19909201916020918201910161014c565b51815160209384036101000a60001901801990921691161790529201948552506040519384900301909220805473ffffffffffffffffffffffffffffffffffffffff169450925050505b50919050565b6060600080836040518082805190602001908083835b602083106101f05780518252601f1990920191602091820191016101d1565b518151600019602094850361010090810a8201928316921993909316919091179092529490920196875260408051978890038201882060018181018054601f600293821615909902909601909516049586018390048302890183019091528488529750909450919250508301828280156102ab5780601f10610280576101008083540402835291602001916102ab565b820191906000526020600020905b81548152906001019060200180831161028e57829003601f168201915b5050505050915050919050565b6060604051908101604052808573ffffffffffffffffffffffffffffffffffffffff168152602001848152602001838152506000826040518082805190602001908083835b6020831061031c5780518252601f1990920191602091820191016102fd565b51815160209384036101000a60001901801990921691161790529201948552506040519384900381019093208451815473ffffffffffffffffffffffffffffffffffffffff191673ffffffffffffffffffffffffffffffffffffffff9091161781558484015180519194610398945060018601935001906108e1565b50604082015180516103b49160028401916020909101906108e1565b50505050505050565b6060806000836040518082805190602001908083835b602083106103f25780518252601f1990920191602091820191016103d3565b518151600019602094850361010090810a8201928316921993909316919091179092529490920196875260408051978890038201882060029081018054601f6001821615909802909501909416049485018290048202880182019052838752909450919250508301828280156104a95780601f1061047e576101008083540402835291602001916104a9565b820191906000526020600020905b81548152906001019060200180831161048c57829003601f168201915b505060405184519495507fc5d2460186f7233c927e7db2dcc703c0e500b653ca82273b7bfad8045d85a4709486945090925082915060208401908083835b602083106105065780518252601f1990920191602091820191016104e7565b6001836020036101000a038019825116818451168082178552505050505050905001915050604051809103902060001916141515610633576000836040518082805190602001908083835b602083106105705780518252601f199092019160209182019101610551565b518151600019602094850361010090810a8201928316921993909316919091179092529490920196875260408051978890038201882060029081018054601f6001821615909802909501909416049485018290048202880182019052838752909450919250508301828280156106275780601f106105fc57610100808354040283529160200191610627565b820191906000526020600020905b81548152906001019060200180831161060a57829003601f168201915b505050505091506101b5565b60408051808201909152600181527f3000000000000000000000000000000000000000000000000000000000000000602082015291506101b5565b6060806000846040518082805190602001908083835b602083106106a35780518252601f199092019160209182019101610684565b518151600019602094850361010090810a8201928316921993909316919091179092529490920196875260408051978890038201882060029081018054601f60018216159098029095019094160494850182900482028801820190528387529094509192505083018282801561075a5780601f1061072f5761010080835404028352916020019161075a565b820191906000526020600020905b81548152906001019060200180831161073d57829003601f168201915b505060405184519495507fc5d2460186f7233c927e7db2dcc703c0e500b653ca82273b7bfad8045d85a4709486945090925082915060208401908083835b602083106107b75780518252601f199092019160209182019101610798565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040518091039020600019161415156108a357826000856040518082805190602001908083835b602083106108225780518252601f199092019160209182019101610803565b51815160209384036101000a600019018019909216911617905292019485525060405193849003810190932084516108679560029092019491909101925090506108e1565b5060408051808201909152600181527f3100000000000000000000000000000000000000000000000000000000000000602082015291506108da565b60408051808201909152600181527f3000000000000000000000000000000000000000000000000000000000000000602082015291505b5092915050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061092257805160ff191683800117855561094f565b8280016001018555821561094f579182015b8281111561094f578251825591602001919060010190610934565b5061095b92915061095f565b5090565b61097991905b8082111561095b5760008155600101610965565b90565b60006109888235610bee565b9392505050565b6000601f820183136109a057600080fd5b81356109b36109ae82610bc2565b610b9b565b915080825260208301602083018583830111156109cf57600080fd5b6109da838284610c07565b50505092915050565b600080600080608085870312156109f957600080fd5b6000610a05878761097c565b945050602085013567ffffffffffffffff811115610a2257600080fd5b610a2e8782880161098f565b935050604085013567ffffffffffffffff811115610a4b57600080fd5b610a578782880161098f565b925050606085013567ffffffffffffffff811115610a7457600080fd5b610a808782880161098f565b91505092959194509250565b600060208284031215610a9e57600080fd5b813567ffffffffffffffff811115610ab557600080fd5b610ac18482850161098f565b949350505050565b60008060408385031215610adc57600080fd5b823567ffffffffffffffff811115610af357600080fd5b610aff8582860161098f565b925050602083013567ffffffffffffffff811115610b1c57600080fd5b610b288582860161098f565b9150509250929050565b610b3b81610bee565b82525050565b6000610b4c82610bea565b808452610b60816020860160208601610c13565b610b6981610c43565b9093016020019392505050565b60208101610b848284610b32565b92915050565b602080825281016109888184610b41565b60405181810167ffffffffffffffff81118282101715610bba57600080fd5b604052919050565b600067ffffffffffffffff821115610bd957600080fd5b506020601f91909101601f19160190565b5190565b73ffffffffffffffffffffffffffffffffffffffff1690565b82818337506000910152565b60005b83811015610c2e578181015183820152602001610c16565b83811115610c3d576000848401525b50505050565b601f01601f1916905600a265627a7a723058207f42123611412f1032e1c8f745b2708172000f7e35ce72ef826f2eef4e2fc93c6c6578706572696d656e74616cf50037";

    public static final String FUNC_GETWALLETADDRESS = "getWalletAddress";

    public static final String FUNC_GETWALLETHASH = "getWalletHash";

    public static final String FUNC_CREATEWALLET = "createWallet";

    public static final String FUNC_GETWALLETPASSWORD = "getWalletPassword";

    public static final String FUNC_UPDATEWALLETPASSWORD = "updateWalletPassword";

    @Deprecated
    protected Wallet(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Wallet(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Wallet(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Wallet(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<String> getWalletAddress(String _uuid) {
        final Function function = new Function(FUNC_GETWALLETADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_uuid)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> getWalletHash(String _uuid) {
        final Function function = new Function(FUNC_GETWALLETHASH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_uuid)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> createWallet(String _wallet_address, String _hash, String _password, String _uuid) {
        final Function function = new Function(
                FUNC_CREATEWALLET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_wallet_address), 
                new org.web3j.abi.datatypes.Utf8String(_hash), 
                new org.web3j.abi.datatypes.Utf8String(_password), 
                new org.web3j.abi.datatypes.Utf8String(_uuid)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> getWalletPassword(String _uuid) {
        final Function function = new Function(FUNC_GETWALLETPASSWORD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_uuid)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> updateWalletPassword(String _uuid, String now_password) {
        final Function function = new Function(
                FUNC_UPDATEWALLETPASSWORD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_uuid), 
                new org.web3j.abi.datatypes.Utf8String(now_password)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Wallet load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Wallet(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Wallet load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Wallet(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Wallet load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Wallet(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Wallet load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Wallet(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Wallet> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Wallet.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Wallet> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Wallet.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Wallet> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Wallet.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Wallet> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Wallet.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
