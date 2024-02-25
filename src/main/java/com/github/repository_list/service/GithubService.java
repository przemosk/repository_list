package com.github.repository_list.service;

import org.springframework.http.ResponseEntity;
import com.github.repository_list.model.Response;
import com.github.repository_list.model.Branch;

import java.util.List;

public interface GithubService {
    public String baseURL = "https://api.github.com";

    public ResponseEntity<Response> getUserRepositories(String username);

    public List<Branch> getUserBranchRepositories(String username, String branch_name);
}
