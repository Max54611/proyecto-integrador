package com.a.ventafrutos.repository;

import com.a.ventafrutos.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findFirstByCorreo(String correo);
}
