package com.github.repository_list.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;

import com.github.repository_list.exception.RepositoryHandleException;
import com.github.repository_list.model.Branch;
import com.github.repository_list.model.Response;

public class GithubServiceImpl implements GithubService {
    private final RestTemplate restTemplate;

    public GithubServiceImpl() {
        this.restTemplate = new RestTemplate();
    }

    public ResponseEntity<Response> getUserRepositories(String username) {
        var fullURL = baseURL + "/search/repositories?q=user:" + username + "&fork:false";

        try {
            ResponseEntity<Response> responseEntity = restTemplate.getForEntity(fullURL, Response.class);
            return new ResponseEntity<>(responseEntity.getBody(), null, responseEntity.getStatusCode());

        } catch (HttpClientErrorException exception) {
            throw new RepositoryHandleException(exception.getMessage(), exception.getStatusCode().value());
        }
    }

    public List<Branch> getUserBranchRepositories(String username, String branch_name) {
        var fullURL = baseURL + "/repos/" + username + "/" + branch_name + "/branches";

        ResponseEntity<List<Branch>> branchResponseEntity = restTemplate.exchange(
                fullURL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Branch>>() {
                });

        return branchResponseEntity.getBody();
    }
}
