package com.example.generaltemplate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class HelloController {

    @FXML
    Cards cardsClicked, cardsClickedOwned,cardsClickedTrade;
    Player playerClicked,playerClickTrade;
    public TextField txtNumCards,txtNumCardsSell,txtCardsAcquired,txtCardsGiveAway;
    public ImageView imgFifaCard,imgRonaldo,imgMessi,imgLewandowski,imgHaaland,imgNeymar,imgMbappe;
    public ListView lstAvailable, lstOwnedCards, lstPlayers, lstTradeList, lstPlayerTrade, lstCardsTrade;
    public Label lblPace, lblShot, lblPass, lblDribble, lblDefense,lblPhysicality,lblRating,lblName,lblCost,lblPlayerCoins,lblDisplay;


    @FXML
    public void handleStart(ActionEvent actionEvent) {
        p1 = new Player("Damian",20);
        p2 = new Player("Kavel",20);
        p3 = new Player("Logan",20);
        lstPlayers.getItems().add(p1.getNameOfPerson());
        lstPlayers.getItems().add(p2.getNameOfPerson());
        lstPlayers.getItems().add(p3.getNameOfPerson());
        lstPlayerTrade.getItems().add(p1.getNameOfPerson());
        lstPlayerTrade.getItems().add(p2.getNameOfPerson());
        lstPlayerTrade.getItems().add(p3.getNameOfPerson());
        messi = new Cards("Messi", 93, 85, 92, 91, 95, 38, 65 ,7);//
        lstAvailable.getItems().add(messi.getNameOfCard());
        ronaldo = new Cards("Ronaldo", 92, 89, 93, 81, 89, 35, 77,6);//
        lstAvailable.getItems().add(ronaldo.getNameOfCard());
        lewandowski = new Cards("Lewandowski", 91, 77, 92, 77, 87, 43, 84, 5);//
        lstAvailable.getItems().add(lewandowski.getNameOfCard());
        haaland = new Cards("Haaland", 88, 89, 91, 65, 80, 49, 87, 3);//
        lstAvailable.getItems().add(haaland.getNameOfCard());
        neymar = new Cards("Neymar", 91, 81, 85, 86, 94, 36, 59, 5);//
        lstAvailable.getItems().add(neymar.getNameOfCard());
        mbappe = new Cards("Mbappe", 90, 96, 86, 78, 91, 39, 76,4);//
        lstAvailable.getItems().add(mbappe.getNameOfCard());

        int [] odd = new int[5];

        int y = 1;

        for (int i = 1; i <=9; i+=2){

            odd[i-y]=i;

            y++;

        }
        System.out.println(odd);
    }
    private String tempCard,tempPlayer,tempCardOwned,tempPlayerTrade,tempCardTrade,tempCardOwnedFull,tempCardTradeFull, tempSelectedTrade,selectedTradeOffer;
    public void handlePlayers(MouseEvent mouseEvent){
        tempPlayer = lstPlayers.getSelectionModel().getSelectedItem().toString();
        lstPlayerTrade.getItems().clear();
        lstCardsTrade.getItems().clear();
        if(tempPlayer.equals(p1.getNameOfPerson())){
            playerClicked=p1;
            lstPlayerTrade.getItems().add(p2.getNameOfPerson());
            lstPlayerTrade.getItems().add(p3.getNameOfPerson());
        }else if (tempPlayer.equals(p2.getNameOfPerson())){
            playerClicked = p2;
            lstPlayerTrade.getItems().add(p1.getNameOfPerson());
            lstPlayerTrade.getItems().add(p3.getNameOfPerson());
        }
        else if (tempPlayer.equals(p3.getNameOfPerson())){
            playerClicked = p3;
            lstPlayerTrade.getItems().add(p1.getNameOfPerson());
            lstPlayerTrade.getItems().add(p2.getNameOfPerson());
        }
        System.out.println(tempPlayer);
        updateListviews();
    }
    public void updateListviews(){
        lstOwnedCards.getItems().clear();
        lstTradeList.getItems().clear();
        if(playerClicked.getMyCard1() !=null){
            lstOwnedCards.getItems().add(playerClicked.getMyCard1().getCardType().getNameOfCard() +
                    " # " + playerClicked.getMyCard1().getNumberOwned());
        }
        if(playerClicked.getMyCard2() !=null){
            lstOwnedCards.getItems().add(playerClicked.getMyCard2().getCardType().getNameOfCard() +
                    " # " + playerClicked.getMyCard2().getNumberOwned());
        }
        if(playerClicked.getMyCard3() !=null){
            lstOwnedCards.getItems().add(playerClicked.getMyCard3().getCardType().getNameOfCard() +
                    " # " + playerClicked.getMyCard3().getNumberOwned());
        }
        if(playerClicked.getMyCard4() !=null){
            lstOwnedCards.getItems().add(playerClicked.getMyCard4().getCardType().getNameOfCard() +
                    " # " + playerClicked.getMyCard4().getNumberOwned());
        }
        if(playerClicked.getMyCard5() !=null){
            lstOwnedCards.getItems().add(playerClicked.getMyCard5().getCardType().getNameOfCard() +
                    " # " + playerClicked.getMyCard5().getNumberOwned());
        }
        if(playerClicked.getMyCard6() !=null){
            lstOwnedCards.getItems().add(playerClicked.getMyCard6().getCardType().getNameOfCard() +
                    " # " + playerClicked.getMyCard6().getNumberOwned());
        }
        if (!playerClicked.getTrade1().isEmpty()){
            lstTradeList.getItems().add(playerClicked.getTrade1());
        }
        if (!playerClicked.getTrade2().isEmpty()){
            lstTradeList.getItems().add(playerClicked.getTrade2());
        }
        if (!playerClicked.getTrade3().isEmpty()){
            lstTradeList.getItems().add(playerClicked.getTrade3());
        }
        lblPlayerCoins.setText("Coins: "+playerClicked.getMoney());
    }
    public void updateListviewsTrade(){
        lstCardsTrade.getItems().clear();

        if(playerClickTrade.getMyCard1() !=null){
            lstCardsTrade.getItems().add(playerClickTrade.getMyCard1().getCardType().getNameOfCard() +
                    " # " + playerClickTrade.getMyCard1().getNumberOwned());
        }
        if(playerClickTrade.getMyCard2() !=null){
            lstCardsTrade.getItems().add(playerClickTrade.getMyCard2().getCardType().getNameOfCard() +
                    " # " + playerClickTrade.getMyCard2().getNumberOwned());
        }
        if(playerClickTrade.getMyCard3() !=null){
            lstCardsTrade.getItems().add(playerClickTrade.getMyCard3().getCardType().getNameOfCard() +
                    " # " + playerClickTrade.getMyCard3().getNumberOwned());
        }
        if(playerClickTrade.getMyCard4() !=null){
            lstCardsTrade.getItems().add(playerClickTrade.getMyCard4().getCardType().getNameOfCard() +
                    " # " + playerClickTrade.getMyCard4().getNumberOwned());
        }
        if(playerClickTrade.getMyCard5() !=null){
            lstCardsTrade.getItems().add(playerClickTrade.getMyCard5().getCardType().getNameOfCard() +
                    " # " + playerClickTrade.getMyCard5().getNumberOwned());
        }
        if(playerClickTrade.getMyCard6() !=null){
            lstCardsTrade.getItems().add(playerClickTrade.getMyCard6().getCardType().getNameOfCard() +
                    " # " + playerClickTrade.getMyCard6().getNumberOwned());
        }
    }
    public void handleCards(MouseEvent mouseEvent){
        tempCard = lstAvailable.getSelectionModel().getSelectedItem().toString();
        imgMessi.setOpacity(0);
        imgRonaldo.setOpacity(0);
        imgLewandowski.setOpacity(0);
        imgHaaland.setOpacity(0);
        imgNeymar.setOpacity(0);
        imgMbappe.setOpacity(0);
        if(tempCard.equals(messi.getNameOfCard())){
            cardsClicked=messi;
            lblName.setText(messi.getNameOfCard());
            lblRating.setText(String.valueOf(messi.getRating()));
            lblPace.setText(String.valueOf(messi.getPace()));
            lblShot.setText(String.valueOf(messi.getShot()));
            lblPass.setText(String.valueOf(messi.getPass()));
            lblDribble.setText(String.valueOf(messi.getDribble()));
            lblDefense.setText(String.valueOf(messi.getDefense()));
            lblPhysicality.setText(String.valueOf(messi.getPhysicality()));
            lblCost.setText("Cost: " + messi.getCost());
            imgMessi.setOpacity(1);
        }else if(tempCard.equals(ronaldo.getNameOfCard())){
            cardsClicked=ronaldo;
            lblName.setText(ronaldo.getNameOfCard());
            lblRating.setText(String.valueOf(ronaldo.getRating()));
            lblPace.setText(String.valueOf(ronaldo.getPace()));
            lblShot.setText(String.valueOf(ronaldo.getShot()));
            lblPass.setText(String.valueOf(ronaldo.getPass()));
            lblDribble.setText(String.valueOf(ronaldo.getDribble()));
            lblDefense.setText(String.valueOf(ronaldo.getDefense()));
            lblPhysicality.setText(String.valueOf(ronaldo.getPhysicality()));
            lblCost.setText("Cost: " + ronaldo.getCost());
            imgRonaldo.setOpacity(1);
        }else if(tempCard.equals(lewandowski.getNameOfCard())){
            cardsClicked=lewandowski;
            lblName.setText(lewandowski.getNameOfCard());
            lblRating.setText(String.valueOf(lewandowski.getRating()));
            lblPace.setText(String.valueOf(lewandowski.getPace()));
            lblShot.setText(String.valueOf(lewandowski.getShot()));
            lblPass.setText(String.valueOf(lewandowski.getPass()));
            lblDribble.setText(String.valueOf(lewandowski.getDribble()));
            lblDefense.setText(String.valueOf(lewandowski.getDefense()));
            lblPhysicality.setText(String.valueOf(lewandowski.getPhysicality()));
            lblCost.setText("Cost: " + lewandowski.getCost());
            imgLewandowski.setOpacity(1);
        } else if(tempCard.equals(haaland.getNameOfCard())){
            cardsClicked=haaland;
            lblName.setText(haaland.getNameOfCard());
            lblRating.setText(String.valueOf(haaland.getRating()));
            lblPace.setText(String.valueOf(haaland.getPace()));
            lblShot.setText(String.valueOf(haaland.getShot()));
            lblPass.setText(String.valueOf(haaland.getPass()));
            lblDribble.setText(String.valueOf(haaland.getDribble()));
            lblDefense.setText(String.valueOf(haaland.getDefense()));
            lblPhysicality.setText(String.valueOf(haaland.getPhysicality()));
            lblCost.setText("Cost: " + haaland.getCost());
            imgHaaland.setOpacity(1);
        }else if(tempCard.equals(neymar.getNameOfCard())){
            cardsClicked=neymar;
            lblName.setText(neymar.getNameOfCard());
            lblRating.setText(String.valueOf(neymar.getRating()));
            lblPace.setText(String.valueOf(neymar.getPace()));
            lblShot.setText(String.valueOf(neymar.getShot()));
            lblPass.setText(String.valueOf(neymar.getPass()));
            lblDribble.setText(String.valueOf(neymar.getDribble()));
            lblDefense.setText(String.valueOf(neymar.getDefense()));
            lblPhysicality.setText(String.valueOf(neymar.getPhysicality()));
            lblCost.setText("Cost: " + neymar.getCost());
            imgNeymar.setOpacity(1);
        }else if(tempCard.equals(mbappe.getNameOfCard())){
            cardsClicked=mbappe;
            lblName.setText(mbappe.getNameOfCard());
            lblRating.setText(String.valueOf(mbappe.getRating()));
            lblPace.setText(String.valueOf(mbappe.getPace()));
            lblShot.setText(String.valueOf(mbappe.getShot()));
            lblPass.setText(String.valueOf(mbappe.getPass()));
            lblDribble.setText(String.valueOf(mbappe.getDribble()));
            lblDefense.setText(String.valueOf(mbappe.getDefense()));
            lblPhysicality.setText(String.valueOf(mbappe.getPhysicality()));
            lblCost.setText("Cost: " + mbappe.getCost());
            imgMbappe.setOpacity(1);
        }
    }
    Cards messi,ronaldo,haaland, lewandowski, neymar,mbappe;
    Player p1, p2, p3;

    public void handleSellCards(ActionEvent actionEvent) {
        lblDisplay.setText(playerClicked.sellItems(cardsClickedOwned,Integer.parseInt(txtNumCardsSell.getText()),playerClicked));
        updateListviews();
    }

    public void handleBuyCards(ActionEvent actionEvent) {
        if (playerClicked.getMoney()>=cardsClicked.getCost()*Integer.parseInt(txtNumCards.getText())){
            lblDisplay.setText(playerClicked.buyItems(cardsClicked,Integer.parseInt(txtNumCards.getText())));
            playerClicked.updateMoney(-1*cardsClicked.getCost()*Integer.parseInt(txtNumCards.getText()));
            lblPlayerCoins.setText("Coins: "+playerClicked.getMoney());
            updateListviews();
        }else{
            lblDisplay.setText("Not Enough Coins");
        }

    }
    public void handleCardsOwned(MouseEvent mouseEvent){
        if (lstOwnedCards.getSelectionModel().getSelectedItem().toString()!=null){
            tempCardOwnedFull = lstOwnedCards.getSelectionModel().getSelectedItem().toString();
            tempCardOwned=tempCardOwnedFull.substring(0,tempCardOwnedFull.indexOf(" #")) ;
            System.out.println(tempCardOwned);
        }
        imgMessi.setOpacity(0);
        imgRonaldo.setOpacity(0);
        imgLewandowski.setOpacity(0);
        imgHaaland.setOpacity(0);
        imgNeymar.setOpacity(0);
        imgMbappe.setOpacity(0);
        if (tempCardOwned.equals(messi.getNameOfCard())){
            cardsClickedOwned=messi;
            lblName.setText(messi.getNameOfCard());
            lblRating.setText(String.valueOf(messi.getRating()));
            lblPace.setText(String.valueOf(messi.getPace()));
            lblShot.setText(String.valueOf(messi.getShot()));
            lblPass.setText(String.valueOf(messi.getPass()));
            lblDribble.setText(String.valueOf(messi.getDribble()));
            lblDefense.setText(String.valueOf(messi.getDefense()));
            lblPhysicality.setText(String.valueOf(messi.getPhysicality()));
            lblCost.setText("Cost: " + messi.getCost());
            imgMessi.setOpacity(1);
        }else if (tempCardOwned.equals(ronaldo.getNameOfCard())){
            cardsClickedOwned=ronaldo;
            lblName.setText(ronaldo.getNameOfCard());
            lblRating.setText(String.valueOf(ronaldo.getRating()));
            lblPace.setText(String.valueOf(ronaldo.getPace()));
            lblShot.setText(String.valueOf(ronaldo.getShot()));
            lblPass.setText(String.valueOf(ronaldo.getPass()));
            lblDribble.setText(String.valueOf(ronaldo.getDribble()));
            lblDefense.setText(String.valueOf(ronaldo.getDefense()));
            lblPhysicality.setText(String.valueOf(ronaldo.getPhysicality()));
            lblCost.setText("Cost: " + ronaldo.getCost());
            imgRonaldo.setOpacity(1);
        }else if (tempCardOwned.equals(lewandowski.getNameOfCard())){
            cardsClickedOwned=lewandowski;
            lblName.setText(lewandowski.getNameOfCard());
            lblRating.setText(String.valueOf(lewandowski.getRating()));
            lblPace.setText(String.valueOf(lewandowski.getPace()));
            lblShot.setText(String.valueOf(lewandowski.getShot()));
            lblPass.setText(String.valueOf(lewandowski.getPass()));
            lblDribble.setText(String.valueOf(lewandowski.getDribble()));
            lblDefense.setText(String.valueOf(lewandowski.getDefense()));
            lblPhysicality.setText(String.valueOf(lewandowski.getPhysicality()));
            lblCost.setText("Cost: " + lewandowski.getCost());
            imgLewandowski.setOpacity(1);
        }else if (tempCardOwned.equals(haaland.getNameOfCard())){
            cardsClickedOwned=haaland;
            lblName.setText(haaland.getNameOfCard());
            lblRating.setText(String.valueOf(haaland.getRating()));
            lblPace.setText(String.valueOf(haaland.getPace()));
            lblShot.setText(String.valueOf(haaland.getShot()));
            lblPass.setText(String.valueOf(haaland.getPass()));
            lblDribble.setText(String.valueOf(haaland.getDribble()));
            lblDefense.setText(String.valueOf(haaland.getDefense()));
            lblPhysicality.setText(String.valueOf(haaland.getPhysicality()));
            lblCost.setText("Cost: " + haaland.getCost());
            imgHaaland.setOpacity(1);
        }else if (tempCardOwned.equals(neymar.getNameOfCard())){
            cardsClickedOwned=neymar;
            lblName.setText(neymar.getNameOfCard());
            lblRating.setText(String.valueOf(neymar.getRating()));
            lblPace.setText(String.valueOf(neymar.getPace()));
            lblShot.setText(String.valueOf(neymar.getShot()));
            lblPass.setText(String.valueOf(neymar.getPass()));
            lblDribble.setText(String.valueOf(neymar.getDribble()));
            lblDefense.setText(String.valueOf(neymar.getDefense()));
            lblPhysicality.setText(String.valueOf(neymar.getPhysicality()));
            lblCost.setText("Cost: " + neymar.getCost());
            imgNeymar.setOpacity(1);
        }else if (tempCardOwned.equals(mbappe.getNameOfCard())){
            cardsClickedOwned=mbappe;
            lblName.setText(mbappe.getNameOfCard());
            lblRating.setText(String.valueOf(mbappe.getRating()));
            lblPace.setText(String.valueOf(mbappe.getPace()));
            lblShot.setText(String.valueOf(mbappe.getShot()));
            lblPass.setText(String.valueOf(mbappe.getPass()));
            lblDribble.setText(String.valueOf(mbappe.getDribble()));
            lblDefense.setText(String.valueOf(mbappe.getDefense()));
            lblPhysicality.setText(String.valueOf(mbappe.getPhysicality()));
            lblCost.setText("Cost: " + mbappe.getCost());
            imgMbappe.setOpacity(1);
        }
    }


    public void handleSubmitTrade(ActionEvent actionEvent) {
        if (Integer.parseInt(txtCardsGiveAway.getText())<=Integer.parseInt(tempCardOwnedFull.substring(tempCardOwnedFull.indexOf("# ")+2)) && Integer.parseInt(txtCardsAcquired.getText())<=Integer.parseInt(tempCardTradeFull.substring(tempCardTradeFull.indexOf("# ")+2))){
            lblDisplay.setText(playerClickTrade.addTrade(tempPlayer,cardsClickedTrade,cardsClickedOwned,Integer.parseInt(txtCardsGiveAway.getText()),Integer.parseInt(txtCardsAcquired.getText())));
            updateListviews();
        }else{
            lblDisplay.setText("Too much cards inputted");
        }

    }

    public void handleAcceptTrade(ActionEvent actionEvent) {

        String nameOfPlayerMakingOffer = selectedTradeOffer.substring(0,selectedTradeOffer.indexOf("offers")-1);//Player Offering Trade
        int numberOfCardsOffered= Integer.parseInt(selectedTradeOffer.substring(selectedTradeOffer.indexOf("offers")+7,selectedTradeOffer.indexOf(";")-1));//Number of Cards He Offers to Give
        String nameOfCardOffered = selectedTradeOffer.substring(selectedTradeOffer.indexOf(";")+2,selectedTradeOffer.indexOf("for")-1);//Name of Card he offers to give
        int numberOfCardsGivingAway = Integer.parseInt(selectedTradeOffer.substring(selectedTradeOffer.indexOf("for")+4,selectedTradeOffer.indexOf(":")-1));// Number of Cards the selected player has to give away
        String nameOfCardGivingAway = selectedTradeOffer.substring(selectedTradeOffer.indexOf(":")+2);// name of card the selected player has to give away
        Player playerMakingOffer=null;
        Cards CardOffered=null;
        Cards CardGivingAway=null;
        //use playerClicked for other player
        if (nameOfPlayerMakingOffer.equals(p1.getNameOfPerson())){
            playerMakingOffer=p1;
        }else if (nameOfPlayerMakingOffer.equals(p2.getNameOfPerson())){
            playerMakingOffer=p2;
        }else if (nameOfPlayerMakingOffer.equals(p3.getNameOfPerson())){
            playerMakingOffer=p3;
        }

        if (playerMakingOffer.getMyCard1()!=null && nameOfCardGivingAway.equals(playerMakingOffer.getMyCard1().getCardType().getNameOfCard())){
            CardOffered=playerMakingOffer.getMyCard1().getCardType();
            playerMakingOffer.getMyCard1().setNumCardOwned(-numberOfCardsGivingAway);
            System.out.println(playerMakingOffer.getMyCard1().getNumberOwned());
        }else if (playerMakingOffer.getMyCard2()!=null && nameOfCardGivingAway.equals(playerMakingOffer.getMyCard2().getCardType().getNameOfCard())){
            CardOffered=playerMakingOffer.getMyCard2().getCardType();
            playerMakingOffer.getMyCard2().setNumCardOwned(-numberOfCardsGivingAway);
        }else if (playerMakingOffer.getMyCard3()!=null && nameOfCardGivingAway.equals(playerMakingOffer.getMyCard3().getCardType().getNameOfCard())){
            CardOffered=playerMakingOffer.getMyCard3().getCardType();
            playerMakingOffer.getMyCard3().setNumCardOwned(-numberOfCardsGivingAway);
        }else if (playerMakingOffer.getMyCard4()!=null && nameOfCardGivingAway.equals(playerMakingOffer.getMyCard4().getCardType().getNameOfCard())){
            CardOffered=playerMakingOffer.getMyCard4().getCardType();
            playerMakingOffer.getMyCard4().setNumCardOwned(-numberOfCardsGivingAway);
        }else if (playerMakingOffer.getMyCard5()!=null && nameOfCardGivingAway.equals(playerMakingOffer.getMyCard5().getCardType().getNameOfCard())){
            CardOffered=playerMakingOffer.getMyCard5().getCardType();
            playerMakingOffer.getMyCard5().setNumCardOwned(-numberOfCardsGivingAway);
        }else if (playerMakingOffer.getMyCard6()!=null && nameOfCardGivingAway.equals(playerMakingOffer.getMyCard6().getCardType().getNameOfCard())){
            CardOffered=playerMakingOffer.getMyCard6().getCardType();
            playerMakingOffer.getMyCard6().setNumCardOwned(-numberOfCardsGivingAway);
        }
        if (playerClicked.getMyCard1()!=null && nameOfCardOffered.equals(playerClicked.getMyCard1().getCardType().getNameOfCard())){
            CardGivingAway=playerClicked.getMyCard1().getCardType();
            playerClicked.getMyCard1().setNumCardOwned(-numberOfCardsOffered);
        }else if (playerClicked.getMyCard2()!=null && nameOfCardOffered.equals(playerClicked.getMyCard2().getCardType().getNameOfCard())){
            CardGivingAway=playerClicked.getMyCard2().getCardType();
            playerClicked.getMyCard2().setNumCardOwned(-numberOfCardsOffered);
        }else if (playerClicked.getMyCard3()!=null && nameOfCardOffered.equals(playerClicked.getMyCard3().getCardType().getNameOfCard())){
            CardGivingAway=playerClicked.getMyCard3().getCardType();
            playerClicked.getMyCard3().setNumCardOwned(-numberOfCardsOffered);
        }else if (playerClicked.getMyCard4()!=null && nameOfCardOffered.equals(playerClicked.getMyCard4().getCardType().getNameOfCard())){
            CardGivingAway=playerClicked.getMyCard4().getCardType();
            playerClicked.getMyCard4().setNumCardOwned(-numberOfCardsOffered);
        }else if (playerClicked.getMyCard5()!=null && nameOfCardOffered.equals(playerClicked.getMyCard5().getCardType().getNameOfCard())){
            CardGivingAway=playerClicked.getMyCard5().getCardType();
            playerClicked.getMyCard5().setNumCardOwned(-numberOfCardsOffered);
        }else if (playerClicked.getMyCard6()!=null && nameOfCardOffered.equals(playerClicked.getMyCard6().getCardType().getNameOfCard())){
            CardGivingAway=playerClicked.getMyCard6().getCardType();
            playerClicked.getMyCard6().setNumCardOwned(-numberOfCardsOffered);
        }
        lblDisplay.setText(playerMakingOffer.TradeAddItems(CardGivingAway,numberOfCardsOffered));
        lblDisplay.setText(playerClicked.TradeAddItems(CardOffered,numberOfCardsGivingAway));
        if (selectedTradeOffer.equals(playerClicked.getTrade1())){
            playerClicked.setTrade1Null();
        }else if (selectedTradeOffer.equals(playerClicked.getTrade2())){
            playerClicked.setTrade2Null();
        }else if (selectedTradeOffer.equals(playerClicked.getTrade3())){
            playerClicked.setTrade3Null();
        }
        updateListviews();
    }

    public void handleDenyTrade(ActionEvent actionEvent) {
        if (selectedTradeOffer.equals(playerClicked.getTrade1())){
            playerClicked.setTrade1Null();
        }else if (selectedTradeOffer.equals(playerClicked.getTrade2())){
            playerClicked.setTrade2Null();
        }else if (selectedTradeOffer.equals(playerClicked.getTrade3())){
            playerClicked.setTrade3Null();
        }
        lblDisplay.setText("Trade Declined");
        updateListviews();
    }
    public void handleTradeOffers(MouseEvent mouseEvent) {
        tempSelectedTrade = lstTradeList.getSelectionModel().getSelectedItem().toString();
        if(tempSelectedTrade.equals(playerClicked.getTrade1())){
            selectedTradeOffer=playerClicked.getTrade1();
        }else if (tempSelectedTrade.equals(playerClicked.getTrade2())){
            selectedTradeOffer=playerClicked.getTrade2();
        }
        else if (tempSelectedTrade.equals(playerClicked.getTrade3())){
            selectedTradeOffer=playerClicked.getTrade3();
        }
        System.out.println(tempSelectedTrade);
        updateListviews();
    }
    public void handlePlayersTrade(MouseEvent mouseEvent) {
        tempPlayerTrade = lstPlayerTrade.getSelectionModel().getSelectedItem().toString();
        if(tempPlayerTrade.equals(p1.getNameOfPerson())){
            playerClickTrade=p1;
        }else if (tempPlayerTrade.equals(p2.getNameOfPerson())){
            playerClickTrade = p2;
        }
        else if (tempPlayerTrade.equals(p3.getNameOfPerson())){
            playerClickTrade = p3;
        }
        updateListviewsTrade();
    }

    public void handleCardsTrade(MouseEvent mouseEvent) {
        if (lstCardsTrade.getSelectionModel().getSelectedItem().toString()!=null){
            tempCardTradeFull = lstCardsTrade.getSelectionModel().getSelectedItem().toString();
            tempCardTrade=tempCardTradeFull.substring(0,tempCardTradeFull.indexOf(" #")) ;
            System.out.println(tempCardTrade);
        }
        imgMessi.setOpacity(0);
        imgRonaldo.setOpacity(0);
        imgLewandowski.setOpacity(0);
        imgHaaland.setOpacity(0);
        imgNeymar.setOpacity(0);
        imgMbappe.setOpacity(0);
        if (tempCardTrade.equals(messi.getNameOfCard())){
            cardsClickedTrade=messi;
            lblName.setText(messi.getNameOfCard());
            lblRating.setText(String.valueOf(messi.getRating()));
            lblPace.setText(String.valueOf(messi.getPace()));
            lblShot.setText(String.valueOf(messi.getShot()));
            lblPass.setText(String.valueOf(messi.getPass()));
            lblDribble.setText(String.valueOf(messi.getDribble()));
            lblDefense.setText(String.valueOf(messi.getDefense()));
            lblPhysicality.setText(String.valueOf(messi.getPhysicality()));
            lblCost.setText("Cost: " + messi.getCost());
            imgMessi.setOpacity(1);
        }else if (tempCardTrade.equals(ronaldo.getNameOfCard())){
            cardsClickedTrade=ronaldo;
            lblName.setText(ronaldo.getNameOfCard());
            lblRating.setText(String.valueOf(ronaldo.getRating()));
            lblPace.setText(String.valueOf(ronaldo.getPace()));
            lblShot.setText(String.valueOf(ronaldo.getShot()));
            lblPass.setText(String.valueOf(ronaldo.getPass()));
            lblDribble.setText(String.valueOf(ronaldo.getDribble()));
            lblDefense.setText(String.valueOf(ronaldo.getDefense()));
            lblPhysicality.setText(String.valueOf(ronaldo.getPhysicality()));
            lblCost.setText("Cost: " + ronaldo.getCost());
            imgRonaldo.setOpacity(1);
        }else if (tempCardTrade.equals(lewandowski.getNameOfCard())){
            cardsClickedTrade=lewandowski;
            lblName.setText(lewandowski.getNameOfCard());
            lblRating.setText(String.valueOf(lewandowski.getRating()));
            lblPace.setText(String.valueOf(lewandowski.getPace()));
            lblShot.setText(String.valueOf(lewandowski.getShot()));
            lblPass.setText(String.valueOf(lewandowski.getPass()));
            lblDribble.setText(String.valueOf(lewandowski.getDribble()));
            lblDefense.setText(String.valueOf(lewandowski.getDefense()));
            lblPhysicality.setText(String.valueOf(lewandowski.getPhysicality()));
            lblCost.setText("Cost: " + lewandowski.getCost());
            imgLewandowski.setOpacity(1);
        }else if (tempCardTrade.equals(haaland.getNameOfCard())){
            cardsClickedTrade=haaland;
            lblName.setText(haaland.getNameOfCard());
            lblRating.setText(String.valueOf(haaland.getRating()));
            lblPace.setText(String.valueOf(haaland.getPace()));
            lblShot.setText(String.valueOf(haaland.getShot()));
            lblPass.setText(String.valueOf(haaland.getPass()));
            lblDribble.setText(String.valueOf(haaland.getDribble()));
            lblDefense.setText(String.valueOf(haaland.getDefense()));
            lblPhysicality.setText(String.valueOf(haaland.getPhysicality()));
            lblCost.setText("Cost: " + haaland.getCost());
            imgHaaland.setOpacity(1);
        }else if (tempCardTrade.equals(neymar.getNameOfCard())){
            cardsClickedTrade=neymar;
            lblName.setText(neymar.getNameOfCard());
            lblRating.setText(String.valueOf(neymar.getRating()));
            lblPace.setText(String.valueOf(neymar.getPace()));
            lblShot.setText(String.valueOf(neymar.getShot()));
            lblPass.setText(String.valueOf(neymar.getPass()));
            lblDribble.setText(String.valueOf(neymar.getDribble()));
            lblDefense.setText(String.valueOf(neymar.getDefense()));
            lblPhysicality.setText(String.valueOf(neymar.getPhysicality()));
            lblCost.setText("Cost: " + neymar.getCost());
            imgNeymar.setOpacity(1);
        }else if (tempCardTrade.equals(mbappe.getNameOfCard())){
            cardsClickedTrade=mbappe;
            lblName.setText(mbappe.getNameOfCard());
            lblRating.setText(String.valueOf(mbappe.getRating()));
            lblPace.setText(String.valueOf(mbappe.getPace()));
            lblShot.setText(String.valueOf(mbappe.getShot()));
            lblPass.setText(String.valueOf(mbappe.getPass()));
            lblDribble.setText(String.valueOf(mbappe.getDribble()));
            lblDefense.setText(String.valueOf(mbappe.getDefense()));
            lblPhysicality.setText(String.valueOf(mbappe.getPhysicality()));
            lblCost.setText("Cost: " + mbappe.getCost());
            imgMbappe.setOpacity(1);
        }
    }


}