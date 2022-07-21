package com.antonechmaev.springboot.pp311.pp311.service;




import com.antonechmaev.springboot.pp311.pp311.entity.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public void saveUser(User user);
    public User findById(int id);
    public void deleteById(int id);
}
