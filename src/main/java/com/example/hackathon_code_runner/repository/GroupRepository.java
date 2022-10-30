package com.example.hackathon_code_runner.repository;

import com.example.hackathon_code_runner.dao.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<User, Long> {
}
