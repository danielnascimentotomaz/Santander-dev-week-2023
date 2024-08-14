package me.dio.service;

import me.dio.domain.User;

public interface IUserService {

    User findById(Long id);

    User create(User user) throws IllegalAccessException;


}
