package com.example.hackathon_code_runner.storage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.hackathon_code_runner.controller.UsersController;
import com.example.hackathon_code_runner.dao.User;
import com.example.hackathon_code_runner.service.HobbiesService;

public class HobbiesRepository {
    private static HobbiesRepository instance;
    private Map<Integer, List<String>> hobbies;

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

    public User[] getUsersWithEqualsHobbie(String hobbie){
        var res = new ArrayList<User>();

        for (Map.Entry<Integer, List<String>> set : hobbies.entrySet()) {
            for (var hob : set.getValue())
                if (hob.equals(hobbie))
                    res.add(UserStorage.getInstance().getUserById(set.getKey()));

        }
        return res.toArray(new User[0]);
    }

    public User[] getUsersWithSimilarTags(List<String> tags){
        var hobbies = Arrays.asList(HobbiesService.getSimilarHobbies(tags, 4));
        var res = new ArrayList<User>();
        var users = UserStorage.getInstance().getUsers();
        for (var user : users){
            var u_hobs = HobbiesRepository.getInstance().getHobbiesFor(user.id);
            if (u_hobs.stream().anyMatch(h -> hobbies.contains(h)))
                res.add(user);
        }
       return res.toArray(new User[0]); 
    }
}
