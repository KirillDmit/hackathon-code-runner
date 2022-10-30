package com.example.hackathon_code_runner.service;

import com.example.hackathon_code_runner.dao.User;
import com.example.hackathon_code_runner.repository.GroupRepository;
import org.apache.catalina.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.core.CrudMethods;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Optional;

@Service
public class GroupServiceImpl{

    private final GroupRepository groupRepository;

    @Autowired
    protected GroupServiceImpl(GroupRepository repository) {
        super();
        this.groupRepository = repository;
    }

    public void deleteById(Long id) {
    }

    public Group save(Group group) {
        return group;
    }

    public Optional<Group> findById(Long id) {
        return Optional.empty();
    }

    public Collection<Group> findAll() {
        return null;
    }
}
