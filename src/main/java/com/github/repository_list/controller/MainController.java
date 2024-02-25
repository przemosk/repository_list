package com.github.repository_list.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.github.repository_list.service.GithubServiceImpl;
import com.github.repository_list.model.Response;

@RestController
class MainController {
    final GithubServiceImpl ghservice = new GithubServiceImpl();

    @GetMapping(value = "/list_repository/{username}", consumes = "application/json", produces = "application/json")
    ResponseEntity<Response> list_repository(@PathVariable String username) {

        ResponseEntity<Response> repository = ghservice.getUserRepositories(username);

        return new ResponseEntity<>(repository.getBody(), repository.getHeaders(), repository.getStatusCode());
    }
}
