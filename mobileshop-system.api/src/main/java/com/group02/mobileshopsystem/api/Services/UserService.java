package com.group02.mobileshopsystem.api.Services;

import com.group02.mobileshopsystem.api.Model.User;
import com.group02.mobileshopsystem.api.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private static final String USER_NOT_FOUND_MSG = "user with email %s not found";
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG,email)));
    }
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
    public Optional<User> findByUserId(Integer id) {
        return userRepository.findById(id);
    }
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

}