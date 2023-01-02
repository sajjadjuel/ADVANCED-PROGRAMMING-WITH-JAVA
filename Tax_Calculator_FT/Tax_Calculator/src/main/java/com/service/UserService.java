package com.service;

import com.domain.User;
//import com.repository.LeaveApplicationImplRepository;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService  {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User insert(User user) {
        return userRepository.create(user);
    }

    @Transactional(readOnly = true)
    public User get(Long id) {
        return userRepository.get(id);
    }

    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Transactional
    public User update(User user) {
        return userRepository.update(user);
    }

    @Transactional
    public void delete(Long id) {
        userRepository.delete(id);
    }
    @Transactional(readOnly = true)
    public User getByUserName(String username) {
        return userRepository.getByUsername(username);
    }
}
