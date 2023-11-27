package org.example.models;


public enum Ingredient {
    CUCUMBER(1, "cucumber"),
    TOMATO(1, "tomato"),
    LETTUCE(1, "lettuce"),
    ONION(1, "onion"),
    CARROT(1, "carrot"),
    MAYONNAISE(2, "mayonnaise"),
    KETCHUP(2, "ketchup"),
    MUSTARD(2, "mustard"),
    BARBECUE_SAUCE(2, "barbecue_sauce"),
    TERIYAKI_SAUCE(2, "teriyaki_sauce"),
    CHICKEN_PATTY(3, "chicken_patty"),
    BEEF_PATTY(3, "beef_patty"),
    VEGGIE_PATTY(3, "veggie_patty"),
    FISH_PATTY(3, "fish_patty"),
    BLACK_BEAN_PATTY(3, "black_bean_patty");

    final int type;
    final String name;


    Ingredient(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getType() {
        return type;
    }


}
