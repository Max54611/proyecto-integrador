package com.a.ventafrutos.dto;

import com.a.ventafrutos.enums.UserRole;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UserDTO {

    private int idcliente;
    private String telefono;
    private String direccion;
    private String correo;
    private String contra;
    private UserRole userRole;

}
