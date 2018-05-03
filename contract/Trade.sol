pragma solidity ^0.4.23;

contract Trade {
    address seller;
    address buyer;
    
    Card card;
    uint16 price;
    
    Bookmaker bookmaker;
    
    constructor(address _seller, Card _card, uint16 _price, Bookmaker _bookmaker) public {
        seller = _seller;
        card = _card;
        price = _price;
        bookmaker = _bookmaker;
    }
    
    function buy(address _buyer) {
        //TODO: lier le contract Card a des contrats Trade pour obliger le joueur à executer l'écahnge et prendre son argent.
        //TODO: par la meme ocaz, la carte ne peut pas etre jouer quand elle fait partie d'une échange.
    }
    
    function getCard() external view returns(Card) {
        return card;
    }
    
    function getPrice() external view returns(uint16) {
        return price;
    }
}