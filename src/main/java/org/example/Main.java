package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.models.Breed;
import org.example.models.Ingredient;
import org.example.services.IngredientManager;
import org.json.JSONException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws JSONException, JsonProcessingException {
        Breed breed = new Breed();
        IngredientManager.getIngredientsList();
        System.out.println(IngredientManager.ingredientsList);
        String input = new Scanner(System.in).next();
        String[] parts = input.split(",");
        //String[] parts = "10,1,1,6".split(",");
        for (int i=1; i<=parts.length; i++){
            int ingredientNumber;
            Ingredient ingredient;
            try {
                ingredientNumber = Integer.parseInt(parts[i-1]);
            }
            catch (NumberFormatException e) { continue;}
            ingredient = IngredientManager.getByNumber(ingredientNumber);
            IngredientManager.order(i, ingredient);
        }
        breed.bunning();
        System.out.println(jsonnier(breed.json.toString()));
    }

    public static String jsonnier(String uglyJson) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Object jsonObject = objectMapper.readValue(uglyJson, Object.class);
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
    }
}