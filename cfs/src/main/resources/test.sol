pragma solidity ^0.4.0;


contract test{
    
    //受益人对象 
    struct needer{
        address Neederaddress;
        uint goal;
        uint amount;
        uint funderAmount;
        mapping(uint => funder) map;
    }
    
    //捐赠者对象 
    struct funder{
        address Funeraddress;
        uint Tomoney;
    }
    
    uint neederAmount;
    
    mapping(uint => needer) neederMap;
    
    
    function NewNeeder(address _Funeraddress,uint _goal) public{
        neederAmount++;
        neederMap[neederAmount] = needer(_Funeraddress,_goal,0,0);
    }
    
    function contribute(address _address,uint _neederAmouont) public payable{
        needer storage _needer = neederMap[_neederAmouont];
        _needer.amount += msg.value;
        _needer.funderAmount++;
        _needer.map[_needer.funderAmount] = funder(_address,msg.value);
        _needer.Neederaddress.transfer(msg.value);
    }
    
    function IScomplete(uint _neederAmouont) public{
        needer storage _needer = neederMap[_neederAmouont];
        if(_needer.amount > _needer.goal){
            _needer.Neederaddress.transfer(_needer.amount);
        }
    }
    
    function get() view public returns(uint,uint,uint){
        return (neederMap[1].goal,neederMap[1].amount,neederMap[1].funderAmount);
    }
}