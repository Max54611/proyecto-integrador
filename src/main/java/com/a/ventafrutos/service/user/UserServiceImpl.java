package com.a.ventafrutos.service.user;

import com.a.ventafrutos.dto.SignupDTO;
import com.a.ventafrutos.dto.UserDTO;
import com.a.ventafrutos.entities.User;
import com.a.ventafrutos.enums.UserRole;
import com.a.ventafrutos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDTO createUser(SignupDTO signupDTO) {
        User user = new User();
        user.setCorreo(signupDTO.getCorreo());
        user.setUserRole(UserRole.USER);
        user.setContra(new BCryptPasswordEncoder().encode(signupDTO.getContra()));
        userRepository.save(user);
        return user.mapUserToUserDTO();
    }
}
