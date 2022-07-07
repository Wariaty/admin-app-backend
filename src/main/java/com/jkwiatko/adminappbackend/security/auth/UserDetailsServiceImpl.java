package com.jkwiatko.adminappbackend.security.auth;

import com.jkwiatko.adminappbackend.user.db.entity.User;
import com.jkwiatko.adminappbackend.user.db.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));
        return new UserDetailsImpl(user.getId(), user.getEmail(), user.getPassword());
    }

    public UserDetails loadUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("User of id: " + userId + " not found."));
        return new UserDetailsImpl(userId, user.getEmail(), user.getPassword());
    }
}
