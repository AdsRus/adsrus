package com.codeup.adsrus.dao;

import com.codeup.adsrus.models.User;

import java.util.List;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);
}
