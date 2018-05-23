pragma solidity ^0.4.23;

contract Bookmaker{

        //Users
        mapping(address => bool) private listOfFighters; //player adresse, if he fight or not.
        
        //Fights
        mapping(address => bool) private allFights;
        Fight[] private allFightsTable;  // all available fights.
        uint private indexLastFight = 0; //TODO: Géré la taille du tableau
        
        //Trades
        mapping(address => bool) private allTrades;
        Trade[] private allTradesTable;
        
        //Cards
        mapping(address=>bool) private allCards;
        
        
        function newFight(Card _card) external{
            if(listOfFighters[msg.sender] == false && allCards[_card] == true) {
                Fight f = new Fight(msg.sender, _card, this);
                allFights[f]=true;
                allFightsTable.push(f);
                indexLastFight = 0;
            }
        }
        
        function newTrade(Card _card, uint16 _price) external {
            Trade t = new Trade(msg.sender, _card, _price, this);
            allTradesTable.push(t);
        }
        
        function generatCardToWinner(address _winner) external {
            if(allFights[msg.sender]) {
                new Card( _winner);
                allFights[msg.sender]=false;
            }
        }
        
        
        
        function remove(uint index) private{
            if (index >= allFightsTable.length) return;
    
            for (uint i = index; i<allFightsTable.length-1; i++){
                allFightsTable[i] = allFightsTable[i+1];
            }
            delete allFightsTable[allFightsTable.length-1];
        }
        
        function getListOfFights()  external constant returns (Fight[]) {
            return allFightsTable;
        }
        
        function getListOfTrades() external constant returns (Trade[]) {
            return allTradesTable;
        }
        
        function fighterIsFighting(address _fighter) external view returns (bool){
            return listOfFighters[_fighter];
        }
        
        function cardExist(Card _card) external view returns (bool){
            return allCards[_card];
        }
        
}