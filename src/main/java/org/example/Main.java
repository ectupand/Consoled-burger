package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.models.Breed;
import org.example.models.Ingredient;
import org.example.models.JSONManager;
import org.example.services.IngredientManager;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws JsonProcessingException, JSONException {
        Breed breed = new Breed();
        IngredientManager.getIngredientsList();
        System.out.println(IngredientManager.ingredientsList);
        //String input = new Scanner(System.in).nextLine();
        //String[] parts = input.split(",");
        String[] parts = "1, 2, 3,4,5,6,7,8,9,1,2,3,12".split(",");

        for (int k = 0; k < parts.length; k++) {
            String s = parts[k];
            String newS = s.replace(" ", "");
            parts[k] = newS;
        }
        for (int i=1; i<=parts.length; i++){
            int ingredientNumber;
            Ingredient ingredient;
            try {
                ingredientNumber = Integer.parseInt(parts[i-1]);
            }
            catch (NumberFormatException e) { continue;}
            ingredient = IngredientManager.getByNumber(ingredientNumber);
            IngredientManager.order(ingredient);
        }
        breed.bunning();
        System.out.println(
                jsonnier(
                        new JSONObject(breed.jsonLike).toString()
                )
        );
    }

    public static String jsonnier(String uglyJson) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Object jsonObject = objectMapper.readValue(uglyJson, Object.class);
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
    }
}