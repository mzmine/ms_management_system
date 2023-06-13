package com.mzmine.msmanagmentsystem.service;

import com.mzmine.msmanagmentsystem.model.User;

public interface UserService {
    User registerUser(User user);
    User loginUser(String email, String password);
//    void logoutUser(String email);
    boolean deleteUser(Long id);
}
