package com.example.generaltemplate;

public class Player {
    private int money;
    private String nameOfPlayer;
    private CardData myCard1,myCard2,myCard3,myCard4,myCard5,myCard6;
    private String trade1="",trade2="",trade3="";
    public Player(String name,int money){
        nameOfPlayer=name;
        this.money = money;
    }
    public String buyItems(Cards cardsBought, int numCardsBought){
        if ( (myCard1!=null && myCard1.getCardType().equals(cardsBought)) || (myCard2!=null && myCard2.getCardType().equals(cardsBought))|| (myCard3!=null && myCard3.getCardType().equals(cardsBought))|| (myCard4!=null && myCard4.getCardType().equals(cardsBought))|| (myCard5!=null && myCard5.getCardType().equals(cardsBought))|| (myCard6!=null && myCard6.getCardType().equals(cardsBought))){
            System.out.println("You Already own " + cardsBought.getNameOfCard());
            if (myCard1.getCardType().equals(cardsBought)){
                myCard1.setNumCardOwned(numCardsBought);
            } else if (myCard2.getCardType().equals(cardsBought)) {
                myCard2.setNumCardOwned(numCardsBought);
            }else if (myCard3.getCardType().equals(cardsBought)) {
                myCard3.setNumCardOwned(numCardsBought);
            }else if (myCard4.getCardType().equals(cardsBought)) {
                myCard4.setNumCardOwned(numCardsBought);
            }else if (myCard5.getCardType().equals(cardsBought)) {
                myCard5.setNumCardOwned(numCardsBought);
            }else if (myCard6.getCardType().equals(cardsBought)) {
                myCard6.setNumCardOwned(numCardsBought);
            }
        }else{
            if (myCard1==null) {
                myCard1 = new CardData(cardsBought,numCardsBought);
            } else if (myCard2==null) {
                myCard2 = new CardData(cardsBought,numCardsBought);
            }else if (myCard3==null) {
                myCard3 = new CardData(cardsBought,numCardsBought);
            }else if (myCard4==null) {
                myCard4 = new CardData(cardsBought,numCardsBought);
            }else if (myCard5==null) {
                myCard5 = new CardData(cardsBought,numCardsBought);
            }else if (myCard6==null) {
                myCard6 = new CardData(cardsBought,numCardsBought);
            }else{
                return "you can't buy any more card types";
            }
        }
        return nameOfPlayer + " bought "+ numCardsBought + " " + cardsBought.getNameOfCard();
    }
    public String TradeAddItems(Cards CardRecieving,int numberOfCardsRecieiving){
        if ( (myCard1!=null && myCard1.getCardType().equals(CardRecieving)) || (myCard2!=null && myCard2.getCardType().equals(CardRecieving))|| (myCard3!=null && myCard3.getCardType().equals(CardRecieving))|| (myCard4!=null && myCard4.getCardType().equals(CardRecieving))|| (myCard5!=null && myCard5.getCardType().equals(CardRecieving))|| (myCard6!=null && myCard6.getCardType().equals(CardRecieving))){
            if (myCard1.getCardType().equals(CardRecieving)){
                myCard1.setNumCardOwned(numberOfCardsRecieiving);
            } else if (myCard2.getCardType().equals(CardRecieving)) {
                myCard2.setNumCardOwned(numberOfCardsRecieiving);
            }else if (myCard3.getCardType().equals(CardRecieving)) {
                myCard3.setNumCardOwned(numberOfCardsRecieiving);
            }else if (myCard4.getCardType().equals(CardRecieving)) {
                myCard4.setNumCardOwned(numberOfCardsRecieiving);
            }else if (myCard5.getCardType().equals(CardRecieving)) {
                myCard5.setNumCardOwned(numberOfCardsRecieiving);
            }else if (myCard6.getCardType().equals(CardRecieving)) {
                myCard6.setNumCardOwned(numberOfCardsRecieiving);
            }
        }else{
            if (myCard1==null) {
                myCard1 = new CardData(CardRecieving,numberOfCardsRecieiving);
            } else if (myCard2==null) {
                myCard2 = new CardData(CardRecieving,numberOfCardsRecieiving);
            }else if (myCard3==null) {
                myCard3 = new CardData(CardRecieving,numberOfCardsRecieiving);
            }else if (myCard4==null) {
                myCard4 = new CardData(CardRecieving,numberOfCardsRecieiving);
            }else if (myCard5==null) {
                myCard5 = new CardData(CardRecieving,numberOfCardsRecieiving);
            }else if (myCard6==null) {
                myCard6 = new CardData(CardRecieving,numberOfCardsRecieiving);
            }else{
                return "you can't buy any more card types";
            }
        }
        if (myCard1!=null&&myCard1.getNumberOwned()==0){
            myCard1=null;
        }
        if (myCard2!=null&&myCard2.getNumberOwned()==0){
            myCard2=null;
        }
        if (myCard3!=null&&myCard3.getNumberOwned()==0){
            myCard3=null;
        }
        if (myCard4!=null&&myCard4.getNumberOwned()==0){
            myCard4=null;
        }
        if (myCard5!=null&&myCard5.getNumberOwned()==0){
            myCard5=null;
        }
        if (myCard6!=null&&myCard6.getNumberOwned()==0){
            myCard6=null;
        }
        return nameOfPlayer + " recieved "+ numberOfCardsRecieiving + " " + CardRecieving.getNameOfCard();
    }

    public String sellItems(Cards cardsSell, int numCardsSell, Player playerClicked){
        if ( (myCard1!=null && myCard1.getCardType().equals(cardsSell)) || (myCard2!=null && myCard2.getCardType().equals(cardsSell))|| (myCard3!=null && myCard3.getCardType().equals(cardsSell))|| (myCard4!=null && myCard4.getCardType().equals(cardsSell))|| (myCard5!=null && myCard5.getCardType().equals(cardsSell))|| (myCard6!=null && myCard6.getCardType().equals(cardsSell))){
            if (myCard1.getCardType().equals(cardsSell)){
                if (myCard1.getNumberOwned()>=numCardsSell){
                    myCard1.setNumCardOwned(-numCardsSell);
                    playerClicked.updateMoney(numCardsSell*cardsSell.getCost());
                }else{
                    playerClicked.updateMoney(myCard1.getNumberOwned()*cardsSell.getCost());
                    int numberCardsSold = myCard1.getNumberOwned();
                    myCard1.setNumCardOwned(-myCard1.getNumberOwned());
                    if (myCard1.getNumberOwned()==0){
                        myCard1=null;
                    }
                    return nameOfPlayer + " sold "+ numberCardsSold + " " + cardsSell.getNameOfCard();
                }
                if (myCard1.getNumberOwned()==0){
                    myCard1=null;
                }
            } else if (myCard2.getCardType().equals(cardsSell)){
                if (myCard2.getNumberOwned()>=numCardsSell){
                    myCard2.setNumCardOwned(-numCardsSell);
                    playerClicked.updateMoney(numCardsSell*cardsSell.getCost());
                }else{
                    playerClicked.updateMoney(myCard2.getNumberOwned()*cardsSell.getCost());
                    int numberCardsSold = myCard2.getNumberOwned();
                    myCard2.setNumCardOwned(-myCard2.getNumberOwned());
                    if (myCard2.getNumberOwned()==0){
                        myCard2=null;
                    }
                    return nameOfPlayer + " sold "+ numberCardsSold + " " + cardsSell.getNameOfCard();
                }
                if (myCard2.getNumberOwned()==0){
                    myCard2=null;
                }
            }else if (myCard3.getCardType().equals(cardsSell)){
                if (myCard3.getNumberOwned()>=numCardsSell){
                    myCard3.setNumCardOwned(-numCardsSell);
                    playerClicked.updateMoney(numCardsSell*cardsSell.getCost());
                }else{
                    playerClicked.updateMoney(myCard3.getNumberOwned()*cardsSell.getCost());
                    int numberCardsSold = myCard3.getNumberOwned();
                    myCard3.setNumCardOwned(-myCard3.getNumberOwned());
                    if (myCard3.getNumberOwned()==0){
                        myCard3=null;
                    }
                    return nameOfPlayer + " sold "+ numberCardsSold + " " + cardsSell.getNameOfCard();
                }
                if (myCard3.getNumberOwned()==0){
                    myCard3=null;
                }
            }else if (myCard4.getCardType().equals(cardsSell)){
                if (myCard4.getNumberOwned()>=numCardsSell){
                    myCard4.setNumCardOwned(-numCardsSell);
                    playerClicked.updateMoney(numCardsSell*cardsSell.getCost());
                }else{
                    playerClicked.updateMoney(myCard4.getNumberOwned()*cardsSell.getCost());
                    int numberCardsSold = myCard4.getNumberOwned();
                    myCard4.setNumCardOwned(-myCard4.getNumberOwned());
                    if (myCard4.getNumberOwned()==0){
                        myCard4=null;
                    }
                    return nameOfPlayer + " sold "+ numberCardsSold + " " + cardsSell.getNameOfCard();
                }
                if (myCard4.getNumberOwned()==0){
                    myCard4=null;
                }
            }else if (myCard5.getCardType().equals(cardsSell)){
                if (myCard5.getNumberOwned()>=numCardsSell){
                    myCard5.setNumCardOwned(-numCardsSell);
                    playerClicked.updateMoney(numCardsSell*cardsSell.getCost());
                }else{
                    playerClicked.updateMoney(myCard5.getNumberOwned()*cardsSell.getCost());
                    int numberCardsSold = myCard5.getNumberOwned();
                    myCard5.setNumCardOwned(-myCard5.getNumberOwned());
                    if (myCard5.getNumberOwned()==0){
                        myCard5=null;
                    }
                    return nameOfPlayer + " sold "+ numberCardsSold + " " + cardsSell.getNameOfCard();
                }
                if (myCard5.getNumberOwned()==0){
                    myCard5=null;
                }
            }else if (myCard6.getCardType().equals(cardsSell)){
                if (myCard6.getNumberOwned()>=numCardsSell){
                    myCard6.setNumCardOwned(-numCardsSell);
                    playerClicked.updateMoney(numCardsSell*cardsSell.getCost());
                }else{
                    playerClicked.updateMoney(myCard6.getNumberOwned()*cardsSell.getCost());
                    int numberCardsSold = myCard6.getNumberOwned();
                    myCard6.setNumCardOwned(-myCard6.getNumberOwned());
                    if (myCard6.getNumberOwned()==0){
                        myCard6=null;
                    }
                    return nameOfPlayer + " sold "+ numberCardsSold + " " + cardsSell.getNameOfCard();
                }
                if (myCard6.getNumberOwned()==0){
                    myCard6=null;
                }
            }
        }
        return nameOfPlayer + " sold "+ numCardsSell + " " + cardsSell.getNameOfCard();
    }
    public String addTrade(String playerOfferingTrade,Cards cardBeingOffered,Cards cardsGivingAway, int numCardRecieving, int numCardsGiving){

        if (trade1.isEmpty()) {
            trade1= playerOfferingTrade + " offers " + numCardRecieving + " ; " + cardBeingOffered.getNameOfCard() + " for " + numCardsGiving + " : " + cardsGivingAway.getNameOfCard();
        } else if (trade2.isEmpty()) {
            trade2= playerOfferingTrade + " offers " + numCardRecieving + " ; " + cardBeingOffered.getNameOfCard() + " for " + numCardsGiving + " : " + cardsGivingAway.getNameOfCard();
        }else if (trade3.isEmpty()) {
            trade3= playerOfferingTrade + " offers " + numCardRecieving + " ; " + cardBeingOffered.getNameOfCard() + " for " + numCardsGiving + " : " + cardsGivingAway.getNameOfCard();
        }else{
            return "no more open trade slots";
        }
        return "trade offered";
    }

    public void updateMoney(int moneyUpdate){
        money+=moneyUpdate;
    }
    public String getNameOfPerson() {
        return nameOfPlayer;
    }

    public int getMoney() {
        return money;
    }

    public CardData getMyCard1() {
        return myCard1;
    }

    public CardData getMyCard2() {
        return myCard2;
    }

    public CardData getMyCard3() {
        return myCard3;
    }

    public CardData getMyCard4() {
        return myCard4;
    }

    public CardData getMyCard5() {
        return myCard5;
    }

    public CardData getMyCard6() {
        return myCard6;
    }
    public String getTrade1(){
        return trade1;
    }

    public String getTrade2() {
        return trade2;
    }

    public String getTrade3() {
        return trade3;
    }
    public void setTrade1Null(){
        trade1="";
    }
    public void setTrade2Null(){
        trade2="";
    }
    public void setTrade3Null(){
        trade3="";
    }
}
