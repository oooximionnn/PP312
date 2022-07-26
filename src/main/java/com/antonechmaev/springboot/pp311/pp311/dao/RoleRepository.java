package com.antonechmaev.springboot.pp311.pp311.dao;

import com.antonechmaev.springboot.pp311.pp311.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
