package me.dio.service;

import me.dio.domain.User;
import me.dio.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchFieldError::new);
    }

    @Override
    public User create(User user) throws IllegalAccessException {
        if (userRepository.existsByAccountNumber(user.getAccount().getNumber())) {
            throw new IllegalAccessException("this account number alredy exists");
        }
        return userRepository.save(user);

    }


}
