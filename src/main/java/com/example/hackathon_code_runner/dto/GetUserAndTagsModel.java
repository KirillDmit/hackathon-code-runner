package com.example.hackathon_code_runner.dto;

import java.util.UUID;

public class GetUserAndTagsModel {
    public int id;
    public UUID private_id;
    public String login;
    public String password;
    public String name;
    public String surname;
    public String patronymic;
    public String socialNetwork;
    public String phone;
    public String location;
    public String specialization;

    public String[] tokens;
}
