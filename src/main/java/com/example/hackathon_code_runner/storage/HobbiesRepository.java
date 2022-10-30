package com.example.hackathon_code_runner.storage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class HobbiesRepository {
    private static HobbiesRepository instance;
    private HashMap<Integer, List<String>> hobbies;

    private HobbiesRepository() {
        hobbies = new HashMap<>();
    }

    public static synchronized HobbiesRepository getInstance() {
        if (instance == null) {
            instance = new HobbiesRepository();
        }
        return instance;
    }

    public Collection<String> getHobbiesFor(Integer userId) {
        if (!hobbies.containsKey(userId))
            return new ArrayList<>();
        return hobbies.get(userId);
    }

    public void setHobbies(Integer userId, List<String> hobbies){
        this.hobbies.put(userId, hobbies);
    }
}
