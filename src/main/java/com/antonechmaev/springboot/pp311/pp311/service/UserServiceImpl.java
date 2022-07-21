package com.antonechmaev.springboot.pp311.pp311.service;



import com.antonechmaev.springboot.pp311.pp311.dao.UserRepository;
import com.antonechmaev.springboot.pp311.pp311.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //благодаря методам .findAll(); .save  .findById  .deleteById - нам не нужно создавать свои
    // в дао слое
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User findById(int id) {
        return userRepository.getOne(id);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

}
