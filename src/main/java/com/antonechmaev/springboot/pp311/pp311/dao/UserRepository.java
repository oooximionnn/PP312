package com.antonechmaev.springboot.pp311.pp311.dao;


import com.antonechmaev.springboot.pp311.pp311.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


// теперь используя JpaRepository<User, Integer> -
// нам не нужно прописывать методы - уже есть готовые
// 1 дженерик параметр прописываем энтити класс, вторым параметром primary key
public interface UserRepository extends JpaRepository<User, Integer> {
    // а также если 4 дефолтных метода вам мало - можно просто прописать название метода который вам нужен
    // их очень МНОГОО
    // вот, например, готовый метод - найти по имени
    //public List<User> findAllByName(String name);
}
