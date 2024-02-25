package com.github.repository_list.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Branch {
    @JsonProperty("name")
    private String name;
    @JsonProperty("commit")
    private Commit commit;
}
