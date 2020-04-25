pragma solidity ^0.4.0;
pragma experimental ABIEncoderV2;

contract User{
    struct user{
        string username;
        string password;
        string tel;
        string email;
        string headPath;
        address userAddress;
        string walletPath;
        string walletPassword;
        uint32 userType;// 0 普通用户 1 基金会 2 管理员
    }
    string[] usernames;
    mapping (string => user) nameUser;
    mapping (string => uint32) nameIndex;
     
    modifier onlyBy(){
        require(
            msg.sender == 0x4cD2950349B13e33A57c9966784EE5f2bd345394
        );
        _;
    }
    
    
    //判断用户名是否存在
    function isExistUsername(string _username) public view returns(bool isIndeed) {
        if (usernames.length == 0) return false;
        return (keccak256(usernames[nameIndex[_username]]) == keccak256(_username));
        // abi.encodePacked
    }
    
    function isExist(string _username)public view returns(uint32 flag){
        if(isExistUsername(_username)){
            return 1;
        }else{
            return 0;
        }
    }
    
    
    //注册用户 
    function addUser(string _username,string _password,string _tel,string _email,string headPath,uint32 _userType)public onlyBy{
        require(!isExistUsername(_username));
        usernames.push(_username);
        nameUser[_username] = user(_username,_password,_tel,_email,headPath,0,"","",_userType);
        nameIndex[_username] = uint32(usernames.length) - 1;
    }
    
    
    //创建钱包
    function addWallet(string _username,address _userAddress,string _walletPath,string _walletPassword)public onlyBy{
        require(isExistUsername(_username));
        nameUser[_username].userAddress = _userAddress;
        nameUser[_username].walletPath = _walletPath;
        nameUser[_username].walletPassword = _walletPassword;
    }

    
    //返回用户名密码 
    function getPassword(string _username)public view returns(
        string password){
        return (
            nameUser[_username].password);
    }
    
    
    //获取钱包 
    function getWalletPassword(string _username)public view returns(
        string walletPassword
        ){
        return(
            nameUser[_username].walletPassword
            );
    }
    
    
    //返回个人中心信息 
    function getCenterInfo(string _username)public view returns(
        string tel,
        string email,
        string headPath,
        string walletPath,
        uint32 userType
        ){
        return(
            nameUser[_username].tel,
            nameUser[_username].email,
            nameUser[_username].headPath,
            nameUser[_username].walletPath,
            nameUser[_username].userType
            );  
        
    }
    
    
    //getUserAddressByName
    function getUserAddressByName(string _username)public view returns(address userAddress){
        return nameUser[_username].userAddress;
    }
    
    
    //获取用户名 
    function getUsernameById(uint32 index)public view onlyBy returns(string username){
        return usernames[index];
    }
    
    
    //修改头像 
    function updataHead(string _username,string _headPath)public onlyBy{
        require(isExistUsername(_username));
        nameUser[_username].headPath = _headPath;
    }
    
    
    //updataPassword
    function updataPassword(string _username,string _password)public{
        nameUser[_username].password = _password;
    }
    
    
    //updataWalletPassword
    function updataWalletPassword(string _username,string _walletPassword)public{
        nameUser[_username].walletPassword = _walletPassword;
    }
    
    
    //updataEmail
    function updataEmail(string _username,string _email)public{
        nameUser[_username].email = _email;
    }
    
    
    //updataTel
    function updataTel(string _username,string _tel)public{
        nameUser[_username].tel = _tel;
    }
    
        
    //获取用户数量  
    function getUserSize()public view returns(uint32 useSize){
        return uint32(usernames.length);
    }
}
