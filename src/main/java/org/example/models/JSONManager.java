package org.example.models;

import org.json.JSONException;
import org.json.JSONObject;


public class JSONManager extends JSONObject {

    public static JSONObject toJSON(JSONObject json, String jsonLike) throws JSONException {
        JSONObject json2 = new JSONObject(jsonLike);
        json.put("buns", json2);
        return json;
    }
}
