pragma solidity ^0.4.23;

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
