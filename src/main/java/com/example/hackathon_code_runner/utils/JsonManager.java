package com.example.hackathon_code_runner.utils;

import com.google.gson.Gson;

public class JsonManager {
    public static String serialize(Object object){
        var gson = new Gson();
        var res = gson.toJson(object);
        return res;
    }

    public static <T> Object deserialize(String json, T object){
        var gson = new Gson();
        var res = gson.fromJson(json, object.getClass());
        return res;
    }
}
