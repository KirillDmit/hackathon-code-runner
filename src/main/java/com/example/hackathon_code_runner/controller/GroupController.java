package com.example.hackathon_code_runner.controller;

import com.example.hackathon_code_runner.dao.User;
import com.example.hackathon_code_runner.service.GroupServiceImpl;
import org.apache.catalina.Group;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
class GroupController {

    private final Logger log = (Logger) LoggerFactory.getLogger(GroupController.class);

    private final GroupServiceImpl groupService;

    @Autowired
    public GroupController(GroupServiceImpl groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/groups")
    Collection<Group> groups() {
        return groupService.findAll();
    }

    @GetMapping("/group/{id}")
    ResponseEntity<?> getGroup(@PathVariable Long id) {
        Optional<Group> group = groupService.findById(id);
        return group.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/group")
    ResponseEntity<Group> createGroup(@RequestBody Group group) throws URISyntaxException {
        log.info("Request to create group: {}");
        Group result = groupService.save(group);
        return ResponseEntity.created(new URI("/api/group/" + result.getRoles()))
                .body(result);
    }

    @PutMapping("/group")
    ResponseEntity<Group> updateGroup(@RequestBody Group group) {
        log.info("Request to update group: {}");
        Group result = groupService.save(group);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/group/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable Long id) {
        log.info("Request to delete group: {}");
        groupService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
