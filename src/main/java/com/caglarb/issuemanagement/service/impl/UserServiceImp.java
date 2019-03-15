package com.caglarb.issuemanagement.service.impl;

import com.caglarb.issuemanagement.entity.User;
import com.caglarb.issuemanagement.repo.UserRepository;
import com.caglarb.issuemanagement.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        if (user.getEmail() == null) {
            throw new IllegalArgumentException("Username can not be null !!");
        }
        user = userRepository.save(user);
        return user;
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(User user) {
        return null;
    }

    @Override
    public User getbyUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
