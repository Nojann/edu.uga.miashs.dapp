pragma solidity ^0.4.23;

contract Card {

address cardOwner;
string name;

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
   constructor(uint8 _backgroundRed, uint8 _backgroundGreen, uint8 _backgroundBlue, uint8 _polygonRed, uint8 _polygonGreen, uint8 _polygonBlue, uint8[16] _coordinates) public {
        
backgroundRed = _backgroundRed;
backgroundGreen = _backgroundGreen;
backgroundBlue = _backgroundBlue;

polygonRed = _polygonRed;
polygonGreen = _polygonGreen;
polygonBlue = _polygonBlue;

coordinates = _coordinates;


//uint8[2] _coordinate1, uint8[2] _coordinate2, uint8[2] _coordinate3, uint8[2] _coordinate4, uint8[2] _coordinate5, uint8[2] _coordinate6, uint8[2] _coordinate7, uint8[2] _coordinate8,
   //address _owner

//cardOwner = _owner;
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
