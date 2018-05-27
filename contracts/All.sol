pragma solidity ^0.4.23;
contract Bookmaker{

        
        mapping(address => bool) private listOfFighters; //player adresse, if he fight or not.
        Fight[] private allFights;  // all available fights.
        uint private indexLastFight = 0; //TODO: Géré la taille du tableau
        mapping(address => bool) private listOfFight;
	
        mapping(address=>bool) private allCards;
        
        function newFight(Card _card) external{
            if(listOfFighters[msg.sender] == false && allCards[_card] == true) {
                Fight f = new Fight(msg.sender, _card, this);
                allFights.push(f);
		listOfFight(f) = true; //A regarder ci truc.
                indexLastFight = 0;
            }
        }
        
<<<<<<< HEAD:contracts/All.sol
        //Attention à sécuriser !
        function generateNewCard(address win, Card provokerCard, Card approverCard) external returns (Card) {   
        
        //Parcours les Fight[] // TODO
        
=======
        function generateNewCard(address winner, Card provokerCard, Card approverCard) private {   
            
	    if(listOfFight(msg.sender) == true) {
	    	//TODO: Le code ici!
	    }
	    
>>>>>>> af4e9c4e240a9c42c764a30b9640d577343232d0:contracts/All
            //generation d'une nouvelle carte
            uint8 _backgroundRed = ((provokerCard.getBackgroundRed()+1)*(approverCard.getBackgroundRed()+1))%255;
            uint8 _backgroundGreen = ((provokerCard.getBackgroundGreen()+1)*(approverCard.getBackgroundGreen()+1))%255;
            uint8 _backgroundBlue = ((provokerCard.getBackgroundBlue()+1)*(approverCard.getBackgroundBlue()+1))%255;
            uint8 _polygonRed = ((provokerCard.getPolygonRed()+1)*(approverCard.getPolygonGreen()+1))%255;
            uint8 _polygonGreen = ((provokerCard.getPolygonGreen()+1)*(approverCard.getPolygonBlue()+1))%255;
            uint8 _polygonBlue = ((provokerCard.getPolygonBlue()+1)*(approverCard.getPolygonRed()+1))%255;
            
            address winner = win;
            
            uint8[16] memory _coordinates;

            for(uint8 i; i<16; i++){
                _coordinates[i]=(provokerCard.getPolygonGreen()+1)*(approverCard.getPolygonRed()+1)%255;
            }
            
            Card newCard = new Card(_backgroundRed, _backgroundGreen, _backgroundBlue, _polygonRed, _polygonGreen, _polygonBlue, _coordinates, winner);
            
            allCards[newCard.getAddressID()]=true;
            return newCard;
        }
        
        function getListOfFights()  public constant returns (Fight[]) {
    	    return allFights;
	    }
	    
	    function remove(uint index) private{
            if (index >= allFights.length) return;
    
            for (uint i = index; i<allFights.length-1; i++){
                allFights[i] = allFights[i+1];
            }
            delete allFights[allFights.length-1];
        }
        
        function cardExist(Card _card) external view returns (bool){
            return allCards[_card];
        }
        
}

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
            
            if(fight()){
                bookmaker.generateNewCard(provoker, provokerCard, approverCard);
            }
        }
        else{
            bookmaker.generateNewCard(approver, provokerCard, approverCard);
        }
    }
    
    function fight() private view returns(bool)  {
        
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

pragma solidity ^0.4.21;

contract Card {

address cardOwner;

uint8 backgroundRed;
uint8 backgroundGreen;
uint8 backgroundBlue;

uint8 polygonRed;
uint8 polygonGreen;
uint8 polygonBlue;

/*
-Premier point en haut à gauche, dans le sens des aiguille du montre
-x et y
-8 points
*/

uint8[16] coordinates;


//Statut public à chnger ? Ne permerttre qu'au bookmaker de créer une carte
constructor(uint8 _backgroundRed, uint8 _backgroundGreen, uint8 _backgroundBlue, uint8 _polygonRed, uint8 _polygonGreen, uint8 _polygonBlue, uint8[16] _coordinates, address _owner) public {
        
backgroundRed = _backgroundRed;
backgroundGreen = _backgroundGreen;
backgroundBlue = _backgroundBlue;

polygonRed = _polygonRed;
polygonGreen = _polygonGreen;
polygonBlue = _polygonBlue;

coordinates = _coordinates;

cardOwner = _owner;
}
    
    function getBackgroundRed()  public constant returns (uint8) {
        return backgroundRed;
    }

    function getBackgroundGreen()  public constant returns (uint8) {
        return backgroundGreen;
    }
    
    function getBackgroundBlue()  public constant returns (uint8) {
        return backgroundBlue;
    }
    
    function getPolygonRed()  public constant returns (uint8) {
        return polygonRed;
    }
    
    function getPolygonGreen()  public constant returns (uint8) {
        return polygonGreen;
    }
    
    function getPolygonBlue()  public constant returns (uint8) {
        return polygonBlue;
    }
    
    function getCoordinates() public constant returns (uint8[16]) {
        return coordinates;
    }
    
    function getAddressID() public constant returns (address) {
        return cardOwner;
    }
    
    function changeAddress (address newAddressID) external {
        if(msg.sender == cardOwner) {
            cardOwner = newAddressID;
            return;
        }
        return;
    }
}
