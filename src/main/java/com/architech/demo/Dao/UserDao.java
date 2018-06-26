package com.architech.demo.Dao;

import com.architech.demo.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer> {
}
