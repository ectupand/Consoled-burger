package org.example.models;

import org.example.services.IngredientManager;
import org.json.JSONException;
import org.json.JSONObject;

public class Breed {
    public JSONObject json = new JSONObject();

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
        for (String name : parts) {
            if (!this.json.has("buns")) {
                this.json.put("buns", new JSONObject());
            }
            if (!name.isEmpty()) {
                this.json.getJSONObject("buns")
                        .put(String.valueOf(++i), name);
            }
        }
    }

    public void bunning() {
        try {
            fill(0,IngredientManager.typeOne.values().toString());
            fill(IngredientManager.typeOne.values().size(), IngredientManager.typeTwo.values().toString());
            fill(IngredientManager.typeOne.values().size() + IngredientManager.typeTwo.values().size(), IngredientManager.typeThree.values().toString());
        } catch(Exception ignored){}
    }

}
