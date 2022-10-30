package com.example.hackathon_code_runner.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Collection;
import com.example.hackathon_code_runner.dto.HobbiesRequest;
import com.example.hackathon_code_runner.dto.HobbiesResponse;
import com.example.hackathon_code_runner.utils.JsonManager;

public class HobbiesService {
    public String[] getSimilarHobbies(Collection<String> input, int words_count){
        
        try {
            var uri = new URI("http://localhost:8000/get-similar/");
            var requestModel = new HobbiesRequest();
            requestModel.count = words_count;
            requestModel.tokens = input.toArray(new String[0]);
            var jsonized = JsonManager.serialize(requestModel);
            var request = HttpRequest
                .newBuilder(uri)
                .header("Content-Type", "application/json")
                .method("GET", BodyPublishers.ofString(jsonized))
                .build();
            var client = HttpClient.newBuilder().build();
            var response = client.send(request, BodyHandlers.ofString());
            var hobbies =  JsonManager.deserialize(response.body(), HobbiesResponse.class);
            return hobbies.similar_tags;

        }catch(URISyntaxException | IOException | InterruptedException e){

        }
        return new String[0];

    }
}
