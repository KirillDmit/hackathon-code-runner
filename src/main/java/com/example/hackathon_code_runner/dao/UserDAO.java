package com.example.hackathon_code_runner.dao;

import java.util.List;

public interface UserDAO {

    List<User> findAll();
    List<User> findById();
    List<User> findByName();
    boolean insertEmployee(User employee);
    boolean updateEmployee(User employee);
    boolean deleteEmployee(User employee);
}
