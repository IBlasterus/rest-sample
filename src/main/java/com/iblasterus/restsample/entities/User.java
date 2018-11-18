package com.iblasterus.restsample.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class that represent user
 */
public class User {
    /**
     * User name (required)
     */
    private String username;

    @JsonCreator
    public User(@JsonProperty(required = true) String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
