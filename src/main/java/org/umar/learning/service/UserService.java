package org.umar.learning.service;

import org.springframework.stereotype.Service;
import org.umar.learning.model.User;
import org.umar.learning.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Get all Users
    public List<User> findAll() {
        return userRepository.findAll();
    }

    //Get users by ID
    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }

    // Create Users
    public User createUser(User user){
        return userRepository.save(user);
    }

    //Delete users
    public boolean deleteUser(long id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;

        }else{
            return false;
        }
    }

    // update user
    public User updateUser(Long id, User updatedUser) {
        Optional<User> existingUserOptional = userRepository.findById(id);
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            existingUser.setName(updatedUser.getName());
            existingUser.setAge(updatedUser.getAge());
            existingUser.setCollege(updatedUser.getCollege());
            existingUser.setPassword(updatedUser.getPassword());
            return userRepository.save(existingUser); // saves the updated user
        } else {
            return null; // user not found
        }
    }
}
