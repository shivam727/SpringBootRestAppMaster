package com.skilldrive.app.service;

import com.skilldrive.app.model.User;
import com.skilldrive.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void addUser(User user){
        userRepository.save(user);
    }

    /*public void delete(Long id){
        userRepository.deleteById(id);
    }*/

    public List<User> getUsers(){
        return (List<User>)userRepository.findAll();
    }

    public User getUser(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException("Couldn't find User with Id:" + id));
    }

    public ResponseEntity<?> deleteUser(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Couldn't find User with Id:" + id));
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }

    public User updateUSer(User userDtls){
        User user = userRepository.findById(userDtls.getUserId()).orElseThrow(() ->
                new RuntimeException("Couldn't find User with Id:" + userDtls.getUserId()));
        user.setUserName(userDtls.getUserName());
        user.setAddress(userDtls.getAddress());
        return userRepository.save(user);
    }
}