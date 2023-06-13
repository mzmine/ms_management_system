package com.mzmine.msmanagmentsystem.service;

import com.mzmine.msmanagmentsystem.model.User;
import com.mzmine.msmanagmentsystem.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(User user) {
//        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(user.getPassword());
        return userRepository.save(user);
    }

    @Override
    public User loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

//    @Override
//    public void logoutUser(String email) {
//
//        HttpSession session = request.getSession(false);
//        if (session != null) {
//            session.invalidate();
//        }
//    }

    @Override
    public boolean deleteUser(Long id) {
        // Perform any necessary deleteUser operations
        // For example, you can check if the user exists and delete the user from the repository
        // Return true if the deletion is successful, false otherwise
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
