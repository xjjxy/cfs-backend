pragma solidity >0.4.0;
pragma experimental ABIEncoderV2;

contract Wallet{
    struct wallet{
        address wallet_address;
        string hash;
        string password;
    }
    
    mapping(string => wallet) user_wallet;//uuid对应钱包
    
    function createWallet(address _wallet_address,string _hash,string _password,string _uuid)public{
        user_wallet[_uuid] = wallet(_wallet_address,_hash,_password);
    }
    
    function updateWalletPassword(string _uuid,string now_password)public returns(string _result){
        string memory password = user_wallet[_uuid].password;
        if(keccak256(password) != keccak256("")){
            user_wallet[_uuid].password = now_password;
            return "1";
        }else{
            return "0";
        }
    }
    
    function getWalletPassword(string _uuid)public view returns(string _result){
        string memory password = user_wallet[_uuid].password;
        if(keccak256(password) != keccak256("")){
            return user_wallet[_uuid].password;
        }else{
            return "0";
        }
    }
    
    function getWalletAddress(string _uuid)public view returns(address _wallet_address){
        wallet storage temp = user_wallet[_uuid];
        return(temp.wallet_address);
    }
    
    function getWalletHash(string _uuid)public view returns(string _hash){
        wallet storage temp = user_wallet[_uuid];
        return(temp.hash);
    }
}