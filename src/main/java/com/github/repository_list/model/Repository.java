package com.github.repository_list.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.github.repository_list.service.GithubServiceImpl;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository {
    final GithubServiceImpl ghservice = new GithubServiceImpl();

    @JsonProperty("name")
    private String name;
    private Owner owner;
    private List<Branch> branches;

    @JsonProperty("owner")
    public String getOwner() {
        return owner.getLogin();
    }

    @JsonProperty("branches")
    public List<Branch> getBranches() {
        return ghservice.getUserBranchRepositories(getOwner(), getName());
    }

    @JsonIgnore
    public String getName() {
        return this.name;
    }
}
