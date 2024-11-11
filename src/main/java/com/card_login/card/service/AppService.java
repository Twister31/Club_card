package com.card_login.card.service;


import com.card_login.card.entity.UpdateRoleRequest;
import com.card_login.card.entity.User;
import com.card_login.card.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppService {
    private PasswordEncoder encoder;
    private UserRepository userRepository;

    public void addUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void updateUserRole(UpdateRoleRequest request){
        User user = userRepository.findByName(request.getName());

        user.setRole(request.getRole());
        userRepository.save(user);

    }

}
