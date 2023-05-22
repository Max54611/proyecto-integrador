package com.a.ventafrutos.service.user;

import com.a.ventafrutos.dto.SignupDTO;
import com.a.ventafrutos.dto.UserDTO;

public interface UserService {
    UserDTO createUser(SignupDTO signupDTO);
}
