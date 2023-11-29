package org.example.models;

import org.example.services.IngredientManager;
import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Breed {
    public String jsonLike = "{";

    public String[] fixString(String typedIngredients) {
        String[] parts = typedIngredients.split(",");
        for (int k = 0; k < parts.length; k++) {
            String s = parts[k];
            String newS = s.replace("[", "").replace("]", "").replace(" ", "");
            parts[k] = newS;
        }
        return parts;
    }

    private void fill(int start, String typedIngredients) throws JSONException {
        String[] parts = fixString(typedIngredients);
        int i = start;
        String buns = "";
        for (String name : parts) {
            if (!name.isEmpty()) {
                buns += "\""
                        + (++i)
                        + "\": \""
                        + name
                        + "\", ";
            }
        }
        this.jsonLike += buns;
    }

    private String sortByValue(HashMap<Integer, String> map){
        return map.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .map(Map.Entry::getValue)
                .collect(Collectors.joining (","));
    }
    public void bunning() {
        this.jsonLike = "{ \"buns\": {";
        try {

            fill(0,sortByValue(IngredientManager.typeOne));
            fill(
                    IngredientManager.typeOne.values().size(),
                    sortByValue(IngredientManager.typeTwo)
            );
            fill(
                    IngredientManager.typeOne.values().size() + IngredientManager.typeTwo.values().size(),
                    sortByValue(IngredientManager.typeThree)
            );
        } catch(Exception ignored){}
        this.jsonLike = this.jsonLike.substring(0, this.jsonLike.length()-2);
        this.jsonLike += "}}";
    }
}
