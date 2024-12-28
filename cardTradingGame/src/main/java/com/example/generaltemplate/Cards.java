package com.example.generaltemplate;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Cards {
    @FXML
    private String name;
    private int pace,shot,pass,dribble,defense,physicality,cost,rating;
    ;
    public Cards(String name, int rating, int pace, int shot, int pass, int dribble, int defense, int physicality, int cost){
        this.name=name;
        this.rating=rating;
        this.pace=pace;
        this.shot=shot;
        this.pass=pass;
        this.dribble=dribble;
        this.defense=defense;
        this.physicality=physicality;
        this.cost= cost;

    }

    public int getCost() {
        return cost;
    }

    public String getNameOfCard() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public int getPace() {
        return pace;
    }

    public int getShot() {
        return shot;
    }

    public int getPass() {
        return pass;
    }

    public int getDribble() {
        return dribble;
    }

    public int getDefense() {
        return defense;
    }

    public int getPhysicality() {
        return physicality;
    }
}
