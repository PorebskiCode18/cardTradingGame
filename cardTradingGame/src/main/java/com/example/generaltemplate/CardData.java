package com.example.generaltemplate;

public class CardData {
    private int numberOwned;
    private Cards cardType;
    public CardData(Cards CardPlayer, int numberOwned){
        this.numberOwned=numberOwned;
        this.cardType=CardPlayer;
    }
    public Cards getCardType(){
        return cardType;
    }
    public int setNumCardOwned(int numberOwned) {
        if(this.numberOwned-numberOwned <0){
            return -1;
        }else{
            this.numberOwned+=numberOwned;
            return this.numberOwned;
        }
    }
    public int getNumberOwned() {
        return numberOwned;
    }
}
