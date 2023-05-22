package com.a.ventafrutos.entities;

import com.a.ventafrutos.dto.UserDTO;
import com.a.ventafrutos.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="cliente")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcliente;
    private String telefono;
    private String direccion;
    private String correo;
    private String contra;
    private UserRole userRole;


}
