pragma solidity ^0.4.23;

contract Fight {
    Bookmaker private bookmaker;
    
    address private provoker;
    Card private provokerCard;
    
    address private approver;
    Card private approverCard;
    
    constructor(address _provoker, Card _card, Bookmaker _bookmaker) public{
        provoker = _provoker;
        provokerCard = _card;
        bookmaker = _bookmaker;
    }
    
    function challengeAccepted(address _approver, Card _card) internal{
        bool exist = bookmaker.cardExist(_card);
        if(approver == address(0) && exist) {
            approver = _approver;
            approverCard = _card;
            //TODO: faire le combat et généré la carte
            fight();
            //generation d'une carte
            
        }
        else()
    }
    
    function fight() private pure {
        //algo de combat
        
    }
}