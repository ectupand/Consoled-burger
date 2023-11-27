package org.example.services;

import org.example.models.Ingredient;

import java.util.HashMap;


public class IngredientManager {
    public static HashMap<Integer, String> typeOne = new HashMap<>();
    public static HashMap<Integer, String> typeTwo = new HashMap<>();
    public static HashMap<Integer, String> typeThree = new HashMap<>();
    public static HashMap<Integer, Ingredient> ingredientsList;

    public static void getIngredientsList() {
        ingredientsList = IngredientManager.collect();
    }

    public static HashMap<Integer, Ingredient> collect(){
        HashMap<Integer, Ingredient> ingredientsList = new HashMap<>();

        for (int i = 0; i< Ingredient.values().length; i++){
            ingredientsList.put(i+1, Ingredient.values()[i]);
        }
        return ingredientsList;
    }

    public static void order(int i, Ingredient ingredient){
        if (ingredient.getType() == 1){
            typeOne.put(i, ingredient.getName());
        } else if (ingredient.getType() == 2) {
            typeTwo.put(i, ingredient.getName());
        } else if (ingredient.getType() == 3) {
            typeThree.put(i, ingredient.getName());
        }
    }

    public static Ingredient getByNumber(int ingredientNumber) {
        Ingredient ingredient = null;
        try {
            ingredient = ingredientsList.get(ingredientNumber);
        } catch (NullPointerException ignored) {
        }
        return ingredient;
    }
}
