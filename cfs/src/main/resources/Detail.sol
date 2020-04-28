pragma solidity >0.4.0;
pragma experimental ABIEncoderV2;

contract Detail{
    struct detail{
        address wallet_address;
        uint target_amount;
        uint now_amount;
        uint last_amount;
    }
    
    struct phase{
        string time;
        string title;
        string description;
        uint spend;
    }
    
    mapping (uint => detail) project_detail;
    
    mapping (uint => phase[]) project_phase;
    
    function createDetail(address _wallet_address,uint _target_amount,uint _project_id)public returns(string _result){
        project_detail[_project_id] = detail(_wallet_address,_target_amount,0,0);
    }
    
    function donation(uint _project_id)public payable returns(string _result){
        detail storage temp = project_detail[_project_id];
        if(keccak256(temp.wallet_address) != keccak256("")){
            temp.wallet_address.transfer(msg.value);
            temp.now_amount += msg.value;
            temp.last_amount += msg.value;
            return "1";
        }else{
            return "0";
        }
    }
    
    function getDetail(uint _project_id)public view returns(address wallet_address,
        uint target_amount,
        uint now_amount,
        uint last_amount){
        detail storage temp = project_detail[_project_id];
        return (temp.wallet_address,temp.target_amount,temp.now_amount,temp.last_amount);
    }
    
    function createPhase(uint _project_id,string _time,string _title,string _description,uint _spend)public returns(string _result){
        detail storage temp = project_detail[_project_id];
        if((temp.last_amount == 0) || (temp.last_amount < _spend)){
            return "0";
        }
        temp.last_amount -= _spend;
        project_phase[_project_id].push(phase(_time,_title,_description,_spend));
        return "1";
    }
    
    function getPhase(uint _project_id,uint _index)public view returns(string _time,string _title,
    string _description,uint _spend){
        phase storage temp = project_phase[_project_id][_index];
        return (temp.time,temp.title,temp.description,temp.spend);
    }
    
    function getPhaseSize(uint _project_id)public view returns(uint _phaseSize){
        return project_phase[_project_id].length;
    }
}