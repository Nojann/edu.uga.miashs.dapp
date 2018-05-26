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
            approver = fight();
            //generation d'une carte
            
        }
        else()
    }
    
    function fight() private pure returns(bool) {
	uint8 score;
        if(provokerCard.getBackgroundRed() > approverCard.getBackgroundGreen()){
		score=score+1;
	}
	else{
	score=score-1;
	}

	if(provokerCard.getBackgroundBlue() < approverCard.getBackgroundGreen()){
		score=score+1;
	}
	else{
	score=score-1;
	}
	
	if(provokerCard.getBackgroundBlue() > approverCard.getBackgroundRed()){
		score=score+1;
	}
	else{
	score=score-1;
	}

	if(provokerCard.getBackgroundGreen() < approverCard.getBackgroundRed()){
		score=score+1;
	}
	else{
	score=score-1;
	}

	if(provokerCard.getBackgroundRed() > approverCard.getBackgroundBlue()){
		score=score+1;
	}
	else{
	score=score-1;
	}

	if(provokerCard.getBackgroundGreen() < approverCard.getBackgroundBlue()){
		score=score+1;
	}
	else{
	score=score-1;
	}
	
	//---

	if(provokerCard.getPolygonRed() > approverCard.getPolygonGreen()){
		score=score+1;
	}
	else{
	score=score-1;
	}
	
	if(provokerCard.getPolygonGreen() > approverCard.getPolygonBlue()){
		score=score+1;
	}
	else{
	score=score-1;
	}

	if(provokerCard.getPolygonBlue() < approverCard.getPolygonRed()){
		score=score+1;
	}
	else{
	score=score-1;
	}
     	
	if (score >= 0){
		return true;
	}
	else{
		return false;
	}
    }
}
