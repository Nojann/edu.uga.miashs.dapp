pragma solidity ^0.4.23;
contract Bookmaker{

        
        mapping(address => bool) private listOfFighters; //player adresse, if he fight or not.
        Fight[] private allFights;  // all available fights.
        uint private indexLastFight = 0; //TODO: Géré la taille du tableau
        
        mapping(address=>bool) private allCards;
        
        function newFight(Card _card) external{
            if(listOfFighters[msg.sender] == false && allCards[_card] == true) {
                Fight f = new Fight(msg.sender, _card, this);
                allFights.push(f);
                indexLastFight = 0;
            }
        }
        
        /*function generateNewCard() private {   
            address _card = 
            //generation d'une nouvelle carte
            existCards[_card]=true;
        }*/
        
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