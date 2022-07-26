package com.antonechmaev.springboot.pp311.pp311.service;



import com.antonechmaev.springboot.pp311.pp311.dao.RoleRepository;
import com.antonechmaev.springboot.pp311.pp311.dao.UserRepository;
import com.antonechmaev.springboot.pp311.pp311.entity.Role;
import com.antonechmaev.springboot.pp311.pp311.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //благодаря методам .findAll(); .save  .findById  .deleteById - нам не нужно создавать свои
    // в дао слое
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> roles = Set.of(roleRepository.getById(2));
        user.setRoles(roles);
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

    @Override
    public User findUserByUsername(String name) {
        User userDb = userRepository.findByUsername(name);
        if (userDb == null) {
            throw new UsernameNotFoundException("Пользователь не найден");
        }
        return userDb;
    }


    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User userDb = userRepository.findByUsername(name);
        if (userDb == null) {
            throw new UsernameNotFoundException("Пользователь не найден");
        }
        return userDb;
    }

}
