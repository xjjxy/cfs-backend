package com.hutb.cfs.solidity;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint32;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple5;
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
public class User extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50611880806100206000396000f3006080604052600436106100da5763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166301b8c31c81146100df57806307e084eb146101155780631d98ed8f146101425780632fed7bda146101645780634685bf86146101845780634d3d096b146101b557806385b78d4a146101e2578063b3c0f1431461020f578063bcd3a3151461022f578063c040ebec1461024f578063c914b1e814610264578063daa1ee4014610284578063e9bf9f68146102a4578063f0008783146102c4578063fe97607c146102e4575b600080fd5b3480156100eb57600080fd5b506100ff6100fa36600461141f565b610304565b60405161010c9190611701565b60405180910390f35b34801561012157600080fd5b5061013561013036600461141f565b6103fd565b60405161010c91906116df565b34801561014e57600080fd5b5061016261015d366004611504565b61047e565b005b34801561017057600080fd5b506100ff61017f36600461166b565b6104ff565b34801561019057600080fd5b506101a461019f36600461141f565b610598565b60405161010c959493929190611712565b3480156101c157600080fd5b506101d56101d036600461141f565b6109f9565b60405161010c9190611778565b3480156101ee57600080fd5b506102026101fd36600461141f565b610a19565b60405161010c91906116f3565b34801561021b57600080fd5b506100ff61022a36600461141f565b610b77565b34801561023b57600080fd5b5061016261024a366004611504565b610c37565b34801561025b57600080fd5b506101d5610ce3565b34801561027057600080fd5b5061016261027f366004611504565b610cea565b34801561029057600080fd5b5061016261029f366004611504565b610d62565b3480156102b057600080fd5b506101626102bf36600461156d565b610dda565b3480156102d057600080fd5b506101626102df36600461145c565b6110d7565b3480156102f057600080fd5b506101626102ff366004611504565b6112a0565b60606001826040518082805190602001908083835b602083106103385780518252601f199092019160209182019101610319565b518151600019602094850361010090810a8201928316921993909316919091179092529490920196875260408051978890038201882060019081018054601f600293821615909802909501909416049485018290048202880182019052838752909450919250508301828280156103f05780601f106103c5576101008083540402835291602001916103f0565b820191906000526020600020905b8154815290600101906020018083116103d357829003601f168201915b505050505090505b919050565b60006001826040518082805190602001908083835b602083106104315780518252601f199092019160209182019101610412565b51815160209384036101000a600019018019909216911617905292019485525060405193849003019092206005015473ffffffffffffffffffffffffffffffffffffffff16949350505050565b806001836040518082805190602001908083835b602083106104b15780518252601f199092019160209182019101610492565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060010190805190602001906104fa929190611314565b505050565b6060734cd2950349b13e33a57c9966784ee5f2bd345394331461052157600080fd5b6000805463ffffffff841690811061053557fe5b600091825260209182902001805460408051601f60026000196101006001871615020190941693909304928301859004850281018501909152818152928301828280156103f05780601f106103c5576101008083540402835291602001916103f0565b60608060608060006001866040518082805190602001908083835b602083106105d25780518252601f1990920191602091820191016105b3565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405180910390206002016001876040518082805190602001908083835b6020831061063a5780518252601f19909201916020918201910161061b565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405180910390206003016001886040518082805190602001908083835b602083106106a25780518252601f199092019160209182019101610683565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405180910390206004016001896040518082805190602001908083835b6020831061070a5780518252601f1990920191602091820191016106eb565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060060160018a6040518082805190602001908083835b602083106107725780518252601f199092019160209182019101610753565b518151600019602094850361010090810a82019283169219939093169190911790925294909201968752604080519788900382018820600801548c54601f600260018316159098029095011695909504928301829004820288018201905281875263ffffffff9093169594508993509184019050828280156108355780601f1061080a57610100808354040283529160200191610835565b820191906000526020600020905b81548152906001019060200180831161081857829003601f168201915b5050875460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152959a50899450925084019050828280156108c35780601f10610898576101008083540402835291602001916108c3565b820191906000526020600020905b8154815290600101906020018083116108a657829003601f168201915b5050865460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152959950889450925084019050828280156109515780601f1061092657610100808354040283529160200191610951565b820191906000526020600020905b81548152906001019060200180831161093457829003601f168201915b5050855460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152959850879450925084019050828280156109df5780601f106109b4576101008083540402835291602001916109df565b820191906000526020600020905b8154815290600101906020018083116109c257829003601f168201915b505050505091509450945094509450945091939590929450565b6000610a0482610a19565b15610a11575060016103f8565b5060006103f8565b600080541515610a2b575060006103f8565b816040518082805190602001908083835b60208310610a5b5780518252601f199092019160209182019101610a3c565b51815160209384036101000a60001901801990921691161790526040519190930181900381208751909550600094506002938893508291908401908083835b60208310610ab95780518252601f199092019160209182019101610a9a565b51815160209384036101000a6000190180199092169116179052920194855250604051938490030190922054835463ffffffff909116925082109050610afb57fe5b906000526020600020016040518082805460018160011615610100020316600290048015610b605780601f10610b3e576101008083540402835291820191610b60565b820191906000526020600020905b815481529060010190602001808311610b4c575b505060405190819003902092909214949350505050565b60606001826040518082805190602001908083835b60208310610bab5780518252601f199092019160209182019101610b8c565b518151600019602094850361010090810a820192831692199390931691909117909252949092019687526040805197889003820188206007018054601f60026001831615909802909501169590950492830182900482028801820190528187529294509250508301828280156103f05780601f106103c5576101008083540402835291602001916103f0565b734cd2950349b13e33a57c9966784ee5f2bd3453943314610c5757600080fd5b610c6082610a19565b1515610c6b57600080fd5b806001836040518082805190602001908083835b60208310610c9e5780518252601f199092019160209182019101610c7f565b51815160209384036101000a600019018019909216911617905292019485525060405193849003810190932084516104fa956004909201949190910192509050611314565b6000545b90565b806001836040518082805190602001908083835b60208310610d1d5780518252601f199092019160209182019101610cfe565b51815160209384036101000a600019018019909216911617905292019485525060405193849003810190932084516104fa956007909201949190910192509050611314565b806001836040518082805190602001908083835b60208310610d955780518252601f199092019160209182019101610d76565b51815160209384036101000a600019018019909216911617905292019485525060405193849003810190932084516104fa956002909201949190910192509050611314565b734cd2950349b13e33a57c9966784ee5f2bd3453943314610dfa57600080fd5b610e0386610a19565b15610e0d57600080fd5b60008054600181018083559180528751610e4e917f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e563019060208a0190611314565b505061012060405190810160405280878152602001868152602001858152602001848152602001838152602001600073ffffffffffffffffffffffffffffffffffffffff16815260200160206040519081016040528060008152508152602001602060405190810160405280600081525081526020018263ffffffff168152506001876040518082805190602001908083835b60208310610f005780518252601f199092019160209182019101610ee1565b51815160209384036101000a6000190180199092169116179052920194855250604051938490038101909320845180519194610f4194508593500190611314565b506020828101518051610f5a9260018501920190611314565b5060408201518051610f76916002840191602090910190611314565b5060608201518051610f92916003840191602090910190611314565b5060808201518051610fae916004840191602090910190611314565b5060a082015160058201805473ffffffffffffffffffffffffffffffffffffffff191673ffffffffffffffffffffffffffffffffffffffff90921691909117905560c0820151805161100a916006840191602090910190611314565b5060e08201518051611026916007840191602090910190611314565b5061010091909101516008909101805463ffffffff191663ffffffff9092169190911790556000546040518751600019909201916002918991819060208401908083835b602083106110895780518252601f19909201916020918201910161106a565b51815160209384036101000a60001901801990921691161790529201948552506040519384900301909220805463ffffffff191663ffffffff94909416939093179092555050505050505050565b734cd2950349b13e33a57c9966784ee5f2bd34539433146110f757600080fd5b61110084610a19565b151561110b57600080fd5b826001856040518082805190602001908083835b6020831061113e5780518252601f19909201916020918201910161111f565b51815160209384036101000a60001901801990921691161790529201948552506040519384900381018420600501805473ffffffffffffffffffffffffffffffffffffffff191673ffffffffffffffffffffffffffffffffffffffff9690961695909517909455505085518492600192889290918291908401908083835b602083106111db5780518252601f1990920191602091820191016111bc565b51815160209384036101000a60001901801990921691161790529201948552506040519384900381019093208451611220956006909201949190910192509050611314565b50806001856040518082805190602001908083835b602083106112545780518252601f199092019160209182019101611235565b51815160209384036101000a60001901801990921691161790529201948552506040519384900381019093208451611299956007909201949190910192509050611314565b5050505050565b806001836040518082805190602001908083835b602083106112d35780518252601f1990920191602091820191016112b4565b51815160209384036101000a600019018019909216911617905292019485525060405193849003810190932084516104fa9560039092019491909101925090505b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061135557805160ff1916838001178555611382565b82800160010185558215611382579182015b82811115611382578251825591602001919060010190611367565b5061138e929150611392565b5090565b610ce791905b8082111561138e5760008155600101611398565b60006113b882356117d9565b9392505050565b6000601f820183136113d057600080fd5b81356113e36113de826117ad565b611786565b915080825260208301602083018583830111156113ff57600080fd5b61140a838284611800565b50505092915050565b60006113b882356117f7565b60006020828403121561143157600080fd5b813567ffffffffffffffff81111561144857600080fd5b611454848285016113bf565b949350505050565b6000806000806080858703121561147257600080fd5b843567ffffffffffffffff81111561148957600080fd5b611495878288016113bf565b94505060206114a6878288016113ac565b935050604085013567ffffffffffffffff8111156114c357600080fd5b6114cf878288016113bf565b925050606085013567ffffffffffffffff8111156114ec57600080fd5b6114f8878288016113bf565b91505092959194509250565b6000806040838503121561151757600080fd5b823567ffffffffffffffff81111561152e57600080fd5b61153a858286016113bf565b925050602083013567ffffffffffffffff81111561155757600080fd5b611563858286016113bf565b9150509250929050565b60008060008060008060c0878903121561158657600080fd5b863567ffffffffffffffff81111561159d57600080fd5b6115a989828a016113bf565b965050602087013567ffffffffffffffff8111156115c657600080fd5b6115d289828a016113bf565b955050604087013567ffffffffffffffff8111156115ef57600080fd5b6115fb89828a016113bf565b945050606087013567ffffffffffffffff81111561161857600080fd5b61162489828a016113bf565b935050608087013567ffffffffffffffff81111561164157600080fd5b61164d89828a016113bf565b92505060a061165e89828a01611413565b9150509295509295509295565b60006020828403121561167d57600080fd5b60006114548484611413565b611692816117d9565b82525050565b611692816117f2565b60006116ac826117d5565b8084526116c081602086016020860161180c565b6116c98161183c565b9093016020019392505050565b611692816117f7565b602081016116ed8284611689565b92915050565b602081016116ed8284611698565b602080825281016113b881846116a1565b60a0808252810161172381886116a1565b9050818103602083015261173781876116a1565b9050818103604083015261174b81866116a1565b9050818103606083015261175f81856116a1565b905061176e60808301846116d6565b9695505050505050565b602081016116ed82846116d6565b60405181810167ffffffffffffffff811182821017156117a557600080fd5b604052919050565b600067ffffffffffffffff8211156117c457600080fd5b506020601f91909101601f19160190565b5190565b73ffffffffffffffffffffffffffffffffffffffff1690565b151590565b63ffffffff1690565b82818337506000910152565b60005b8381101561182757818101518382015260200161180f565b83811115611836576000848401525b50505050565b601f01601f1916905600a265627a7a723058200eb4789fa026c43491e9c0fce44e4f5ab78fe16c7f124aa8346c79839be3fe306c6578706572696d656e74616cf50037";

    public static final String FUNC_GETPASSWORD = "getPassword";

    public static final String FUNC_GETUSERADDRESSBYNAME = "getUserAddressByName";

    public static final String FUNC_UPDATAPASSWORD = "updataPassword";

    public static final String FUNC_GETUSERNAMEBYID = "getUsernameById";

    public static final String FUNC_GETCENTERINFO = "getCenterInfo";

    public static final String FUNC_ISEXIST = "isExist";

    public static final String FUNC_ISEXISTUSERNAME = "isExistUsername";

    public static final String FUNC_GETWALLETPASSWORD = "getWalletPassword";

    public static final String FUNC_UPDATAHEAD = "updataHead";

    public static final String FUNC_GETUSERSIZE = "getUserSize";

    public static final String FUNC_UPDATAWALLETPASSWORD = "updataWalletPassword";

    public static final String FUNC_UPDATATEL = "updataTel";

    public static final String FUNC_ADDUSER = "addUser";

    public static final String FUNC_ADDWALLET = "addWallet";

    public static final String FUNC_UPDATAEMAIL = "updataEmail";

    @Deprecated
    protected User(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected User(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected User(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected User(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<String> getPassword(String _username) {
        final Function function = new Function(FUNC_GETPASSWORD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_username)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> getUserAddressByName(String _username) {
        final Function function = new Function(FUNC_GETUSERADDRESSBYNAME, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_username)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> updataPassword(String _username, String _password) {
        final Function function = new Function(
                FUNC_UPDATAPASSWORD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_username), 
                new org.web3j.abi.datatypes.Utf8String(_password)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> getUsernameById(BigInteger index) {
        final Function function = new Function(FUNC_GETUSERNAMEBYID, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint32(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Tuple5<String, String, String, String, BigInteger>> getCenterInfo(String _username) {
        final Function function = new Function(FUNC_GETCENTERINFO, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_username)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint32>() {}));
        return new RemoteCall<Tuple5<String, String, String, String, BigInteger>>(
                new Callable<Tuple5<String, String, String, String, BigInteger>>() {
                    @Override
                    public Tuple5<String, String, String, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<String, String, String, String, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue());
                    }
                });
    }

    public RemoteCall<BigInteger> isExist(String _username) {
        final Function function = new Function(FUNC_ISEXIST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_username)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint32>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Boolean> isExistUsername(String _username) {
        final Function function = new Function(FUNC_ISEXISTUSERNAME, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_username)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<String> getWalletPassword(String _username) {
        final Function function = new Function(FUNC_GETWALLETPASSWORD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_username)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> updataHead(String _username, String _headPath) {
        final Function function = new Function(
                FUNC_UPDATAHEAD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_username), 
                new org.web3j.abi.datatypes.Utf8String(_headPath)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getUserSize() {
        final Function function = new Function(FUNC_GETUSERSIZE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint32>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> updataWalletPassword(String _username, String _walletPassword) {
        final Function function = new Function(
                FUNC_UPDATAWALLETPASSWORD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_username), 
                new org.web3j.abi.datatypes.Utf8String(_walletPassword)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> updataTel(String _username, String _tel) {
        final Function function = new Function(
                FUNC_UPDATATEL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_username), 
                new org.web3j.abi.datatypes.Utf8String(_tel)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> addUser(String _username, String _password, String _tel, String _email, String headPath, BigInteger _userType) {
        final Function function = new Function(
                FUNC_ADDUSER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_username), 
                new org.web3j.abi.datatypes.Utf8String(_password), 
                new org.web3j.abi.datatypes.Utf8String(_tel), 
                new org.web3j.abi.datatypes.Utf8String(_email), 
                new org.web3j.abi.datatypes.Utf8String(headPath), 
                new org.web3j.abi.datatypes.generated.Uint32(_userType)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> addWallet(String _username, String _userAddress, String _walletPath, String _walletPassword) {
        final Function function = new Function(
                FUNC_ADDWALLET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_username), 
                new org.web3j.abi.datatypes.Address(_userAddress), 
                new org.web3j.abi.datatypes.Utf8String(_walletPath), 
                new org.web3j.abi.datatypes.Utf8String(_walletPassword)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> updataEmail(String _username, String _email) {
        final Function function = new Function(
                FUNC_UPDATAEMAIL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_username), 
                new org.web3j.abi.datatypes.Utf8String(_email)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static User load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new User(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static User load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new User(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static User load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new User(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static User load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new User(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<User> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(User.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<User> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(User.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<User> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(User.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<User> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(User.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
