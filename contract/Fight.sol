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
    
    function challengeAccepted(address _approver, Card _card) external{
        bool exist = bookmaker.cardExist(_card);
        bool isNotFighting = bookmaker.fighterIsFighting(_approver);
        if( isNotFighting && approver == address(0) && exist) {
            approver = _approver;
            approverCard = _card;
            address winner;
            //TODO: faire le combat et généré la carte
            fight(winner);
            //generation d'une cart
            bookmaker.generatCardToWinner(winner);
        }
    }
    
    function fight(address _winner) private view{
        //TODO: algo de combat
        _winner = provoker;
        
    }
}